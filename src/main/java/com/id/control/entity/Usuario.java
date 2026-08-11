package com.id.control.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author marco-romero
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "login_email")
    private String loginEmail;
    @Column(name = "login_telefono")
    private String loginTelefono;
    @Column(name = "username")
    private String username;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_estatus_usuario_id")
    private CatEstatusUsuario catEstatusUsuario;
    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String loginEmail, String loginTelefono, String username, LocalDateTime fechaRegistro, CatEstatusUsuario catEstatusUsuario, Trabajador trabajador, Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.loginEmail = loginEmail;
        this.loginTelefono = loginTelefono;
        this.username = username;
        this.fechaRegistro = fechaRegistro;
        this.catEstatusUsuario = catEstatusUsuario;
        this.trabajador = trabajador;
        this.roles = roles;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

    public CatEstatusUsuario getCatEstatusUsuario() {
        return catEstatusUsuario;
    }

    public void setCatEstatusUsuario(CatEstatusUsuario catEstatusUsuario) {
        this.catEstatusUsuario = catEstatusUsuario;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
