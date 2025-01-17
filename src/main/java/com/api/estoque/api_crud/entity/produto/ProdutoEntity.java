package com.api.estoque.api_crud.entity.produto;

import com.api.estoque.api_crud.entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.entity.ProdutoItemEntity.ProdutoItemEntity;
import com.api.estoque.api_crud.entity.ProdutoVenda.ProdutoVendaEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity
@Table( name = "produtos" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id")
    private Long id;
    @Column( name = "imagem")
    private byte[] imagem;
    @Column( name = "nome")
    private String nomeProduto;
    @Column( name = "descricao" )
    private String descricaoProduto;

    @Column( name = "preco_venda_produto" )
    private Double precoVendaProduto;

    @Column( name = "preco_custo_produto")
    private Double precoCustoProduto;

    @ManyToMany( cascade = CascadeType.ALL )
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn( name = "produto_id" ),
            inverseJoinColumns = @JoinColumn( name = "categoria_id" )
    )
    @JsonManagedReference
    private List<CategoriaEntity> produtoCategoria = new ArrayList<>();

    // Relacionamento com ProdutoVenda (One-to-Many)
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoVendaEntity> vendas;

    @OneToMany( mappedBy = "produto", cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<ProdutoItemEntity> produtoItens = new ArrayList<>();

    @Column( name = "quantidade")
    private Integer quantidade;

    public ProdutoEntity(String nomeProduto, String descricaoProduto, Double precoUnitario, Integer quantidadeProduto, Double precoCusto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoVendaProduto = precoUnitario;
        this.precoCustoProduto = precoCusto;
        this.quantidade = quantidadeProduto;
    }

}
