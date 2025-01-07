package com.api.estoque.api_crud.Controller.DashboardEstoque;

import com.api.estoque.api_crud.DTO.Categoria.CategoriaRequestDTO;
import com.api.estoque.api_crud.DTO.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.DTO.Item.ItemRequestDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseProdutoDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseUltimosItensDTO;
import com.api.estoque.api_crud.Entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import com.api.estoque.api_crud.Exceptions.IdNaoEncontrado;
import com.api.estoque.api_crud.Service.CategoriaService;
import com.api.estoque.api_crud.Service.Item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/estoque" )
@CrossOrigin(origins = "http://localhost:3000")
public class EstoqueController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ItemService itemService;

    // Endpoint para adicionar categoria
    @PostMapping( "/categorias" )
    public ResponseEntity<CategoriaResponseDTO> adicionarCategoria(@RequestBody CategoriaRequestDTO cDto) {
        CategoriaEntity categoria = categoriaService.adicionarCategoria(cDto.tranformaEmCategoria());
        CategoriaResponseDTO cRespDTO = categoria.tranformandoEmDTO();
        return ResponseEntity.ok(cRespDTO);
    }

    // Endpoint para buscar categorias
    @GetMapping( "/categorias" )
    public ResponseEntity<List<CategoriaResponseDTO>> buscarCategorias() {
        return ResponseEntity.ok(categoriaService.buscarCategorias());
    }

    // Endpoint para apagar uma categoria
    @DeleteMapping( "/categorias/{id}" )
    public ResponseEntity deletarCategoria(@PathVariable Long id) {
        categoriaService.removerCategoria(id);
        return ResponseEntity.ok("Apagado!");
    }

    // Endpoint para adicionar itens ao inventário
    @PostMapping( "/item" )
    public ResponseEntity<ItemResponseDTO> adicionarItem(@RequestBody ItemRequestDTO dtoRequest) {
//        ItemEntity item = new ItemEntity(dto.getNomeItem(), dto.getPrecoUnitario(), dto.getQuantidadeItem(), dto.getDataCompra());
//        ItemEntity item = itemService.adicionarItem(dtoRequest.tranformandoEmItem());
//        ItemResponseDTO dto = dtoRequest.tranformandoEmDTO();
        return ResponseEntity.ok(itemService.adicionarItem(dtoRequest));
    }

    // Endpoint para listar os itens do inventário
    @GetMapping( "/item" )
    public ResponseEntity<List<ItemResponseDTO>> listarItens() {
        return ResponseEntity.ok(itemService.buscarItens());
    }

    // Endpoint para listar os últimos cinco itens adicionados
    // Futuramente irei receber um parâmetro de quantos itens irei querer enviar na requisição, no momento será somente 5.
    @GetMapping("/item/ultimos/5")
    public ResponseEntity<List<ItemResponseUltimosItensDTO>> listarUltimosItens() {
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(itemService.buscarUltimosItens());
    }

    // Endpoint para listar os itens zerados
    @GetMapping( "/item/esgotados" )
    public ResponseEntity<List<ItemResponseDTO>> listarItensEstogotados() {
        return ResponseEntity.ok(itemService.buscarItensEsgotagos());
    }

    // Endpoint para apagar um item do inventário
    @DeleteMapping( "/item/deletar/{id}")
    public ResponseEntity<?> deletarItem(@PathVariable Long id) throws IdNaoEncontrado {
        try {
            itemService.deletarItem(id);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (IdNaoEncontrado e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Endpoint para retornar os itens para a página de adicionar produto
    @GetMapping( "/item/produto" )
    public ResponseEntity<List<ItemResponseProdutoDTO>> listarItensParaProdutos() {
        return ResponseEntity.ok(itemService.buscarItensPPProd());
    }



}
