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
        dto.setId(m.getIdMateriaDictada());
        dto.setNombreMateria(dto.getNombreMateria());
        dto.setNombreModulo(dto.getNombreModulo());
        dto.setNombreProfesor(dto.getNombreProfesor());
        dto.setNombrePeriodo(dto.getNombrePeriodo());
        dto.setFechaInicio(dto.getFechaInicio());
        dto.setFechaFin(dto.getFechaFin());
        return dto;

    }

}
