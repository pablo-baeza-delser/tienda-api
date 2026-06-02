package com.tienda.api.controller;

import com.tienda.api.model.EstadoPedido;
import com.tienda.api.model.Pedido;
import com.tienda.api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable int id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        pedidoService.eliminar(id);
    }

    @GetMapping("cliente/{idCliente}")
    public List<Pedido> buscarPorCliente(@PathVariable int idCliente) {
        return pedidoService.obtenerPorCliente(idCliente);
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstado(@PathVariable int id, @RequestBody EstadoPedido estado) {
        pedidoService.cambiarEstado(id, estado);
    }
}
