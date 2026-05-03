package com.iglesia.ver1.escuela.inscripcionmateria.service;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.estudiante.repository.EstudianteRepository;
import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaRequesDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaResponseDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.mapper.InscripcionMapper;
import com.iglesia.ver1.escuela.inscripcionmateria.model.Inscripcion;
import com.iglesia.ver1.escuela.inscripcionmateria.repository.InscripcionRepository;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import com.iglesia.ver1.escuela.materiadictada.repository.MateriaDictadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InscripcionServiceImplement implements InscripcionService{

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private InscripcionMapper inscripcionMapper;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private MateriaDictadaRepository materiaDictadaRepository;


    @Transactional
    @Override
    public InscripcionMateriaResponseDTO guardarInscripcion(InscripcionMateriaRequesDTO dto) {
        Inscripcion inscripcion =inscripcionMapper.toEntity(dto) ;
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        MateriaDictada materiaDictada = materiaDictadaRepository.findById(dto.getIdMateriaDictada())
                .orElseThrow(()->new RuntimeException("MateriaDictada no encontrada"));
        inscripcion.setEstudiante(estudiante);
        inscripcion.setMateriaDictada(materiaDictada);
        Inscripcion guardada = inscripcionRepository.save(inscripcion);
        return inscripcionMapper.toDTO(guardada);
    }



    @Override
    public Optional<InscripcionMateriaResponseDTO> getInscripcion(Integer id) {
        return inscripcionRepository.findById(id.longValue())
                .map(inscripcion -> inscripcionMapper.toDTO(inscripcion));
    }

    @Override
    public List<InscripcionMateriaResponseDTO> listarInscripcion() {
        return inscripcionRepository.findAll()
                .stream()
                .map(inscripcionMapper::toDTO)
                .toList();
    }

    @Transactional
    @Override
    public InscripcionMateriaResponseDTO actualizarInscripcion(Long id, InscripcionMateriaRequesDTO dto) {
        //1. Buscamos la entidad original
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Inscripcion no encontrada"));
        // 2. Si el DTO trae un ID de estudiante, lo validamos Y lo asignamos
        if (dto.getIdEstudiante() != null){
            Estudiante
                     estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                    .orElseThrow(()-> new RuntimeException("Estudiante no existente"));
            inscripcion.setEstudiante(estudiante);
        }
        // 3. Lo mismo para materia Dictada
        if(dto.getIdMateriaDictada() != null){
            MateriaDictada materiaDictada = materiaDictadaRepository.findById(dto.getIdMateriaDictada())
                    .orElseThrow(()-> new RuntimeException("MateriaDictada no encontrada"));
            inscripcion.setMateriaDictada(materiaDictada);
        }
        Inscripcion actualizado = inscripcionRepository.save(inscripcion);


        return inscripcionMapper.toDTO(actualizado);
    }

    @Override
    public void eliminarInscripcion(Integer id) {
        inscripcionRepository.deleteById(id.longValue());
    }
}
