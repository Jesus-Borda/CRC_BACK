package com.iglesia.ver1.escuela.inscripciones.repository;

import com.iglesia.ver1.escuela.inscripciones.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository <Inscripcion, Long>{
}
