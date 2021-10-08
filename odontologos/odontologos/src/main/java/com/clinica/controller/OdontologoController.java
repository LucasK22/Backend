package com.clinica.controller;

import com.clinica.model.OdontologoDTO;
import com.clinica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDTO odontologoDTO)
    {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable long id)
    {
        return odontologoService.leerOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO)
    {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable long id)
    {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body("eliminado");

    }

    @GetMapping("/list")
    public Collection<OdontologoDTO> listaOdontologos()
    {
        return odontologoService.getAll();
    }

}
