package com.iglesia.ver1.escuela.periodo.mapper;

import com.iglesia.ver1.escuela.periodo.dto.PeriodoReponseDTO;
import com.iglesia.ver1.escuela.periodo.dto.PeriodoRequestDTO;
import com.iglesia.ver1.escuela.periodo.model.Periodo;
import org.springframework.stereotype.Component;

@Component
public class PeriodoMapper {
    public Periodo toEntity (PeriodoRequestDTO dto){
        Periodo p = new Periodo();
        p.setNombre(dto.getNombre());
        p.setAnio(dto.getAnio());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        return p;
    }
    public PeriodoReponseDTO toDto (Periodo p){
        PeriodoReponseDTO dto = new PeriodoReponseDTO();
        dto.setNombre(p.getNombre());
        dto.setAnio(p.getAnio());
        dto.setFechaInicio(p.getFechaInicio());
        dto.setFechaFin(p.getFechaFin());
        return dto;
    }
}
