package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class MenuNavDTO {

    private String descripcion;
    private boolean estatus;

    public MenuNavDTO() {
    }

    public MenuNavDTO(String descripcion, boolean estatus) {
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
