package com.api.estoque.api_crud.entity.Item;

import com.api.estoque.api_crud.dto.item.ItemResponseDTO;
import com.api.estoque.api_crud.entity.ProdutoItemEntity.ProdutoItemEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itens")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "nome" )
    private String nome;
    @Column( name = "preco" )
    private double preco;
    @Column( name = "quantidade" )
    private int quantidade;
    @Column( name = "data_compra" )
    private String dataCompra;

    public ItemEntity(String n, double p, int q, String dC) {
          this.nome = n;
          this.preco = p;
          this.quantidade = q;
          this.dataCompra = dC;
    }

    @OneToMany( mappedBy = "item", cascade = CascadeType.ALL )
    @JsonBackReference
    private List<ProdutoItemEntity> produtosItem = new ArrayList<>();

    // Tranformando em DTO Response
    public ItemResponseDTO tranformandoEmDTO() {
        return new ItemResponseDTO(getId(), getNome(), getPreco(), getQuantidade(), getDataCompra());
    }

}
