/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Aprendiz
 */
public class CasisteDAO extends Casiste{
    
     PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CasisteDAO> arreglo= new ArrayList();
    
    
    
    public ArrayList<CasisteDAO> lISTAR() {
        CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from asiste ");

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CasisteDAO objlogin = new CasisteDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setUser(Rs.getLong("user"));
                objlogin.setEvento(Rs.getString("evento"));
                objlogin.setCurso(Rs.getInt("curso"));
                objlogin.setFecha(Rs.getString("fecha"));
                objlogin.setHora(Rs.getString("hora"));
                objlogin.setEstado(Rs.getString("estado"));
                objlogin.setNovedad(Rs.getString("novedad"));
                
                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setEvento(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }

    public String Ingresaruser(CasisteDAO Usu) {
        String respuesta = "";

        try {
            stmt = cnn.prepareStatement("INSERT INTO asiste values (?,?,?,?,?,?,?,?) ");
            stmt.setLong(1, Usu.getCodigo());
            stmt.setLong(2, Usu.getUser());
            stmt.setString(3, Usu.getEvento());
            stmt.setLong(4, Usu.getCurso());
            stmt.setString(5, Usu.getFecha());
            stmt.setString(6, Usu.getHora());
            stmt.setString(7, Usu.getEstado());
            stmt.setString(8, Usu.getNovedad());
            
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
 
    
    public ArrayList<CasisteDAO> lISTARxfecha(String fecha,long doc) {
        CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from asiste where fecha=? and cedula=?");
            stmt.setString(1, fecha);
            stmt.setLong(2,doc);

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CasisteDAO objlogin = new CasisteDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setUser(Rs.getLong("cedula"));
                objlogin.setEvento(Rs.getString("evento"));
                objlogin.setCurso(Rs.getInt("curso"));
                objlogin.setFecha(Rs.getString("fecha"));
                objlogin.setHora(Rs.getString("hora"));
                objlogin.setEstado(Rs.getString("estado"));
                objlogin.setNovedad(Rs.getString("novedad"));
                
                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setEvento(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
     public ArrayList<CasisteDAO> lISTARxfechatodos(String fecha) {
        CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from asiste where fecha=? ");
            stmt.setString(1, fecha);
           

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CasisteDAO objlogin = new CasisteDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setUser(Rs.getLong("cedula"));
                objlogin.setEvento(Rs.getString("evento"));
                objlogin.setCurso(Rs.getInt("curso"));
                objlogin.setFecha(Rs.getString("fecha"));
                objlogin.setHora(Rs.getString("hora"));
                objlogin.setEstado(Rs.getString("estado"));
                objlogin.setNovedad(Rs.getString("novedad"));
                
                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setEvento(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
    public ArrayList<CasisteDAO> lISTARxcurso(String curso) {
        CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from asiste where curso=?");
            stmt.setString(1, curso);

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CasisteDAO objlogin = new CasisteDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setUser(Rs.getLong("cedula"));
                objlogin.setEvento(Rs.getString("evento"));
                objlogin.setCurso(Rs.getInt("curso"));
                objlogin.setFecha(Rs.getString("fecha"));
                objlogin.setHora(Rs.getString("hora"));
                objlogin.setEstado(Rs.getString("estado"));
                objlogin.setNovedad(Rs.getString("novedad"));
                
                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setEvento(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
     public ArrayList<CasisteDAO> lISTARxdocumentoTodos(long id) {
        CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();

        try {
            stmt = cnn.prepareStatement("select * from asiste where cedula=? order by fecha");
            stmt.setLong(1, id);

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CasisteDAO objlogin = new CasisteDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setUser(Rs.getLong("cedula"));
                objlogin.setEvento(Rs.getString("evento"));
                objlogin.setCurso(Rs.getInt("curso"));
                objlogin.setFecha(Rs.getString("fecha"));
                objlogin.setHora(Rs.getString("hora"));
                objlogin.setEstado(Rs.getString("estado"));
                objlogin.setNovedad(Rs.getString("novedad"));
                
                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setUser(333);
            objlogi.setHora(ex.getMessage());
            arreglo.add(objlogi);

        }
        catch (Exception ex) {
            objlogi.setUser(2222);
            objlogi.setHora(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }

    public boolean Entro(long l) throws ParseException {
     boolean entro=false;
     Ctiempo temp = new Ctiempo();
         CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();
         java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha);
             String estado="";
         if(hoyfecha.after(temp.getIniciaañana()) && hoyfecha.before(temp.getHora3())){
         estado="salio mañana";
         }else if(hoyfecha.after(temp.getIniciatarde()) && hoyfecha.before(temp.getHora4())){
         estado="salio tarde";
         }else{estado="novalido"+hoy;}
      try{
          stmt = cnn.prepareStatement("select * from asiste where cedula=? and fecha=? and estado=?");
            stmt.setLong(1, l);
            stmt.setString(2, hoy);
            stmt.setString(3,estado );

            Rs = stmt.executeQuery();
      
      if(Rs.next()){
      entro=true;
      }else{entro=false;}
      
      
      
      }catch(SQLException ex){
      
      entro=false;
      
      }
    return entro;}

    public boolean Entrotarde(long l) {
      boolean entro=false;
         CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();
         java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha);
      try{
          stmt = cnn.prepareStatement("select * from asiste where cedula=? and fecha=? and estado='tarde'");
            stmt.setLong(1, l);
            stmt.setString(2, hoy);

            Rs = stmt.executeQuery();
      
      if(Rs.next()){
      entro=true;
      }else{entro=false;}
      
      
      
      }catch(SQLException ex){
      
      entro=false;
      
      }
    return entro;
    }
 public int EntroSALIO(long l) throws ParseException {
     int a1=0;
     Ctiempo temp = new Ctiempo();
         CasisteDAO objlogi = new CasisteDAO();
        Connection cnn = Conectar.getInstace();
         java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha);
           
      try{
          stmt = cnn.prepareStatement("select * from asiste where cedula=? and fecha=?");
            stmt.setLong(1, l);
            stmt.setString(2, hoy);
            

            Rs = stmt.executeQuery();
      
      while(Rs.next()){
      a1++;
      }
      
      
      
      }catch(SQLException ex){
      
      a1=9999;
      
      }
    return a1;}
   
}
