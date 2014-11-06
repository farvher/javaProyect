/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.dto.Genero;
import com.pms.dto.Rol;
import com.pms.dto.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Farith S
 */
public class DAOusuario extends Usuarios {

    static Conectar cnn;
    static PreparedStatement pst;
   
    ArrayList<DAOusuario> listausuarios = new ArrayList();

    public boolean login(DAOusuario user) {
        cnn.getInstace();
        ResultSet rs ;
        try {
            String consulta = "select * from usuarios where documento ='" + user.getDocumento() + "' and clave='" + user.getClave() + "' ";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.print("error:" + e.getMessage());
        }
        return false;
    }

    public static DAOusuario getUsuario(String documento) {
        cnn.getInstace();
        DAOusuario user = new DAOusuario();
        ResultSet rs;
        try {
            String consulta = "select * from usuarios where documento ='" + documento + "' ";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                user.setApellidos(rs.getString("apellidos"));
                user.setBarrio(rs.getString("barrio"));
                user.setCiudad(rs.getString("ciudad"));
                user.setClave(rs.getString("clave"));
                user.setCorreo(rs.getString("correo"));
                user.setDireccion(rs.getString("direccion"));
                user.setDocumento(rs.getString("documento"));
                user.setEdad(rs.getInt("edad"));
                user.setFechacreacion(rs.getString("fechacreacion"));

                user.setId(rs.getInt("id"));
                user.setNacimiento(rs.getString("nacimiento"));
                user.setNombres(rs.getString("nombres"));

                user.setTelefono(rs.getString("telefono"));
                Rol rol = new Rol();
                rol = getRol(rs.getInt("rol"));
                user.setRol(rol);
                Genero g = new Genero(1);
                g = getGenero(rs.getInt("genero"));
                user.setGenero(g);

            }
        } catch (Exception e) {
            user = new DAOusuario();
            System.out.print("error:" + e.getMessage());
        }
        return user;
    }

    public static DAOusuario getUsuario(int id) {
        cnn.getInstace();
        DAOusuario user = new DAOusuario();
        ResultSet rs ;
        try {
            String consulta = "select * from usuarios where id ='" + id + "' ";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {

                user.setApellidos(rs.getString("apellidos"));
                user.setBarrio(rs.getString("barrio"));
                user.setCiudad(rs.getString("ciudad"));
                user.setClave(rs.getString("clave"));
                user.setCorreo(rs.getString("correo"));
                user.setDireccion(rs.getString("direccion"));
                user.setDocumento(rs.getString("documento"));
                user.setEdad(rs.getInt("edad"));
                user.setFechacreacion(rs.getString("fechacreacion"));

                user.setId(rs.getInt("id"));
                user.setNacimiento(rs.getString("nacimiento"));
                user.setNombres(rs.getString("nombres"));
                user.setTelefono(rs.getString("telefono"));
                Rol rol = new Rol();
                rol = getRol(rs.getInt("rol"));
                user.setRol(rol);
                Genero g = new Genero(1);
                g = getGenero(rs.getInt("genero"));
                user.setGenero(g);
            }
        } catch (Exception e) {
            user = new DAOusuario();
            user.setNombres(e.getMessage());
            System.out.print("error:" + e.getMessage());
        }
        return user;
    }

    public static Rol getRol(int id) {
        cnn.getInstace();
        Rol rol = new Rol();
        ResultSet rs ;
        try {
            String consulta = "select * from rol where id ='" + id + "' ";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                rol.setId(rs.getInt("id"));
                rol.setRol(rs.getString("rol"));

            }
        } catch (Exception e) {
            System.out.print("error:" + e.getMessage());
            rol.setRol(e.getMessage());
        }
        return rol;
    }

    public static Genero getGenero(int id) {
        cnn.getInstace();
        Genero g = new Genero();
        ResultSet rs;
        try {
            String consulta = "select g.id,g.genero gene from genero g where id ='" + id + "' ";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                g.setId(rs.getInt("id"));
                g.setGenero(rs.getString("gene"));

            }
        } catch (Exception e) {
            System.out.print("error:" + e.getMessage());

        }
        return g;
    }

    public int IngresarUser(DAOusuario user) {
        int res = 0;
        cnn.getInstace();
        try {
            String query = "insert into usuarios"
                    + "(\n"
                    + "`documento`,\n"
                    + "`nombres`,\n"
                    + "`apellidos`,\n"
                    + "`nacimiento`,\n"
                    + "`edad`,\n"
                    + "`rol`,\n"
                    + "`genero`,\n"
                    + "`estado`,\n"
                    + "`direccion`,\n"
                    + "`telefono`,\n"
                    + "`correo`,\n"
                    + "`clave`,\n"
                    + "`ciudad`,\n"
                    + "`barrio`,\n"
                    + "`fechacreacion`)"
                    + " values ("
                    + "'" + user.getDocumento() + "'"
                    + ",'" + user.getNombres() + "'"
                    + ",'" + user.getApellidos() + "'"
                    + ",'" + user.getNacimiento() + "'"
                    + "," + user.getEdad() + ""
                    + "," + user.getRol().getId() + ""
                    + "," + user.getGenero().getId() + ""
                    + "," + user.getEstado() + ""
                    + ",'" + user.getDireccion() + "'"
                    + ",'" + user.getTelefono() + "'"
                    + ",'" + user.getCorreo() + "'"
                    + ",'" + user.getClave() + "'"
                    + ",'" + user.getCiudad() + "'"
                    + ",'" + user.getBarrio() + "'"
                    + ",'" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "'"
                    + ")";
            System.out.println(query);
            res = cnn.insertar(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return res;
    }

    public static boolean ExisteUsuario(String user) {
        cnn.getInstace();
        ResultSet rs ;
        try {
            String consulta = "select * from usuarios where documento = '" + user + "' or correo='" + user + "'";
            rs = cnn.Consultar(consulta);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

            System.out.print("error:" + e.getMessage());
        }
        return false;
    }
}
