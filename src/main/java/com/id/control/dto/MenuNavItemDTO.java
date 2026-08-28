package com.id.control.dto;

import java.util.List;

/**
 *
 * @author marco-romero
 */
public class MenuNavItemDTO {

    private Integer idMenu;
    private String descripcionMenu;
    private String urlMenu;
    private String iconMenu;
    private boolean estatusMenu;
    private Integer ordenMenu;
    private List<SubmenuNavDTO> submenus;

    public MenuNavItemDTO() {
    }

    public MenuNavItemDTO(Integer idMenu, String descripcionMenu, String urlMenu, String iconMenu, boolean estatusMenu, Integer ordenMenu, List<SubmenuNavDTO> submenus) {
        this.idMenu = idMenu;
        this.descripcionMenu = descripcionMenu;
        this.urlMenu = urlMenu;
        this.iconMenu = iconMenu;
        this.estatusMenu = estatusMenu;
        this.ordenMenu = ordenMenu;
        this.submenus = submenus;
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

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public String getIconMenu() {
        return iconMenu;
    }

    public void setIconMenu(String iconMenu) {
        this.iconMenu = iconMenu;
    }

    public boolean isEstatusMenu() {
        return estatusMenu;
    }

    public void setEstatusMenu(boolean estatusMenu) {
        this.estatusMenu = estatusMenu;
    }

    public Integer getOrdenMenu() {
        return ordenMenu;
    }

    public void setOrdenMenu(Integer ordenMenu) {
        this.ordenMenu = ordenMenu;
    }

    public List<SubmenuNavDTO> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<SubmenuNavDTO> submenus) {
        this.submenus = submenus;
    }

}
