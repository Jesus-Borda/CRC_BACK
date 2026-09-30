package com.iglesia.ver1.escuela.seminario.controller;

import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioResponseDTO;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import com.iglesia.ver1.escuela.seminario.service.SeminarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/Seminario")
public class SeminarioController {
    @Autowired
    private SeminarioService  seminarioService ;
   //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearSeminario")
    public SeminarioResponseDTO crearSeminario (@RequestBody SeminarioRequestDTO dto){
        return seminarioService.guardarSeminario(dto);
    }

    //------------------------------LISTAR
    @GetMapping("/listarSeminarios")
    public List<SeminarioResponseDTO> listarSeminarios (){return seminarioService.listarSeminarios();
    }
    @GetMapping("/buscarSeminario/{id}")
    public Seminario buscarPorId (@PathVariable Integer id){
        return seminarioService.getSeminario(id)
                .orElseThrow(()->new RuntimeException("Seminario no encontrado"));
    }
    //------------------------------ACTUALIZAR
    @PostMapping("/actualizarSeminario/{id}")
    public SeminarioResponseDTO actualizarSeminario (@PathVariable Long id, @RequestBody SeminarioRequestDTO dto){

        return seminarioService.actualizarSeminarios(id,dto);
    }
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarSeminario/{id}")
    public void eliminarSeminario (@PathVariable Integer id){
        Seminario seminarioExistente= seminarioService.getSeminario(id)
                .orElseThrow(()->new RuntimeException("Seminario no encontrado00000"));
        seminarioService.eliminarSeminario(id);
    }
}
