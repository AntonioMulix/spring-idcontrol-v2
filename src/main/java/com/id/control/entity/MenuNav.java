package com.id.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "menu_nav")
public class MenuNav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_nav")
    private Integer idMenuNav;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estatus")
    private boolean estatus;

    public MenuNav() {
    }

    public MenuNav(Integer idMenuNav, String descripcion, boolean estatus) {
        this.idMenuNav = idMenuNav;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getIdMenuNav() {
        return idMenuNav;
    }

    public void setIdMenuNav(Integer idMenuNav) {
        this.idMenuNav = idMenuNav;
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
