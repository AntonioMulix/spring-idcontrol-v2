package com.id.control.repository;

import com.id.control.entity.CatEstatusUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface CatEstatusUsuarioRepository extends JpaRepository<CatEstatusUsuario, Integer> {

}
