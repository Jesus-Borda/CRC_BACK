package com.iglesia.ver1.escuela.asistenciaSeminario.model;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import jakarta.persistence.*;

@Entity
@Table(name = "asistencia_seminarios")
public class AsistenciaSeminario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_seminario")
    private Seminario seminario;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    @Column (name = "asistio")
    private boolean asistencia;


    public AsistenciaSeminario() {
    }

    public AsistenciaSeminario(Long id, Seminario seminario, Estudiante estudiante, boolean asistencia) {
        this.id = id;
        this.seminario = seminario;
        this.estudiante = estudiante;
        this.asistencia = asistencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "AsistenciaSeminario{" +
                "id=" + id +
                ", seminario=" + seminario +
                ", estudiante=" + estudiante +
                ", asistencia=" + asistencia +
                '}';
    }
}
