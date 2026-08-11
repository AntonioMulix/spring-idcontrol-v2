package com.id.control.repository;

import com.id.control.entity.CatGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface CatGeneroRepository extends JpaRepository<CatGenero, Integer> {

}
