package com.carcenter.carCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Mecanicos")
@Getter
@Setter
public class Mecanico {
    @Id
    @SequenceGenerator(name = "mecanico_sequence", sequenceName = "mecanico_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mecanico_sequence")
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoDocumento;
    private Integer numeroDocumento;
    private Integer numeroCelular;
    private String direccion;
    private String correoElectronico;
    private String estado;

    @OneToMany(mappedBy = "mecanico", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Factura> facturaSet;

}
