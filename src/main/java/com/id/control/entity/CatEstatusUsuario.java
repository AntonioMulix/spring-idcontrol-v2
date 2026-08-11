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
@Table(name = "cat_estatus_usuario")
public class CatEstatusUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cat_estatus_usuario")
    private Integer idCatEstatusUsuario;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estatus")
    private boolean estatus;

    public CatEstatusUsuario() {
    }

    public CatEstatusUsuario(Integer idCatEstatusUsuario, String descripcion, boolean estatus) {
        this.idCatEstatusUsuario = idCatEstatusUsuario;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getIdCatEstatusUsuario() {
        return idCatEstatusUsuario;
    }

    public void setIdCatEstatusUsuario(Integer idCatEstatusUsuario) {
        this.idCatEstatusUsuario = idCatEstatusUsuario;
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
