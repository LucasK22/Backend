package com.clinica.service;

import com.clinica.model.Turno;
import com.clinica.model.TurnoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public interface ITurnoService {

    public void crearTurno(TurnoDTO turnoDTO);

    public Collection<TurnoDTO> getAll();

}
