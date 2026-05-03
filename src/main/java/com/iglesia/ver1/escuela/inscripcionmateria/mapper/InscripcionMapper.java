package com.iglesia.ver1.escuela.inscripcionmateria.mapper;

import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaRequesDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaResponseDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.model.Inscripcion;
import org.springframework.stereotype.Component;

@Component
public class InscripcionMapper {
    //CREAR METODO TO ENTITY
    public Inscripcion toEntity (InscripcionMateriaRequesDTO dto){
        if (dto == null){
            return null;
        }
        Inscripcion i =new Inscripcion();
        return i;

    }
    //DEL BACK AL FRONT PARA CONSULTAS GET
    public InscripcionMateriaResponseDTO toDTO (Inscripcion i){
        InscripcionMateriaResponseDTO dto = new InscripcionMateriaResponseDTO();
        // 1. Mapeas el ID principal
        dto.setId(i.getIdInscripcion());
        // 2. Extraes los nombres de los objetos relacionados (Navegación de objetos)
        if (i.getEstudiante() !=null){
            dto.setNombreEstudiante(i.getEstudiante().getPersona().getNombres());
        }
        if (i.getMateriaDictada() !=null){
            dto.setNombreMateria(i.getMateriaDictada().getMateria().getNombreMateria());
            dto.setNombreModulo(i.getMateriaDictada().getMateria().getModulo().getNombre());
            dto.setNombrePeriodo(i.getMateriaDictada().getPeriodo().getNombre());
            dto.setNombreProfesor(i.getMateriaDictada().getProfesor().getPersona().getNombres());
        }
        return dto;

    }

}
