package com.api.estoque.api_crud.Controller.DashboardProduto;

import com.api.estoque.api_crud.DTO.Produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.DTO.Produto.ProdutoResponseDTO;
import com.api.estoque.api_crud.Service.Produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/produtos" )
@CrossOrigin(origins = "http://localhost:3000")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para adicionar Produtos
    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarprodutoItem(@RequestBody ProdutoRequestDTO produto) {
        produtoService.adicionarProduto(produto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    // Endpoint para listar os produtos
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutos() {
        return ResponseEntity.ok(produtoService.buscarProdutos());
    }

    // Endpoint para deletar um produto
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarProduto(@PathVariable Long id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok().body(HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            throw new RuntimeException("Não foi possível deletar o Produto");
        }
    }

    // Endpoint que vai listar os produtos por categoria após o usuário selecionar a categoria
    @GetMapping("/categorias/listar/{id}")
    public ResponseEntity<List<ProdutoResponseDTO>> buscarProdutosPorCategoria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoService.buscarProdutosPorCategoria(id));
    }


}
