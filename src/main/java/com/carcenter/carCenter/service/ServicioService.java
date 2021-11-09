package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Mecanico;
import com.carcenter.carCenter.model.Servicio;
import com.carcenter.carCenter.repository.IMecanicoRepository;
import com.carcenter.carCenter.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    IServicioRepository servicioRepository;

    @Override
    public Servicio agregarServicio(Servicio servicio) {

        servicioRepository.save(servicio);
        return servicio;
    }

    @Override
    public List<Servicio> traerServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> buscarServicio(Long id)  {


        return servicioRepository.findById(id);


    }

    @Override
    public Servicio editarServicio(Servicio servicio) throws ResourceNotFoundException {
        if(servicioRepository.existsById(servicio.getId())){
            servicioRepository.save(servicio);
            return servicio;
        }else{
            throw new ResourceNotFoundException("El servicio con id " + servicio.getId() + " que quiere modificar no fue encontrado");
        }
    }

    @Override
    public void eliminarServicio(Long id) throws ResourceNotFoundException {

        if (servicioRepository.findById(id).isPresent()){
            servicioRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No se encontró el servicio con id " + id);
        }
    }
}
