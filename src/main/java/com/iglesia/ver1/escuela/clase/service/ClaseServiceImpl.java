package com.iglesia.ver1.escuela.clase.service;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;
import com.iglesia.ver1.escuela.clase.mapper.ClaseMapper;
import com.iglesia.ver1.escuela.clase.repository.ClaseRepository;
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



        return null;
    }

    @Override
    public Optional<ClaseResponseDTO> getClase(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<ClaseResponseDTO> listarClase() {
        return List.of();
    }

    @Override
    public ClaseResponseDTO actualizarClase(Long id) {
        return null;
    }

    @Override
    public void eliminarClase(Integer id) {

    }
}
