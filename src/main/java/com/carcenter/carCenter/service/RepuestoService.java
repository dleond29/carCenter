package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Repuesto;
import com.carcenter.carCenter.repository.IRepuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoService implements IRepuestoService{

    @Autowired
    IRepuestoRepository repuestoRepository;

    @Override
    public Repuesto agregarRepuesto(Repuesto repuesto) {

        repuestoRepository.save(repuesto);
        return repuesto;
    }

    @Override
    public List<Repuesto> traerRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Optional<Repuesto> buscarRepuesto(Long id)  {


        return repuestoRepository.findById(id);


    }

    @Override
    public Repuesto editarRepuesto(Repuesto repuesto) throws ResourceNotFoundException {
        if(repuestoRepository.existsById(repuesto.getId())){
            repuestoRepository.save(repuesto);
            return repuesto;
        }else{
            throw new ResourceNotFoundException("El repuesto con id " + repuesto.getId() + " que quiere modificar no fue encontrado");
        }
    }

    @Override
    public void eliminarRepuesto(Long id) throws ResourceNotFoundException {

        if (repuestoRepository.findById(id).isPresent()){
            repuestoRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No se encontró el repuesto con id " + id);
        }
    }

}
