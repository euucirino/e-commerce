package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.ItensPedido;
import com.comercioeletronico.ecommerce.model.ItensPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, ItensPedidoId> {
}


