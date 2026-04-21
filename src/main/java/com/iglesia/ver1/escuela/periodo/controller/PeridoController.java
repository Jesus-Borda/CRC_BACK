package com.iglesia.ver1.escuela.periodo.controller;

import com.iglesia.ver1.escuela.modulo.model.Modulo;
import com.iglesia.ver1.escuela.periodo.dto.PeriodoReponseDTO;
import com.iglesia.ver1.escuela.periodo.dto.PeriodoRequestDTO;
import com.iglesia.ver1.escuela.periodo.model.Periodo;
import com.iglesia.ver1.escuela.periodo.service.PeriodoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/periodo")
public class PeridoController {
    @Autowired
    private PeriodoService periodoService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearPeriodo")
    public PeriodoReponseDTO crearPeriodo (@RequestBody PeriodoRequestDTO dto){
        return periodoService.guardarPeriodo(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarPeriodo")
    public List<PeriodoReponseDTO> listarPeriodo (){
        return  periodoService.listarPeriodo();
    }

    @GetMapping("/buscarPeriodo/{id}")
    public Periodo buscarPorId (@PathVariable Integer id){
        return periodoService.getPeriodo(id)
                .orElseThrow(()-> new RuntimeException("Periodo no encontrado"));
    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarPeriodo/{id}")
    public void eliminarPeriodo (@PathVariable Integer id){
        Periodo periodoExistente = periodoService.getPeriodo(id)
                .orElseThrow(()-> new RuntimeException("Periodo no encontrado"));
        periodoService.eliminarPeriodo(id);
    }

    @PostMapping("/actualizarPeriodo/{id}")
    public PeriodoReponseDTO actualizarPeriodo (@PathVariable Long id, @RequestBody PeriodoRequestDTO dto){
        return periodoService.actualizarPeriodo(id,dto);
    }

}