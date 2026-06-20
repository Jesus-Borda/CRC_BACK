package com.iglesia.ver1.escuela.nota.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NotaRequestDTO {
    private Long idinscripcion;
    private BigDecimal quiz;
    private BigDecimal examen;
    private BigDecimal trabjo;
    private BigDecimal asistencia;
    private BigDecimal notaFinal;

    public NotaRequestDTO() {
    }
}
