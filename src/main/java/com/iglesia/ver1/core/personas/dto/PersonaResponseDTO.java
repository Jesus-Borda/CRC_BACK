package com.iglesia.ver1.core.personas.dto;

import lombok.Data;

//ESTO ES PARA RESPONDER
@Data
public class PersonaResponseDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String telefono;

    public PersonaResponseDTO() {
    }


}
