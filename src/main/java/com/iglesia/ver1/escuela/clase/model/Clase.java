package com.iglesia.ver1.escuela.clase.model;

import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "clases")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long idClase;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia_dictada")
    private MateriaDictada materiaDictada;
    @Column (name = "fecha")
    private LocalDate fechaClae;
    @Column (name = "numero_clase")
    private Integer numeroClase;

    public Clase() {
    }

    public Clase(Long idClase, MateriaDictada materiaDictada, LocalDate fechaClae, Integer numeroClase) {
        this.idClase = idClase;
        this.materiaDictada = materiaDictada;
        this.fechaClae = fechaClae;
        this.numeroClase = numeroClase;
    }

    public Long getIdClase() {
        return idClase;
    }

    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public MateriaDictada getMateriaDictada() {
        return materiaDictada;
    }

    public void setMateriaDictada(MateriaDictada materiaDictada) {
        this.materiaDictada = materiaDictada;
    }

    public LocalDate getFechaClae() {
        return fechaClae;
    }

    public void setFechaClae(LocalDate fechaClae) {
        this.fechaClae = fechaClae;
    }

    public Integer getNumeroClase() {
        return numeroClase;
    }

    public void setNumeroClase(Integer numeroClase) {
        this.numeroClase = numeroClase;
    }

    @Override
    public String toString() {
        return "clase{" +
                "idClase=" + idClase +
                ", materiaDictada=" + materiaDictada +
                ", fechaClae=" + fechaClae +
                ", numeroClase=" + numeroClase +
                '}';
    }
}
