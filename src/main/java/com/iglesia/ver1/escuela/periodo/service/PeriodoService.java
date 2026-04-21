package com.iglesia.ver1.escuela.periodo.service;

import com.iglesia.ver1.escuela.periodo.dto.PeriodoReponseDTO;
import com.iglesia.ver1.escuela.periodo.dto.PeriodoRequestDTO;
import com.iglesia.ver1.escuela.periodo.model.Periodo;

import java.util.List;
import java.util.Optional;

public interface PeriodoService {
    PeriodoReponseDTO guardarPeriodo (PeriodoRequestDTO dto);
    Optional<Periodo> getPeriodo (Integer id);
    List<PeriodoReponseDTO> listarPeriodo ();
    PeriodoReponseDTO actualizarPeriodo (Long id, PeriodoRequestDTO dto);
    void eliminarPeriodo (Integer id);
}
