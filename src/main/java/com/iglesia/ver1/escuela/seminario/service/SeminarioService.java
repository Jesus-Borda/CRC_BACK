package com.iglesia.ver1.escuela.seminario.service;

import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioResponseDTO;
import com.iglesia.ver1.escuela.seminario.model.Seminario;

import java.util.List;
import java.util.Optional;

public interface SeminarioService {
    SeminarioResponseDTO guardarSeminario (SeminarioRequestDTO dto);
    Optional<Seminario> getSeminario (Integer id);
    List<SeminarioResponseDTO> listarSeminarios ();
    SeminarioResponseDTO actualizarSeminarios ( Long id , SeminarioRequestDTO dto);
    void eliminarSeminario (Integer id);
}
