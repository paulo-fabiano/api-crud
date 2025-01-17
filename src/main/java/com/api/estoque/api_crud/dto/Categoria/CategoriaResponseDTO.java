package com.api.estoque.api_crud.dto.Categoria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoriaResponseDTO {

    @JsonProperty( "id" )
    private Long id;

    @JsonProperty( "nome" )
    private String nome_categoria;

}
