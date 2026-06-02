package com.tienda.api.controller;

import com.tienda.api.model.Categoria;
import com.tienda.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerTodos() {
        return categoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable int id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        categoriaService.eliminar(id);
    }
}
