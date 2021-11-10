package com.carcenter.carCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Servicios")
@Getter
@Setter
public class Servicio {
    @Id
    @SequenceGenerator(name = "servicio_sequence", sequenceName = "servicio_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_sequence")
    private Long id;
    private String nombreServicio;
    private Integer manoDeObra;
    private Double descuento;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore //sino entra en un ciclo infinito
    private Set<Factura> facturaSet;

}
