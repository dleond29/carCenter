package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Mecanico;
import com.carcenter.carCenter.repository.IMecanicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MecanicoService implements IMecanicoService{

    @Autowired
    IMecanicoRepository mecanicoRepository;

    @Override
    public Mecanico agregarMecanico(Mecanico mecanico) {

        mecanicoRepository.save(mecanico);
        return mecanico;
    }

    @Override
    public List<Mecanico> traerMecanicos() {
        return mecanicoRepository.findAll();
    }

    @Override
    public Optional<Mecanico> buscarMecanico(Long id)  {


        return mecanicoRepository.findById(id);


    }

    @Override
    public Mecanico editarMecanico(Mecanico mecanico) throws ResourceNotFoundException {
        if(mecanicoRepository.existsById(mecanico.getId())){
            mecanicoRepository.save(mecanico);
            return mecanico;
        }else{
            throw new ResourceNotFoundException("El mecánico con id " + mecanico.getId() + " que quiere modificar no fue encontrado");
        }
    }

    @Override
    public void eliminarMecanico(Long id) throws ResourceNotFoundException {

        if (mecanicoRepository.findById(id).isPresent()){
            mecanicoRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No se encontró el mecánico con id " + id);
        }
    }
}
