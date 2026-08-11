package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class TrabajadorDTO {

    private Long personaId;
    private Long plazaId;
    private Long numEmpleado;
    private String folioEmpleado;

    public TrabajadorDTO() {
    }

    public TrabajadorDTO(Long personaId, Long plazaId, Long numEmpleado, String folioEmpleado) {
        this.personaId = personaId;
        this.plazaId = plazaId;
        this.numEmpleado = numEmpleado;
        this.folioEmpleado = folioEmpleado;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public Long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Long plazaId) {
        this.plazaId = plazaId;
    }

    public Long getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Long numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getFolioEmpleado() {
        return folioEmpleado;
    }

    public void setFolioEmpleado(String folioEmpleado) {
        this.folioEmpleado = folioEmpleado;
    }

}
