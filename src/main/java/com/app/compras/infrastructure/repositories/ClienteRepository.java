package com.app.compras.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.compras.domain.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

}
