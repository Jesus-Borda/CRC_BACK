package com.iglesia.ver1.escuela.materia.dto;

import lombok.Data;

@Data
public class    MateriaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcionMateria;
    private String nombreModulo;

    public MateriaResponseDTO() {
    }

}
