package com.id.control.controller;

import com.id.control.dto.UsuarioGuardarDTO;
import com.id.control.exception.ApiResponse;
import com.id.control.service.UsuarioService;
import com.id.control.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<ApiResponse<Response>> saveUsuario(@RequestBody UsuarioGuardarDTO usuarioGuardarDTO) {
        usuarioService.registerUser(usuarioGuardarDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.CREATED));
    }

}
