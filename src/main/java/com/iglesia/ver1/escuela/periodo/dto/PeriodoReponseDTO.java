package com.iglesia.ver1.escuela.periodo.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PeriodoReponseDTO {
    //ESTO ES PARA RESPONDER
    private String nombre;
    private Integer anio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
