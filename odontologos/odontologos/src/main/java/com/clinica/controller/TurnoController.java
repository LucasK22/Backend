package com.clinica.controller;

import com.clinica.model.TurnoDTO;
import com.clinica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody TurnoDTO turnoDTO)
    {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public Collection<TurnoDTO> listaTurnos()
    {
        return turnoService.getAll();
    }

}
