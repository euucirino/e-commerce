package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
    public Produtos findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }


    @PostMapping
    public ResponseEntity<Produtos> save(@RequestBody Produtos produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty() ||
                produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0 ||
                produto.getEstoque() == null || produto.getEstoque() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Produtos savedProduto = repository.save(produto);
        return ResponseEntity.status(201).body(savedProduto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produtos> update(@PathVariable Integer id, @RequestBody Produtos produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty() ||
                produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0 ||
                produto.getEstoque() == null || produto.getEstoque() <= 0 ||
                produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        Produtos existingProduto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        existingProduto.setNome(produto.getNome());
        existingProduto.setDescricao(produto.getDescricao());

        this.repository.save(existingProduto);
        return ResponseEntity.ok(existingProduto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Produtos produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }
}
