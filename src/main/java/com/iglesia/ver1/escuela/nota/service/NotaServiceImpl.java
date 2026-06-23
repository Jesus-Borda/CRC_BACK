package com.iglesia.ver1.escuela.nota.service;

import com.iglesia.ver1.escuela.inscripcionmateria.model.Inscripcion;
import com.iglesia.ver1.escuela.inscripcionmateria.repository.InscripcionRepository;
import com.iglesia.ver1.escuela.nota.dto.NotaRequestDTO;
import com.iglesia.ver1.escuela.nota.dto.NotaResponseDTO;
import com.iglesia.ver1.escuela.nota.mapper.NotaMapper;
import com.iglesia.ver1.escuela.nota.model.Nota;
import com.iglesia.ver1.escuela.nota.repository.NotaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class NotaServiceImpl implements  NotaService{
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private NotaMapper notaMapper;
    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Transactional
    @Override
    public NotaResponseDTO guardarNota(NotaRequestDTO dto) {
        Nota nota = notaMapper.toEntity(dto);
        Inscripcion inscripcion = inscripcionRepository.findById(dto.getIdinscripcion())
                .orElseThrow(() ->new RuntimeException("Inscripcion no encontrada"));
        nota.setInscripcion(inscripcion);
        BigDecimal notaFinal =
                dto.getQuiz().multiply(new BigDecimal("0.20"))
                        .add(dto.getAsistencia().multiply(new BigDecimal("0.10")))
                        .add(dto.getExamen().multiply(new BigDecimal("0.35")))
                        .add(dto.getTrabajo().multiply(new BigDecimal("0.35")));
        nota.setNotaFinal(notaFinal);
        Nota guardada = notaRepository.save(nota);
        return notaMapper.toDto(guardada);
    }

    @Override
    public Optional<NotaResponseDTO> getNotas(Integer id) {
        return notaRepository.findById(id.longValue()).map(nota-> notaMapper.toDto(nota));
    }

    @Override
    public List<NotaResponseDTO> listarNotas() {
        return notaRepository.findAll()
                .stream()
                .map(notaMapper::toDto)
                .toList();
    }

    @Override
    public NotaResponseDTO actualizarNota(Long id, NotaRequestDTO dto) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nota no encontrada"));
        if (dto.getQuiz() != null){
            nota.setQuiz(dto.getQuiz());
        }
        if (dto.getExamen()!=null){
            nota.setExamen(dto.getExamen());
        }
        if (dto.getAsistencia()!=null){
            nota.setAsistencia(dto.getAsistencia());
        }
        if (dto.getTrabajo()!=null){
            nota.setTrabajo(dto.getTrabajo());
        }
        // Recalcular la nota final usando los valores actuales
        BigDecimal quiz = nota.getQuiz() != null ? nota.getQuiz() : BigDecimal.ZERO;
        BigDecimal examen = nota.getExamen() != null ? nota.getExamen() : BigDecimal.ZERO;
        BigDecimal asistencia = nota.getAsistencia() != null ? nota.getAsistencia() : BigDecimal.ZERO;
        BigDecimal trabajo = nota.getTrabajo() != null ? nota.getTrabajo() : BigDecimal.ZERO;

        BigDecimal notaFinal =
                quiz.multiply(new BigDecimal("0.20"))
                        .add(asistencia.multiply(new BigDecimal("0.10")))
                        .add(examen.multiply(new BigDecimal("0.35")))
                        .add(trabajo.multiply(new BigDecimal("0.35")));

        nota.setNotaFinal(notaFinal);

        Nota actualizada = notaRepository.save(nota);

        return notaMapper.toDto(actualizada);
    }

    @Override
    public void eliminarNota(Integer id) {
        notaRepository.deleteById(id.longValue());
    }
}
