package com.id.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "submenu_nav")
public class SubmenuNav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_submenu_nav")
    private Integer idSubmenuNav;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_nav_id")
    private MenuNav menuNav;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url")
    private String url;
    @Column(name = "icon")
    private String icon;
    @Column(name = "estatus")
    private boolean estatus;
    @Column(name = "orden")
    private Integer orden;

    public SubmenuNav() {
    }

    public SubmenuNav(Integer idSubmenuNav, MenuNav menuNav, String descripcion, String url, String icon, boolean estatus, Integer orden) {
        this.idSubmenuNav = idSubmenuNav;
        this.menuNav = menuNav;
        this.descripcion = descripcion;
        this.url = url;
        this.icon = icon;
        this.estatus = estatus;
        this.orden = orden;
    }

    public Integer getIdSubmenuNav() {
        return idSubmenuNav;
    }

    public void setIdSubmenuNav(Integer idSubmenuNav) {
        this.idSubmenuNav = idSubmenuNav;
    }

    public MenuNav getMenuNav() {
        return menuNav;
    }

    public void setMenuNav(MenuNav menuNav) {
        this.menuNav = menuNav;
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
