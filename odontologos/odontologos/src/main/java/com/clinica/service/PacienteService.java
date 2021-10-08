package com.clinica.service;

import com.clinica.model.Paciente;
import com.clinica.model.PacienteDTO;
import com.clinica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository IPacienteRepository;

    @Autowired
    ObjectMapper mapper;

    public void crearPaciente(PacienteDTO p) {
        Paciente paciente = mapper.convertValue(p, Paciente.class);
        IPacienteRepository.save(paciente);
    }

    public PacienteDTO leerPaciente(Long id) {
        PacienteDTO pacienteDTO = null;
        Optional<Paciente> paciente = IPacienteRepository.findById(id);
        if (paciente.isPresent()) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    public void actualizarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        IPacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) {
        IPacienteRepository.deleteById(id);
    }

    public Collection<PacienteDTO> getAll() {
        List<Paciente> pacientes = IPacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente : pacientes) {
            PacienteDTO pacienteDTO = new PacienteDTO();

            pacienteDTO.setNombre(paciente.getNombre());
            pacienteDTO.setApellido(paciente.getApellido());
            pacienteDTO.setId(paciente.getId());

            pacientesDTO.add(pacienteDTO);
        }
        return pacientesDTO;
    }

}


