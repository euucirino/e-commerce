package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Pedidos;
import com.comercioeletronico.ecommerce.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> pedidos = repository.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> findById(@PathVariable Integer id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedidos> save(@RequestBody Pedidos pedido) {
        try {
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(calcularTotalPedido(pedido));

            Pedidos savedPedido = repository.save(pedido);
            return ResponseEntity.status(201).body(savedPedido);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> update(@PathVariable Integer id, @RequestBody Pedidos pedido) {
        return repository.findById(id).map(existingPedido -> {
            existingPedido.setDataPedido(pedido.getDataPedido());
            existingPedido.setItensPedido(pedido.getItensPedido());
            existingPedido.setTotal(calcularTotalPedido(pedido));

            repository.save(existingPedido);
            return ResponseEntity.ok(existingPedido);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            Pedidos pedido = this.repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

            this.repository.delete(pedido);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    private BigDecimal calcularTotalPedido(Pedidos pedido) {
        return pedido.getItensPedido().stream()
                .map(itens -> itens.getPrecoUnitario().multiply(BigDecimal.valueOf(itens.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
