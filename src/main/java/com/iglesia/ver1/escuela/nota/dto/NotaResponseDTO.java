package com.iglesia.ver1.escuela.nota.dto;

import com.iglesia.ver1.escuela.estudiante.dto.EstudianteResponseDTO;
import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import com.iglesia.ver1.escuela.materia.model.Materia;
import com.iglesia.ver1.escuela.materiadictada.dto.MateriaDictadaResponseDTO;
import com.iglesia.ver1.escuela.materiadictada.model.MateriaDictada;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NotaResponseDTO {
    private Long idNota;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nombreMateriaDictada;
    private String nombreModulo;
    private String nombreProfesor;
    private String apellidoProfesor;
    private Integer anio;
    private BigDecimal quiz;
    private BigDecimal examen;
    private BigDecimal asistencia;
    private BigDecimal notaFinal;


}
