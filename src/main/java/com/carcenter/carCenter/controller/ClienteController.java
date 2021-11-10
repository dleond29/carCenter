package com.carcenter.carCenter.controller;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Cliente;
import com.carcenter.carCenter.model.Servicio;
import com.carcenter.carCenter.service.ClienteService;
import com.carcenter.carCenter.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) throws BadRequestException {

        return ResponseEntity.ok(clienteService.agregarCliente(cliente));
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> listClientes(){
        return ResponseEntity.ok(clienteService.traerClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id)  {
        Cliente cliente = clienteService.buscarCliente(id).orElse(null);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable long id) throws ResourceNotFoundException
    {
        clienteService.eliminarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
