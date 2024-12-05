package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.*;

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
}
