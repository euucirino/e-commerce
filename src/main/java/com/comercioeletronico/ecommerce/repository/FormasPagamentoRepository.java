package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.FormasPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormasPagamentoRepository extends JpaRepository<FormasPagamento, Integer> {

}

