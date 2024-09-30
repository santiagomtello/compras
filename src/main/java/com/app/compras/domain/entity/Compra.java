package com.app.compras.domain.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "compras")
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int idCompra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false ,name = "medio_pago")
    private MedioPago medioPago;

    @Column(length = 100, nullable = true)
    private String comentario;

    @Column(length = 1, nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
