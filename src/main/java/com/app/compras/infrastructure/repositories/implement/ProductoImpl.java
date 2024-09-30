package com.app.compras.infrastructure.repositories.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.compras.application.services.IProductoService;
import com.app.compras.domain.entity.Producto;
import com.app.compras.infrastructure.repositories.ProductoRepository;

@Service
public class ProductoImpl implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    @Override
    public Optional<Producto> delete(int idProducto) {
        Optional<Producto> productoOp = productoRepository.findById(idProducto);
        productoOp.ifPresent(productoDb -> {
            productoRepository.delete(productoDb);
        });
        return productoOp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(int idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Transactional
    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Transactional
    @Override
    public Optional<Producto> update(int idProducto, Producto producto) {
        Optional<Producto> productoOld = productoRepository.findById(idProducto);
        if (productoOld.isPresent()) {
            Producto productoDb = productoOld.orElseThrow();
            productoDb.setNombre(producto.getNombre());
            productoDb.setCodigoBarras(producto.getCodigoBarras());
            productoDb.setPrecioVenta(producto.getPrecioVenta());
            productoDb.setCantidadStock(producto.getCantidadStock());
            productoDb.setEstado(producto.getEstado());
            productoDb.setCategoria(producto.getCategoria());
            return Optional.of(productoRepository.save(productoDb));
        }
        return Optional.empty();
    }
}
