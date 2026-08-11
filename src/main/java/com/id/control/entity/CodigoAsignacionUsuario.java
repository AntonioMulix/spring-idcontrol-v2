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
import java.time.LocalDateTime;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "codigo_asignacion_usuario")
public class CodigoAsignacionUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_codigo_asignacion")
    private Long idCodigoAsignacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(name = "codigo_verificacion")
    private Integer codigoVerificacion;
    @Column(name = "codigo_utilizado")
    private boolean codigoUtilizado;
    @Column(name = "expired")
    private boolean expired;
    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    public CodigoAsignacionUsuario() {
    }

    public CodigoAsignacionUsuario(Long idCodigoAsignacion, Usuario usuario, Integer codigoVerificacion, boolean codigoUtilizado, boolean expired, LocalDateTime fechaExpiracion) {
        this.idCodigoAsignacion = idCodigoAsignacion;
        this.usuario = usuario;
        this.codigoVerificacion = codigoVerificacion;
        this.codigoUtilizado = codigoUtilizado;
        this.expired = expired;
        this.fechaExpiracion = fechaExpiracion;
    }

    public Long getIdCodigoAsignacion() {
        return idCodigoAsignacion;
    }

    public void setIdCodigoAsignacion(Long idCodigoAsignacion) {
        this.idCodigoAsignacion = idCodigoAsignacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(Integer codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public boolean isCodigoUtilizado() {
        return codigoUtilizado;
    }

    public void setCodigoUtilizado(boolean codigoUtilizado) {
        this.codigoUtilizado = codigoUtilizado;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

}
