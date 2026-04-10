package com.iglesia.ver1.core.personas.controller;

import com.iglesia.ver1.core.personas.model.Persona;
import com.iglesia.ver1.core.personas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //-------------------------------METODOS-------------------------------
    //------------------------------CREAR
    @PostMapping("/crearPersona")
    public Persona crearPersona ( @RequestBody Persona persona){
        return personaService.guardarPersona(persona);
    }
    //------------------------------LISTAR
    @GetMapping("/listarPersonas")
    public List<Persona> listarPersonas (){
        return personaService.listarPersonas();
    }
    @PatchMapping("/actualizarPersona/{id}")
    //------------------------------ACTUALIZAR
    public Persona actualizarPersona (@PathVariable Integer id, @RequestBody Persona persona){

        Persona personaExistente = personaService.get(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (persona.getNombres() != null) {
            personaExistente.setNombres(persona.getNombres());
        }
        if (persona.getApellidos() != null) {
            personaExistente.setApellidos(persona.getApellidos());
        }
        if (persona.getTelefono() != null) {
            personaExistente.setTelefono(persona.getTelefono());
        }
        if (persona.getEmail() != null) {
            personaExistente.setEmail(persona.getEmail());
        }
        if (persona.getDireccion() != null) {
            personaExistente.setDireccion(persona.getDireccion());
        }
        if (persona.getFecha_nacimiento() != null) {
            personaExistente.setFecha_nacimiento(persona.getFecha_nacimiento());
        }
        if (persona.getGenero() != null) {
            personaExistente.setGenero(persona.getGenero());
        }
        if (persona.getFecha_registro() != null) {
            personaExistente.setFecha_registro(persona.getFecha_registro());
        }
        if (persona.getEstado() != null) {
            personaExistente.setEstado(persona.getEstado());
        }
        if (persona.getEscuela_formacion() != null) {
            personaExistente.setEscuela_formacion(persona.getEscuela_formacion());
        }
        if (persona.getCedula() != null) {
            personaExistente.setCedula(persona.getCedula());
        }

        return personaService.actualizarPersona(personaExistente);

    }
    //------------------------------DELETE
    @DeleteMapping("/eliminarPersona/{id}")
    public void eliminarPersona (@PathVariable Integer id){
        Persona personaExistente = personaService.get(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        personaService.eliminarPersona(id);
    }
    //------------------------------Read by id
    @GetMapping("/buscarPersona/{id}")
    public Persona buscarPorId(@PathVariable Integer id){
        return personaService.get(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }
}
