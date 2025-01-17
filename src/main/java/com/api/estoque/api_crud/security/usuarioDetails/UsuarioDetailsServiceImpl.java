package com.api.estoque.api_crud.security.usuarioDetails;

import com.api.estoque.api_crud.Repository.usuario.UsuarioRepository;
import com.api.estoque.api_crud.entity.usuario.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioEntity usuario = usuarioRepository.findByEmail(username).orElseThrow(
            () -> new RuntimeException("Usuário não encontrado!")
        );
        return new UserDetailsImpl(usuario);
    }

}
