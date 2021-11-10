package com.carcenter.carCenter.controller;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Cliente;
import com.carcenter.carCenter.model.Factura;
import com.carcenter.carCenter.service.ClienteService;
import com.carcenter.carCenter.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping()
    public ResponseEntity<Factura> addFactura(@RequestBody Factura factura) throws BadRequestException {

        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    @GetMapping()
    public ResponseEntity<List<Factura>> listFacturas(){
        return ResponseEntity.ok(facturaService.traerFacturas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarFactura(@PathVariable Long id)  {
        Factura factura = facturaService.buscarFactura(id).orElse(null);
        return ResponseEntity.ok(factura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFactura(@PathVariable long id) throws ResourceNotFoundException
    {
        facturaService.eliminarFactura(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
