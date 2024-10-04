package com.app.compras.infrastructure.repositories.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.compras.application.services.ICompraProductoService;
import com.app.compras.domain.entity.CompraProducto;
import com.app.compras.domain.entity.CompraProductoId;
import com.app.compras.infrastructure.repositories.CompraProductoRepository;


@Service
public class CompraProductoImpl implements ICompraProductoService{

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Transactional
    @Override
    public Optional<CompraProducto> delete(CompraProductoId id) {
        Optional<CompraProducto> compraProductoOp = compraProductoRepository.findById(id);
        compraProductoOp.ifPresent(compraProductoDb -> {
            compraProductoRepository.delete(compraProductoDb);
        });
        return compraProductoOp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CompraProducto> findAll() {
        return (List<CompraProducto>) compraProductoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<CompraProducto> findById(CompraProductoId id) {
        return compraProductoRepository.findById(id);
    }

    @Transactional
    @Override
    public CompraProducto save(CompraProducto compraProducto) {
        return compraProductoRepository.save(compraProducto);
    }

    @Override
    public Optional<CompraProducto> update(CompraProductoId id, CompraProducto compraProducto) {
        Optional<CompraProducto> compraProductoOld = compraProductoRepository.findById(id);
        if (compraProductoOld.isPresent()){
            CompraProducto compraProductoDb = compraProductoOld.orElseThrow();
            compraProductoDb.setCompra(compraProducto.getCompra());
            compraProductoDb.setProducto(compraProducto.getProducto());
            compraProductoDb.setCantidad(compraProducto.getCantidad());
            compraProductoDb.setTotal(compraProducto.getTotal());
            compraProductoDb.setEstado(compraProducto.getEstado());
        }
        return Optional.empty();
    }
}
