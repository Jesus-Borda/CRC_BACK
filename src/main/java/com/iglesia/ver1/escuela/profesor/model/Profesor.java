package com.iglesia.ver1.escuela.profesor.model;

import com.iglesia.ver1.core.personas.model.Persona;
import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Profesor() {
    }

    public Profesor(Long idProfesor, Persona persona) {
        this.idProfesor = idProfesor;
        this.persona = persona;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", persona=" + persona +
                '}';
    }
}
