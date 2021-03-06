package com.clinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Set;

@Table(name="pacientes")
@Entity
@Getter
@Setter
@ToString

public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaAlta;
    private String domicilio;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, String fechaAlta, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.domicilio = domicilio;
    }
}
