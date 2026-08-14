package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class MenuNavDTO {

    private String descripcion;
    private boolean estatus;
    private Integer orden;

    public MenuNavDTO() {
    }

    public MenuNavDTO(String descripcion, boolean estatus, Integer orden) {
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.orden = orden;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
