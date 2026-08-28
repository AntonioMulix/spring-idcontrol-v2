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
@Table(name = "menu_rol")
public class MenuRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_rol")
    private Integer idMenuRol;
    @Column(name = "submenu_id")
    private Integer submenuId;
    @Column(name = "rol_id")
    private Integer rolId;

    public MenuRoles(Integer idMenuRol, Integer submenuId, Integer rolId) {
        this.idMenuRol = idMenuRol;
        this.submenuId = submenuId;
        this.rolId = rolId;
    }

    public Integer getIdMenuRol() {
        return idMenuRol;
    }

    public void setIdMenuRol(Integer idMenuRol) {
        this.idMenuRol = idMenuRol;
    }

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

}
