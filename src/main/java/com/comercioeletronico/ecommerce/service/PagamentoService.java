package com.comercioeletronico.ecommerce.service;

import com.comercioeletronico.ecommerce.model.Pagamento;

import java.util.List;

public interface PagamentoService {
    Pagamento criarPagamento(Pagamento pagamento);
    List<Pagamento> listarPagamentos();
    Pagamento buscarPagamentoPorId(Integer id);
}

