package com.tienda.api.controller;

import com.tienda.api.model.Producto;
import com.tienda.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable int id) {
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        productoService.eliminar(id);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Producto> obtenerPorCategoria(@PathVariable int idCategoria) {
        return productoService.obtenerPorCategoria(idCategoria);
    }
}
