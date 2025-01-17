package com.api.estoque.api_crud.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDTO {

    @JsonProperty( "image" )
    private String imagem;
    @JsonProperty("name")
    private String nomeProduto;
    @JsonProperty("description")
    private String descricaoProduto;
    @JsonProperty("price")
    private Double precoVendaProduto;
    @JsonProperty("costPrice")
    private Double precoCustoProduto;
    @JsonProperty("stock")
    private int quantidadeProduto;
    @JsonProperty("categories")
    private List<Long> produtoCategoria = new ArrayList<>();
    @JsonProperty("itens")
    private Map<Long, Integer> produtoItens = new HashMap<>();

}
