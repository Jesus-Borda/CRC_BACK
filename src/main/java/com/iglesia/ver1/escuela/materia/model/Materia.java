package com.iglesia.ver1.escuela.materia.model;

import com.iglesia.ver1.escuela.modulo.model.Modulo;
import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Long idMateria;
    @Column(name = "nombre")
    private String nombreMateria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo")
    private Modulo modulo;
    @Column(name = "descripcion_materia", columnDefinition = "TEXT")
    private String descripcionMateria;

    public Materia() {
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public Materia(Long id, String nombre, Modulo modulo, String descripcion) {
        this.idMateria = id;
        this.nombreMateria = nombre;
        this.modulo = modulo;
        this.descripcionMateria = descripcion;
    }



    @Override
    public String toString() {
        return "materia{" +
                "id=" + idMateria +
                ", nombre='" + nombreMateria + '\'' +
                ", modulo=" + modulo +
                ", descripcion='" + descripcionMateria + '\'' +
                '}';
    }
}
