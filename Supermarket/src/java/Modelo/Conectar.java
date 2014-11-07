/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.*;



public class Conectar {
         static Connection cnn;

    private Conectar() {
    }

    private static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/indicadores", "root", ""); 
        } catch (SQLException e) {  
          System.out.println("Error de MySQL: " + e.getMessage()); 
        }  catch (Exception e) {
          System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public static Connection getInstace() {
        if (cnn == null) {
            conectar();
        }
        return cnn;
    }

   
    
}
    


