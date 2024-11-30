package com.comercioeletronico.ecommerce.controller;


import com.comercioeletronico.ecommerce.dto.UsuariosRequestDTO;
import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.model.Usuarios;
import com.comercioeletronico.ecommerce.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public List<Usuarios> findAll() {
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
    }
    @PostMapping
    public Usuarios save(@RequestBody UsuariosRequestDTO dto) {
        Usuarios usuarios = new Usuarios();
        usuarios.setNome(dto.nome());
        usuarios.setEmail(dto.email());
        usuarios.setSenha(dto.senha());

        return this.repository.save(usuarios);
    }
}
