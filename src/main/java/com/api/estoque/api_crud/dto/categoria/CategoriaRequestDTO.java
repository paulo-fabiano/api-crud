package com.api.estoque.api_crud.dto.categoria;

import com.api.estoque.api_crud.entity.Categoria.CategoriaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoriaRequestDTO {

    @JsonProperty( "nome" )
    private String nome;

    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public CategoriaEntity tranformaEmCategoria() {
        return new CategoriaEntity(nome);
    }

}
