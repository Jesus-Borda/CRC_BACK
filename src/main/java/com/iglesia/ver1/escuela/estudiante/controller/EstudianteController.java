package com.iglesia.ver1.escuela.estudiante.controller;

import com.iglesia.ver1.escuela.estudiante.dto.EstudianteRequestDTO;
import com.iglesia.ver1.escuela.estudiante.dto.EstudianteResponseDTO;
import com.iglesia.ver1.escuela.estudiante.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crear")
    public EstudianteResponseDTO crear(@RequestBody EstudianteRequestDTO dto){

        return estudianteService.crear(dto);
    }
    @GetMapping("/Lista")
    //-----------------------------LISTAR
    public List<EstudianteResponseDTO> listar(){
        return estudianteService.listar();
    }
}
