package com.id.control.util;

/**
 *
 * @author marco-romero
 */
public final class Constantes {

    private Constantes() {
    }

    /* Errores en base de datos */
    public static final String ERROR_EN_BASE_DE_DATOS = "Error en base de datos";

    /*
     * ===========================================
     * Constantes de Respuestas para OutputEntity
     * ==============================================
     */
    public static final String USUARIO_INEXISTENTE_OUTPUT = "No existe nigun usuario con el nombre ingresado";
    public static final String CREDENCIALES_INCORRECTAS = "Telefono, Correo o Contraseña incorrecta";
    /* CURP */
    public static final String CURP_EXISTE_EN_LLAVE_OUTPUT = "El CURP ingresado ya existe en el sistema de llave cdmx. Intenta iniciar sesión con usuario y contraseña";
    public static final String CURP_FORMATO_INCORRECTO_OUTPUT = "El formato del CURP es incorrecto, revisa que estes pasando los 18 caracteres del formato.";
    public static final String CURP_RESPUESTA_VACIA_OUTPUT = "El servicio de CURP regreso una respuesta vacia, puede ser que el servicio de RENAPO este fallando.";
    public static final String CURP_SERVICIO_ERROR_OUTPUT = "Error en el servicio de CURP; Probablemente el servicio de RENAPO este fallando. Intenta nuevamente mas tarde";
    /* CODIGO POSTAL */
    public static final String CP_INVALIDO = "El formato del Código Postal es inválido. Revisa el Formato del CP";
    public static final String CP_VALIDO = "Se econtraron resultados con el código postal ingresado.";
    public static final String CP_SIN_RESULTADOS = "No se encontraron resultado con el código postal ingresado.";
    /* VALIDACION DE MEDIOS DE CONTACTO */
    public static final String USUARIO_EXTRANJERO_OUTPUT = "El usuario es extranjero. No es necesario hacer la validación de los medios de contacto";
    public static final String MENSAJE_ENVIADO_OUTPUT = "El mensaje fue enviado con éxito";
    public static final String CORREO_ENVIADO_OUTPUT = "El correo fue enviado con éxito";
    public static final String CORREO_Y_MENSAJE_OUTPUT = "El correo y el mensaje fue enviado con éxito";
    public static final String USUARIO_NO_ENCONTRADO_OUTPUT = "No hay ningun usuario registrado con los medios de contacto proporcionados, favor de verificar el correo o telefonos enviados.";
    public static final String DATOS_INVALIDOS_OUTPUT = "Debe proporcionar correo o telefono";
    /* Registro de usuario extranjero */
    public static final String FALTA_DOCUMENTACION_EXTRANJERO_OUTPUT = "Falta la documentación del usuario extranjero";
    public static final String DOCUMENTO_EXCEDE_LONGITUD_OUTPUT = "El documento excede el tamaño permitido 2MB";
    /* Login de Usuario */
    public static final String INVALID_PASSWORD_OUTPUT = "Password invalido";

}
