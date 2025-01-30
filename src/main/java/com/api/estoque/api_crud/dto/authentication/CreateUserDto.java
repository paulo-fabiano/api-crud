package com.api.estoque.api_crud.dto.authentication;

import com.api.estoque.api_crud.enums.RoleName;

public record CreateUserDto(

    String email,
    String password,
    RoleName role

){}
