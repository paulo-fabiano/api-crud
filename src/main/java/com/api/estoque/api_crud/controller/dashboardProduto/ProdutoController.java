package com.api.estoque.api_crud.controller.dashboardProduto;

import com.api.estoque.api_crud.dto.categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.dto.produto.ProdutoRequestDTO;
import com.api.estoque.api_crud.dto.produto.ProdutoResponseEstoqueDTO;
import com.api.estoque.api_crud.Service.CategoriaService;
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
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String get() {
        return "Deu certo";
    }

    // Endpoint para adicionar Produtos
    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarprodutoItem(@RequestBody ProdutoRequestDTO produto) {
        produtoService.adicionarProduto(produto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    // Endpoint para listar os produtos
    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponseEstoqueDTO>> buscarProdutos() {
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

    @GetMapping("/categorias/listar")
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.buscarCategorias());
    }

    // Endpoint que vai listar os produtos por categoria após o usuário selecionar a categoria
    @GetMapping("/categorias/listar/{id}")
    public ResponseEntity<List<ProdutoResponseEstoqueDTO>> buscarProdutosPorCategoria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoService.buscarProdutosPorCategoria(id));
    }


}
