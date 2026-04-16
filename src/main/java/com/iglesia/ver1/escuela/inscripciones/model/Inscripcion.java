package com.iglesia.ver1.escuela.inscripciones.model;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import jakarta.persistence.*;

@Entity
@Table(name = "Inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia_dictada")
    private MateriaDictada materiaDictada;

    public Inscripcion() {
    }

    public Inscripcion(Long id, Estudiante estudiante, MateriaDictada materiaDictada) {
        this.id = id;
        this.estudiante = estudiante;
        this.materiaDictada = materiaDictada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", estudiante=" + estudiante +
                ", materiaDictada=" + materiaDictada +
                '}';
    }

}
