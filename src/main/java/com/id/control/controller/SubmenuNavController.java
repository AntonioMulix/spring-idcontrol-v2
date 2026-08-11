package com.id.control.controller;

import com.id.control.dto.SubmenuNavDTO;
import com.id.control.entity.SubmenuNav;
import com.id.control.exception.ApiResponse;
import com.id.control.service.MenuNavService;
import com.id.control.util.Response;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco-romero
 */
@RestController
@RequestMapping("/v1/submenu")
@Tag(name = "Navegación de submenu")
@SecurityRequirement(name = "bearerAuth")
public class SubmenuNavController {

    @Autowired
    private MenuNavService menuNavService;

    /**
     * ==============================================================
     * ================= SUBMENU - NAV ================================
     *
     * @return
     */
    //Listar
    @GetMapping("/listar")
    public ResponseEntity<ApiResponse<List<SubmenuNav>>> listarSubmenu() {
        List<SubmenuNav> result = menuNavService.listAllMenuNav();
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    //GUARDAR
    @PostMapping("/guardar")
    public ResponseEntity<ApiResponse<Response>> guardarMenu(@RequestBody SubmenuNavDTO subMenuDTO) {
        menuNavService.saveSubmenu(subMenuDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.CREATED));
    }

    //Editar
    @PostMapping("/editar/{idSubmenu}")
    public ResponseEntity<ApiResponse<Response>> actualizarMenu(@PathVariable Integer idSubmenu, @RequestBody SubmenuNavDTO subMenuDTO) {
        menuNavService.updateSubmenu(idSubmenu, subMenuDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));
    }

    //Cambiar estatus
    @PostMapping("/estatus/{idSubmenu}")
    public ResponseEntity<ApiResponse<Response>> updateEstatus(@PathVariable Integer idSubmenu) {
        menuNavService.updateEstatusSubmenu(idSubmenu);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));
    }

    //Eliminar registro
    @DeleteMapping("/eliminar/{idSubmenu}")
    public ResponseEntity<ApiResponse<Response>> deleteEstatus(@PathVariable Integer idSubmenu) {
        menuNavService.deleteSubmenu(idSubmenu);
        return ResponseEntity.ok(ApiResponse.ok(Response.DELETED));
    }

}
