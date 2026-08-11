package com.id.control.dto;

/**
 *
 * @author marco-romero
 */
public class PersonaDTO {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer catGeneroId;
    private String domicilio;
    private String email;
    private String telefono;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String primerApellido, String segundoApellido, Integer catGeneroId, String domicilio, String email, String telefono) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.catGeneroId = catGeneroId;
        this.domicilio = domicilio;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getCatGeneroId() {
        return catGeneroId;
    }

    public void setCatGeneroId(Integer catGeneroId) {
        this.catGeneroId = catGeneroId;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
