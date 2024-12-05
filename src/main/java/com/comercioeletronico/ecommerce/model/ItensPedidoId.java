package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ItensPedidoId implements Serializable {

    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "id_produto")
    private Integer idProduto;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}
