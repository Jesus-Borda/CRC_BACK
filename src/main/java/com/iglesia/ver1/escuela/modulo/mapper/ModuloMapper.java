package com.iglesia.ver1.escuela.modulo.mapper;

import com.iglesia.ver1.core.personas.dto.PersonaResponseDTO;
import com.iglesia.ver1.escuela.modulo.dto.ModuloRequestDTO;
import com.iglesia.ver1.escuela.modulo.dto.ModuloResponseDTO;
import com.iglesia.ver1.escuela.modulo.model.Modulo;
import org.springframework.stereotype.Component;

@Component
public class ModuloMapper {
    public Modulo toEntity (ModuloRequestDTO dto){
        Modulo m = new Modulo();
        m.setNombre(dto.getNombre());
        m.setDescripcion(dto.getDescripcion());
        m.setEstado(dto.getEstado());
        return m;

    }
    public ModuloResponseDTO toDto (Modulo m){
        ModuloResponseDTO dto = new ModuloResponseDTO();
        dto.setNombre(m.getNombre());
        dto.setDescripcion(m.getDescripcion());
        dto.setEstado(m.getEstado());
        return dto;
        }
}
