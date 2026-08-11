package com.id.control.repository;

import com.id.control.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
