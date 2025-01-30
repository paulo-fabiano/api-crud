package com.api.estoque.api_crud.repository.ProdutoItem;

import com.api.estoque.api_crud.entity.ProdutoItemEntity.ProdutoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoItemRepository extends JpaRepository<ProdutoItemEntity, Long> {
}
