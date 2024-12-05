package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Pagamento;
import com.comercioeletronico.ecommerce.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;


    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@RequestBody Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoService.criarPagamento(pagamento);
        return ResponseEntity.status(201).body(novoPagamento);
    }


    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Integer id) {
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
        return ResponseEntity.ok(pagamento);
    }
}

