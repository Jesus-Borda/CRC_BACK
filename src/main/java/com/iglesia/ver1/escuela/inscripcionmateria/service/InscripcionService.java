package com.iglesia.ver1.escuela.inscripcionmateria.service;

import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaRequesDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface InscripcionService {
    InscripcionMateriaResponseDTO guardarInscripcion (InscripcionMateriaRequesDTO dto);
    Optional<InscripcionMateriaResponseDTO> getInscripcion (Integer id);
    List<InscripcionMateriaResponseDTO> listarInscripcion ();
    InscripcionMateriaResponseDTO actualizarInscripcion (Long id,InscripcionMateriaRequesDTO dto);
    void eliminarInscripcion (Integer id);
}
