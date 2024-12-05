package com.comercioeletronico.ecommerce.dto;

import java.math.BigDecimal;

public record ProdutosRequestDTO(String nome, String descricao, BigDecimal preco, Integer estoque) {
}
