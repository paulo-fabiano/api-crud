package com.api.estoque.api_crud.repository.Categoria;


import com.api.estoque.api_crud.entity.Categoria.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long > {

}
