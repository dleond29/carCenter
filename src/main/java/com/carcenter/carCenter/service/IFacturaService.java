package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Factura;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {

    Factura crearFactura(Factura factura) throws BadRequestException;

    List<Factura> traerFacturas();

    Optional<Factura> buscarFactura(Long id);

    Factura editarFactura(Factura factura) throws ResourceNotFoundException;

    List<Factura> traerFacturasPorEstado(Boolean estado) throws BadRequestException;

    void eliminarFactura(Long id) throws ResourceNotFoundException;
}
