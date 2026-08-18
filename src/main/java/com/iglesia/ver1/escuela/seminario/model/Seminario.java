package com.iglesia.ver1.escuela.seminario.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "seminarios" )
public class Seminario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seminario")
    private Long idSeminario;
    @Column(name = "nombre")
    private String nombreSeminario;
    @Column(name = "fecha")
    private LocalDate fechaInicio;

    public Seminario() {
    }

    public Seminario(Long idSeminario, String nombreSeminario, LocalDate fechaInicio) {
        this.idSeminario = idSeminario;
        this.nombreSeminario = nombreSeminario;
        this.fechaInicio = fechaInicio;
    }

    public Long getIdSeminario() {
        return idSeminario;
    }

    public void setIdSeminario(Long idSeminario) {
        this.idSeminario = idSeminario;
    }

    public String getNombreSeminario() {
        return nombreSeminario;
    }

    public void setNombreSeminario(String nombreSeminario) {
        this.nombreSeminario = nombreSeminario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
