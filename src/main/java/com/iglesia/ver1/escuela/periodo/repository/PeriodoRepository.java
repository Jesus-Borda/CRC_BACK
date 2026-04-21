package com.iglesia.ver1.escuela.periodo.repository;

import com.iglesia.ver1.escuela.periodo.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository <Periodo, Long> {
}
