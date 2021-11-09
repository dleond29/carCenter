package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Repuesto;

import java.util.List;
import java.util.Optional;

public interface IRepuestoService {

    Repuesto agregarRepuesto(Repuesto repuesto);

    List<Repuesto> traerRepuestos();

    Optional<Repuesto> buscarRepuesto(Long id);

    Repuesto editarRepuesto(Repuesto repuesto) throws ResourceNotFoundException;

    void eliminarRepuesto(Long id) throws ResourceNotFoundException;

}
