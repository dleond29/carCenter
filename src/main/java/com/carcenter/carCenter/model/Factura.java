package com.carcenter.carCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private Double costoLimite;


    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="mecanico_id", nullable = false)
    private Mecanico mecanico;

    @ManyToOne
    @JoinColumn(name="servicio_id", nullable = false)
    private Servicio servicio;

}
