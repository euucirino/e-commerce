package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
}