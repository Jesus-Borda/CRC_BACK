package com.iglesia.ver1.escuela.profesor.mapper;

import com.iglesia.ver1.escuela.profesor.dto.ProfesorResponseDTO;
import com.iglesia.ver1.escuela.profesor.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorResponseDTO toDTO (Profesor p){
        ProfesorResponseDTO dto = new ProfesorResponseDTO();

        dto.setId(p.getIdProfesor());
        dto.setNombres(p.getPersona().getNombres());
        dto.setApellidos(p.getPersona().getApellidos());
        dto.setCedula(p.getPersona().getCedula());
        return dto;
    }

}
