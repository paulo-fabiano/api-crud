package com.api.estoque.api_crud.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {

    @JsonProperty( "id" )
    private Long id;
    @JsonProperty( "nome" )
    private String nomeItem;
    @JsonProperty( "preco" )
    private Double precoUnitario;
    @JsonProperty( "quantidade" )
    private Integer quantidadeItem;
    @JsonProperty( "dataCompra" )
    private String dataCompra;

    // Contrutor para a função que lista os itens esgotados
    public ItemResponseDTO(Long id, String nome) {
        this.id = id;
        this.nomeItem = nome;
    }

    // Construtor para a função no Service que envia a lista de produtos
    public ItemResponseDTO(Long id, String nome, int quantidade) {
        this.id = id;
        this.nomeItem = nome;
        this.quantidadeItem = quantidade;
    }

}
