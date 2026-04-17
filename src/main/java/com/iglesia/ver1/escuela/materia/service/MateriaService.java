package com.iglesia.ver1.escuela.materia.service;

import com.iglesia.ver1.escuela.materia.dto.MateriaRequestDTO;
import com.iglesia.ver1.escuela.materia.dto.MateriaResponseDTO;
import com.iglesia.ver1.escuela.materia.model.Materia;

import java.util.List;
import java.util.Optional;

public interface MateriaService {
    MateriaResponseDTO guardarMateria (MateriaRequestDTO dto);
    Optional<Materia> getMateria(Integer id);
    List<MateriaResponseDTO> listarMaterias ();
    MateriaResponseDTO actualizarMateria (Long id, MateriaRequestDTO dto);
    void eliminarMateria (Integer id);
}
