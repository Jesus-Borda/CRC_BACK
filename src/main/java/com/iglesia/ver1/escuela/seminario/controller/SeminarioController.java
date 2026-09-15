package com.iglesia.ver1.escuela.seminario.controller;

import com.iglesia.ver1.escuela.seminario.dto.SeminarioRequestDTO;
import com.iglesia.ver1.escuela.seminario.dto.SeminarioResponseDTO;
import com.iglesia.ver1.escuela.seminario.model.Seminario;
import com.iglesia.ver1.escuela.seminario.service.SeminarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Seminario")
public class SeminarioController {
    @Autowired
    private SeminarioService seminarioService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearSeminario")
    public SeminarioResponseDTO crearSeminarioResponseDTO (@RequestBody SeminarioRequestDTO dto){
        return seminarioService.guardarSeminario(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarSeminarios")
    public List<SeminarioResponseDTO> listarSeminarios (){return seminarioService.listarSeminarios();
    }
    //------------------------------ACTUALIZAR
    @PatchMapping("/actualizarSeminario/{id}")
    public Seminario actualizarSeminario (@PathVariable Integer id, @RequestBody Seminario seminario){
        Seminario seminarioExistente = seminarioService.getSeminario(id).orElseThrow(()-> new RuntimeException("Servicio no encontrado") );

        if (seminario.getNombreSeminario()!= null){

        }
    }
}
