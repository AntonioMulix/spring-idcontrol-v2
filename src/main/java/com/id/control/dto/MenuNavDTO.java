package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class MenuNavDTO {

    private String descripcion;
    private String url;
    private String icon;
    private boolean estatus;
    private Integer orden;

    public MenuNavDTO() {
    }

    public MenuNavDTO(String descripcion, String url, String icon, boolean estatus, Integer orden) {
        this.descripcion = descripcion;
        this.url = url;
        this.icon = icon;
        this.estatus = estatus;
        this.orden = orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
