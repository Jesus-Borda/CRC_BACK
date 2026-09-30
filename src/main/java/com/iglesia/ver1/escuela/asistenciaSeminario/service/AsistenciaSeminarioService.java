package com.iglesia.ver1.escuela.asistenciaSeminario.service;

import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioRequestDTO;
import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioResponseDTO;
import java.util.List;
import java.util.Optional;

public interface AsistenciaSeminarioService {
    AsistenciaSeminarioResponseDTO guardarAsistenciaSeminario (AsistenciaSeminarioRequestDTO dto);
    Optional<AsistenciaSeminarioResponseDTO> getAsistenciaSeminario (Integer id);
    List<AsistenciaSeminarioResponseDTO>listarAsistenciaSeminario ();
    AsistenciaSeminarioResponseDTO actualizarAsistenciaSeminario (Long id, AsistenciaSeminarioRequestDTO dto);
    void eliminarAsistenciaSeminario (Integer id);
}
