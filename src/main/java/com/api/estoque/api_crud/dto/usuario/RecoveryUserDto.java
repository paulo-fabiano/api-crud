package com.api.estoque.api_crud.dto.usuario;

import com.api.estoque.api_crud.entity.role.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}