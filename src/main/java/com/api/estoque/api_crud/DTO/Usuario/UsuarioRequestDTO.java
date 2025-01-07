package com.api.estoque.api_crud.DTO.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequestDTO {

    private String nomeUsuario;
    private String sobrenomeUsuario;
    private String email;
    private String senha;
    private String telefone;

}
