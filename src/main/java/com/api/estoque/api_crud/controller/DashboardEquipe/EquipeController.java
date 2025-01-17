//package com.api.estoque.api_crud.controller.DashboardEquipe;
//
//import com.api.estoque.api_crud.dto.Usuario.UsuarioRequestDTO;
//import com.api.estoque.api_crud.entity.usuario.UsuarioEntity;
//import com.api.estoque.api_crud.Service.Usuario.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping( "/api/equipe" )
//public class EquipeController {
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    // Endpoint para adicionar um colaborador
//    public ResponseEntity<?> adicionarFuncionario(@RequestBody UsuarioRequestDTO dto) {
//        try {
//            usuarioService.salvarUsuario(dto);
//            return ResponseEntity.ok(HttpStatus.CREATED);
//        }
//        catch (SQLException e) {
//            Map<String, Object> erroResponse = new HashMap<>();
//            erroResponse.put("timestamp", LocalDateTime.now());
//            erroResponse.put("status", HttpStatus.BAD_REQUEST.value());
//            erroResponse.put("erro", "Erro ao salvar usuário!");
//            erroResponse.put("mensagem", e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
//        }
//    }
//
//    // Endpoint para buscarColaboradores
//    public ResponseEntity buscarListaFuncionarios() {
//        try {
//            List<UsuarioEntity> lista = usuarioService.buscarUsuarios();
//            return ResponseEntity.ok(lista);
//        }
//        catch (SQLException e) {
//            Map<String, Object> erroResponse = new HashMap<>();
//            erroResponse.put("timestamp", LocalDateTime.now());
//            erroResponse.put("status", HttpStatus.BAD_REQUEST.value());
//            erroResponse.put("erro", "Erro ao salvar usuário!");
//            erroResponse.put("mensagem", e.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
//        }
//    }
//
//}
