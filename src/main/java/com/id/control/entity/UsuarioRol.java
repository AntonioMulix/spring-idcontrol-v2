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
@Table(name = "usuarios_roles")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol")
    private Long idUsuarioRol;
    @Column(name = "usuario_id")
    private Long usuarioId;
    @Column(name = "rol_id")
    private Integer rolId;

    public UsuarioRol() {
    }

    public UsuarioRol(Long idUsuarioRol, Long usuarioId, Integer rolId) {
        this.idUsuarioRol = idUsuarioRol;
        this.usuarioId = usuarioId;
        this.rolId = rolId;
    }

    public Long getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(Long idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

}
