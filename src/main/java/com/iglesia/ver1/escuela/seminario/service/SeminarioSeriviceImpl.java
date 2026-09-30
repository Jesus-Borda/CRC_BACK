package com.iglesia.ver1.escuela.seminario.service;

import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioResponseDTO;
import com.iglesia.ver1.escuela.seminario.mapper.SeminarioMapper;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import com.iglesia.ver1.escuela.seminario.repository.SeminarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeminarioSeriviceImpl implements SeminarioService{
    @Autowired
    private SeminarioRepository seminarioRepository;
    @Autowired
    private SeminarioMapper seminarioMapper;
    @Override
    public SeminarioResponseDTO guardarSeminario(SeminarioRequestDTO dto) {
        Seminario seminario = seminarioMapper.toEntity(dto);
        Seminario guardado = seminarioRepository.save(seminario);
        return  seminarioMapper.toDto(guardado);
    }


    @Override
    public Optional<Seminario> getSeminario(Integer id) {
        return seminarioRepository.findById(id.longValue());
    }

    @Override
    public List<SeminarioResponseDTO> listarSeminarios() {
        return seminarioRepository.findAll()
                .stream()
                .map(seminarioMapper::toDto)
                .toList();
    }

    @Override
    public SeminarioResponseDTO actualizarSeminarios(Long id ,SeminarioRequestDTO dto) {
        Seminario seminario = seminarioRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Seminario no encontrado"));
        if (dto.getNombre() != null){
            seminario.setNombreSeminario(dto.getNombre());
        }
        if (dto.getFechaInicio() != null){
            seminario.setFechaInicio(dto.getFechaInicio());
        }
        Seminario actualizado = seminarioRepository.save(seminario);
        return seminarioMapper.toDto(actualizado);
    }

    @Override
    public void eliminarSeminario(Integer id) {
        seminarioRepository.deleteById(id.longValue());
    }
}
