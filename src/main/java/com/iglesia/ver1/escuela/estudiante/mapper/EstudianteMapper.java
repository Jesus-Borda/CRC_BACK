package com.iglesia.ver1.escuela.estudiante.mapper;

import com.iglesia.ver1.escuela.estudiante.dto.EstudianteResponseDTO;
import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public EstudianteResponseDTO toDTO (Estudiante e){

        EstudianteResponseDTO dto = new EstudianteResponseDTO();

        dto.setId(e.getId());
        dto.setNombres(e.getPersona().getNombres());
        dto.setApellidos(e.getPersona().getApellidos());
        dto.setCedula(e.getPersona().getCedula());

        return dto;
    }

}
