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
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador")
    private Long idTrabajador;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @Column(name = "plaza_id")
    private Long plazaId;
    @Column(name = "num_empleado")
    private Long numEmpleado;
    @Column(name = "folio_empleado")
    private String folioEmpleado;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Trabajador() {
    }

    public Trabajador(Long idTrabajador, Persona persona, Long plazaId, Long numEmpleado, String folioEmpleado, LocalDateTime fechaRegistro) {
        this.idTrabajador = idTrabajador;
        this.persona = persona;
        this.plazaId = plazaId;
        this.numEmpleado = numEmpleado;
        this.folioEmpleado = folioEmpleado;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getPlazaId() {
        return plazaId;
    }

    public void setPlazaId(Long plazaId) {
        this.plazaId = plazaId;
    }

    public Long getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Long numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getFolioEmpleado() {
        return folioEmpleado;
    }

    public void setFolioEmpleado(String folioEmpleado) {
        this.folioEmpleado = folioEmpleado;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
