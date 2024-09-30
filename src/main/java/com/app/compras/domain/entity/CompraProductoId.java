package com.app.compras.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CompraProductoId implements Serializable {
    private int idCompra;
    private int idProducto;
}
