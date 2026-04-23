package com.iglesia.ver1.escuela.materia.mapper;

import com.iglesia.ver1.escuela.materia.dto.MateriaRequestDTO;
import com.iglesia.ver1.escuela.materia.dto.MateriaResponseDTO;
import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.modulo.model.Modulo;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {
    //ENTRAR AL BACK PARA CREAR/ EDITAR
    public Materia toEntity (MateriaRequestDTO dto){
        Materia m = new Materia();
        m.setNombreMateria(dto.getNombreMateria());
        m.setDescripcionMateria(dto.getDescripcionMateria());
        return m;
    }
    //DEL BACK AL FRONT PARA CONSULTAS GET
    public MateriaResponseDTO toDto (Materia m){
        MateriaResponseDTO dto = new MateriaResponseDTO();
        dto.setId(m.getIdMateria());
        dto.setNombre(m.getNombreMateria());
        dto.setDescripcionMateria(m.getDescripcionMateria());
        if (m.getModulo() != null) {
            dto.setNombreModulo(m.getModulo().getNombre());
        }
        return  dto;

    }
}
