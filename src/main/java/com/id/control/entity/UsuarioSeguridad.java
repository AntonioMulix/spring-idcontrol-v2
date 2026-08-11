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
@Table(name = "usuario_seguridad")
public class UsuarioSeguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_seguridad")
    private Long idUsuarioSeguridad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "tel_confirmado")
    private boolean telConfirmado;
    @Column(name = "email_confirmado")
    private boolean emailConfirmado;
    @Column(name = "ultimo_cambio_pwd")
    private LocalDateTime ultimoCambioPWD;
    @Column(name = "intentos_fallidos")
    private Short intentosFallidos;
    @Column(name = "fecha_bloqueo")
    private LocalDateTime fechaBloqueo;

    public UsuarioSeguridad() {
    }

    public UsuarioSeguridad(Long idUsuarioSeguridad, Usuario usuario, String password, boolean telConfirmado, boolean emailConfirmado, LocalDateTime ultimoCambioPWD, Short intentosFallidos, LocalDateTime fechaBloqueo) {
        this.idUsuarioSeguridad = idUsuarioSeguridad;
        this.usuario = usuario;
        this.password = password;
        this.telConfirmado = telConfirmado;
        this.emailConfirmado = emailConfirmado;
        this.ultimoCambioPWD = ultimoCambioPWD;
        this.intentosFallidos = intentosFallidos;
        this.fechaBloqueo = fechaBloqueo;
    }

    public Long getIdUsuarioSeguridad() {
        return idUsuarioSeguridad;
    }

    public void setIdUsuarioSeguridad(Long idUsuarioSeguridad) {
        this.idUsuarioSeguridad = idUsuarioSeguridad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTelConfirmado() {
        return telConfirmado;
    }

    public void setTelConfirmado(boolean telConfirmado) {
        this.telConfirmado = telConfirmado;
    }

    public boolean isEmailConfirmado() {
        return emailConfirmado;
    }

    public void setEmailConfirmado(boolean emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    public LocalDateTime getUltimoCambioPWD() {
        return ultimoCambioPWD;
    }

    public void setUltimoCambioPWD(LocalDateTime ultimoCambioPWD) {
        this.ultimoCambioPWD = ultimoCambioPWD;
    }

    public Short getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(Short intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public LocalDateTime getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(LocalDateTime fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

}
