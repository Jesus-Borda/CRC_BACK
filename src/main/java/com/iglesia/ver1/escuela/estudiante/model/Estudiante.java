package com.iglesia.ver1.escuela.estudiante.model;

import com.iglesia.ver1.core.personas.model.Persona;
import jakarta.persistence.*;


@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Estudiante() {
    }

    public Estudiante(Long id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", persona=" + persona +
                '}';
    }
}
