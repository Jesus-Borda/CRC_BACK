package com.iglesia.ver1.escuela.nota.mapper;

import com.iglesia.ver1.escuela.nota.dto.NotaRequestDTO;
import com.iglesia.ver1.escuela.nota.dto.NotaResponseDTO;
import com.iglesia.ver1.escuela.nota.model.Nota;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {
    //CREAR METODO TO ENTITY
    public Nota toEntity (NotaRequestDTO dto){
        if (dto == null){
            return null;
        }
        Nota n = new Nota();
        n.setQuiz(dto.getQuiz());
        n.setExamen(dto.getExamen());
        n.setAsistencia(dto.getAsistencia());
        n.setTrabajo(dto.getTrabajo());
        return n;
    }
    //DEL BACK AL FRONT PARA CONSULTAS GET
    public NotaResponseDTO toDto (Nota nota){
        NotaResponseDTO dto =new NotaResponseDTO();
        // 1. Mapeas el ID principal
        dto.setIdNota(nota.getId());
        // 2. Extraes los nombres de los objetos relacionados (Navegación de objetos)
        if (nota.getInscripcion()!=null){
            dto.setIdNota(nota.getId());
            dto.setNombreEstudiante(nota.getInscripcion().getEstudiante().getPersona().getNombres());
            dto.setApellidoEstudiante(nota.getInscripcion().getEstudiante().getPersona().getApellidos());
            dto.setNombreProfesor(nota.getInscripcion().getMateriaDictada().getProfesor().getPersona().getNombres());
            dto.setApellidoProfesor(nota.getInscripcion().getMateriaDictada().getProfesor().getPersona().getApellidos());
            dto.setNombreMateriaDictada(nota.getInscripcion().getMateriaDictada().getMateria().getNombreMateria());
            dto.setNombreModulo(nota.getInscripcion().getMateriaDictada().getPeriodo().getNombre());
            dto.setAnio(nota.getInscripcion().getMateriaDictada().getPeriodo().getAnio());
            dto.setQuiz(nota.getQuiz());
            dto.setExamen(nota.getExamen());
            dto.setTrabajo(nota.getTrabajo());
            dto.setAsistencia(nota.getAsistencia());
            dto.setNotaFinal(nota.getNotaFinal());
        }
        return dto;
    }
}
