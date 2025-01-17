package com.api.estoque.api_crud.entity.Clientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table( name = "clientes" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClienteEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "nome_cliente" )
    private String nome;

}
