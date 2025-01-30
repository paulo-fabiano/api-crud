package com.api.estoque.api_crud.Service;

import com.api.estoque.api_crud.dto.categoria.CategoriaResponseDTO;
import com.api.estoque.api_crud.entity.Categoria.CategoriaEntity;
import com.api.estoque.api_crud.repository.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Salvando a categoria
    public CategoriaEntity adicionarCategoria(CategoriaEntity categoria) {
        return categoriaRepository.save(categoria);
    }

    // Buscando categorias
    public List<CategoriaResponseDTO> buscarCategorias() {
        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        List<CategoriaResponseDTO> resp = new ArrayList<>();
        for (CategoriaEntity c : categorias) {
            CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO(c.getId(), c.getNomeCategoria());
            resp.add(categoriaResponseDTO);
        }
        return resp;
    }

    // Removendo categoria
    public void removerCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

}
