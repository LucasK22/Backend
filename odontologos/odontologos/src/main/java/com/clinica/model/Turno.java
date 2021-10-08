package com.clinica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Turnos")
@Setter @Getter
public class Turno {

    @Id
    @GeneratedValue
    private Long id;
    private String fecha;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;
}




