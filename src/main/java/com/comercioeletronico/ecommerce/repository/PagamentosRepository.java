package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Pagamentos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentosRepository extends JpaRepository<Pagamentos, Integer> {

}
