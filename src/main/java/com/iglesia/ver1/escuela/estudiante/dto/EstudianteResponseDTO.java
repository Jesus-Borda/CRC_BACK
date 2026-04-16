package com.iglesia.ver1.escuela.estudiante.dto;

import lombok.Data;

@Data
public class EstudianteResponseDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;
}
