package com.api.estoque.api_crud.entity.ProdutoVenda;

import com.api.estoque.api_crud.entity.produto.ProdutoEntity;
import com.api.estoque.api_crud.entity.Venda.VendaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "produto_venda" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoVendaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private VendaEntity venda;

    private Integer quantidade;
}
