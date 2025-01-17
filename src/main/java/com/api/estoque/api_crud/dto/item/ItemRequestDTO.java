package com.api.estoque.api_crud.dto.item;

import com.api.estoque.api_crud.entity.Item.ItemEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemRequestDTO {

    @JsonProperty( "nome" )
    private String nomeItem;
    @JsonProperty( "preco" )
    private Double precoUnitario;
    @JsonProperty( "quantidade" )
    private Integer quantidadeItem;
    @JsonProperty( "dataCompra" )
    private String dataCompra;

    public ItemEntity tranformandoEmItem() {
        return new ItemEntity(nomeItem, precoUnitario, quantidadeItem, dataCompra);
    }

}
