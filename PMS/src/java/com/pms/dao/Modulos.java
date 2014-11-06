/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.dto.Rol;

/**
 *
 * @author Farith S
 */
public class Modulos {

    private String ruta;
    private String idrol;
    private String rol;
    //historia
    private boolean addhistoria;
    private boolean deletehistoria;
    private boolean edithistoria;
    private boolean readhistoria;
    //citas
    private boolean addcitas;
    private boolean delecitas;
    private boolean editcitas;
    private boolean readcitas;
    //novedades
    private boolean addnovedades;
    private boolean delenovedades;
    private boolean editnovedades;
    private boolean readnovedades;
    private boolean admin;
    private boolean psico;
    private boolean profe;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public static Modulos Permisos(Rol rol) {
        // 1 admin 
        // 2 psico
        // 3 estud
        // 4 usuario
        // 5 profesor 
        // 6 familiar
        Modulos modulo = new Modulos();
        switch (rol.getId()) {
            case 1:
                modulo.setProfe(true);
                modulo.setPsico(true);
                modulo.setAdmin(true);
                break;
            case 2:
                modulo.setProfe(false);
                modulo.setPsico(true);
                modulo.setAdmin(false);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                modulo.setProfe(true);
                modulo.setPsico(false);
                modulo.setAdmin(false);

                break;
            case 6:
                break;

        }

        return modulo;


    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isAddhistoria() {
        return addhistoria;
    }

    public void setAddhistoria(boolean addhistoria) {
        this.addhistoria = addhistoria;
    }

    public boolean isDeletehistoria() {
        return deletehistoria;
    }

    public void setDeletehistoria(boolean deletehistoria) {
        this.deletehistoria = deletehistoria;
    }

    public boolean isEdithistoria() {
        return edithistoria;
    }

    public void setEdithistoria(boolean edithistoria) {
        this.edithistoria = edithistoria;
    }

    public boolean isReadhistoria() {
        return readhistoria;
    }

    public void setReadhistoria(boolean readhistoria) {
        this.readhistoria = readhistoria;
    }

    public boolean isAddcitas() {
        return addcitas;
    }

    public void setAddcitas(boolean addcitas) {
        this.addcitas = addcitas;
    }

    public boolean isDelecitas() {
        return delecitas;
    }

    public void setDelecitas(boolean delecitas) {
        this.delecitas = delecitas;
    }

    public boolean isEditcitas() {
        return editcitas;
    }

    public void setEditcitas(boolean editcitas) {
        this.editcitas = editcitas;
    }

    public boolean isReadcitas() {
        return readcitas;
    }

    public void setReadcitas(boolean readcitas) {
        this.readcitas = readcitas;
    }

    public boolean isAddnovedades() {
        return addnovedades;
    }

    public void setAddnovedades(boolean addnovedades) {
        this.addnovedades = addnovedades;
    }

    public boolean isDelenovedades() {
        return delenovedades;
    }

    public void setDelenovedades(boolean delenovedades) {
        this.delenovedades = delenovedades;
    }

    public boolean isEditnovedades() {
        return editnovedades;
    }

    public void setEditnovedades(boolean editnovedades) {
        this.editnovedades = editnovedades;
    }

    public boolean isReadnovedades() {
        return readnovedades;
    }

    public void setReadnovedades(boolean readnovedades) {
        this.readnovedades = readnovedades;
    }

    public Modulos() {
        this.setAddcitas(false);
        this.setAddhistoria(false);
        this.setAddnovedades(false);
        this.setReadcitas(false);
        this.setReadhistoria(false);
        this.setReadnovedades(false);
        this.setEditcitas(false);
        this.setEdithistoria(false);
        this.setEditnovedades(false);
        this.setDelecitas(false);
        this.setDelenovedades(false);
        this.setDeletehistoria(false);
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isPsico() {
        return psico;
    }

    public void setPsico(boolean psico) {
        this.psico = psico;
    }

    public boolean isProfe() {
        return profe;
    }

    public void setProfe(boolean profe) {
        this.profe = profe;
    }
}
