package com.comercioeletronico.ecommerce.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private BigDecimal preco;

    @Column
    private Integer estoque;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(idProduto, produtos.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProduto);
    }
}
