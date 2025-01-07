package com.api.estoque.api_crud.Repository.Usuario;

import com.api.estoque.api_crud.Entity.Usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
