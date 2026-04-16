package com.iglesia.ver1.escuela.inscripciones.service;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.estudiante.repository.EstudianteRepository;
import com.iglesia.ver1.escuela.inscripciones.dto.InscripcionRequestDTO;
import com.iglesia.ver1.escuela.inscripciones.dto.InscripcionResponseDTO;
import com.iglesia.ver1.escuela.inscripciones.mapper.InscripcionMapper;
import com.iglesia.ver1.escuela.inscripciones.model.Inscripcion;
import com.iglesia.ver1.escuela.inscripciones.repository.InscripcionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository isnInscripcionRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private MateriaDictadaRepository materiaDictadaRepository;

    @Autowired
    private InscripcionMapper inscripcionMapper;

    @Transactional
    public InscripcionResponseDTO crear (InscripcionRequestDTO dto){
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        MateriaDictada materia = materiaDictadaRepository.findById(dto.getIdMateriaDictada())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setMateriaDictada(materia);
        Inscripcion guardada = isnInscripcionRepository.save(inscripcion);
        return inscripcionMapper.toDTO(guardada);
    }

    public List<InscripcionResponseDTO> listar(){
        return inscripcionRepository.findAll()
                .stream()
                .map(inscripcionMapper::toDTO)
                .toList();
    }
}
