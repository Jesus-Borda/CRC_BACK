package com.iglesia.ver1.escuela.nota.model;

import com.iglesia.ver1.escuela.inscripcionmateria.model.Inscripcion;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "notas")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscripcion")
    private Inscripcion inscripcion;


    @Column(precision = 5, scale = 2)
    private BigDecimal quiz;

    @Column(precision = 5, scale = 2)
    private BigDecimal examen;

    @Column(precision = 5, scale = 2)
    private BigDecimal asistencia;

    @Column(name = "nota_final", precision = 5, scale = 2)
    private BigDecimal notaFinal;

    public Nota() {
    }

    public Nota(Long id, Inscripcion inscripcion, BigDecimal quiz, BigDecimal examen, BigDecimal asistencia, BigDecimal notaFinal) {
        this.id = id;
        this.inscripcion = inscripcion;
        this.quiz = quiz;
        this.examen = examen;
        this.asistencia = asistencia;
        this.notaFinal = notaFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public BigDecimal getQuiz() {
        return quiz;
    }

    public void setQuiz(BigDecimal quiz) {
        this.quiz = quiz;
    }

    public BigDecimal getExamen() {
        return examen;
    }

    public void setExamen(BigDecimal examen) {
        this.examen = examen;
    }

    public BigDecimal getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(BigDecimal asistencia) {
        this.asistencia = asistencia;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", inscripcion=" + inscripcion +
                ", quiz=" + quiz +
                ", examen=" + examen +
                ", asistencia=" + asistencia +
                ", notaFinal=" + notaFinal +
                '}';
    }
}
