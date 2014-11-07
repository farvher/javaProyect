/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CproductoDAO extends Cproductos {

    PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CproductoDAO> arreglo = new ArrayList();

    public ArrayList<CproductoDAO> lISTAR() {

        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from productos");
            System.out.println(stmt);

            Rs = stmt.executeQuery();

            System.out.println(stmt);

            while (Rs.next()) {
                CproductoDAO objlogin = new CproductoDAO();
                objlogin.setId_producto(Rs.getInt("id_producto"));
                objlogin.setProducto(Rs.getString("producto"));
                objlogin.setF_creacion(Rs.getString("f_creacion"));
                objlogin.setPrecio(Rs.getInt("precio"));
                objlogin.setMedida(Rs.getString("medida"));

                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return arreglo;
    }

    public ArrayList<CproductoDAO> lISTARlike(int id) {

        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from productos where id_producto like '%" + id + "%'");
            System.out.println(stmt);

            Rs = stmt.executeQuery();

            System.out.println(stmt);

            while (Rs.next()) {
                CproductoDAO objlogin = new CproductoDAO();
                objlogin.setId_producto(Rs.getInt("id_producto"));
                objlogin.setProducto(Rs.getString("producto"));
                objlogin.setF_creacion(Rs.getString("f_creacion"));
                objlogin.setPrecio(Rs.getInt("precio"));
                objlogin.setMedida(Rs.getString("medida"));

                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return arreglo;
    }

    public ArrayList<CproductoDAO> lISTARfactura(int id) {

        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select id_factura,id_producto,count(*) total from producto_factura where id_factura=? group by id_producto,id_factura");
            stmt.setInt(1, id);
            System.out.println(stmt);

            Rs = stmt.executeQuery();

            System.out.println(stmt);

            while (Rs.next()) {
                CproductoDAO objlogin = new CproductoDAO();
                objlogin = objlogin.Escoger(Rs.getInt("id_producto"));
                objlogin.setCant(Rs.getInt("total"));

                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return arreglo;
    }

    public ArrayList<CproductoDAO> lISTARfacturaTODOS() {

        Connection cnn = Conectar.getInstace();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date hoy = new Date();
        try {
            stmt = cnn.prepareStatement("select id_factura,id_producto,count(*) total from producto_factura  group by id_producto,id_factura order by id_factura");

            System.out.println(stmt);

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CproductoDAO objlogin = new CproductoDAO();
                objlogin = objlogin.Escoger(Rs.getInt("id_producto"));
                objlogin.setF_creacion("" + Rs.getInt("id_factura"));
                objlogin.setCant(Rs.getInt("total"));
                

                    arreglo.add(objlogin);
               
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return arreglo;
    }

    public CproductoDAO Escoger(int id) {
        CproductoDAO objlogin = new CproductoDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from productos where id_producto=?");
            stmt.setInt(1, id);
            System.out.println(stmt);

            Rs = stmt.executeQuery();

            System.out.println(stmt);

            if (Rs.next()) {

                objlogin.setId_producto(Rs.getInt("id_producto"));
                objlogin.setProducto(Rs.getString("producto"));
                objlogin.setF_creacion(Rs.getString("f_creacion"));
                objlogin.setPrecio(Rs.getInt("precio"));
                objlogin.setMedida(Rs.getString("medida"));


            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return objlogin;
    }

    public String Ingresarproducto(CproductoDAO Usu) {
        String respuesta = "";

        try {
            stmt = cnn.prepareStatement("INSERT INTO productos values (?,?,?,?,?) ");
            stmt.setInt(1, Usu.getId_producto());
            stmt.setString(2, Usu.getProducto());
            stmt.setString(3, Usu.getF_creacion());
            stmt.setInt(4, Usu.getPrecio());
            stmt.setString(5, Usu.getMedida());

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

    public String eliminar(int doc) {
        Connection cnn = Conectar.getInstace();
        String resultado = "";
        try {
            eliminarPROFACTURA(doc);
            stmt = cnn.prepareStatement("delete from productos where id_producto=?");
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

    public String eliminarPROFACTURA(int doc) {
        Connection cnn = Conectar.getInstace();
        String resultado = "";
        try {
            stmt = cnn.prepareStatement("delete from producto_factura where id_producto=?");
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

    public String actualizar(CproductoDAO Usu) {
        String respuesta = "";

        try {
            stmt = cnn.prepareStatement("update productos set producto=? ,f_creacion=? , precio=? , medida=? where id_producto=? ");

            stmt.setString(1, Usu.getProducto());
            stmt.setString(2, Usu.getF_creacion());
            stmt.setInt(3, Usu.getPrecio());
            stmt.setString(4, Usu.getMedida());
            stmt.setInt(5, Usu.getId_producto());

            System.out.println(stmt);
            int result = stmt.executeUpdate();
            if (result != 0) {
                respuesta = "Actualizo Correctamente";
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
}
