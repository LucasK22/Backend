package com.clinica.controller;

import com.clinica.model.PacienteDTO;
import com.clinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;


    @PostMapping
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO pacienteDTO)
    {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable long id)
    {
        return pacienteService.leerPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO)
    {
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable long id)
    {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");

    }

    @GetMapping("/list")
    public Collection<PacienteDTO> listaPacientes()
    {
        return pacienteService.getAll();
    }


}