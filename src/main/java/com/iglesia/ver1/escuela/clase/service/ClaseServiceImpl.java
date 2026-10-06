package com.iglesia.ver1.escuela.clase.service;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;
import com.iglesia.ver1.escuela.clase.mapper.ClaseMapper;
import com.iglesia.ver1.escuela.clase.model.Clase;
import com.iglesia.ver1.escuela.clase.repository.ClaseRepository;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import com.iglesia.ver1.escuela.materiadictada.repository.MateriaDictadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;
    @Autowired
    private ClaseMapper claseMapper;
    @Autowired
    private MateriaDictadaRepository materiaDictadaRepository;

    @Transactional
    @Override
    public ClaseResponseDTO guardarClase(ClaseRequestDTO dto) {

        Clase clase= claseMapper.toEntity(dto);
        MateriaDictada materiaDictada = materiaDictadaRepository.findById(dto.getIdMateriaDictada())
            .orElseThrow( ()->new RuntimeException("Clase no encontrada"));
        clase.setMateriaDictada(materiaDictada);
        Clase guardada = claseRepository.save(clase);

        return claseMapper.toDTO(guardada);
    }

    @Override
    public Optional<Clase> getClase(Integer id) {
        return claseRepository.findById(id.longValue());
    }

    @Override
    public List<ClaseResponseDTO> listarClase() {
        return claseRepository.findAll()
                .stream()
                .map(claseMapper::toDTO)
                .toList();
    }

    @Override
    public ClaseResponseDTO actualizarClase(Long id, ClaseRequestDTO dto) {
        Clase clase=claseRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Clase no encontrada"));
        if (dto.getFechaClase()!=null){
            clase.setFechaClae(dto.getFechaClase());
        }
        if (dto.getNumeroClase() != null){
            clase.setNumeroClase(dto.getNumeroClase());
        }
        if (dto.getIdMateriaDictada() != null){
            MateriaDictada materiaDictada = materiaDictadaRepository.findById(dto.getIdMateriaDictada())
                    .orElseThrow(()->new RuntimeException("Materua Dictada no encontrada"));
        }
        Clase actualiada = claseRepository.save(clase);
        return claseMapper.toDTO(actualiada);
    }

    @Override
    public void eliminarClase(Integer id) {
        claseRepository.deleteById(id.longValue());
    }
}
