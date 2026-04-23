package com.iglesia.ver1.escuela.materiadictada.service;

import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaRequestDTO;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaResponseDTO;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;

import java.util.List;
import java.util.Optional;

public interface MateriaDictadaService {
    MateriaDictadaResponseDTO guardarMateriaDictada (MateriaDictadaRequestDTO dto);
    Optional<MateriaDictada> getMateriaDictada (Integer id);
    List<MateriaDictadaResponseDTO> listarMateriaDictada ();
    MateriaDictadaResponseDTO actualizarMateriaDictada (Long id, MateriaDictadaRequestDTO dto);
    void eliminarMateria (Integer id);
}
