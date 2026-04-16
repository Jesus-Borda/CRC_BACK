package com.iglesia.ver1.escuela.modulo.controller;

import com.iglesia.ver1.escuela.modulo.dto.ModuloRequestDTO;
import com.iglesia.ver1.escuela.modulo.dto.ModuloResponseDTO;
import com.iglesia.ver1.escuela.modulo.model.Modulo;
import com.iglesia.ver1.escuela.modulo.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/modulo")
public class ModuloController {
    @Autowired
    private ModuloService moduloService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearModulo")
    public ModuloResponseDTO crearModulo (@RequestBody ModuloRequestDTO dto){
        return moduloService.guardarModulo(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/ListarModulos")
    public List<ModuloResponseDTO> listarModulos (){
        return moduloService.listarModulos();
    }
    @GetMapping("/BuscarModulo/{id}")
    public Modulo buscarPorId (@PathVariable Integer id){
        return moduloService.get(id)
                .orElseThrow(()->new RuntimeException("Modulo no encontrado"));
    }

    //------------------------------ACTUALIZAR


   @PostMapping("/actualizarModulo/{id}")
    public Modulo actualizarModulo (@PathVariable Integer id, @RequestBody Modulo modulo){
       Modulo moduloExistente = moduloService.get(id)
               .orElseThrow(() -> new RuntimeException("Modulo no encontrado"));
       if (modulo.getNombre() != null) {
           moduloExistente.setNombre(modulo.getNombre());
       }
       if (modulo.getDescripcion() != null) {
           moduloExistente.setDescripcion(modulo.getDescripcion());
       }
       if (modulo.getEstado() != null) {
           moduloExistente.setEstado(modulo.getEstado());
       }
        return moduloService.actualizarModulo(moduloExistente);
    }


   @DeleteMapping("/eliminarModulo/{id}")
    public void eliminarModulo (@PathVariable Integer id){
        Modulo moduloExistente = moduloService.get(id)
                .orElseThrow(() -> new RuntimeException("Modulo no encontrado"));
        moduloService.eliminarModulo(id);
   }
}