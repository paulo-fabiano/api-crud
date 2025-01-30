package com.api.estoque.api_crud.dto.authentication;

import com.api.estoque.api_crud.entity.usuario.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,

        String email,

        List<Role> roles
) {
}