package com.iglesia.ver1.escuela.profesor.repository;

import com.iglesia.ver1.escuela.profesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository <Profesor, Long>{
}
