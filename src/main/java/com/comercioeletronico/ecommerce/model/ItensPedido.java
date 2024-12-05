package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ItensPedido {

    @Id
    @EmbeddedId
    private ItensPedidoId id;

    @ManyToOne
    @MapsId("pedidoId")
    private Pedidos pedido;

    @ManyToOne
    @MapsId("produtoId")
    private Produtos produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal precoUnitario;

    // Getters e Setters
    public ItensPedidoId getId() {
        return id;
    }

    public void setId(ItensPedidoId id) {
        this.id = id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}
