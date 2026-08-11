package com.id.control.controller;

import com.id.control.dto.PersonaDTO;
import com.id.control.exception.ApiResponse;
import com.id.control.service.PersonaService;
import com.id.control.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("v1/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //Guardar nuevo registro
    @PostMapping("/registroPersona")
    public ResponseEntity<ApiResponse<Response>> savePersona(@RequestBody PersonaDTO personaDTO) {

        personaService.guardarPersona(personaDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));

    }

}
