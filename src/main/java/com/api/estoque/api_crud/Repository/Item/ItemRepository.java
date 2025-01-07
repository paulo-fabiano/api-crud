package com.api.estoque.api_crud.Repository.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.estoque.api_crud.Entity.Item.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    /**
     * Quando estendemos o JpaReposirory é necessário especificar dois tipos genéricos.
     * O tipo da entidade e o tipo da chave primária desse objeto.
     */
    @Query( value = "SELECT * FROM table_itens WHERE quantidade_item = 0", nativeQuery = true )
    List<ItemEntity> buscarItemEsgotados();

}
