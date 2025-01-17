package com.api.estoque.api_crud.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemResponseUltimosItensDTO {

    private Long id;
    private String nome;
    private Integer quantidade;

}
