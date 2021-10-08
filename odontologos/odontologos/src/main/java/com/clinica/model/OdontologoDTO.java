package com.clinica.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    public OdontologoDTO() {
    }

    public OdontologoDTO(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
