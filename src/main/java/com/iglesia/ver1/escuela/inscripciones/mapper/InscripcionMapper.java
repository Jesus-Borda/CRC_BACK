package com.iglesia.ver1.escuela.inscripciones.mapper;

import com.iglesia.ver1.escuela.inscripciones.dto.InscripcionResponseDTO;
import com.iglesia.ver1.escuela.inscripciones.model.Inscripcion;
import org.springframework.stereotype.Component;

@Component
public class InscripcionMapper {
    public InscripcionResponseDTO toDTO (Inscripcion i){
        InscripcionResponseDTO dto = new InscripcionResponseDTO();
        dto.setId(i.getId());
        dto.setEstudiante(
                i.getEstudiante().getPersona().getNombres()+ "" +
                        i.getEstudiante().getPersona().getApellidos()
        );
        dto.setMateria(i.getMateriaDictada().getMateria().getNombres()
        );
        return dto;
    }
}
