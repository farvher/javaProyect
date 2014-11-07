/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CuserDAO extends Cusuario {

    PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CuserDAO> arreglousuarios = new ArrayList<CuserDAO>();

    public CuserDAO login(long cedula, String Clave) {
        CuserDAO objlogin = new CuserDAO();
        Connection cnn = Conectar.getInstace();
        System.out.print("login");
        try {
            stmt = cnn.prepareStatement("select * from usuario where cedula=? AND clave=?");
            stmt.setLong(1, cedula);
            stmt.setString(2, Clave);
            Rs = stmt.executeQuery();

            System.out.println(stmt);

            if (Rs.next()) {
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setNombre(Rs.getString("nombre"));
                objlogin.setApellido(Rs.getString("apellido"));
                objlogin.setSexo(Rs.getString("sexo"));
                objlogin.setEmail(Rs.getString("email"));
                objlogin.setTelefono(Rs.getString("telefono"));

                objlogin.setRol(Rs.getString("rol"));

                objlogin.setClave(Rs.getString("clave"));
            } else {
                objlogin.setCedula(0);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            objlogin.setNombre(ex.getMessage());

        }
        return objlogin;
    }

    public ArrayList<CuserDAO> lISTAR() {
        CuserDAO objlogi = new CuserDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from usuario ");

            Rs = stmt.executeQuery();

            System.out.println(stmt);

            while (Rs.next()) {
                CuserDAO objlogin = new CuserDAO();
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setNombre(Rs.getString("nombre"));
                objlogin.setApellido(Rs.getString("apellido"));
                objlogin.setSexo(Rs.getString("sexo"));
                objlogin.setEmail(Rs.getString("email"));
                objlogin.setTelefono(Rs.getString("telefono"));

                objlogin.setRol(Rs.getString("rol"));

                objlogin.setClave(Rs.getString("clave"));

                arreglousuarios.add(objlogin);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            arreglousuarios.add(objlogi);

        }
        return arreglousuarios;
    }

    public String Ingresaruser(CuserDAO Usu) {
        String respuesta = "";

        try {
            stmt = cnn.prepareStatement("INSERT INTO usuario values (?,?,?,?,?,?,?,?) ");
            stmt.setLong(1, Usu.getCedula());
            stmt.setString(2, Usu.getNombre());
            stmt.setString(3, Usu.getApellido());
            stmt.setString(4, Usu.getSexo());
            stmt.setString(5, Usu.getEmail());
            stmt.setString(6, Usu.getTelefono());


            stmt.setString(7, Usu.getRol());
            stmt.setString(8, Usu.getClave());



            System.out.println(stmt);


            int result = stmt.executeUpdate();
            if (result != 0) {
                respuesta = "si";
            } else {
                respuesta = "Falló";
            }

        } catch (SQLException ex) {
            respuesta = ex.getMessage();

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return respuesta;
    }

    public String eliminar(long doc) {
        Connection cnn = Conectar.getInstace();
        String resultado = "";
        try {
            stmt = cnn.prepareStatement("delete from usuario where cedula=?");

            stmt.setLong(1, doc);
            System.out.println(stmt);
            int result = stmt.executeUpdate();

            if (result != 0) {
                resultado = "elimino";
            } else {
                resultado = "Falló";
            }


        } catch (SQLException ex) {
            resultado = ex.getMessage();

        }
        return resultado;
    }

    public ArrayList<CuserDAO> buscar(int doc) {
        CuserDAO objlogi = new CuserDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from usuario where cedula=?");
            stmt.setInt(1, doc);
            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CuserDAO objlogin = new CuserDAO();
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setNombre(Rs.getString("nombre"));
                objlogin.setApellido(Rs.getString("apellido"));
                objlogin.setSexo(Rs.getString("sexo"));
                objlogin.setEmail(Rs.getString("email"));
                objlogin.setTelefono(Rs.getString("telefono"));

                objlogin.setRol(Rs.getString("roll"));

                objlogin.setClave(Rs.getString("clave"));

                arreglousuarios.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setNombre(ex.getMessage());

        }
        return arreglousuarios;
    }

    public CuserDAO escogerxid(Long documento) {
        CuserDAO objlogi = new CuserDAO();
        Connection cnn = Conectar.getInstace();
        CuserDAO objlogin = new CuserDAO();

        try {
            stmt = cnn.prepareStatement("select * from usuario where cedula=? ");
            stmt.setLong(1, documento);
            Rs = stmt.executeQuery();



            if (Rs.next()) {

                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setNombre(Rs.getString("nombre"));
                objlogin.setApellido(Rs.getString("apellido"));
                objlogin.setSexo(Rs.getString("sexo"));
                objlogin.setEmail(Rs.getString("email"));
                objlogin.setTelefono(Rs.getString("telefono"));

                objlogin.setRol(Rs.getString("rol"));

                objlogin.setClave(Rs.getString("clave"));

            }


        } catch (SQLException ex) {
            objlogin.setNombre(ex.getMessage());

        }
        return objlogin;
    }

    public void HABILITAR(CuserDAO objdao) {
        
        String estado=objdao.getRol();
        estado=estado.equals("cajero")?"Inactivo":"cajero";

        try {
            stmt = cnn.prepareStatement("Update usuario set rol=? where cedula=?");
            stmt.setString(1, estado);
            stmt.setLong(2, objdao.getCedula());
            int as = stmt.executeUpdate();

            System.out.println(stmt);

            
          


        } catch (SQLException ex) {
            
System.out.println(ex.getMessage());
        }
      

    }
}
