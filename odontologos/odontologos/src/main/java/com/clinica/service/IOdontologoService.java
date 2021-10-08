package com.clinica.service;

import com.clinica.model.Odontologo;
import com.clinica.model.OdontologoDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {

    public void crearOdontologo(OdontologoDTO o);

    public OdontologoDTO leerOdontologo(Long id);

    public void actualizarOdontologo(OdontologoDTO odontologoDTO);

    public void eliminarOdontologo(Long id);

    public Collection<OdontologoDTO> getAll();

}
