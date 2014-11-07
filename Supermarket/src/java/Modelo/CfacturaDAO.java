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


public class CfacturaDAO extends Cfactura {
    
    PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CfacturaDAO> arreglo = new ArrayList();
    
    public String IngresarPorductoFactura(CfacturaDAO Usu) {
        String respuesta = "";
        
        try {
            stmt = cnn.prepareStatement("INSERT INTO producto_factura values (?,?) ");
            stmt.setInt(1, Usu.getId_factura());
            stmt.setInt(2, Usu.getId_producto());
            
            
            System.out.println(stmt);
            int result = stmt.executeUpdate();
            if (result != 0) {
                respuesta = "Nuevo Producto Ingresado";
            } else {
                respuesta = "Falló";
            }
            
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
            System.out.println("Error inesperado: " + ex.getMessage());
            
        } catch (Exception e) {
            respuesta = e.getMessage();
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return respuesta;
    }

    public String reiniciarFactura(int doc) {
        Connection cnn = Conectar.getInstace();
        String resultado = "";
        try {
            stmt = cnn.prepareStatement("delete from producto_factura where id_factura=?");
            stmt.setLong(1, doc);
            System.out.println(stmt);
            int result = stmt.executeUpdate();
            
            if (result != 0) {
                resultado = "Se elimino Correctamente";
            } else {
                resultado = "Falló";
            }
            
            
        } catch (SQLException ex) {
            resultado = ex.getMessage();
            
        }
        return resultado;
    }

    public String IngresarVenta(CfacturaDAO Usu) {
        String respuesta = "";
        
        try {
            stmt = cnn.prepareStatement("INSERT INTO factura values (?,?,?,?,?,?) ");
            stmt.setInt(1, Usu.getId_factura());
            stmt.setLong(2, Usu.getId_usuario());
            stmt.setLong(3, Usu.getCedula());
            stmt.setString(4, Usu.getF_factura());
            stmt.setString(5, Usu.getT_pago());
            stmt.setInt(6, Usu.getTotal());
            
            
            System.out.println(stmt);
            int result = stmt.executeUpdate();
            if (result != 0) {
                respuesta = "Se realizo la venta con exito";
            } else {
                respuesta = "Falló";
            }
            
        } catch (SQLException ex) {
            respuesta = ex.getMessage();
            System.out.println("Error inesperado: " + ex.getMessage());
            
        } catch (Exception e) {
            respuesta = e.getMessage();
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return respuesta;
    }

    public ArrayList<CfacturaDAO> lISTAR() {
        
        Connection cnn = Conectar.getInstace();
        
        try {
            stmt = cnn.prepareStatement("select * from factura");
            System.out.println(stmt);
            
            Rs = stmt.executeQuery();
            
            System.out.println(stmt);
            
            while (Rs.next()) {
                CfacturaDAO objlogin = new CfacturaDAO();
                objlogin.setId_factura(Rs.getInt("id_factura"));
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setId_usuario(Rs.getLong("cliente"));
                objlogin.setF_factura(Rs.getString("f_factura"));
                objlogin.setT_pago(Rs.getString("t_pago"));
                objlogin.setTotal(Rs.getInt("total"));
                
                arreglo.add(objlogin);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return arreglo;
    }
      public ArrayList<CfacturaDAO> lISTARxtipo(String tipo) {
        
        Connection cnn = Conectar.getInstace();
        
        try {
            stmt = cnn.prepareStatement("select * from factura where t_pago='"+tipo+"'");
            System.out.println(stmt);
            
            Rs = stmt.executeQuery();
            
            System.out.println(stmt);
            
            while (Rs.next()) {
                CfacturaDAO objlogin = new CfacturaDAO();
                objlogin.setId_factura(Rs.getInt("id_factura"));
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setId_usuario(Rs.getLong("cliente"));
                objlogin.setF_factura(Rs.getString("f_factura"));
                objlogin.setT_pago(Rs.getString("t_pago"));
                objlogin.setTotal(Rs.getInt("total"));
                
                arreglo.add(objlogin);
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return arreglo;
    }
    
    public CfacturaDAO Escoger(int id) {
        CfacturaDAO objlogin = new CfacturaDAO();
        Connection cnn = Conectar.getInstace();
        
        try {
            stmt = cnn.prepareStatement("select * from factura where id_factura=?");
            stmt.setInt(1, id);
            System.out.println(stmt);
            
            Rs = stmt.executeQuery();
            
            System.out.println(stmt);
            
            if (Rs.next()) {
                
                objlogin.setId_factura(Rs.getInt("id_factura"));
                objlogin.setCedula(Rs.getLong("cedula"));
                objlogin.setId_usuario(Rs.getLong("cliente"));
                objlogin.setF_factura(Rs.getString("f_factura"));
                objlogin.setT_pago(Rs.getString("t_pago"));
                objlogin.setTotal(Rs.getInt("total"));
                
               
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return objlogin;
    }
}
