package com.app.compras.application.services;

import java.util.List;
import java.util.Optional;

import com.app.compras.domain.entity.Categoria;

public interface ICategoriaService {
    List<Categoria> findAll();
    
    Optional<Categoria> findById(int idCategoria);

    Categoria save(Categoria categoria);

    Optional<Categoria> update(int idCategoria, Categoria categoria);

    Optional<Categoria> delete(int idCategoria);
}
