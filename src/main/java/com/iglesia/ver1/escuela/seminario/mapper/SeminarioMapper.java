package com.iglesia.ver1.escuela.seminario.mapper;

import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioResponseDTO;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import org.springframework.stereotype.Component;

@Component
public class SeminarioMapper {
    public Seminario toEntity (SeminarioRequestDTO dto){
       if (dto==null){
           return null;
       }
       Seminario s = new Seminario();
       s.setNombreSeminario(dto.getNombre());
       s.setFechaInicio(dto.getFechaInicio());
       return s;
    }
    public SeminarioResponseDTO toDto (Seminario seminario){
        SeminarioResponseDTO dto = new SeminarioResponseDTO();
        dto.setIdSeminario(seminario.getIdSeminario());
        dto.setNombre(seminario.getNombreSeminario());
        dto.setFechaInicio(seminario.getFechaInicio());
        return  dto;
    }
}
