package com.api.estoque.api_crud.repository.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.estoque.api_crud.entity.item.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    /**
     * Quando estendemos o JpaReposirory é necessário especificar dois tipos genéricos.
     * O tipo da entidade e o tipo da chave primária desse objeto.
     */
    @Query( value = "SELECT * FROM itens WHERE quantidade = 0", nativeQuery = true )
    List<ItemEntity> buscarItemEsgotados();

}
