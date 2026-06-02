package com.tienda.api.service;

import com.tienda.api.model.Producto;
import com.tienda.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(int id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> obtenerPorCategoria(int idCategoria) {
        return productoRepository.findByCategoria_Id(idCategoria);
    }
}
