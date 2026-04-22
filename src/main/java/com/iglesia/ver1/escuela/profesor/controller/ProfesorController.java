package com.iglesia.ver1.escuela.profesor.controller;

import com.iglesia.ver1.escuela.profesor.dto.ProfesorRequestDTO;
import com.iglesia.ver1.escuela.profesor.dto.ProfesorResponseDTO;
import com.iglesia.ver1.escuela.profesor.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorServiceImpl profesorService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearProfesor")
    public ProfesorResponseDTO crear(@RequestBody ProfesorRequestDTO dto){
        return profesorService.crearProfesor(dto);
    }
    @GetMapping("/Lista")
    //-----------------------------LISTAR
    public List<ProfesorResponseDTO> listar(){
        return profesorService.listarProfesor();
    }

}
