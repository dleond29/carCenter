package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Mecanico;

import java.util.List;
import java.util.Optional;

public interface IMecanicoService {

    Mecanico agregarMecanico(Mecanico mecanico);

    List<Mecanico> traerMecanicos();

    Optional<Mecanico> buscarMecanico(Long id);

    Mecanico editarMecanico(Mecanico mecanico) throws ResourceNotFoundException;

    void eliminarMecanico(Long id) throws ResourceNotFoundException;
}
