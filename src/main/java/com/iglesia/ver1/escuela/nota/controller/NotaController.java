package com.iglesia.ver1.escuela.nota.controller;

import com.iglesia.ver1.escuela.nota.dto.NotaRequestDTO;
import com.iglesia.ver1.escuela.nota.dto.NotaResponseDTO;
import com.iglesia.ver1.escuela.nota.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/escuela/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;
    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearNotas")
    public NotaResponseDTO crearNota (@RequestBody NotaRequestDTO dto){
        return notaService.guardarNota(dto);
    }
    //------------------------------LISTAR
    @GetMapping("/listarnotas")
    public List<NotaResponseDTO> listarNotas (){return notaService.listarNotas();}
    @GetMapping("/buscarNota/{id}")
    public NotaResponseDTO buscarNotaPorId (@PathVariable Integer id){
        return notaService.getNotas(id).orElseThrow(()-> new RuntimeException(""));
    }
   //------------------------------ACTUALIZAR
    @PostMapping("/actualizarNota/{id}")
    public NotaResponseDTO actualizarNota (@PathVariable Integer id, @RequestBody NotaRequestDTO dto){
        return  notaService.actualizarNota(id.longValue(),dto);
    } /*
    //------------------------------ELIMINAR
    @DeleteMapping("/eliminarInscripcion/{id}")
    public void eliminarNota (@PathVariable Integer id){
        NotaResponseDTO notaResponseDTO = notaService.getNotas(id)
                .orElseThrow(()->new RuntimeException("nota no encontrada"));
        notaService.eliminarNota(id);
    }
    */

}
