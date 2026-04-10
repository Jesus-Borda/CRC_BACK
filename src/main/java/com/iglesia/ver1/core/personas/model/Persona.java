package com.iglesia.ver1.core.personas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "personas")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fecha_nacimiento;
    private String genero;
    private LocalDate fecha_registro;
    private String estado;
    private Boolean escuela_formacion;
    private String cedula;

    public Persona() {
    }

    public Persona(Integer id_persona, String nombres, String apellidos, String telefono, String email, String direccion, LocalDate fecha_nacimiento, String genero, LocalDate fecha_registro, String estado, Boolean escuela_formacion, String cedula) {
        this.id_persona = id_persona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
        this.escuela_formacion = escuela_formacion;
        this.cedula = cedula;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getEscuela_formacion() {
        return escuela_formacion;
    }

    public void setEscuela_formacion(Boolean escuela_formacion) {
        this.escuela_formacion = escuela_formacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id_persona=" + id_persona +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", genero='" + genero + '\'' +
                ", fecha_registro=" + fecha_registro +
                ", estado='" + estado + '\'' +
                ", escuela_formacion=" + escuela_formacion +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
