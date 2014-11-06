/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import java.io.Serializable;

/**
 *
 * @author DiegoV
 */

public class TipoNovedad implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tipoNovedad;
    private String gravedad;

    public TipoNovedad() {
    }

    public TipoNovedad(Integer id) {
        this.id = id;
    }

    public TipoNovedad(Integer id, String tipoNovedad, String gravedad) {
        this.id = id;
        this.tipoNovedad = tipoNovedad;
        this.gravedad = gravedad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
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
        if (!(object instanceof TipoNovedad)) {
            return false;
        }
        TipoNovedad other = (TipoNovedad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pms.dto.TipoNovedad[ id=" + id + " ]";
    }
    
}
