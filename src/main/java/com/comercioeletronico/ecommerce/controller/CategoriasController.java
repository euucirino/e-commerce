package com.comercioeletronico.ecommerce.controller;


import com.comercioeletronico.ecommerce.dto.CategoriasRequestDTO;
import com.comercioeletronico.ecommerce.dto.UsuariosRequestDTO;
import com.comercioeletronico.ecommerce.model.Categorias;
import com.comercioeletronico.ecommerce.model.Usuarios;
import com.comercioeletronico.ecommerce.repository.CategoriasRepository;
import com.comercioeletronico.ecommerce.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriasController {

    @Autowired
    private CategoriasRepository repository;

    @GetMapping
    public ResponseEntity<List<Categorias>>findAll() {
        List<Categorias> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public Categorias findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
    }

    @PostMapping
    public ResponseEntity<Categorias> save(@RequestBody CategoriasRequestDTO dto) {
        if (dto.nome() == null || dto.nome().isEmpty() ||
                dto.descricao() == null || dto.descricao().isEmpty()){

            return ResponseEntity.status(400).build();
        }
        Categorias categorias = new Categorias();

        categorias.setNomeCategoria(dto.nome());
        categorias.setDescricao(dto.descricao());


        this.repository.save(categorias);
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Categorias categorias = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
           this.repository.delete(categorias);
           return ResponseEntity.noContent().build();
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Categorias> update(@PathVariable Integer id, @RequestBody CategoriasRequestDTO dto) {
        if (dto.nome() == null || dto.nome().isEmpty()){

            return ResponseEntity.status(400).build();
        }

        Categorias categorias = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));


        categorias.setNomeCategoria(dto.nome());
        categorias.setDescricao(dto.descricao());


        this.repository.save(categorias);
        return ResponseEntity.ok(categorias);
    }
}
