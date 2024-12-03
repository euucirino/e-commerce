package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.dto.ProdutosRequestDTO;
import com.comercioeletronico.ecommerce.dto.UsuariosRequestDTO;
import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.model.Usuarios;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public List<Produtos> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Integer id) {
        Produtos produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produtos> save(@RequestBody ProdutosRequestDTO dto) {
        Produtos produto = new Produtos();
        produto.setNome(produto.getNome());
        produto = this.repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}

