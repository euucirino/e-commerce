package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.dto.ProdutosRequestDTO;
import com.comercioeletronico.ecommerce.dto.UsuariosRequestDTO;
import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.model.Usuarios;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public List<Produtos> findAll(){
      return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Produtos findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    @PostMapping
    public Produtos save(@RequestBody ProdutosRequestDTO dto) {
        Produtos produtos = new Produtos();
        produtos.setNome(dto.nome());

        return this.repository.save(produtos);
    }


}
