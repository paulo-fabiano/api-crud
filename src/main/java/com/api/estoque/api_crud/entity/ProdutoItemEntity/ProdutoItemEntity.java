package com.api.estoque.api_crud.entity.ProdutoItemEntity;

import com.api.estoque.api_crud.entity.item.ItemEntity;
import com.api.estoque.api_crud.entity.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "produto_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoItemEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private ItemEntity item;

    @Column(name = "quantidade_itens", nullable = false)
    private Integer quantidadeItens;

}
