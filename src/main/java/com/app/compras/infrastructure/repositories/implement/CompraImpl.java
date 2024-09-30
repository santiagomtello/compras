package com.app.compras.infrastructure.repositories.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.compras.application.services.ICompraService;
import com.app.compras.domain.entity.Compra;
import com.app.compras.infrastructure.repositories.CompraRepository;

@Service
public class CompraImpl implements ICompraService{

    @Autowired
    private CompraRepository compraRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Compra> delete(int idCompra) {
        Optional<Compra> compraOp = compraRepository.findById(idCompra);
        compraOp.ifPresent(compraDb -> {
            compraRepository.delete(compraDb);
        });
        return compraOp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Compra> findAll() {
        return (List<Compra>) compraRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Compra> findById(int idCompra) {
        return compraRepository.findById(idCompra);
    }

    @Transactional
    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Transactional
    @Override
    public Optional<Compra> update(int idCompra, Compra compra) {
        Optional<Compra> compraOld = compraRepository.findById(idCompra);
        if (compraOld.isPresent()) {
            Compra compraDb = compraOld.orElseThrow();
            compraDb.setFecha(compra.getFecha());
            compraDb.setMedioPago(compra.getMedioPago());
            compraDb.setComentario(compra.getComentario());
            compraDb.setEstado(compra.getEstado());
            compraDb.setCliente(compra.getCliente());
            return Optional.of(compraRepository.save(compraDb));
        }
        return Optional.empty();
    }
}
