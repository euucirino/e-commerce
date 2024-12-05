package com.comercioeletronico.ecommerce.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record PagamentosRequestDTO(Integer idPedido, Integer idFormaPagamento, BigDecimal valorPago, Timestamp dataPagamento) {
}

