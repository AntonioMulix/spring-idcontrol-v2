package com.id.control.util;

import lombok.Getter;

/**
 *
 * @author marco-romero
 */
@Getter
public enum Response {
    OK("Proceso exitoso"),
    DELETED("Eliminado exitosamente"),
    CREATED("Registro creado exitosamente"),
    USUARIO_NO_ENCONTRADO("Usuario no encontrado"),
    CREDENCIALES_INCORRECTAS("Credenciales incorrectas"),
    CURP_NO_ENCONTRADA("CURP no encontrada"),
    DATOS_INVALIDOS("Datos inválidos"),
    /*
     * Respuestas Personalizadas
     * Marco Romero 20-07-26
     */
    /* CATALOGOS */
    /*  MENÚ - NAVEGACIÓN*/
    NOT_FOUND("No se encontraron resultados"),
    /* SUBMENU - NAVEGACION */
    MENU_NOT_FOUND("No hay resultados de el menu relacionado al submenu");
    private final String message;

    Response(String message) {
        this.message = message;
    }

}
