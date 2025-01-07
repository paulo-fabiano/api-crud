package com.api.estoque.api_crud.Entity.Venda;

import com.api.estoque.api_crud.Entity.Clientes.ClienteEntity;
import com.api.estoque.api_crud.Entity.ProdutoVenda.ProdutoVendaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "vendas" )
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "data_venda" )
    private LocalDate data_venda;

    private BigDecimal total;
    private BigDecimal valorPago;
    private BigDecimal saldoDevedor;

    @Enumerated( EnumType.STRING)
    private StatusVenda statusVenda;

    private String observacoes;

    @ManyToOne
    @JoinColumn( name = "id_cliente", nullable = false )
    private ClienteEntity cliente;

    // Relacionamento com ProdutoVenda (One-to-Many)
    @OneToMany( mappedBy = "venda", cascade = CascadeType.ALL )
    private List<ProdutoVendaEntity> produtos;


}
