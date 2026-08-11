package com.id.control.service;

import com.id.control.dto.UsuarioGuardarDTO;
import com.id.control.entity.Usuario;
import com.id.control.entity.UsuarioSeguridad;
import java.util.Optional;

/**
 *
 * @author marco-romero
 */
public interface UsuarioService {

    //Register a user
    public void registerUser(UsuarioGuardarDTO usuarioDTO);

    //load user by loginEmail
    public UsuarioGuardarDTO loadUserByEmail(String email);

    //Cargar usuario por opcionLogin
    public UsuarioSeguridad loadUserByOptionLogin(String optionLogin);

    //Usuario Seguridad
    public Usuario loadByUsername(String username);

}
