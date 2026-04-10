package com.iglesia.ver1.core.personas.repository;

import com.iglesia.ver1.core.personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer> {


}
