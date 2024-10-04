package com.app.compras.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.compras.application.services.ICompraProductoService;
import com.app.compras.domain.entity.CompraProducto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/compraProducto")
@CrossOrigin(origins = "http://localhost:5173")
public class CompraProductoController {
    @Autowired
    private ICompraProductoService compraProductoService;

    @GetMapping
    public List<CompraProducto> list() {
        return compraProductoService.findAll();
    }
    
    @GetMapping("/{idCompraProducto}")
    public ResponseEntity<?> view(@PathVariable ) {
        return new String();
    }
    
}
