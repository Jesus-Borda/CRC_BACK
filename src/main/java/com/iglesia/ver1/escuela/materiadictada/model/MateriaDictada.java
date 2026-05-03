package com.iglesia.ver1.escuela.materiadictada.model;

import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.periodo.model.Periodo;
import com.iglesia.ver1.escuela.profesor.model.Profesor;
import jakarta.persistence.*;

@Entity
@Table(name = "materias_dictadas")
public class MateriaDictada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia_dictada")
    private Long idMateriaDictada;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_periodo")
    private Periodo periodo;

    public MateriaDictada() {
    }

    public MateriaDictada(Long idMateriaDictada, Materia materia, Profesor profesor, Periodo periodo) {
        this.idMateriaDictada = idMateriaDictada;
        this.materia = materia;
        this.profesor = profesor;
        this.periodo = periodo;
    }

    public Long getIdMateriaDictada() {
        return idMateriaDictada;
    }

    public void setIdMateriaDictada(Long idMateriaDictada) {
        this.idMateriaDictada = idMateriaDictada;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "MateriaDictada{" +
                "idMateriaDictada=" + idMateriaDictada +
                ", materia=" + materia +
                ", profesor=" + profesor +
                ", periodo=" + periodo +
                '}';
    }
}
