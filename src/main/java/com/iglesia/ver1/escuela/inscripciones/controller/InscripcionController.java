package com.iglesia.ver1.escuela.inscripciones.controller;

import com.iglesia.ver1.escuela.inscripciones.dto.InscripcionRequestDTO;
import com.iglesia.ver1.escuela.inscripciones.dto.InscripcionResponseDTO;
import com.iglesia.ver1.escuela.inscripciones.service.InscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    InscripcionService inscripcionService;
    @PostMapping("/crear")
    public InscripcionResponseDTO crear(@RequestBody InscripcionRequestDTO dto){
        return inscripcionService.crear(dto);
    }
    @GetMapping("/listar")
    public List<InscripcionResponseDTO> listar(){
        return inscripcionService.listar();
    }



}
