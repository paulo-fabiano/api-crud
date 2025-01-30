package com.api.estoque.api_crud.repository;

import com.api.estoque.api_crud.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
