package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Factura;
import com.carcenter.carCenter.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IMecanicoRepository mecanicoRepository;
    @Autowired
    private IRepuestoRepository repuestoRepository;
    @Autowired
    private IServicioRepository servicioRepository;
    @Autowired
    private IFacturaRepository facturaRepository;

    @Override
    public Factura crearFactura(Factura factura) throws BadRequestException{
        if(mecanicoRepository.findById(factura.getMecanico().getId()).isEmpty() || clienteRepository.findById(factura.getCliente().getId()).isEmpty()){
            throw new BadRequestException("El mecánico o el cliente no existen");
        }
        if(factura != null){
            facturaRepository.save(factura);
        }

        factura.setMecanico(mecanicoRepository.getById(factura.getMecanico().getId()));
        factura.setCliente(clienteRepository.getById(factura.getCliente().getId()));


        factura.setTotalFactura(factura.getServicio().getRepuesto().getPrecioPorUnidad()*factura.getServicio().getRepuesto().getNumeroDeUnidades());;

        if(factura.getTotalFactura()>factura.getCostoLimite()){

        }

        return factura;
    }

    @Override
    public List<Factura> traerFacturas(){
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> buscarFactura(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura editarFactura(Factura factura) throws ResourceNotFoundException {
        if (buscarFactura(factura.getId()).isPresent()) {
            return facturaRepository.save(factura);
        } else {
            throw new ResourceNotFoundException("Factura no encontrada");
        }
    }

    @Override
    public void eliminarFactura(Long id) throws ResourceNotFoundException {
        if (buscarFactura(id).isPresent()){
            facturaRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Factura no encontrada");
        }
    }
}
