package com.carcenter.carCenter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Factura")
@Setter
@Getter
public class Factura {
    private Long id;
    private Integer totalFactura;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="mecanico_id", nullable = false)
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name="repuesto_id", nullable = false)
    private Repuesto repuesto;

    @ManyToOne
    @JoinColumn(name="servicio_id", nullable = false)
    private Servicio servicio;

}
