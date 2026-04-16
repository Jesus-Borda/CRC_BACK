package com.iglesia.ver1.core.personas.dto;

import lombok.Data;

import java.time.LocalDate;
//ESTO ES PARA CREAR/EDITAR
@Data
public class PersonaRequestDTO {
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String cedula;

    public PersonaRequestDTO() {
    }

}
