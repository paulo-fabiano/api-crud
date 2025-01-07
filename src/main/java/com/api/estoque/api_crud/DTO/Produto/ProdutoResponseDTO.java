package com.api.estoque.api_crud.DTO.Produto;

import com.api.estoque.api_crud.DTO.Categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.DTO.Item.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Double precoVendaProduto;
    private Double precoCustoProduto;
    private Integer quantidade;
    private List<CategoriaResponseDTO> categorias;
    private List<ItemResponseDTO> itens;

    public ProdutoResponseDTO(
            Long id,
            String nome,
            String descricao,
            Double precoVendaProduto,
            Integer quantidade
    ) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVendaProduto = precoVendaProduto;
        this.quantidade = quantidade;
    }

}
