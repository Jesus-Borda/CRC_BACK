package com.iglesia.ver1.core.personas.service;

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


    @Override
    public Persona guardarPersona(Persona persona) {
        return  personaRepository.save(persona);
    }

    @Override
    public Optional<Persona> get(Integer id_persona) {
        return personaRepository.findById(id_persona);
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
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
