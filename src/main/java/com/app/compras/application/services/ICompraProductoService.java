package com.app.compras.application.services;

import java.util.List;
import java.util.Optional;

import com.app.compras.domain.entity.CompraProducto;
import com.app.compras.domain.entity.CompraProductoId;

public interface ICompraProductoService {
    List<CompraProducto> findAll();
    
    Optional<CompraProducto> findById(CompraProductoId id);

    CompraProducto save(CompraProducto compra);

    Optional<CompraProducto> update(CompraProductoId id, CompraProducto compra);

    Optional<CompraProducto> delete(CompraProductoId id);
}
