package com.comercioeletronico.ecommerce.service;

import com.comercioeletronico.ecommerce.model.Pedidos;
import com.comercioeletronico.ecommerce.repository.PedidoServiceInterface;
import com.comercioeletronico.ecommerce.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements PedidoServiceInterface {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Override
    public List<Pedidos> buscarTodosPedidos() {
        return pedidosRepository.findAll();
    }

    @Override
    public Pedidos buscarPedidoPorId(int idPedido) {
        Optional<Pedidos> pedido = pedidosRepository.findById(idPedido);
        return pedido.orElse(null);
    }

    @Override
    public Pedidos salvarPedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    @Override
    public void deletarPedido(int idPedido) {
        pedidosRepository.deleteById(idPedido);
    }
}
