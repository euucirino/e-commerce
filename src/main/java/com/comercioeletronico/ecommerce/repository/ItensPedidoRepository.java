package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.ItensPedido;
import com.comercioeletronico.ecommerce.model.ItensPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, ItensPedidoId> {
    List<ItensPedido> findByPedido_IdPedido(int id);
}

