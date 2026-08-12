package com.id.control.security.service;

import com.id.control.entity.UsuarioSeguridad;
import com.id.control.exception.NotFoundException;
import com.id.control.service.UsuarioService;
import com.id.control.util.Response;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioService usuarioService;

    public UserDetailsServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String optionLogin) throws UsernameNotFoundException {
        UsuarioSeguridad usuario = usuarioService.loadUserByOptionLogin(optionLogin);
        if (usuario == null) {
            throw new NotFoundException(Response.USUARIO_NO_ENCONTRADO.getMessage());
        }
        return UsuarioPrincipal.build(usuario);

    }

}
