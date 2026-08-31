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
@Table(name = "menu_rol")
public class MenuRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_rol")
    private Integer idMenuRol;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "submenu_id")
    @Column(name = "submenu_id")
    private Integer submenu;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "rol_id")
    @Column(name = "rol_id")
    private Integer rolId;

    public MenuRol(Integer idMenuRol, Integer submenu, Integer rolId) {
        this.idMenuRol = idMenuRol;
        this.submenu = submenu;
        this.rolId = rolId;
    }

    public Integer getIdMenuRol() {
        return idMenuRol;
    }

    public void setIdMenuRol(Integer idMenuRol) {
        this.idMenuRol = idMenuRol;
    }

    public Integer getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Integer submenu) {
        this.submenu = submenu;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

}
