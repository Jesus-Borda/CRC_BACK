package com.iglesia.ver1.escuela.clase.service;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;
import com.iglesia.ver1.escuela.clase.model.Clase;

import java.util.List;
import java.util.Optional;

public interface ClaseService {
    ClaseResponseDTO guardarClase (ClaseRequestDTO dto);
    Optional<Clase> getClase (Integer id);
    List <ClaseResponseDTO> listarClase ();
    ClaseResponseDTO actualizarClase (Long id, ClaseRequestDTO dto);
    void eliminarClase (Integer id);
}
