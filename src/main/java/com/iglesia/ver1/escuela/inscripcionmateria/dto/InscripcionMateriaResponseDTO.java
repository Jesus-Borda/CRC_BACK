package com.iglesia.ver1.escuela.inscripcionmateria.dto;

import lombok.Data;

@Data
public class InscripcionMateriaResponseDTO {
   private Long id;
   private String nombreMateria;
   private String nombreModulo;
   private String nombrePeriodo;
   private String nombreProfesor;
   private String nombreEstudiante;
}
