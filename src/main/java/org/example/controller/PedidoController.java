package org.example.controller;

import org.example.dto.LoginResponseDTO;
import org.example.dto.PedidoDTO;
import org.example.model.Pedido;
import org.example.service.PedidoService;

import java.util.List;

public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController() {

        this.pedidoService = new PedidoService();
    }

    public Pedido crearPedido(LoginResponseDTO user, PedidoDTO pedido) {

        return this.pedidoService.save(user, pedido);
    }

    public List<Pedido> listarPedidos(LoginResponseDTO user) {

        return this.pedidoService.getByUser(user);
    }
}
