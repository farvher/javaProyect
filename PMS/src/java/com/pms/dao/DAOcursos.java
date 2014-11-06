/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dao;

import com.pms.dto.Cursos;
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
public class DAOcursos extends Cursos {

    private static Conectar cnn;
    private static PreparedStatement pst;
    private static ResultSet rs;

    public static ArrayList<DAOusuario> getEstudiantesDelProfesor(int idprofesor) {
        ArrayList<DAOusuario> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select\n"
                    + "u.id userid\n"
                    + " from usuarios u\n"
                    + "left join curso_estudiante ce on ce.idestudiante = u.id\n"
                    + "left join cursos c on c.id = ce.idcurso\n"
                    + "where c.idprofesor=" + idprofesor + " ";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOusuario temp = DAOusuario.getUsuario(rs.getInt("userid"));
                lista.add(temp);

            }
        } catch (Exception e) {


            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static ArrayList<DAOusuario> getEstudiantes() {
        ArrayList<DAOusuario> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from usuarios where rol ='3'  ";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOusuario temp = DAOusuario.getUsuario(rs.getInt("id"));
                lista.add(temp);

            }
        } catch (Exception e) {


            System.out.println(e.getMessage());
        }
        return lista;
    }
    public static ArrayList<DAOusuario> getUsuariostodos() {
        ArrayList<DAOusuario> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from usuarios   ";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOusuario temp = DAOusuario.getUsuario(rs.getInt("id"));
                lista.add(temp);

            }
        } catch (Exception e) {


            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static ArrayList<DAOusuario> getEstudiantesDelCurso(int idcurso) {
        ArrayList<DAOusuario> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select\n"
                    + "u.id userid\n"
                    + " from usuarios u\n"
                    + "left join curso_estudiante ce on ce.idestudiante = u.id\n"
                    + "left join cursos c on c.id = ce.idcurso\n"
                    + "where c.id=" + idcurso + " ";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOusuario temp = DAOusuario.getUsuario(rs.getInt("userid"));
                lista.add(temp);

            }
        } catch (Exception e) {


            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static ArrayList<DAOcursos> getCursos() {
        ArrayList<DAOcursos> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select * from cursos";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOcursos temp = new DAOcursos();
                temp.setCurso(rs.getString("curso"));
                temp.setId(rs.getInt("id"));
                temp.setDescripcion(rs.getString("descripcion"));
                temp.setUsuarios(DAOusuario.getUsuario(rs.getInt("idprofesor")));
                lista.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static ArrayList<DAOcursos> getCursosdelEstudiante(int id) {
        ArrayList<DAOcursos> lista = new ArrayList();

        try {
            ResultSet rs = null;
            String consulta = "select c.* from cursos c\n"
                    + "left join curso_estudiante  ce on c.id=ce.idcurso\n"
                    + "where ce.idestudiante = '" + id + "'";

            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                DAOcursos temp = new DAOcursos();
                temp.setCurso(rs.getString("curso"));
                temp.setId(rs.getInt("id"));
                temp.setDescripcion(rs.getString("descripcion"));
                temp.setUsuarios(DAOusuario.getUsuario(rs.getInt("idprofesor")));
                lista.add(temp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public static DAOcursos getCursos(int id) {
        DAOcursos temp = new DAOcursos();
        try {
            ResultSet rs = null;
            String consulta = "select * from cursos where id = '" + id + "' ";
            rs = cnn.Consultar(consulta);
            System.out.println(consulta);
            while (rs.next()) {
                temp.setCurso(rs.getString("curso"));
                temp.setId(rs.getInt("id"));
                temp.setDescripcion(rs.getString("descripcion"));
                temp.setUsuarios(DAOusuario.getUsuario(rs.getInt("idprofesor")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}
