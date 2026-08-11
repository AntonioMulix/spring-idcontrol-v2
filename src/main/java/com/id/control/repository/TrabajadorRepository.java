package com.id.control.repository;

import com.id.control.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

    //Encontrar trabajador por id
    @Query("""
           SELECT trabajador FROM Trabajador trabajador
           WHERE trabajador.idTrabajador =:idTrabajador
           """)
    public Trabajador findTrabajadorById(@Param("trabajadorId") Long trabajadorId);

    //Buscar ultimo registro por fecha de registro
    @Query("""
           SELECT trabajador FROM Trabajador trabajador
           ORDER BY trabajador.fechaRegistro DESC
           LIMIT 1
           """)
    public Trabajador findLastRegisterTrabajador();

}
