package com.api.estoque.api_crud.entity.usuario;

import com.api.estoque.api_crud.entity.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table( name = "usuarios" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    @Enumerated(EnumType.STRING)

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    @JoinTable( name = "usuarios_roles",
            joinColumns = @JoinColumn( name = "usuario_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" )
    )
    private List<Role> roles;

    public UsuarioEntity(String nome, String sobrenome, String email, String senha, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

}
