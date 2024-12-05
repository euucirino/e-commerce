package com.comercioeletronico.ecommerce.dto;

public record ItensPedidoRequestDTO(Integer idPedido, Integer idProduto, Integer quantidade, Double precoUnitario) {
}
