package com.api.estoque.api_crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Boleto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;
    @Column( name = "data_boleto" )
    private LocalDate data_boleto;
    @Column( name = "preco_boleto" )
    private Double preco_boleto;
    @Column( name = "descricao" )
    private String descricao;

}
