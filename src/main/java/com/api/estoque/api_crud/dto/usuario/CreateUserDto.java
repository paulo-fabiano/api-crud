package com.api.estoque.api_crud.dto.usuario;

import com.api.estoque.api_crud.entity.role.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}