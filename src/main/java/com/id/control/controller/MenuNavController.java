package com.id.control.controller;

import com.id.control.dto.MenuNavDTO;
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
@RequestMapping("/v1/menu")
@Tag(name = "Navegación de Menú")
@SecurityRequirement(name = "bearerAuth")
public class MenuNavController {

    @Autowired
    private MenuNavService menuNavService;

    /**
     * *******************MENU NAV
     *
     **************************
     * @param menuDTO
     * @return
     */
    //Guardar
    @PostMapping("/guardar")
    public ResponseEntity<ApiResponse<Response>> guardarMenu(@RequestBody MenuNavDTO menuDTO) {
        menuNavService.saveMenu(menuDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.CREATED));
    }

    //Editar
    /**
     *
     * @param idMenu
     * @param menuDTO
     * @return
     */
    @PostMapping("/editar/{idMenu}")
    public ResponseEntity<ApiResponse<Response>> actualizarMenu(@PathVariable Integer idMenu, @RequestBody MenuNavDTO menuDTO) {
        menuNavService.updateMenu(idMenu, menuDTO);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));
    }

    //Cambiar estatus
    @PostMapping("/estatus/{idMenu}")
    public ResponseEntity<ApiResponse<Response>> updateEstatus(@PathVariable Integer idMenu) {
        menuNavService.updateEstatusMenu(idMenu);
        return ResponseEntity.ok(ApiResponse.ok(Response.OK));
    }

    //Eliminar registro
    @DeleteMapping("/eliminar/{idMenu}")
    public ResponseEntity<ApiResponse<Response>> deleteEstatus(@PathVariable Integer idMenu) {
        menuNavService.deleteMenu(idMenu);
        return ResponseEntity.ok(ApiResponse.ok(Response.DELETED));
    }
}
