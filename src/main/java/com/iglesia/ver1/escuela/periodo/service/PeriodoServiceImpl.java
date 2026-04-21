package com.iglesia.ver1.escuela.periodo.service;

import com.iglesia.ver1.escuela.periodo.dto.PeriodoReponseDTO;
import com.iglesia.ver1.escuela.periodo.dto.PeriodoRequestDTO;
import com.iglesia.ver1.escuela.periodo.mapper.PeriodoMapper;
import com.iglesia.ver1.escuela.periodo.model.Periodo;
import com.iglesia.ver1.escuela.periodo.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodoServiceImpl implements PeriodoService {
    @Autowired
    private PeriodoRepository periodoRepository;

    @Autowired
    private PeriodoMapper periodoMapper;

    @Override
    public PeriodoReponseDTO guardarPeriodo(PeriodoRequestDTO dto) {
        Periodo periodo = periodoMapper.toEntity(dto);
        Periodo guardado = periodoRepository.save(periodo);
        return periodoMapper.toDto(guardado);
    }

    @Override
    public Optional<Periodo> getPeriodo(Integer id) {
        return periodoRepository.findById(id.longValue());
    }

    @Override
    public List<PeriodoReponseDTO> listarPeriodo() {
        return periodoRepository.findAll()
                .stream()
                .map(periodoMapper::toDto)
                .toList();
    }

    @Override
    public PeriodoReponseDTO actualizarPeriodo(Long id, PeriodoRequestDTO dto) {
        Periodo periodo = periodoRepository.findById(id).orElseThrow(() -> new RuntimeException("Periodo no encontrado"));
        if (dto.getNombre() != null){
            periodo.setNombre(dto.getNombre());
        }
        if (dto.getAnio() != null){
            periodo.setAnio(dto.getAnio());
        }
        if (dto.getFechaInicio() != null){
            periodo.setFechaInicio(dto.getFechaInicio());
        }
        if (dto.getFechaFin() != null){
            periodo.setFechaFin(dto.getFechaFin());
        }
        Periodo actualizado = periodoRepository.save(periodo);

        return periodoMapper.toDto(actualizado);
    }

    @Override
    public void eliminarPeriodo(Integer id) { periodoRepository.deleteById(id.longValue());

    }
}
