package com.clinica.service;

import com.clinica.model.Turno;
import com.clinica.model.TurnoDTO;
import com.clinica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearTurno(TurnoDTO turnoDTO)
    {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    public Collection<TurnoDTO> getAll()
    {
        List<Turno> turnos = turnoRepository.findAll();

        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }

}
