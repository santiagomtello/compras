package com.app.compras.application.services;

import java.util.List;
import java.util.Optional;

import com.app.compras.domain.entity.Cliente;

public interface IClienteService {
    List<Cliente> findAll();
    
    Optional<Cliente> findById(String idCliente);

    Cliente save(Cliente cliente);

    Optional<Cliente> update(String idCliente, Cliente cliente);

    Optional<Cliente> delete(String idCliente);
}
