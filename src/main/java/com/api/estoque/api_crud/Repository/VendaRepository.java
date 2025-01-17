package com.api.estoque.api_crud.Repository;

import com.api.estoque.api_crud.entity.Venda.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {

    /*
        Essa consulta irá buscar o valor das vendas realizadas no dia.
     */
    @Query( value = "SELECT valor_venda FROM venda WHERE data_venda = :dia", nativeQuery = true )
    List<BigDecimal> buscarPorDia(@Param("dia") LocalDate dia);

    /*
        Essa consulta irá buscar o valor das vendas realizadas nos últimos sete dias
     */
    @Query( value = "SELECT valor_venda FROM venda WHERE data_venda BETWEEN :dataInicio AND :dataFim", nativeQuery = true )
    List<BigDecimal> buscarPorSemana(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

}
