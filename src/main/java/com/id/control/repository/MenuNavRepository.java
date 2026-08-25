package com.id.control.repository;

import com.id.control.dto.MenuNavItemDTO;
import com.id.control.entity.MenuNav;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface MenuNavRepository extends JpaRepository<MenuNav, Integer> {

    //Encontrar el ultimo registro de MenuNav
    @Query("""
           SELECT menuNav FROM MenuNav menuNav
           ORDER BY orden DESC LIMIT 1
           """)
    public MenuNav findLastOneOrder();

    //Encontrar registro por número de orden
    @Query("""
           SELECT menuNav FROM MenuNav menuNav
           WHERE orden =:orden
           """)
    public MenuNav findByOrderNum(@Param("orden") Integer orden);

    @Query("""
    SELECT DISTINCT menu
    FROM MenuNav menu
    LEFT JOIN FETCH menu.submenus
    ORDER BY menu.orden
    """)
    List<MenuNav> findAllMenusWithSubmenus();
}
