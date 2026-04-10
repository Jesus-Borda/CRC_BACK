package com.iglesia.ver1.core.personas.service;

import com.iglesia.ver1.core.personas.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
     Persona guardarPersona(Persona persona);
     Optional<Persona> get (Integer id_persona);
     List<Persona> listarPersonas();
     Persona actualizarPersona(Persona persona);
     void eliminarPersona(Integer id);
}
