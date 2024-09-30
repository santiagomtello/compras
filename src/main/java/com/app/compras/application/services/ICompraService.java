package com.app.compras.application.services;

import java.util.List;
import java.util.Optional;

import com.app.compras.domain.entity.Compra;

public interface ICompraService {
    List<Compra> findAll();
    
    Optional<Compra> findById(int idCompra);

    Compra save(Compra compra);

    Optional<Compra> update(int idCompra, Compra compra);

    Optional<Compra> delete(int idCompra);
}
