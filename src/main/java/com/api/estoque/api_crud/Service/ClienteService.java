package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.entity.Cliente;
import com.api.estoque.api_crud.Exceptions.ClienteNaoEncontrado;
import com.api.estoque.api_crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarCliente(Long id) { return clienteRepository.findById(id); }



    public Cliente atualizarCliente(Long id, Cliente cliente) throws ClienteNaoEncontrado{
      Optional<Cliente> clienteOpt = clienteRepository.findById(id);
      if (!clienteOpt.isPresent()) {
          throw new ClienteNaoEncontrado("Cliente não encontrado");
      }
      return clienteRepository.save(cliente);
    };

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
