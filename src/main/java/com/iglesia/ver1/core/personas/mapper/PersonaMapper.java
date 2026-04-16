package com.iglesia.ver1.core.personas.mapper;

import com.iglesia.ver1.core.personas.dto.PersonaRequestDTO;
import com.iglesia.ver1.core.personas.dto.PersonaResponseDTO;
import com.iglesia.ver1.core.personas.model.Persona;
import org.springframework.stereotype.Component;
@Component
public class PersonaMapper {

    public Persona toEntity(PersonaRequestDTO dto){
        Persona p = new Persona();
        p.setCedula(dto.getCedula());
        p.setNombres(dto.getNombres());
        p.setApellidos(dto.getApellidos());
        p.setTelefono(dto.getTelefono());
        p.setEmail(dto.getEmail());
        return p;
    }

    public PersonaResponseDTO toDTO(Persona p){
        PersonaResponseDTO dto = new PersonaResponseDTO();
        dto.setId(p.getId_persona().longValue());
        dto.setNombres(p.getNombres());
        dto.setApellidos(p.getApellidos());
        dto.setTelefono(p.getTelefono());
        return dto;
    }
}
