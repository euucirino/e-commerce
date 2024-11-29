package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
