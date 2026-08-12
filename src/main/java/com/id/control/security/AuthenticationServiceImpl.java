package com.id.control.security;

import com.id.control.dto.request.AuthenticationRequest;
import com.id.control.dto.response.AuthenticationResponse;
import com.id.control.entity.Usuario;
import com.id.control.repository.UsuarioRepository;
import com.id.control.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco-romero
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UsuarioRepository usuarioRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getLoginOption(),
                        authenticationRequest.getPassword())
        );
        Usuario usuario = usuarioRepository.buscarPorEmailTelefonoUsername(authenticationRequest.getLoginOption()).get();
        String jwtToken = jwtService.generateTokenUser(usuario);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;

    }

}
