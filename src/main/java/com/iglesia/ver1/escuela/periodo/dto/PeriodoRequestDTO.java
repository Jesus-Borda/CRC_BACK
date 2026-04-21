package com.iglesia.ver1.escuela.periodo.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PeriodoRequestDTO {
    //ESTO ES PARA CREAR/EDITAR
    private Integer anio;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
