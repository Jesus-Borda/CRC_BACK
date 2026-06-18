package com.iglesia.ver1.escuela.nota.service;

import com.iglesia.ver1.escuela.nota.dto.NotaRequestDTO;
import com.iglesia.ver1.escuela.nota.dto.NotaResponseDTO;
import com.iglesia.ver1.escuela.nota.model.Nota;

import java.util.List;
import java.util.Optional;

public interface NotaService {
    NotaResponseDTO guardarNota (NotaRequestDTO dto);
    Optional<NotaResponseDTO> getNotas (Integer id);
    List<NotaResponseDTO> listarNotas ();
    NotaResponseDTO actualizarNota (Long id, NotaRequestDTO dto);
    void eliminarNota (Integer id);
}
