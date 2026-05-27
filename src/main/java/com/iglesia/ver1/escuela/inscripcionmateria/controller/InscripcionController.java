package com.iglesia.ver1.escuela.inscripcionmateria.controller;

import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaRequesDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.dto.InscripcionMateriaResponseDTO;
import com.iglesia.ver1.escuela.inscripcionmateria.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/inscripcionMateria")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearInscripcionMateria")
    public InscripcionMateriaResponseDTO crearInscripcionMateria(@RequestBody InscripcionMateriaRequesDTO dto){
    return  inscripcionService.guardarInscripcion(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarInscripcionMaterias")
    public List<InscripcionMateriaResponseDTO> listarMaterias(){
        return inscripcionService.listarInscripcion();
    }
    @GetMapping("/buscarInscripcionMateria/{id}")
    public InscripcionMateriaResponseDTO buscarInscripcionPorId (@PathVariable Integer id){
        return inscripcionService.getInscripcion(id).orElseThrow(()->new RuntimeException("Inscripcion no encontrada"));
    }
    /*------------------------------ACTUALIZAR
    @PostMapping("/actualizarInscripcion/{id}")
    public InscripcionMateriaResponseDTO actualizarInscripcion (@PathVariable Integer id, @RequestBody InscripcionMateriaRequesDTO dto){
        return  inscripcionService.actualizarInscripcion(id.longValue(),dto);
    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarInscripcion/{id}")
    public void eliminarInscripcion (@PathVariable Integer id){
        InscripcionMateriaResponseDTO inscripcionMateriaResponseDTO = inscripcionService.getInscripcion(id)
                .orElseThrow(()->new RuntimeException("Inscripcion no encontrada"));
        inscripcionService.eliminarInscripcion(id);
    }*/
}
