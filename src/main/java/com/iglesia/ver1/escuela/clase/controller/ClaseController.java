package com.iglesia.ver1.escuela.clase.controller;

import com.iglesia.ver1.escuela.clase.dto.ClaseRequestDTO;
import com.iglesia.ver1.escuela.clase.dto.ClaseResponseDTO;
import com.iglesia.ver1.escuela.clase.model.Clase;
import com.iglesia.ver1.escuela.clase.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/clase")
public class ClaseController {
    @Autowired
    private ClaseService claseService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearClase")
    public ClaseResponseDTO crearClase (@RequestBody ClaseRequestDTO dto){
        return claseService.guardarClase(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarClase")
    public List<ClaseResponseDTO> listarClases (){
        return  claseService.listarClase();
    }
    @GetMapping("/buscarClase/{id}")
    public Clase buscarClasePorId (@PathVariable Integer id){
        return  claseService.getClase(id)
                .orElseThrow(()-> new RuntimeException("Clase no encontrada"));
    }


    //------------------------------ACTUALIZAR
    @PostMapping("/actualizarClase/{id}")
    public ClaseResponseDTO actualizarClase (@PathVariable Integer id , @RequestBody ClaseRequestDTO dto){
        return claseService.actualizarClase(id.longValue() ,dto);
    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarclase/{id}")
    public void eliminarClase (@PathVariable Integer id){
        Clase claseResponse = claseService.getClase(id)
                .orElseThrow(()->new RuntimeException(""));
        claseService.eliminarClase(id);
    }
}
