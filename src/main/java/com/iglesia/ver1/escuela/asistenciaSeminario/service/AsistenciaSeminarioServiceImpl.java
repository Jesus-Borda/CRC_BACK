package com.iglesia.ver1.escuela.asistenciaSeminario.service;

import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioRequestDTO;
import com.iglesia.ver1.escuela.asistenciaSeminario.dto.AsistenciaSeminarioResponseDTO;
import com.iglesia.ver1.escuela.asistenciaSeminario.mapper.AsistenciaSeminarioMapper;
import com.iglesia.ver1.escuela.asistenciaSeminario.model.AsistenciaSeminario;
import com.iglesia.ver1.escuela.asistenciaSeminario.repository.AsistenciaSeminarioRepository;
import com.iglesia.ver1.escuela.estudiante.mapper.EstudianteMapper;
import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.estudiante.repository.EstudianteRepository;
import com.iglesia.ver1.escuela.seminario.mapper.SeminarioMapper;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import com.iglesia.ver1.escuela.seminario.repository.SeminarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaSeminarioServiceImpl implements AsistenciaSeminarioService {

    @Autowired
    private AsistenciaSeminarioRepository asistenciaSeminarioRepository;
    @Autowired
    private AsistenciaSeminarioMapper asistenciaSeminarioMapper;
    @Autowired
    private SeminarioMapper seminarioMapper;
    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private SeminarioRepository seminarioRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public AsistenciaSeminarioResponseDTO guardarAsistenciaSeminario(AsistenciaSeminarioRequestDTO dto) {
        AsistenciaSeminario asistenciaSeminario = asistenciaSeminarioMapper.toEntity(dto);
        Seminario seminario = seminarioRepository.findById(dto.getIdSeminario())
                .orElseThrow(()->new RuntimeException("Seminario no encontrado"));
        asistenciaSeminario.setSeminario(seminario);
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(()->new RuntimeException("Estudiante no encontrado"));
        asistenciaSeminario.setEstudiante(estudiante);
        asistenciaSeminario.setAsistencia(dto.isAsistencia());
        AsistenciaSeminario guardada = asistenciaSeminarioRepository.save(asistenciaSeminario);

        return asistenciaSeminarioMapper.toDto(guardada);
    }

    @Override
    public Optional<AsistenciaSeminarioResponseDTO> getAsistenciaSeminario(Integer id) {
        return asistenciaSeminarioRepository.findById(id.longValue())
                .map(asistenciaSeminario -> asistenciaSeminarioMapper.toDto(asistenciaSeminario));
    }
    @Transactional
    @Override
    public List<AsistenciaSeminarioResponseDTO> listarAsistenciaSeminario() {
        return asistenciaSeminarioRepository.findAll()
                .stream()
                .map(asistenciaSeminarioMapper::toDto)
                .toList();
    }



    @Override
    public AsistenciaSeminarioResponseDTO actualizarAsistenciaSeminario(Long id, AsistenciaSeminarioRequestDTO dto) {
        // 1. Buscamos la entidad original
        AsistenciaSeminario asistenciaSeminario = asistenciaSeminarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("AsistenciaSeminario no encontrada"));
        // 2. Si el DTO trae un ID de materia, lo validamos Y lo asignamos
        if (dto.getIdSeminario() != null) {
            Seminario seminario = seminarioRepository.findById(dto.getIdSeminario())
                    .orElseThrow(()-> new RuntimeException("Seminario no encontrado"));
            asistenciaSeminario.setSeminario(seminario);
        }
        if (dto.getIdEstudiante()!=null){
            Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                    .orElseThrow(()-> new RuntimeException("Estudiante no encontrado"));
            asistenciaSeminario.setEstudiante(estudiante);
        }
        asistenciaSeminario.setAsistencia(dto.isAsistencia());

        AsistenciaSeminario actualizada = asistenciaSeminarioRepository.save(asistenciaSeminario);
        return asistenciaSeminarioMapper.toDto(actualizada);
    }

    @Override
    public void eliminarAsistenciaSeminario(Integer id) {
        asistenciaSeminarioRepository.deleteById(id.longValue());

    }
}
