package com.iglesia.ver1.escuela.inscripciones.dto;

import lombok.Data;

@Data
public class InscripcionResponseDTO {

    private Long id;
    private String estudiante;
    private String materia;
    private String profesor;
}
