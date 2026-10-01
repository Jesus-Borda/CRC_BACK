package com.iglesia.ver1.escuela.clase.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class ClaseResponseDTO {
    private Long idClase;
    private Integer numeroClase;
    private String nombreMateria;
    private String nombreProfesor;
    private String apellidoProfesor;
    private LocalDate fechaClase;

}
