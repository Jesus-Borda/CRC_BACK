package com.iglesia.ver1.escuela.materia.dto;

import lombok.Data;

@Data
public class MateriaRequestDTO {
    private Long idModulo;
    private String nombreMateria;
    private String descripcionMateria;

    public MateriaRequestDTO() {
    }
}
