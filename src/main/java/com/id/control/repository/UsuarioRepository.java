package com.id.control.repository;

import com.id.control.dto.UsuarioGuardarDTO;
import com.id.control.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marco-romero
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Find user by loginEmail
    @Query("""
           SELECT u
           FROM Usuario u
           WHERE u.loginEmail =:loginEmail
           """)
    public UsuarioGuardarDTO findUserByEmail(@Param("loginEmail") String loginEmail);

    @Query("""
    SELECT u
    FROM Usuario u
    WHERE u.loginEmail = :valor
    OR u.loginTelefono = :valor
    OR u.username = :valor
    """)
    Optional<Usuario> buscarPorEmailTelefonoUsername(@Param("valor") String valor);

}
