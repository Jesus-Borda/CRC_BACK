package com.iglesia.ver1.escuela.inscripcionmateria.model;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import jakarta.persistence.*;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long idInscripcion;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia_dictada")
    private MateriaDictada materiaDictada;

    public Inscripcion() {
    }

    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public MateriaDictada getMateriaDictada() {
        return materiaDictada;
    }

    public void setMateriaDictada(MateriaDictada materiaDictada) {
        this.materiaDictada = materiaDictada;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", estudiante=" + estudiante +
                ", materiaDictada=" + materiaDictada +
                '}';
    }
}
