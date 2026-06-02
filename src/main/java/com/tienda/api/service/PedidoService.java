package com.tienda.api.service;

import com.tienda.api.model.EstadoPedido;
import com.tienda.api.model.Pedido;
import com.tienda.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(int id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void eliminar(int id) {
        pedidoRepository.deleteById(id);
    }

    public List<Pedido> obtenerPorCliente(int idCliente) {
        return pedidoRepository.findByCliente_Id(idCliente);
    }

    public void cambiarEstado(int id, EstadoPedido estado) {
        Pedido pedido = pedidoRepository.findById(id).get();
        pedido.setEstado(estado);
        pedidoRepository.save(pedido);
    }
}
