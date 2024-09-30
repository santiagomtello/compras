package com.app.compras.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 150, name = "codigo_barras", nullable = false)
    private String codigoBarras;

    @Column(precision = 16, scale = 2,name = "precio_venta", nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "cantidad_stock", nullable = false)
    private int cantidadStock;

    @Column(nullable = false)
    private byte estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Producto() {
    }
}
