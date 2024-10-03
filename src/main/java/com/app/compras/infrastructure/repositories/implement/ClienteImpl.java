package com.app.compras.infrastructure.repositories.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.compras.application.services.IClienteService;
import com.app.compras.domain.entity.Cliente;
import com.app.compras.infrastructure.repositories.ClienteRepository;

@Service
public class ClienteImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @Override
    public Optional<Cliente> delete(String id) {
        Optional<Cliente> clienteOp = clienteRepository.findById(id);
        clienteOp.ifPresent(clienteDb -> {
            clienteRepository.delete(clienteDb);
        });
        return clienteOp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    @Override
    public Optional<Cliente> update(String id, Cliente cliente) {
        Optional<Cliente> clienteOld = clienteRepository.findById(id);
        if (clienteOld.isPresent()) {
            Cliente clienteDb = clienteOld.orElseThrow();
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setApellido(cliente.getApellido());
            clienteDb.setCelular(cliente.getCelular());
            clienteDb.setDireccion(cliente.getDireccion());
            clienteDb.setCorreoElectronico(cliente.getCorreoElectronico());
            clienteDb.setCompra(cliente.getCompra());
            return Optional.of(clienteRepository.save(clienteDb));
        }
        return Optional.empty();
    }
}
