package com.iglesia.ver1.escuela.materiadictada.mapper;

import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaRequestDTO;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaResponseDTO;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import org.springframework.stereotype.Component;

@Component
public class MateriaDictadaMapper {
    //CREAR METODO TO ENTITY

    public MateriaDictada toEntity (MateriaDictadaRequestDTO dto){
        if (dto == null) {
            return null;
        }
        MateriaDictada m = new MateriaDictada();
        return m;

    }
    //DEL BACK AL FRONT PARA CONSULTAS GET
    public MateriaDictadaResponseDTO toDTO (MateriaDictada m){

        MateriaDictadaResponseDTO dto = new MateriaDictadaResponseDTO();
        // 1. Mapeas el ID principal
        dto.setId(m.getIdMateriaDictada());

        // 2. Extraes los nombres de los objetos relacionados (Navegación de objetos)
        if(m.getMateria() != null){
            dto.setNombreMateria(m.getMateria().getNombreMateria());
            if(m.getMateria().getModulo() != null){
                dto.setNombreModulo(m.getMateria().getModulo().getNombre());
            }
        }
        if (m.getProfesor() != null && m.getProfesor().getPersona() != null) {
            dto.setNombreProfesor(m.getProfesor().getPersona().getNombres());
        }

        if (m.getPeriodo() != null) {
            dto.setNombrePeriodo(m.getPeriodo().getNombre());
            dto.setFechaInicio(m.getPeriodo().getFechaInicio());
            dto.setFechaFin(m.getPeriodo().getFechaFin());
        }

        return dto;

    }

}
