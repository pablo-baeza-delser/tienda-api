package com.tienda.api.service;

import com.tienda.api.model.Categoria;
import com.tienda.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminar(int id) {
        categoriaRepository.deleteById(id);
    }
}
