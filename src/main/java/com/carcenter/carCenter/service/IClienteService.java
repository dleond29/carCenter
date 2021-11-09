package com.carcenter.carCenter.service;

import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Cliente agregarCliente(Cliente cliente);
    List<Cliente> traerClientes();
    Optional<Cliente> buscarCliente(Long id);
    Cliente editarCliente(Cliente cliente) throws ResourceNotFoundException;
    void eliminarCliente(Long id) throws ResourceNotFoundException;
}
