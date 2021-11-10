package com.carcenter.carCenter.controller;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Repuesto;
import com.carcenter.carCenter.model.Servicio;
import com.carcenter.carCenter.service.RepuestoService;
import com.carcenter.carCenter.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping()
    public ResponseEntity<Servicio> addServicio(@RequestBody Servicio servicio) throws BadRequestException, ResourceNotFoundException {

        return ResponseEntity.ok(servicioService.agregarServicio(servicio));
    }

    @GetMapping()
    public ResponseEntity<List<Servicio>> listServicios(){
        return ResponseEntity.ok(servicioService.traerServicios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarServicio(@PathVariable Long id)  {
        Servicio servicio = servicioService.buscarServicio(id).orElse(null);
        return ResponseEntity.ok(servicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServicio(@PathVariable long id) throws ResourceNotFoundException
    {
        servicioService.eliminarServicio(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
