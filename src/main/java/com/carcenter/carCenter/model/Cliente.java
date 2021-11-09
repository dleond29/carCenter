package com.carcenter.carCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clientes")
@Getter
@Setter
public class Cliente {
    @Id
    @SequenceGenerator(name = "cliente_sequence", sequenceName = "cliente_sequence", allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
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

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<Factura> facturaSet;
}
