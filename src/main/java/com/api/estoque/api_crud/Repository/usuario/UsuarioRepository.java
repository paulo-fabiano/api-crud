package com.api.estoque.api_crud.Repository.usuario;

import com.api.estoque.api_crud.entity.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    // Procurar usuário por email
    Optional<UsuarioEntity> findByEmail(String email);

}
