package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "formas_pagamento")
public class FormasPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    private int idFormaPagamento;

    @Column(name = "descricao", nullable = false)
    private String descricao;


    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormasPagamento that = (FormasPagamento) o;
        return idFormaPagamento == that.idFormaPagamento;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFormaPagamento);
    }
}
