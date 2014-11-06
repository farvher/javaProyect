/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import java.io.Serializable;



public class Novedades implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer id;
  
    private String fecha;

    private String observacion;
 
    private int estado;
 
    private Usuarios estudiante;

    private Usuarios profesor;
  
    private TipoNovedad tipoNovedad;

    public Novedades() {
    }

    public Novedades(Integer id) {
        this.id = id;
    }

    public Novedades(Integer id, String fecha, String observacion, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estado = estado;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuarios getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuarios usuarios) {
        this.profesor = usuarios;
    }

    public Usuarios getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuarios usuarios1) {
        this.estudiante = usuarios1;
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
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pms.dto.Novedades[ id=" + id + " ]";
    }
      public TipoNovedad getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(TipoNovedad tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }
    
    
}
