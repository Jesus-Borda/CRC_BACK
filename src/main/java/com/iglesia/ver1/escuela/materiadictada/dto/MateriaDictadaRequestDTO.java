package com.iglesia.ver1.escuela.materiadictada.dto;

import lombok.Data;

@Data
public class MateriaDictadaRequestDTO {
    private Long idMateria;
    private Long idProfesor;
    private Long idPeriodo;

    public MateriaDictadaRequestDTO() {
    }
}
