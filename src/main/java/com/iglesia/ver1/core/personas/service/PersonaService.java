package com.iglesia.ver1.core.personas.service;

import com.iglesia.ver1.core.personas.dto.PersonaRequestDTO;
import com.iglesia.ver1.core.personas.dto.PersonaResponseDTO;
import com.iglesia.ver1.core.personas.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {


     PersonaResponseDTO guardarPersona(PersonaRequestDTO dto);
     Optional<Persona> get (Integer id_persona);
     List<PersonaResponseDTO> listarPersonas();
     Persona actualizarPersona(Persona persona);
     void eliminarPersona(Integer id);
}
