/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Farith S
 */
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String documento;
    private String nombres;
    private String apellidos;
    private String nacimiento;
    private int edad;
    private String direccion;
    private String telefono;
    private String correo;
    private String clave;
    private String ciudad;
    private String barrio;
    private String fechacreacion;
    private Collection<Cursos> cursosCollection;
    private Collection<Familiares> familiaresCollection;
    private Collection<Familiares> familiaresCollection1;
    private Cursos curso;
    private Collection<Novedades> novedadesCollection;
    private Collection<Novedades> novedadesCollection1;
    private Estado estado;
    private Genero genero;
    private Rol rol;

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }
    private Collection<CursoEstudiante> cursoEstudianteCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String documento, String nombres, String apellidos, String nacimiento, int edad, String clave) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    public Collection<Familiares> getFamiliaresCollection() {
        return familiaresCollection;
    }

    public void setFamiliaresCollection(Collection<Familiares> familiaresCollection) {
        this.familiaresCollection = familiaresCollection;
    }

    public Collection<Familiares> getFamiliaresCollection1() {
        return familiaresCollection1;
    }

    public void setFamiliaresCollection1(Collection<Familiares> familiaresCollection1) {
        this.familiaresCollection1 = familiaresCollection1;
    }

    public Collection<Novedades> getNovedadesCollection() {
        return novedadesCollection;
    }

    public void setNovedadesCollection(Collection<Novedades> novedadesCollection) {
        this.novedadesCollection = novedadesCollection;
    }

    public Collection<Novedades> getNovedadesCollection1() {
        return novedadesCollection1;
    }

    public void setNovedadesCollection1(Collection<Novedades> novedadesCollection1) {
        this.novedadesCollection1 = novedadesCollection1;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Collection<CursoEstudiante> getCursoEstudianteCollection() {
        return cursoEstudianteCollection;
    }

    public void setCursoEstudianteCollection(Collection<CursoEstudiante> cursoEstudianteCollection) {
        this.cursoEstudianteCollection = cursoEstudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pms.dto.Usuarios[ id=" + id + " ]";
    }
}
