package com.clinica.service;

import com.clinica.model.Odontologo;
import com.clinica.model.OdontologoDTO;
import com.clinica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository IOdontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearOdontologo(OdontologoDTO o) {
        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        IOdontologoRepository.save(odontologo);
    }

    public OdontologoDTO leerOdontologo(Long id) {
        OdontologoDTO odontologoDTO = null;
        Optional<Odontologo> odontologo = IOdontologoRepository.findById(id);
        if (odontologo.isPresent()) {
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        IOdontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) {
        IOdontologoRepository.deleteById(id);
    }

    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = IOdontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            OdontologoDTO odontologoDTO = new OdontologoDTO();

            odontologoDTO.setNombre(odontologo.getNombre());
            odontologoDTO.setApellido(odontologo.getApellido());
            odontologoDTO.setId(odontologo.getId());

            odontologosDTO.add(odontologoDTO);
        }
        return odontologosDTO;
    }

}

