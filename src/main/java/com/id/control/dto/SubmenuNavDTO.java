package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class SubmenuNavDTO {

    private String descripcion;
    private String url;
    private Integer menuNavId;
    private String iconSubmenu;
    private boolean estatus;
    private Integer orden;

    public SubmenuNavDTO() {
    }

    public SubmenuNavDTO(String descripcion, String url, Integer menuNavId, String iconSubmenu, boolean estatus, Integer orden) {
        this.descripcion = descripcion;
        this.url = url;
        this.menuNavId = menuNavId;
        this.iconSubmenu = iconSubmenu;
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

    public Integer getMenuNavId() {
        return menuNavId;
    }

    public void setMenuNavId(Integer menuNavId) {
        this.menuNavId = menuNavId;
    }

    public String getIconSubmenu() {
        return iconSubmenu;
    }

    public void setIconSubmenu(String iconSubmenu) {
        this.iconSubmenu = iconSubmenu;
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
