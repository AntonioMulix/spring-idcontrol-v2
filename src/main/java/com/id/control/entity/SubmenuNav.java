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
    @Column(name = "estatus")
    private boolean estatus;

    public SubmenuNav() {
    }

    public SubmenuNav(Integer idSubmenuNav, MenuNav menuNav, String descripcion, boolean estatus) {
        this.idSubmenuNav = idSubmenuNav;
        this.menuNav = menuNav;
        this.descripcion = descripcion;
        this.estatus = estatus;
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

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
