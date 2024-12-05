package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Pagamentos;
import com.comercioeletronico.ecommerce.repository.PagamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentosRepository repository;

    @GetMapping
    public ResponseEntity<List<Pagamentos>> findAll() {
        List<Pagamentos> pagamentos = repository.findAll();
        if (pagamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamentos> findById(@PathVariable Integer id) {
        Pagamentos pagamento = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
        return ResponseEntity.ok(pagamento);
    }
}
