/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pms.dto;

import java.io.Serializable;

public class Citas implements Serializable {
    private static final long serialVersionUID = 1L;
 
   private String hora ;
    private Integer id;
    private Usuarios psicologo;
    private Usuarios estudiante;
private String estado; 
    private String fecha;
 
    private String observacion;

    public Citas() {
    }

    public Citas(Integer id) {
        this.id = id;
    }

    public Citas(Integer id, String fecha, String observacion) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pms.dto.Citas[ id=" + id + " ]";
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Usuarios getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Usuarios psicologo) {
        this.psicologo = psicologo;
    }

    public Usuarios getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuarios estudiante) {
        this.estudiante = estudiante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
