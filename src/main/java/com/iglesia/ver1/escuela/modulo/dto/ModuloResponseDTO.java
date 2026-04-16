package com.iglesia.ver1.escuela.modulo.dto;

import lombok.Data;

@Data
public class ModuloResponseDTO {
    private String nombre;
    private String descripcion;
    private String estado;

    public ModuloResponseDTO() {
    }
}
