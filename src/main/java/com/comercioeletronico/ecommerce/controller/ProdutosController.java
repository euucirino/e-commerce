package com.comercioeletronico.ecommerce.controller;

import com.comercioeletronico.ecommerce.model.Produtos;
import com.comercioeletronico.ecommerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
