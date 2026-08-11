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
@Table(name = "cat_genero")
public class CatGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cat_genero")
    private Integer idCatGenero;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estatus")
    private boolean estatus;

    public CatGenero() {
    }

    public CatGenero(Integer idCatGenero, String descripcion, boolean estatus) {
        this.idCatGenero = idCatGenero;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getIdCatGenero() {
        return idCatGenero;
    }

    public void setIdCatGenero(Integer idCatGenero) {
        this.idCatGenero = idCatGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
