package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.dto.PedidosRequestDTO;
import com.comercioeletronico.ecommerce.model.Pedidos;
import com.comercioeletronico.ecommerce.repository.PedidosRepository;
import com.comercioeletronico.ecommerce.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> pedidos = pedidosRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Pedidos pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedidosRepository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Pedidos findById(@PathVariable Integer id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Pedidos> save(@RequestBody PedidosRequestDTO dto) {
        Pedidos pedido = new Pedidos();
        pedido.setUsuario(usuariosRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")));
        pedido.setStatus(dto.status());

        pedido.setDataPedido(LocalDateTime.now());
        pedidosRepository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}



