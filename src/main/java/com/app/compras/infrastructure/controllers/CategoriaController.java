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

import com.app.compras.application.services.ICategoriaService;
import com.app.compras.domain.entity.Categoria;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "http://localhost:5173") 
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public List<Categoria> list() {
        return categoriaService.findAll();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<?> view(@PathVariable int idCategoria) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(idCategoria);
        if (categoriaOptional.isPresent()) {
            return ResponseEntity.ok(categoriaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable int idCategoria) {
        Optional<Categoria> categoriaOptional = categoriaService.update(idCategoria, categoria);
        if (categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<?> delete(@PathVariable int idCategoria) {
        Optional<Categoria> categoriaOptional = categoriaService.findById(idCategoria);
        if (!categoriaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria no encontrado");
        }
        Optional<Categoria> categoriaEliminado = categoriaService.delete(idCategoria);
        if (categoriaEliminado.isPresent()) {
            return ResponseEntity.ok(categoriaEliminado.orElseThrow());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la categoria");
    }
}
