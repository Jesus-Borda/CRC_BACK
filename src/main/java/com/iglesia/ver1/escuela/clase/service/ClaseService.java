package com.iglesia.ver1.escuela.clase.service;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ClaseService {
    ClaseResponseDTO guardarClase (ClaseRequestDTO dto);
    Optional<ClaseResponseDTO> getClase (Integer id);
    List <ClaseResponseDTO> listarClase ();
    ClaseResponseDTO actualizarClase (Long id);
    void eliminarClase (Integer id);
}
