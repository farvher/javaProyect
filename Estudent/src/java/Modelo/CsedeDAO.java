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

/**
 *
 * @author Aprendiz
 */
public class CsedeDAO extends Csede{
    
    
    PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CsedeDAO> arreglo = new ArrayList();
    
    
    
    public ArrayList<CsedeDAO> lISTAR() {
        CsedeDAO objlogi = new CsedeDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from sede ");

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CsedeDAO objlogin = new CsedeDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setSede(Rs.getString("sede"));
                objlogin.setDireccion(Rs.getString("direccion"));
                objlogin.setTelefono(Rs.getString("telefono"));
                objlogin.setLocalidad(Rs.getString("localidad"));
               

                arreglo.add(objlogin); 
            }


        } catch (SQLException ex) {
            objlogi.setSede(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
    
}
