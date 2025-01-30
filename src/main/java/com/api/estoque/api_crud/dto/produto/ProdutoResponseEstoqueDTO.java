package com.api.estoque.api_crud.dto.produto;

import com.api.estoque.api_crud.dto.categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.dto.item.ItemResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponseEstoqueDTO {

    @JsonProperty( "id" )
    private Long id;
    @JsonProperty( "nome" )
    private String nome;
    @JsonProperty( "descricao" )
    private String descricao;
    @JsonProperty( "precoVenda" )
    private Double precoVendaProduto;
    @JsonProperty( "precoCusto" )
    private Double precoCustoProduto;
    @JsonProperty( "quantidade" )
    private Integer quantidade;
    @JsonProperty( "categorias" )
    private List<CategoriaResponseDTO> categorias;
    @JsonProperty( "itens" )
    private List<ItemResponseDTO> itens;

    public ProdutoResponseEstoqueDTO(
            Long id,
            String nome,
            String descricao,
            Double precoVendaProduto,
            Integer quantidade
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVendaProduto = precoVendaProduto;
        this.quantidade = quantidade;
    }

}
