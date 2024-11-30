package com.comercioeletronico.ecommerce.repository;

import com.comercioeletronico.ecommerce.model.Usuarios;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
}
