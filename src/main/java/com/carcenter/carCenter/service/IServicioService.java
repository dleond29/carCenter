package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Servicio;

import java.util.List;
import java.util.Optional;

public interface IServicioService {

    Servicio agregarServicio(Servicio servicio) throws ResourceNotFoundException;

    List<Servicio> traerServicios();

    Optional<Servicio> buscarServicio(Long id);

    Servicio editarServicio(Servicio servicio) throws ResourceNotFoundException;

    void eliminarServicio(Long id) throws ResourceNotFoundException;

}
