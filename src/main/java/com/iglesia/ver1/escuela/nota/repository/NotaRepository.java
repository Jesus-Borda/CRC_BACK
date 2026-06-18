package com.iglesia.ver1.escuela.nota.repository;

import com.iglesia.ver1.escuela.nota.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository <Nota, Long>{
}
