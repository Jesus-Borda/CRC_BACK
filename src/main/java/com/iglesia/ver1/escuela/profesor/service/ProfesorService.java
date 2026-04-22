package com.iglesia.ver1.escuela.profesor.service;

import com.iglesia.ver1.escuela.profesor.dto.ProfesorRequestDTO;
import com.iglesia.ver1.escuela.profesor.dto.ProfesorResponseDTO;
import com.iglesia.ver1.escuela.profesor.model.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    ProfesorResponseDTO crearProfesor (ProfesorRequestDTO dto);
    Optional<Profesor> getProfesor (Integer id);
    List<ProfesorResponseDTO> listarProfesor ();
    ProfesorResponseDTO actualizarProfesor (Long id,ProfesorRequestDTO dto);

}
