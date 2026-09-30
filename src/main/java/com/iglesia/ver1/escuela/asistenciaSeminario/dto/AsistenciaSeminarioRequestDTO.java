package com.iglesia.ver1.escuela.asistenciaSeminario.dto;

import lombok.Data;

@Data
public class AsistenciaSeminarioRequestDTO {
    private Long idSeminario;
    private Long idEstudiante;
    private boolean asistencia;

    public AsistenciaSeminarioRequestDTO() {
    }
}
