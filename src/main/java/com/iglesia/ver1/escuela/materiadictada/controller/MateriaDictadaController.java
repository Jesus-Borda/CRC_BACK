package com.iglesia.ver1.escuela.materiadictada.controller;

import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaRequestDTO;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaResponseDTO;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import com.iglesia.ver1.escuela.materiadictada.service.MateriaDictadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/materiaDictada")
public class MateriaDictadaController {
      @Autowired
      private MateriaDictadaService materiaDictadaService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearMateriaDictada")
    public MateriaDictadaResponseDTO crearMateriaDictada (@RequestBody MateriaDictadaRequestDTO dto){
        return materiaDictadaService.guardarMateriaDictada(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarMateriasDictadas")
    public List<MateriaDictadaResponseDTO> listarMateriasDictadas (){
        return materiaDictadaService.listarMateriaDictada();
    }
    @GetMapping("/buscarMateriaDictada/{id}")
    public  MateriaDictada buscarMateriaPorId (@PathVariable Integer id){
        return materiaDictadaService.getMateriaDictada(id)
                .orElseThrow(()->new RuntimeException("Materia no encontrada"));
    }
    //------------------------------ACTUALIZAR
    @PostMapping("/actualizarMateriaDictada/{id}")
    public MateriaDictadaResponseDTO actualizarMateria (@PathVariable Long id,@RequestBody  MateriaDictadaRequestDTO dto ){
        return  materiaDictadaService.actualizarMateriaDictada(id, dto);
    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarMateria/{id}")
    public void  eliminarMateriaDictada (@PathVariable Integer id){
        MateriaDictada materiaDictada = materiaDictadaService.getMateriaDictada(id)
                .orElseThrow(()-> new RuntimeException("Materia Dictada no encontrada"));
        materiaDictadaService.eliminarMateria(id);
    }
}
