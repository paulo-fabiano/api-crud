package com.api.estoque.api_crud.Entity.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "usuarios" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "nome" )
    private String nome;
    @Column( name = "sobrenome" )
    private String sobrenome;
    @Column( name = "email" )
    private String email;
    @Column( name = "senha" )
    private String senha;
    @Column( name = "telefone" )
    private String telefone;
    @Column( name = "role" )
    private String role; // A role irei definir posteriormente

    public UsuarioEntity(String nome, String sobrenome, String email, String senha, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

}
