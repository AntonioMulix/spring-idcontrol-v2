package com.id.control.service;

import com.id.control.dto.UsuarioGuardarDTO;
import com.id.control.entity.Usuario;
import com.id.control.entity.UsuarioSeguridad;
import java.util.Optional;

/**
 *
 * @author marco-romero
 */
public interface JwtService {

    public String extractUsername(String jwt);

    public boolean isTokenValid(String token, UsuarioSeguridad usuarios);

    public String generateTokenUser(Usuario usuario);

}
