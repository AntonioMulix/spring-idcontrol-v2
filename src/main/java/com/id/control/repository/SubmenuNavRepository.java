package com.id.control.repository;

import com.id.control.entity.SubmenuNav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface SubmenuNavRepository extends JpaRepository<SubmenuNav, Integer> {

}
