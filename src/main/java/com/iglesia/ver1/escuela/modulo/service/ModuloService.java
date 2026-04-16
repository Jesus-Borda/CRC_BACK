package com.iglesia.ver1.escuela.modulo.service;

import com.iglesia.ver1.escuela.modulo.dto.ModuloRequestDTO;
import com.iglesia.ver1.escuela.modulo.dto.ModuloResponseDTO;
import com.iglesia.ver1.escuela.modulo.model.Modulo;

import java.util.List;
import java.util.Optional;

public interface ModuloService  {
    ModuloResponseDTO guardarModulo (ModuloRequestDTO dto);
    Optional<Modulo> get (Integer id);
    List<ModuloResponseDTO> listarModulos();
    Modulo actualizarModulo (Modulo modulo);
    void eliminarModulo (Integer id);
}