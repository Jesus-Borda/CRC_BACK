package com.iglesia.ver1.escuela.materia.service;

import com.iglesia.ver1.escuela.materia.dto.MateriaRequestDTO;
import com.iglesia.ver1.escuela.materia.dto.MateriaResponseDTO;
import com.iglesia.ver1.escuela.materia.mapper.MateriaMapper;
import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.materia.repository.MateriaRepository;
import com.iglesia.ver1.escuela.modulo.model.Modulo;
import com.iglesia.ver1.escuela.modulo.repository.ModuloRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private MateriaMapper materiaMapper;
    @Autowired
    private ModuloRepository moduloRepository;

    @Override
    public MateriaResponseDTO guardarMateria(MateriaRequestDTO dto) {
        Materia materia = materiaMapper.toEntity(dto);
        Modulo modulo=moduloRepository.findById(dto.getIdModulo()).orElseThrow(() -> new RuntimeException("Modulo no encontrado"));
        materia.setModulo(modulo);
        Materia guardada = materiaRepository.save(materia);
        return materiaMapper.toDto(guardada);
    }

    @Override
    public Optional<Materia> getMateria(Integer id) {
        return materiaRepository.findById(id.longValue());
    }

    @Override
    public List<MateriaResponseDTO> listarMaterias() {
        return materiaRepository.findAll()
                .stream()
                .map(materiaMapper::toDto)
                .toList();
    }

    @Override
    public MateriaResponseDTO actualizarMateria(Long id, MateriaRequestDTO dto) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        // ✅ Solo actualiza si viene en el DTO
        if (dto.getNombreMateria() != null) {
            materia.setNombreMateria(dto.getNombreMateria());
        }

        if (dto.getDescripcionMateria() != null) {
            materia.setDescripcionMateria(dto.getDescripcionMateria());
        }


        if (dto.getIdModulo() != null) {
            Modulo modulo = moduloRepository.findById(dto.getIdModulo())
                    .orElseThrow(() -> new RuntimeException("Modulo no encontrado"));

            materia.setModulo(modulo);
        }
        Materia actualizada = materiaRepository.save(materia);

        return materiaMapper.toDto(actualizada);
    }


    @Override
    public void eliminarMateria(Integer id) {
        materiaRepository.deleteById(id.longValue());
    }
}
