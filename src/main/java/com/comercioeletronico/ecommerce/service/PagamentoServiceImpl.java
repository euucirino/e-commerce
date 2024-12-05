package com.comercioeletronico.ecommerce.service;

import com.comercioeletronico.ecommerce.model.Pagamento;
import com.comercioeletronico.ecommerce.repository.PagamentoRepository;
import com.comercioeletronico.ecommerce.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Pagamento buscarPagamentoPorId(Integer id) {
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));
    }
}
