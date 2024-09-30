package com.app.compras.domain.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 40, nullable = false)
    private String apellido;

    @Column(length = 10, nullable = false)
    private int celular;

    @Column(length = 80, nullable = false)
    private String direccion;

    @Column(name = "correo_electronico", length = 70, nullable = true)
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compra;
}
