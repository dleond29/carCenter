package com.carcenter.carCenter.controller;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.exception.ResourceNotFoundException;
import com.carcenter.carCenter.model.Repuesto;
import com.carcenter.carCenter.service.RepuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/repuesto")
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    @PostMapping()
    public ResponseEntity<Repuesto> addRepuesto(@RequestBody Repuesto repuesto) throws BadRequestException {

        return ResponseEntity.ok(repuestoService.agregarRepuesto(repuesto));
    }

    @GetMapping()
    public ResponseEntity<List<Repuesto>> listRepuestos(){
        return ResponseEntity.ok(repuestoService.traerRepuestos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> buscarRepuesto(@PathVariable Long id)  {
        Repuesto repuesto = repuestoService.buscarRepuesto(id).orElse(null);
        return ResponseEntity.ok(repuesto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepuestos(@PathVariable long id) throws ResourceNotFoundException
    {
        repuestoService.eliminarRepuesto(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
