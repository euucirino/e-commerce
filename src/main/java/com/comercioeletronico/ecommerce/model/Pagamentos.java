package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "pagamentos")
public class Pagamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagamento;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormasPagamento formaPagamento;

    @Column(nullable = false)
    private BigDecimal valorPago;

    @Column(name = "data_pagamento", nullable = false)
    private Timestamp dataPagamento;

    // Getters e setters
    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public FormasPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormasPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
