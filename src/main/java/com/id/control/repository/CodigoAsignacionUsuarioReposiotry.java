package com.id.control.repository;

import com.id.control.entity.CodigoAsignacionUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface CodigoAsignacionUsuarioReposiotry extends JpaRepository<CodigoAsignacionUsuario, Long> {

    @Query("""
           SELECT codigoAsignacionUsuario
           FROM CodigoAsignacionUsuario codigoAsignacionUsuario
           WHERE codigoAsignacionUsuario.codigoVerificacion =:codigoVerifiacion
           AND expired = FALSE
           """)
    public CodigoAsignacionUsuario findCodigoVerificacionUsuarioActiveByCodigoVerificacion(@Param("codigoVerificacion") String codigoVerificacion);

}
