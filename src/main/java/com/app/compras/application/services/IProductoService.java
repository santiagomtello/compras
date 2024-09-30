package com.app.compras.application.services;

import java.util.List;
import java.util.Optional;

import com.app.compras.domain.entity.Producto;


public interface IProductoService {
    List<Producto> findAll();
    
    Optional<Producto> findById(int idProducto);

    Producto save(Producto producto);

    Optional<Producto> update(int idProducto, Producto producto);

    Optional<Producto> delete(int idProducto);
}
