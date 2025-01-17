package com.api.estoque.api_crud.Service.Usuario;

import com.api.estoque.api_crud.dto.usuario.CreateUserDto;
import com.api.estoque.api_crud.dto.usuario.LoginUserDto;
import com.api.estoque.api_crud.dto.usuario.RecoveryJwtTokenDto;
import com.api.estoque.api_crud.entity.role.Role;
import com.api.estoque.api_crud.entity.usuario.UsuarioEntity;
import com.api.estoque.api_crud.Repository.usuario.UsuarioRepository;
import com.api.estoque.api_crud.security.config.SecurityConfiguration;
import com.api.estoque.api_crud.security.jwt.JwtTokenService;
import com.api.estoque.api_crud.security.usuarioDetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    // Método responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    // Método responsável por criar um usuário
    public void createUser(CreateUserDto createUserDto) {

        try {
            // Cria um novo usuário com os dados fornecidos
            UsuarioEntity newUser = UsuarioEntity.builder()
                    .email(createUserDto.email())
                    // Codifica a senha do usuário com o algoritmo bcrypt
                    .senha(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
                    // Atribui ao usuário uma permissão específica
                    .roles(List.of(Role.builder().name(createUserDto.role()).build()))
                    .build();

            // Salva o novo usuário no banco de dados
            usuarioRepository.save(newUser);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao criar usuário");
        }
    }

}
