package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class SubmenuNavDTO {

    private String descripcion;
    private Integer menuNavId;
    private boolean estatus;
    private Integer orden;

    public SubmenuNavDTO() {
    }

    public SubmenuNavDTO(String descripcion, Integer menuNavId, boolean estatus, Integer orden) {
        this.descripcion = descripcion;
        this.menuNavId = menuNavId;
        this.estatus = estatus;
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMenuNavId() {
        return menuNavId;
    }

    public void setMenuNavId(Integer menuNavId) {
        this.menuNavId = menuNavId;
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
