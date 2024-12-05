package com.comercioeletronico.ecommerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {

    @EmbeddedId
    private ItensPedidoId id = new ItensPedidoId();

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto")
    private Produtos produto;

    @Column
    private Integer quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal precoUnitario;

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

    public BigDecimal calcularTotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}
