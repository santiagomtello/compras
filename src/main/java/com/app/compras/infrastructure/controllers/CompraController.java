package com.app.compras.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.compras.application.services.ICompraService;
import com.app.compras.domain.entity.Compra;

@RestController
@RequestMapping("/api/compra")
public class CompraController {
    @Autowired
    private ICompraService compraService;

    @GetMapping
    public List<Compra> list() {
        return compraService.findAll();
    }

    @GetMapping("/{idCompra}")
    public ResponseEntity<?> view(@PathVariable int idCompra) {
        Optional<Compra> compraOptional = compraService.findById(idCompra);
        if (compraOptional.isPresent()) {
            return ResponseEntity.ok(compraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Compra compra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.save(compra));
    }

    @PutMapping("/{idCompra}")
    public ResponseEntity<?> update(@RequestBody Compra compra, @PathVariable int idCompra) {
        Optional<Compra> compraOptional = compraService.update(idCompra, compra);
        if (compraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(compraOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCompra}")
    public ResponseEntity<?> delete(@PathVariable int idCompra) {
        Optional<Compra> compraOptional = compraService.findById(idCompra);
        if (!compraOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra no encontrado");
        }
        Optional<Compra> compraEliminado = compraService.delete(idCompra);
        if (compraEliminado.isPresent()) {
            return ResponseEntity.ok(compraEliminado.orElseThrow());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el compra");
    }
}
