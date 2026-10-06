package com.iglesia.ver1.escuela.clase.mapper;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;
import com.iglesia.ver1.escuela.clase.model.Clase;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapper {
    public Clase toEntity (ClaseRequestDTO dto){
        if (dto==null){
            return null;
        }
        Clase c = new Clase();
        return c;
    }
    public ClaseResponseDTO toDTO (Clase c){
        ClaseResponseDTO dto = new ClaseResponseDTO();
        // 1. Mapeas el ID principal
        dto.setIdClase(c.getIdClase());
        dto.setFechaClase(c.getFechaClae());
        dto.setNumeroClase(c.getNumeroClase());
        // 2. Extraes los nombres de los objetos relacionados (Navegación de objetos)
        if (c.getMateriaDictada() != null){
            if (c.getMateriaDictada().getMateria() != null){
                dto.setNombreMateria(c.getMateriaDictada().getMateria().getNombreMateria());
            }
            if (c.getMateriaDictada().getProfesor() != null){
                dto.setNombreProfesor(c.getMateriaDictada().getProfesor().getPersona().getNombres());
                dto.setApellidoProfesor(c.getMateriaDictada().getProfesor().getPersona().getApellidos());
            }
        }
        return dto;
    }
}
