package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Cliente;
import com.carcenter.carCenter.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> traerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarCliente(Long id)  {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente editarCliente(Cliente cliente) throws ResourceNotFoundException {
        if(clienteRepository.existsById(cliente.getId())){
            clienteRepository.save(cliente);
            return cliente;
        }else{
            throw new ResourceNotFoundException("El cliente con id " + cliente.getId() + " que quiere modificar no fue encontrado");
        }
    }

    @Override
    public void eliminarCliente(Long id) throws ResourceNotFoundException {

        if (clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No se encontró el cliente con id " + id);
        }
    }

}
