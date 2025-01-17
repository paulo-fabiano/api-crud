package com.api.estoque.api_crud.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemResponseProdutoDTO {

    @JsonProperty( "id" )
    private Long id;
    @JsonProperty( "name" )
    private String nome;
    @JsonProperty( "quantity" )
    private int quantidade;
    @JsonProperty( "unitPrice" )
    private double precoUnitario;

}
