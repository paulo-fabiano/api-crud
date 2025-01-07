package com.api.estoque.api_crud.Service.Usuario;

import com.api.estoque.api_crud.DTO.Usuario.UsuarioRequestDTO;
import com.api.estoque.api_crud.Entity.Usuario.UsuarioEntity;
import com.api.estoque.api_crud.Repository.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Função que tranforma UsuarioRequestDTO em Usuário
    public UsuarioEntity tranformaEmUsuario(UsuarioRequestDTO dto) {
        UsuarioEntity usuario = new UsuarioEntity(
                dto.getNomeUsuario(),
                dto.getSobrenomeUsuario(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getTelefone()
        );
        return usuario;
    }

    // Função que salva um usuário
    public UsuarioEntity salvarUsuario(UsuarioRequestDTO dto) throws SQLException {
        try {
            return usuarioRepository.save(tranformaEmUsuario(dto));
        }
        catch (Exception e) {
            throw new SQLException("Erro ao salvar "+e.getMessage());
        }
    }

    // Função para buscar todos os usuários
    public List<UsuarioEntity> buscarUsuarios() throws SQLException {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

}
