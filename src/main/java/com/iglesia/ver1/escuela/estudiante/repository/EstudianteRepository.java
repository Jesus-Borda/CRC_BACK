package com.iglesia.ver1.escuela.estudiante.repository;

import com.iglesia.ver1.escuela.estudiante.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository <Estudiante, Long> {

}
