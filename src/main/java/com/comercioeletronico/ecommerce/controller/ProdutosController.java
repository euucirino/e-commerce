package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public ResponseEntity<List<Produtos>> findAll() {
        List<Produtos> produtos = repository.findAll();
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable Integer id) {
        System.out.println("Buscando produto com id: " + id); // Adicionando log para debug
        Optional<Produtos> produtoOpt = repository.findById(id);

        if (produtoOpt.isEmpty()) {
            System.out.println("Produto não encontrado!"); // Log adicional
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não encontrado
        }

        Produtos produto = produtoOpt.get();
        System.out.println("Produto encontrado: " + produto); // Log para verificação

        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produtos> save(@RequestBody Produtos produto) {
        try {
            produto = repository.save(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
        } catch (Exception e) {
            e.printStackTrace();  // Logando a exceção para ajudar a depurar
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
