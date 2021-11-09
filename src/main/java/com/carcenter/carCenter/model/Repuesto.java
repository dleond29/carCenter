package com.carcenter.carCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Repuestos")
@Getter
@Setter
public class Repuesto {
    @Id
    @SequenceGenerator(name = "repuesto_sequence", sequenceName = "repuesto_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repuesto_sequence")
    private Long id;
    private String nombreRepuesto;
    private Integer precioPorUnidad;
    private Integer numeroDeUnidades;
    private Integer descuento;

    @OneToMany(mappedBy = "repuesto")
    @JsonIgnore
    private Set<Factura> facturaSet;
}
