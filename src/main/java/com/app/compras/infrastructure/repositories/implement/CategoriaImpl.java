package com.app.compras.infrastructure.repositories.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.compras.application.services.ICategoriaService;
import com.app.compras.domain.entity.Categoria;
import com.app.compras.infrastructure.repositories.CategoriaRepository;

@Service
public class CategoriaImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> delete(int idCategoria) {
        Optional<Categoria> categoriaOp = categoriaRepository.findById(idCategoria);
        categoriaOp.ifPresent(categoriaDb -> {
            categoriaRepository.delete(categoriaDb);
        });
        return categoriaOp;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> findById(int idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    @Override
    public Optional<Categoria> update(int idCategoria, Categoria categoria) {
        Optional<Categoria> categoriaOld = categoriaRepository.findById(idCategoria);
        if (categoriaOld.isPresent()) {
            Categoria categoriaDb = categoriaOld.orElseThrow();
            categoriaDb.setDescripcion(categoria.getDescripcion());
            categoriaDb.setEstado(categoria.getEstado());
            categoriaDb.setProductos(categoria.getProductos());
            return Optional.of(categoriaRepository.save(categoriaDb));
        }
        return Optional.empty();
    }
}
