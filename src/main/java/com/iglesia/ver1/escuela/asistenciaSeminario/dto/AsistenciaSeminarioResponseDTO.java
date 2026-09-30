package com.iglesia.ver1.escuela.asistenciaSeminario.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AsistenciaSeminarioResponseDTO {
    private Long id;
    private String nombreSeminario;
    private LocalDate fecha;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private boolean asistencia;



}
