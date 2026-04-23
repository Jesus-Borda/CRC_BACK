package com.iglesia.ver1.escuela.materiadictada.service;

import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.materia.repository.MateriaRepository;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaRequestDTO;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaResponseDTO;
import com.iglesia.ver1.escuela.materiadictada.mapper.MateriaDictadaMapper;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import com.iglesia.ver1.escuela.materiadictada.repository.MateriaDictadaRepository;
import com.iglesia.ver1.escuela.periodo.model.Periodo;
import com.iglesia.ver1.escuela.periodo.repository.PeriodoRepository;
import com.iglesia.ver1.escuela.profesor.model.Profesor;
import com.iglesia.ver1.escuela.profesor.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class MateriaDictadaServiceImpl implements MateriaDictadaService{
    @Autowired
    private MateriaDictadaRepository materiaDictadaRepository;
    @Autowired
    private MateriaDictadaMapper materiaDictadaMapper;
    @Autowired
    private MateriaRepository materiaRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private PeriodoRepository periodoRepository;


    @Transactional
    @Override
    public MateriaDictadaResponseDTO guardarMateriaDictada(MateriaDictadaRequestDTO dto) {
        MateriaDictada materiaDictada = materiaDictadaMapper.toEntity(dto);
        Materia materia = materiaRepository.findById(dto.getIdMateria())
                .orElseThrow(() ->new RuntimeException("Materia No encontrada"));

        Profesor profesor= profesorRepository.findById(dto.getIdProfesor())
                .orElseThrow(()->new RuntimeException("Profesor No encontrado"));
        Periodo periodo = periodoRepository.findById(dto.getIdPeriodo())
                .orElseThrow(()-> new RuntimeException("Periodo No encontrado"));
        materiaDictada.setMateria(materia);
        materiaDictada.setProfesor(profesor);
        materiaDictada.setPeriodo(periodo);
        MateriaDictada guardada = materiaDictadaRepository.save(materiaDictada);
        return materiaDictadaMapper.toDTO(guardada);
    }

    @Override
    public Optional<MateriaDictada> getMateriaDictada (Integer id) {
        return materiaDictadaRepository.findById(id.longValue());
    }

    @Override
    public List<MateriaDictadaResponseDTO> listarMateriaDictada() {
        return materiaDictadaRepository.findAll()
                .stream()
                .map(materiaDictadaMapper::toDTO)
                .toList();
    }
    @Transactional
    @Override
    public MateriaDictadaResponseDTO actualizarMateriaDictada(Long id, MateriaDictadaRequestDTO dto) {
        MateriaDictada materiaDictada = materiaDictadaRepository.findById(id).orElseThrow(()->new RuntimeException("MateriaDictada NO encontrada"));
        if (dto.getIdMateria() != null){
            Materia materia = materiaRepository.findById(dto.getIdMateria())
                            .orElseThrow(()->new RuntimeException("Materia No exste"));
        }
        if (dto.getIdProfesor() != null) {
            Profesor profesor = profesorRepository.findById(dto.getIdProfesor())
                    .orElseThrow(()->new RuntimeException("Profesor no encontrado"));
        }
        if (dto.getIdPeriodo() != null){
            Periodo periodo = periodoRepository.findById(dto.getIdPeriodo())
                    .orElseThrow(()-> new RuntimeException("Periodo no encontrado"));
        }
        MateriaDictada actualizada = materiaDictadaRepository.save(materiaDictada);

        return materiaDictadaMapper.toDTO(actualizada);
    }

    @Override
    public void eliminarMateria(Integer id) {
        materiaDictadaRepository.deleteById(id.longValue());

    }
}
