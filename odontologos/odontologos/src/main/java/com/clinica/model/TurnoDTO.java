package com.clinica.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TurnoDTO {

    private Long id;
    private String fecha;
    private Paciente paciente;
    private Odontologo odontologo;

}
