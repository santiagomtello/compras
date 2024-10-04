package com.app.compras.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;

import com.app.compras.domain.entity.CompraProducto;
import com.app.compras.domain.entity.CompraProductoId;

public interface CompraProductoRepository extends CrudRepository<CompraProducto,CompraProductoId>{

}
