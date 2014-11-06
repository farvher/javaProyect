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

public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private Integer id;
   
    private String genero;
   
    private Collection<Usuarios> usuariosCollection;

    public Genero() {
    }

    public Genero(Integer id) {
        this.id = id;
    }

    public Genero(Integer id, String genero) {
        this.id = id;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
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
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pms.dto.Genero[ id=" + id + " ]";
    }
    
}
