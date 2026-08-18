package com.iglesia.ver1.escuela.seminario.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeminarioRequestDTO {
    private Long idSeminario;
    private String nombre;
    private LocalDate fechaInicio;

    public SeminarioRequestDTO() {
    }
}
