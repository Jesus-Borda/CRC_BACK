package com.iglesia.ver1.core.personas.service;

import com.iglesia.ver1.core.personas.dto.PersonaRequestDTO;
import com.iglesia.ver1.core.personas.dto.PersonaResponseDTO;
import com.iglesia.ver1.core.personas.mapper.PersonaMapper;
import com.iglesia.ver1.core.personas.model.Persona;
import com.iglesia.ver1.core.personas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;


    @Override
    public PersonaResponseDTO guardarPersona(PersonaRequestDTO dto) {
        Persona persona = personaMapper.toEntity(dto);

        Persona guardada = personaRepository.save(persona);

        return personaMapper.toDTO(guardada);
    }

    @Override
    public Optional<Persona> get(Integer id_persona) {
        return personaRepository.findById(id_persona);
    }

    @Override
    public List<PersonaResponseDTO> listarPersonas() {

        return personaRepository.findAll()
                .stream()
                .map(personaMapper::toDTO)
                .toList();
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepository.deleteById(id);
    }
}
