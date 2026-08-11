package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class MenuNavItemDTO {

    private Integer idMenu;
    private String descripcionMenu;
    private boolean estatusMenu;
    private Integer idSubmenu;
    private String descripcionSubmenu;
    private boolean estatusSubmenu;

    public MenuNavItemDTO() {
    }

    public MenuNavItemDTO(Integer idMenu, String descripcionMenu, boolean estatusMenu, Integer idSubmenu, String descripcionSubmenu, boolean estatusSubmenu) {
        this.idMenu = idMenu;
        this.descripcionMenu = descripcionMenu;
        this.estatusMenu = estatusMenu;
        this.idSubmenu = idSubmenu;
        this.descripcionSubmenu = descripcionSubmenu;
        this.estatusSubmenu = estatusSubmenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public boolean isEstatusMenu() {
        return estatusMenu;
    }

    public void setEstatusMenu(boolean estatusMenu) {
        this.estatusMenu = estatusMenu;
    }

    public Integer getIdSubmenu() {
        return idSubmenu;
    }

    public void setIdSubmenu(Integer idSubmenu) {
        this.idSubmenu = idSubmenu;
    }

    public String getDescripcionSubmenu() {
        return descripcionSubmenu;
    }

    public void setDescripcionSubmenu(String descripcionSubmenu) {
        this.descripcionSubmenu = descripcionSubmenu;
    }

    public boolean isEstatusSubmenu() {
        return estatusSubmenu;
    }

    public void setEstatusSubmenu(boolean estatusSubmenu) {
        this.estatusSubmenu = estatusSubmenu;
    }

}
