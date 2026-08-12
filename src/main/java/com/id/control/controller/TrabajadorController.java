package com.id.control.controller;

import com.id.control.dto.TrabajadorDTO;
import com.id.control.exception.ApiResponse;
import com.id.control.service.TrabajadorService;
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
@RequestMapping("/v1/trabajador")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ApiResponse<Response>> saveTrabajador(@RequestBody TrabajadorDTO trabajadorDTO) {
        trabajadorService.guardarTrabajador(trabajadorDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));
    }

}
