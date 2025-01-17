package com.api.estoque.api_crud.entity.produto;

public interface ProdutoProjection {
    Long getProdutoId();
    String getNomeProduto();
    String getDescricaoProduto();
    Double getPrecoVendaProduto();
    Double getPrecoCustoProduto();
    Long getCategoriaId();
    String getNomeCategoria();
    Long getItemId();
    String getNomeItem();
    Integer getQuantidadeItem();
    Integer getQuantidadeProduto();
}
