/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.dto.Estado;
import com.pms.dto.Novedades;
import com.pms.dto.TipoNovedad;
import com.pms.dto.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Farith S
 */
public class DAOnovedades extends Novedades {

    private static Conectar cnn;
    private static PreparedStatement pst;

    public static ArrayList<DAOnovedades> getNovedades() {
        ArrayList<DAOnovedades> listaNovedades = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from novedades";

            rs = cnn.Consultar(consulta);
            while (rs.next()) {
                DAOnovedades temp = new DAOnovedades();
                Estado esta = new Estado();
                Usuarios estu = DAOusuario.getUsuario(rs.getInt("idestudiante"));
                Usuarios profe = DAOusuario.getUsuario(rs.getInt("idprofesor"));
                TipoNovedad tipoNo = DAOnovedades.getTiposNovedades(rs.getInt("i_tipo_novedad"));

                temp.setId(rs.getInt("id"));
                temp.setEstado(rs.getInt("estado"));
                temp.setFecha(rs.getString("fecha"));
                temp.setProfesor(profe);
                temp.setObservacion(rs.getString("observacion"));
                temp.setEstudiante(estu);
                temp.setTipoNovedad(tipoNo);
                listaNovedades.add(temp);

            }
        } catch (Exception e) {
            Novedades temp = new Novedades();
            temp.setObservacion(e.getMessage());

            System.out.println(e.getMessage());
        }
        return listaNovedades;
    }
    public static ArrayList<DAOnovedades> getNovedadesEstado(String estado) {
        ArrayList<DAOnovedades> listaNovedades = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from novedades where estado='"+estado+"'";

            rs = cnn.Consultar(consulta);
            while (rs.next()) {
                DAOnovedades temp = new DAOnovedades();
                Estado esta = new Estado();
                Usuarios estu = DAOusuario.getUsuario(rs.getInt("idestudiante"));
                Usuarios profe = DAOusuario.getUsuario(rs.getInt("idprofesor"));
                TipoNovedad tipoNo = DAOnovedades.getTiposNovedades(rs.getInt("i_tipo_novedad"));

                temp.setId(rs.getInt("id"));
                temp.setEstado(rs.getInt("estado"));
                temp.setFecha(rs.getString("fecha"));
                temp.setProfesor(profe);
                temp.setObservacion(rs.getString("observacion"));
                temp.setEstudiante(estu);
                temp.setTipoNovedad(tipoNo);
                listaNovedades.add(temp);

            }
        } catch (Exception e) {
            Novedades temp = new Novedades();
            temp.setObservacion(e.getMessage());

            System.out.println(e.getMessage());
        }
        return listaNovedades;
    }

    public static TipoNovedad getTiposNovedades(int id) {
        TipoNovedad temp = new TipoNovedad();
        try {
            ResultSet rs = null;
            String consulta = "select * from tipo_novedad where id='" + id + "'";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                temp.setId(rs.getInt("id"));
                temp.setGravedad(rs.getString("gravedad"));
                temp.setTipoNovedad(rs.getString("tipo_novedad"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static ArrayList<TipoNovedad> getTiposNovedades() {
        ArrayList<TipoNovedad> listatipos = new ArrayList();
        try {
            ResultSet rs = null;
            String consulta = "select * from tipo_novedad";
            rs = cnn.Consultar(consulta);
            while (rs.next()) {
                TipoNovedad temp = new TipoNovedad();
                temp.setId(rs.getInt("id"));
                temp.setGravedad(rs.getString("gravedad"));
                temp.setTipoNovedad(rs.getString("tipo_novedad"));
                listatipos.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listatipos;
    }

    public static String getEstadoN(int id) {

        switch (id) {

            case 1:
                return "azul";
            case 2:
                return "rojo";
            case 3:
                return "gris";
            case 4:
                return "rojo";
            case 5:
                return "verde";
            case 6:
                return "amarillo";
        }

        return "";

    }

    public static int ingresarNovedad(DAOnovedades N) {
        int res = 0;
        try {
            ResultSet rs = null;
            String consulta = "INSERT INTO `pms`.`novedades`\n"
                    + "(`idprofesor`,\n"
                    + "`idestudiante`,\n"
                    + "`fecha`,\n"
                    + "`observacion`,\n"
                    + "`estado`,\n"
                    + "`i_tipo_novedad`)\n"
                    + "VALUES\n"
                    + "('" + N.getProfesor().getId() + "',\n"
                    + "'" + N.getEstudiante().getId() + "',\n"
                    + "'" + N.getFecha() + "',\n"
                    + "'" + N.getObservacion() + "',\n"
                    + "'" + N.getEstado() + "',\n"
                    + "'" + N.getTipoNovedad().getId() + "');";
            res = cnn.insertar(consulta);
            System.out.println("INGRESARNOVEDAD::"+consulta);

        } catch (Exception e) {
            res = 0;
            System.out.println(e.getMessage());
        }
        return res;
    }
}
