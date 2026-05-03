package com.iglesia.ver1.escuela.inscripcionmateria.repository;

import com.iglesia.ver1.escuela.inscripcionmateria.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository <Inscripcion, Long> {
}
