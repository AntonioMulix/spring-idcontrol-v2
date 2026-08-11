package com.id.control.repository;

import com.id.control.entity.UsuarioSeguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface UsuarioSeguridadRepository extends JpaRepository<UsuarioSeguridad, Long> {

    //Find user by username for LOGIN and CREDENTIAL
    @Query("""
           SELECT usuarioSeguridad FROM UsuarioSeguridad usuarioSeguridad
           WHERE usuarioSeguridad.usuario.username =:username
           """)
    public UsuarioSeguridad findByUsername(@Param("username") String username);

    @Query("""
    SELECT us
    FROM UsuarioSeguridad us
    WHERE us.usuario.loginEmail = :valor
    OR us.usuario.loginTelefono = :valor
    OR us.usuario.username = :valor
    """)
    UsuarioSeguridad buscarPorEmailTelefonoUsername(@Param("valor") String valor);

}
