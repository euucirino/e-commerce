package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Pedidos;
import java.util.List;

public interface PedidoServiceInterface {
    List<Pedidos> buscarTodosPedidos();
    Pedidos buscarPedidoPorId(int idPedido);
    Pedidos salvarPedido(Pedidos pedido);
    void deletarPedido(int idPedido);
}
