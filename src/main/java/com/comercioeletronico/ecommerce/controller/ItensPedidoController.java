package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.dto.ItensPedidoRequestDTO;
import com.comercioeletronico.ecommerce.model.ItensPedido;
import com.comercioeletronico.ecommerce.model.Pedidos;
import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.repository.ItensPedidoRepository;
import com.comercioeletronico.ecommerce.repository.PedidosRepository;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItensPedidoController {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @PostMapping
    public ItensPedido addItemPedido(@RequestBody ItensPedidoRequestDTO itemDTO) {
        ItensPedido item = new ItensPedido();

        // Recuperar os objetos relacionados com base nos IDs passados
        Pedidos pedido = pedidosRepository.findById(itemDTO.idPedido()).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        Produtos produto = produtosRepository.findById(itemDTO.idProduto()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Atribuir os objetos ao item do pedido
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(itemDTO.quantidade());

        item.setPrecoUnitario(BigDecimal.valueOf(itemDTO.precoUnitario()));

        return itensPedidoRepository.save(item);
    }

    @GetMapping
    public List<ItensPedido> getAllItems() {
        return itensPedidoRepository.findAll();
    }
}
