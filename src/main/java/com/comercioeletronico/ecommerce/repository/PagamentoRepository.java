package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}

