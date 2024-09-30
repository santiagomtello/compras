package com.app.compras.infrastructure.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.compras.application.services.IProductoService;
import com.app.compras.domain.entity.Producto;

@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<Producto> list() {
        return productoService.findAll();
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<?> view(@PathVariable int idProducto) {
        Optional<Producto> productoOptional = productoService.findById(idProducto);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable int idProducto) {
        Optional<Producto> productoOptional = productoService.update(idProducto, producto);
        if (productoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<?> delete(@PathVariable int idProducto) {
        Optional<Producto> productoOptional = productoService.findById(idProducto); // Primero buscar si existe el
                                                                                    // producto

        if (!productoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }

        // Si el producto existe, intentar eliminarlo
        Optional<Producto> productoEliminado = productoService.delete(idProducto);
        if (productoEliminado.isPresent()) {
            return ResponseEntity.ok(productoEliminado.orElseThrow());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el producto");
    }

}
