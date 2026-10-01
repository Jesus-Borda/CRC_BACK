package com.iglesia.ver1.escuela.clase.repository;

import com.iglesia.ver1.escuela.clase.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository <Clase,Long> {
}
