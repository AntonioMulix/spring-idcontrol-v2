package com.id.control.security;

import com.id.control.dto.request.AuthenticationRequest;
import com.id.control.dto.response.AuthenticationResponse;

/**
 *
 * @author marco-romero
 */
public interface AuthenticationService {

    //Iniciar sesion y dar acceso JWT Token
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}
