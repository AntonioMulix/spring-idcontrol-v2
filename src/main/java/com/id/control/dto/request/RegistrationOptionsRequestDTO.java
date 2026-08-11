package com.id.control.dto.request;

/**
 *
 * @author marco-romero
 */
public class RegistrationOptionsRequestDTO {

    private Long idUsuario; // Id usuario llaveCDMX
    private String curp; // Identificador unico del ciudadano
    private String nombreCompleto; // Nombre que verá el usuario cuando el autenticador le muestre qué cuenta est+a
    // registrando o seleccionando. (displayName)

    public RegistrationOptionsRequestDTO(Long idUsuario, String curp, String nombreCompleto) {
        this.idUsuario = idUsuario;
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

}
