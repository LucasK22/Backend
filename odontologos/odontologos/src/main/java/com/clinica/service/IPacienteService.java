package com.clinica.service;

import com.clinica.model.PacienteDTO;

import java.util.Collection;
import java.util.Set;

public interface IPacienteService{

    public void crearPaciente(PacienteDTO p);

    public PacienteDTO leerPaciente(Long id);

    public void actualizarPaciente(PacienteDTO pacienteDTO);

    public void eliminarPaciente(Long id);

    public Collection<PacienteDTO> getAll();

}
