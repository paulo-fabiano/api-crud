package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.entity.Venda.VendaEntity;
import com.api.estoque.api_crud.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    /*
        Função que soma os valores da lista.
     */
    public Double somaVendas(List<BigDecimal> listaValores) {
        Double total = 0.0;
        for (int i = 0; i < listaValores.size(); i++) {
            total += i;
        }
        return total;
    }

    public VendaEntity registrarVenda(VendaEntity vendaEntity) {
        return vendaRepository.save(vendaEntity);
    }

    /*
        Essa função vai buscar todas as vendas realizadas.
    */
    public List<VendaEntity> buscarVendas() {
        return vendaRepository.findAll();
    }

    /*
        Essa função retorna o valor das vendas realizadas no dia.
    */
    public Double buscarVendasHoje(LocalDate dia) {
        return somaVendas(vendaRepository.buscarPorDia(dia));
    }

    /*
        Essa função retorna o valor total das vendas realizadas em uma semana.
    */
    public Double buscarVendasSemana(LocalDate dataInicio, LocalDate dataFim) {
        return somaVendas(vendaRepository.buscarPorSemana(dataInicio, dataFim));
    }

}
