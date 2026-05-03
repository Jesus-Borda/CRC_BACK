package com.iglesia.ver1.escuela.inscripcionmateria.dto;

import lombok.Data;

@Data
public class InscripcionMateriaRequesDTO {
    private Long idEstudiante;
    private Long idMateriaDictada;

    public InscripcionMateriaRequesDTO() {
    }
}
