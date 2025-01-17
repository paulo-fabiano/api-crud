package com.api.estoque.api_crud.Service.Item;

import com.api.estoque.api_crud.dto.item.ItemRequestDTO;
import com.api.estoque.api_crud.dto.item.ItemResponseDTO;
import com.api.estoque.api_crud.dto.item.ItemResponseProdutoDTO;
import com.api.estoque.api_crud.dto.item.ItemResponseUltimosItensDTO;
import com.api.estoque.api_crud.entity.Item.ItemEntity;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
import com.api.estoque.api_crud.Repository.Item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Função para adicionar itens no inventário
    public ItemResponseDTO adicionarItem(ItemRequestDTO dto) {
        ItemEntity item = new ItemEntity(dto.getNomeItem(), dto.getPrecoUnitario(), dto.getQuantidadeItem(), dto.getDataCompra());
        itemRepository.save(item);

        return  item.tranformandoEmDTO();
    }

    // Função para retornar a lista de itens do inventário
    public List<ItemResponseDTO> buscarItens() {
        List<ItemEntity> lItem = itemRepository.findAll();
        List<ItemResponseDTO> lItemDTO = new ArrayList<>();
        for(ItemEntity i : lItem) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO(i.getId(), i.getNome(), i.getPreco(), i.getQuantidade(), i.getDataCompra());
            lItemDTO.add(itemResponseDTO);
        }
        return lItemDTO;
    }


    // Função que retorna os últimos cinco itens adicionados
    public List<ItemResponseUltimosItensDTO> buscarUltimosItens() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
        Page<ItemEntity> pagina = itemRepository.findAll(pageable);

        List<ItemResponseUltimosItensDTO> ultimos = new ArrayList<>();
        for (ItemEntity i : pagina.getContent()) {
            ItemResponseUltimosItensDTO u = new ItemResponseUltimosItensDTO(i.getId(), i.getNome(), i.getQuantidade());
            ultimos.add(u);
        }
        return ultimos;
    }

    //Função para retornar os itens que estão esgotados
    public List<ItemResponseDTO> buscarItensEsgotagos() {
        List<ItemEntity> lItem = itemRepository.buscarItemEsgotados();
        List<ItemResponseDTO> lItemDTO = new ArrayList<>();
        for (ItemEntity i : lItem) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO(i.getId(), i.getNome());
            lItemDTO.add(itemResponseDTO);
        }
        return lItemDTO;
    }

    // Função para deletar um item no inventário
    public void deletarItem(Long id) throws IdNaoEncontrado {
        Optional<ItemEntity> itemOpt = itemRepository.findById(id);
        if (itemOpt.isEmpty()) {
            throw new IdNaoEncontrado("Item com ID " + id + " não foi encontrado.");
        }
        // Deleta o item se ele existir
        itemRepository.delete(itemOpt.get());
    }

    // Função que retorna os itens para a página de adicionar produto
    // buscarItensPProd -> buscarItensParaPaginaProdutos
    public List<ItemResponseProdutoDTO> buscarItensPPProd() {
        List<ItemEntity> lItem = itemRepository.findAll();
        List<ItemResponseProdutoDTO> lItemDTO = new ArrayList<>();
        for (ItemEntity i : lItem) {
            ItemResponseProdutoDTO itemResponseProdutoDTO = new ItemResponseProdutoDTO(i.getId(), i.getNome(), i.getQuantidade(), i.getPreco());
            lItemDTO.add(itemResponseProdutoDTO);
        }
        return lItemDTO;
    }


}
