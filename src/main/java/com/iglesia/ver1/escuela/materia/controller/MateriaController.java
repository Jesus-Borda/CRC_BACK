package com.iglesia.ver1.escuela.materia.controller;

import com.iglesia.ver1.escuela.materia.dto.MateriaRequestDTO;
import com.iglesia.ver1.escuela.materia.dto.MateriaResponseDTO;
import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.materia.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/escuela/materia")
public class MateriaController {
    @Autowired
    private MateriaService materiaService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearMateria")
    public MateriaResponseDTO crearMateria (@RequestBody MateriaRequestDTO dto){
        return  materiaService.guardarMateria(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarMaterias")
    public List<MateriaResponseDTO> listarMaterias (){
        return materiaService.listarMaterias();
    }
    @GetMapping("/buscarMateria/{id}")
    public Materia buscarPorId (@PathVariable Integer id){
        return materiaService.getMateria(id)
                .orElseThrow(()->new RuntimeException("Materia no encontrada"));
    }
    //------------------------------ACTUALIZAR
    @PostMapping("/actualizarMateria/{id}")
    public MateriaResponseDTO actualizarMateria (@PathVariable Long id, @RequestBody MateriaRequestDTO dto){

        return materiaService.actualizarMateria(id, dto);

    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarMateria/{id}")
    public void eliminarMateria (@PathVariable Integer id){
        Materia materiaExistente = materiaService.getMateria(id)
                .orElseThrow(()-> new RuntimeException("Materia no encontrada"));
        materiaService.eliminarMateria(id);
    }

}
