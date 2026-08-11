package com.id.control.security.service;

import com.id.control.entity.UsuarioSeguridad;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author marco-romero
 */
public class UsuarioPrincipal implements UserDetails {

    private Long idUsuario;
    private String username;
    private String loginEmail;
    private String telefonoEmail;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(Long idUsuario, String username, String loginEmail, String telefonoEmail, String password, Collection<? extends GrantedAuthority> authorities) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.loginEmail = loginEmail;
        this.telefonoEmail = telefonoEmail;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(UsuarioSeguridad usuario) {
        List<GrantedAuthority> authorities
                = usuario.getUsuario().getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getName().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getUsuario().getIdUsuario(), usuario.getUsuario().getUsername(), usuario.getUsuario().getLoginEmail(), usuario.getUsuario().getLoginTelefono(), usuario.getPassword(), authorities);
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getTelefonoEmail() {
        return telefonoEmail;
    }

    public void setTelefonoEmail(String telefonoEmail) {
        this.telefonoEmail = telefonoEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
