package com.api.estoque.api_crud.entity.Categoria;

import com.api.estoque.api_crud.dto.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.entity.produto.ProdutoEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "categorias" )
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CategoriaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", nullable = false )
    private Long id;
    @Column( name = "nome_categoria", nullable = false )
    private String nomeCategoria;

    // Criando o relacionamento com a entidade produtos
    @JsonIgnore
    @ManyToMany( mappedBy = "produtoCategoria" )
    @JsonBackReference
    private List<ProdutoEntity> produtos = new ArrayList<>();

    // Construtor padrão
    public CategoriaEntity(String nome) {
        this.nomeCategoria = nome;
    }

    // Tranformando em DTO Response
    public CategoriaResponseDTO tranformandoEmDTO() {
        return new CategoriaResponseDTO(getId(), getNomeCategoria());
    }

}
