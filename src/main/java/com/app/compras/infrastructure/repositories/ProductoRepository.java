package com.app.compras.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.compras.domain.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
