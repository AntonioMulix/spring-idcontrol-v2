package com.id.control.dto;

import com.id.control.entity.Rol;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author marco-romero
 */
public class UsuarioGuardarDTO {

    private String loginEmail;
    private String loginTelefono;
    private String username;
    private LocalDateTime fechaRegistro;
    private Integer estatusUsuario;
    private Long trabajadorId;

    private Set<Rol> roles = new HashSet<>();

    private String password;

    public UsuarioGuardarDTO() {
    }

    public UsuarioGuardarDTO(String loginEmail, String loginTelefono, String username, LocalDateTime fechaRegistro, Integer estatusUsuario, Long trabajadorId) {
        this.loginEmail = loginEmail;
        this.loginTelefono = loginTelefono;
        this.username = username;
        this.fechaRegistro = fechaRegistro;
        this.estatusUsuario = estatusUsuario;
        this.trabajadorId = trabajadorId;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginTelefono() {
        return loginTelefono;
    }

    public void setLoginTelefono(String loginTelefono) {
        this.loginTelefono = loginTelefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(Integer estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }

    public Long getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(Long trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
