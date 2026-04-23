package com.iglesia.ver1.escuela.materiadictada.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MateriaDictadaResponseDTO {
    private Long id;
    private String nombreMateria;
    private String nombreModulo;
    private String nombreProfesor;
    private String nombrePeriodo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
