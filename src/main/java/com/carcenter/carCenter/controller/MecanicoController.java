package com.carcenter.carCenter.controller;

import com.carcenter.carCenter.exception.BadRequestException;
import com.carcenter.carCenter.model.Mecanico;
import com.carcenter.carCenter.service.MecanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/mecanico")
public class MecanicoController {
    @Autowired
    private MecanicoService mecanicoService;

    @PostMapping()
    public ResponseEntity<Mecanico> addMecanico(@RequestBody Mecanico mecanico) throws BadRequestException {

        return ResponseEntity.ok(mecanicoService.agregarMecanico(mecanico));
    }

    @GetMapping()
    public ResponseEntity<List<Mecanico>> listMecanicos(){
        return ResponseEntity.ok(mecanicoService.traerMecanicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mecanico> buscarMecanico(@PathVariable Long id)  {
        Mecanico mecanico = mecanicoService.buscarMecanico(id).orElse(null);
        return ResponseEntity.ok(mecanico);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
