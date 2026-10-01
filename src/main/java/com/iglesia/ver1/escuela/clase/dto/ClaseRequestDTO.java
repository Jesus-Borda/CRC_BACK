package com.iglesia.ver1.escuela.clase.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaseRequestDTO {
    private Long idMateriaDictada;
    private LocalDate fechaClase;
    private Integer numeroClase;

    public ClaseRequestDTO() {
    }
}
