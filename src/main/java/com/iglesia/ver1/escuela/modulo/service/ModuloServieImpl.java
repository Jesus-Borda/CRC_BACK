package com.iglesia.ver1.escuela.modulo.service;

import com.iglesia.ver1.escuela.modulo.dto.ModuloRequestDTO;
import com.iglesia.ver1.escuela.modulo.dto.ModuloResponseDTO;
import com.iglesia.ver1.escuela.modulo.mapper.ModuloMapper;
import com.iglesia.ver1.escuela.modulo.model.Modulo;
import com.iglesia.ver1.escuela.modulo.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ModuloServieImpl implements ModuloService {
    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private ModuloMapper moduloMapper;

    @Override
    public ModuloResponseDTO guardarModulo(ModuloRequestDTO dto) {
        Modulo modulo=moduloMapper.toEntity(dto);
        Modulo guardado = moduloRepository.save(modulo);

        return moduloMapper.toDto(guardado);

    }

    @Override
    public Optional<Modulo> get(Integer id) {
        return moduloRepository.findById(id.longValue());
    }

    @Override
    public List<ModuloResponseDTO> listarModulos() {
        return moduloRepository.findAll()
                .stream()
                .map(moduloMapper::toDto)
                .toList();
    }

    @Override
    public Modulo actualizarModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }

    @Override
    public void eliminarModulo(Integer id) {
        moduloRepository.deleteById(id.longValue());

    }
}
