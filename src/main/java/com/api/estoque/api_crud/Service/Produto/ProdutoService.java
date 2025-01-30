package com.api.estoque.api_crud.Service.Produto;

import com.api.estoque.api_crud.dto.categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.dto.item.ItemResponseDTO;
import com.api.estoque.api_crud.dto.produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.dto.produto.ProdutoResponseEstoqueDTO;
import com.api.estoque.api_crud.entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.entity.item.ItemEntity;
import com.api.estoque.api_crud.entity.produto.ProdutoEntity;
import com.api.estoque.api_crud.entity.produto.ProdutoProjection;
import com.api.estoque.api_crud.entity.ProdutoItemEntity.ProdutoItemEntity;
import com.api.estoque.api_crud.repository.Categoria.CategoriaRepository;
import com.api.estoque.api_crud.repository.Item.ItemRepository;
import com.api.estoque.api_crud.repository.Produto.ProdutoRepository;
import com.api.estoque.api_crud.repository.ProdutoItem.ProdutoItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoItemRepository produtoItemRepository;

    // Função que adicionar um produto
    public ProdutoEntity adicionarProduto(ProdutoRequestDTO produtoDTO) {

        byte[] imagemBytes = null;
        if (produtoDTO.getImagem() != null && produtoDTO.getImagem().isEmpty()) {
            imagemBytes = Base64.getDecoder().decode(produtoDTO.getImagem());
        }
        // Criar um objeto com os atributos nome, descrição, preço de venda, preço de custo e quantidade
        ProdutoEntity produto = new ProdutoEntity();

        produto.setImagem(imagemBytes);
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setDescricaoProduto(produtoDTO.getDescricaoProduto());
        produto.setPrecoVendaProduto(produtoDTO.getPrecoVendaProduto());
        produto.setPrecoCustoProduto(produtoDTO.getPrecoCustoProduto());
        produto.setQuantidade(produtoDTO.getQuantidadeProduto());

        // Buscar as categorias e associar ao produto
        List<Long> listaLongCategorias = produtoDTO.getProdutoCategoria();
        List<CategoriaEntity> listaCategorias = new ArrayList<>();
        for (Long l : listaLongCategorias) {
            Optional<CategoriaEntity> categoriaOpt = categoriaRepository.findById(l);
            if (!categoriaOpt.isPresent()) {
                throw new RuntimeException("Erro no For ao verificar");
            }
            listaCategorias.add(categoriaOpt.get());
        }
        produto.setProdutoCategoria(listaCategorias); // Setar a lista de categorias em Produto

        // Salvar o produto para obter o Id
        produto = produtoRepository.save(produto);




        for(Map.Entry<Long, Integer> i : produtoDTO.getProdutoItens().entrySet()) {
            ProdutoItemEntity produtoItemEntity = new ProdutoItemEntity();
            Optional<ItemEntity> itemOpt = itemRepository.findById(i.getKey());

            if (!itemOpt.isPresent()) {
                throw new RuntimeException("Id não encontrado");
            }
            produtoItemEntity.setProduto(produto);
            produtoItemEntity.setItem(itemOpt.get());
            produtoItemEntity.setQuantidadeItens(i.getValue());

            produtoItemEntity = produtoItemRepository.save(produtoItemEntity);

        }

        System.out.print("Produto Salvo!");
        return produto;

    }

    // Função que busca os produtos
    public List<ProdutoResponseEstoqueDTO> buscarProdutos() {
        List<ProdutoProjection> resultados = produtoRepository.buscarListaProdutos();

        Map<Long, ProdutoResponseEstoqueDTO> produtoMap = new HashMap<>();

        for (ProdutoProjection linha : resultados) {
            // Extrai dados da linha
            Long produtoId = linha.getProdutoId();
            String nomeProduto = linha.getNomeProduto();
            String descricaoProduto = linha.getDescricaoProduto();
            Double precoVendaProduto = linha.getPrecoVendaProduto();
            Double precoCustoProduto = linha.getPrecoCustoProduto();
            Integer quantidadeProduto = linha.getQuantidadeProduto();

            // Verifica se o produto já existe no mapa
            ProdutoResponseEstoqueDTO produto = produtoMap.computeIfAbsent(produtoId, id -> {
                ProdutoResponseEstoqueDTO p = new ProdutoResponseEstoqueDTO();
                p.setId(produtoId);
                p.setNome(nomeProduto);
                p.setDescricao(descricaoProduto);
                p.setPrecoVendaProduto(precoVendaProduto);
                p.setPrecoCustoProduto(precoCustoProduto);
                p.setQuantidade(quantidadeProduto);
                p.setCategorias(new ArrayList<>());
                p.setItens(new ArrayList<>());
                return p;
            });

            // Adiciona categoria, se existir
            if (linha.getCategoriaId() != null) {
                produto.getCategorias().add(new CategoriaResponseDTO(linha.getCategoriaId(), linha.getNomeCategoria()));
            }

            // Adiciona item, se existir
            if (linha.getItemId() != null) {
                produto.getItens().add(new ItemResponseDTO(linha.getItemId(), linha.getNomeItem(), linha.getQuantidadeItem()));
            }
        }

        return new ArrayList<>(produtoMap.values());
    }

    // Função para remover um produto
    @Transactional
    public void deletarProduto(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto com ID " + id + " não encontrado"));

        // Limpa as associações para evitar problemas de chave estrangeira
        produto.getProdutoCategoria().clear();
        produto.getProdutoItens().clear();

        produtoRepository.save(produto); // Atualiza as associações

        produtoRepository.delete(produto); // Agora você pode deletar o produto
    }


    @Transactional
    public List<ProdutoResponseEstoqueDTO> buscarProdutosPorCategoria(Long id) {

        List<ProdutoProjection> resultados = produtoRepository.buscarProdutosPorCategoria(id);
        Map<Long, ProdutoResponseEstoqueDTO> produtoMap = new HashMap<>();

        for (ProdutoProjection linha : resultados) {
            Long produtoId = linha.getProdutoId();

            if(!produtoMap.containsKey(produtoId)) {

                ProdutoResponseEstoqueDTO dto = new ProdutoResponseEstoqueDTO();
                dto.setId(produtoId);
                dto.setNome(linha.getNomeProduto());
                dto.setDescricao(linha.getDescricaoProduto());
                dto.setPrecoVendaProduto(linha.getPrecoVendaProduto());
                dto.setPrecoCustoProduto(linha.getPrecoCustoProduto());
                dto.setQuantidade(linha.getQuantidadeProduto());

                produtoMap.put(produtoId, dto);
            }

        }
        System.out.println(produtoMap.values());
        return new ArrayList<>(produtoMap.values());

    };


}
