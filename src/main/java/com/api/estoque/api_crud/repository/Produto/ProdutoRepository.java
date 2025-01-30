package com.api.estoque.api_crud.repository.Produto;

import com.api.estoque.api_crud.entity.produto.ProdutoEntity;
import com.api.estoque.api_crud.entity.produto.ProdutoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query(value = "SELECT " +
            "p.id AS produtoId, " +
            "p.nome AS nomeProduto, " +
            "p.descricao AS descricaoProduto, " +
            "p.preco_venda_produto AS precoVendaProduto, " +
            "p.preco_custo_produto AS precoCustoProduto, " +
            "p.quantidade AS quantidadeProduto, " +
            "c.id AS categoriaId, " +
            "c.nome_categoria AS nomeCategoria, " +
            "i.id AS itemId, " +
            "i.nome AS nomeItem, " +
            "pi.quantidade_itens AS quantidadeItem " +
            "FROM produtos p " +
            "LEFT JOIN produto_categoria pc ON p.id = pc.produto_id " +
            "LEFT JOIN categorias c ON pc.categoria_id = c.id " +
            "LEFT JOIN produto_item pi ON p.id = pi.id_produto " +
            "LEFT JOIN itens i ON pi.id_item = i.id " +
            "ORDER BY p.id", nativeQuery = true)
    List<ProdutoProjection> buscarListaProdutos();

    @Query(value = "SELECT " +
            "p.id AS produtoId, " +
            "p.nome AS nomeProduto, " +
            "p.descricao AS descricaoProduto, " +
            "p.preco_venda_produto AS precoVendaProduto, " +
            "p.preco_custo_produto AS precoCustoProduto, " +
            "p.quantidade AS quantidadeProduto, " +
            "c.id AS categoriaId, " +
            "c.nome_categoria AS nomeCategoria, " +
            "i.id AS itemId, " +
            "i.nome AS nomeItem, " +
            "pi.quantidade_itens AS quantidadeItem " +
            "FROM produtos p " +
            "LEFT JOIN produto_categoria pc ON p.id = pc.produto_id " +
            "LEFT JOIN categorias c ON pc.categoria_id = c.id " +
            "LEFT JOIN produto_item pi ON p.id = pi.id_produto " +
            "LEFT JOIN itens i ON pi.id_item = i.id " +
            "WHERE c.id = :categoriaId " +
            "ORDER BY p.id", nativeQuery = true)
    List<ProdutoProjection> buscarProdutosPorCategoria(@Param("categoriaId") Long categoriaId);


}

