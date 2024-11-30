package com.comercioeletronico.ecommerce.controller;


import com.comercioeletronico.ecommerce.dto.UsuariosRequestDTO;
import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.model.Usuarios;
import com.comercioeletronico.ecommerce.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuarios>>findAll() {
        List<Usuarios> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Usuarios> save(@RequestBody UsuariosRequestDTO dto) {
        if (dto.nome() == null || dto.nome().isEmpty() ||
                dto.email() == null || dto.email().isEmpty() ||
                dto.senha() == null || dto.senha().isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        Usuarios usuarios = new Usuarios();

        usuarios.setNome(dto.nome());
        usuarios.setEmail(dto.email());
        usuarios.setSenha(dto.senha());

        this.repository.save(usuarios);
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Usuarios usuarios = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
           this.repository.delete(usuarios);
           return ResponseEntity.noContent().build();
    }
}
