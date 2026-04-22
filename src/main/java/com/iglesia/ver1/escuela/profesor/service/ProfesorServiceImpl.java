package com.iglesia.ver1.escuela.profesor.service;

import com.iglesia.ver1.core.personas.model.Persona;
import com.iglesia.ver1.core.personas.repository.PersonaRepository;
import com.iglesia.ver1.escuela.profesor.dto.ProfesorRequestDTO;
import com.iglesia.ver1.escuela.profesor.dto.ProfesorResponseDTO;
import com.iglesia.ver1.escuela.profesor.mapper.ProfesorMapper;
import com.iglesia.ver1.escuela.profesor.model.Profesor;
import com.iglesia.ver1.escuela.profesor.repository.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ProfesorMapper profesorMapper;




    @Override
    @Transactional
    public ProfesorResponseDTO crearProfesor(ProfesorRequestDTO dto) {
        Persona persona = personaRepository.findById(Math.toIntExact(dto.getIdPersona()))
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        Profesor profesor = new Profesor();
        profesor.setPersona(persona);
        Profesor guardado = (Profesor) profesorRepository.save(profesor);

        return profesorMapper.toDTO(guardado);
    }
    @Override
    public Optional<Profesor> getProfesor(Integer id) {
        return profesorRepository.findById(id.longValue());
    }
    @Override
    public List<ProfesorResponseDTO> listarProfesor() {
        return profesorRepository.findAll()
                .stream()
                .map(profesorMapper::toDTO)
                .toList();
    }

    @Override
    public ProfesorResponseDTO actualizarProfesor(Long id, ProfesorRequestDTO dto) {

        return null;
    }
}
