package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Categorias;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
}
