package com.id.control.repository;

import com.id.control.entity.MenuNav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface MenuNavRepository extends JpaRepository<MenuNav, Integer> {

}
