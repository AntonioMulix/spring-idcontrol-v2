package com.id.control.controller;

import com.id.control.dto.CatEstatusUsuarioDTO;
import com.id.control.dto.CatGeneroDTO;
import com.id.control.exception.ApiResponse;
import com.id.control.service.CatalogosService;
import com.id.control.util.Response;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("/v1/catalogos")
@Tag(name = "Catálogos")
@SecurityRequirement(name = "bearerAuth")
public class CatalogosController {

    @Autowired
    private CatalogosService catalogosService;

    /*=========================================================
        CATALOGO GENERO
    ===========================================================*/
    @GetMapping("/genero/listar")
    public ResponseEntity<ApiResponse<List<CatGeneroDTO>>> listAllCatGenero() {
        List<CatGeneroDTO> result = catalogosService.listAllCatGenero();
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping("/genero/registrar")
    public ResponseEntity<ApiResponse<Response>> saveGenero(@RequestBody CatGeneroDTO catGeneroDTO) {
        catalogosService.guardarGenero(catGeneroDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.CREATED));
    }

    /*==========================================================
    CATALOGO ESTATUS USUARIO
    ============================================================*/
    @PostMapping("/estatus-usuario/registrar")
    public ResponseEntity<ApiResponse<Response>> saveEstatusUsuario(@RequestBody CatEstatusUsuarioDTO catEstatusUsuarioDTO) {
        catalogosService.guardarEstatusUsuario(catEstatusUsuarioDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.CREATED));
    }

}
