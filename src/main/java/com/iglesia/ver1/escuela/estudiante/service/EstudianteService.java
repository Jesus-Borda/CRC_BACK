package com.iglesia.ver1.escuela.estudiante.service;

import com.iglesia.ver1.core.personas.model.Persona;
import com.iglesia.ver1.core.personas.repository.PersonaRepository;
import com.iglesia.ver1.escuela.estudiante.dto.EstudianteRequestDTO;
import com.iglesia.ver1.escuela.estudiante.dto.EstudianteResponseDTO;
import com.iglesia.ver1.escuela.estudiante.mapper.EstudianteMapper;
import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.estudiante.repository.EstudianteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Transactional
    public EstudianteResponseDTO crear (EstudianteRequestDTO dto){
        Persona persona = personaRepository.findById(Math.toIntExact(dto.getIdPersona()))
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        Estudiante estudiante = new Estudiante();
        estudiante.setPersona(persona);
        Estudiante guardado = estudianteRepository.save(estudiante);
        return estudianteMapper.toDTO(guardado);

    }
    public List<EstudianteResponseDTO> listar(){
        return estudianteRepository.findAll()
                .stream()
                .map(estudianteMapper::toDTO)
                .toList();
    }


}
