/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.dto.Citas;
import com.pms.dto.Estado;
import com.pms.dto.Novedades;
import com.pms.dto.TipoNovedad;
import com.pms.dto.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DiegoV
 */
public class DAOcitas extends Citas {

    private static Conectar cnn;
    private static PreparedStatement pst;

    public static ArrayList<DAOcitas> getCitas() {
        ArrayList<DAOcitas> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from citas order by fecha desc";

            rs = cnn.Consultar(consulta);
            while (rs.next()) {
                DAOcitas temp = new DAOcitas();
                DAOusuario psi = DAOusuario.getUsuario(rs.getInt("idpsicologo"));
                DAOusuario estu = DAOusuario.getUsuario(rs.getInt("idpaciente"));
                temp.setFecha(rs.getString("fecha"));
                temp.setId(rs.getInt("id"));
                temp.setObservacion(rs.getString("observacion"));
                temp.setHora(rs.getString("hora"));
                temp.setEstudiante(estu);
                temp.setPsicologo(psi);
                lista.add(temp);


            }
        } catch (Exception e) {
            Novedades temp = new Novedades();
            temp.setObservacion(e.getMessage());

            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static int ingresarCita(DAOcitas c) {
        int res = 0;
        ResultSet rs;
        try {
            String sentencia = "INSERT INTO `pms`.`citas`\n"
                    + "(`idpaciente`,\n"
                    + "`idpsicologo`,\n"
                    + "`fecha`,\n"
                    + "`observacion`,\n"
                    + "`estado`,\n"
                    + "`hora`)\n"
                    + "VALUES\n"
                    + "('" + c.getEstudiante().getId() + "',\n"
                    + "'" + c.getPsicologo().getId() + "',\n"
                    + "'" + c.getFecha() + "',\n"
                    + "'" + c.getObservacion() + "',\n"
                    + "'" + c.getEstado() + "',\n"
                    + "'" + c.getHora() + "');";
            res = cnn.insertar(sentencia);
            System.out.println(sentencia);
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return res;
    }
}
