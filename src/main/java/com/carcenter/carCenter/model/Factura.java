package com.carcenter.carCenter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Facturas")
@Setter
@Getter
public class Factura {
    @Id
    @SequenceGenerator(name = "factura_sequence", sequenceName = "factura_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_sequence")
    private Long id;
    private Double totalFactura;


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
