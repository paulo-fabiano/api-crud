package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.entity.Boleto;
import com.api.estoque.api_crud.Exceptions.BoletoNaoAdicionado;
import com.api.estoque.api_crud.repository.BoletoRepostirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoletoService {

    @Autowired
    private BoletoRepostirory boletoRepostirory;

    public Boleto adicinarBoleto(Boleto boleto) throws BoletoNaoAdicionado{
        try {
            return boletoRepostirory.save(boleto);
        } catch (DataAccessException erro) {
            throw new BoletoNaoAdicionado("Erro ao adicionar o boleto: " + erro.getMessage());
        }
    }

    public List<Boleto> listarBoleto() {
//        try {
//            return boletoRepostirory.findAll();
//        } catch (DataAccessException e) {
//            throw new BoletoNaoEncontrado("Erro ao buscar a lista de boletos: " + e.getMessage());
//        }
        return boletoRepostirory.findAll();
    }

    public void apagarBoleto(Long id) {
        boletoRepostirory.deleteById(id);
    }

}
