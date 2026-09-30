package com.iglesia.ver1.escuela.asistenciaSeminario.mapper;

import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioRequestDTO;
import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioResponseDTO;
import com.iglesia.ver1.escuela.asistenciaSeminario.model.AsistenciaSeminario;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class AsistenciaSeminarioMapper {
    public AsistenciaSeminario toEntity (AsistenciaSeminarioRequestDTO dto){
        if (dto == null){
            return null;
        }
        AsistenciaSeminario a =new AsistenciaSeminario();
        return a;
    }

    public AsistenciaSeminarioResponseDTO toDto (AsistenciaSeminario a){
        AsistenciaSeminarioResponseDTO dto = new AsistenciaSeminarioResponseDTO();
        // 1. Mapeas el ID principal
        dto.setId(a.getId());
        dto.setAsistencia(a.getAsistencia());
        // 2. Extraes los nombres de los objetos relacionados (Navegación de objetos)
        if (a.getSeminario() != null){
            dto.setNombreSeminario(a.getSeminario().getNombreSeminario());
            dto.setFecha(a.getSeminario().getFechaInicio());
        }
        if (a.getEstudiante() != null){
            dto.setNombreEstudiante(a.getEstudiante().getPersona().getNombres());
            dto.setApellidoEstudiante(a.getEstudiante().getPersona().getApellidos());

        }
    return dto;
    }
}
