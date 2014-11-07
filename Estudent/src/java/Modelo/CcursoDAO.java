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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Aprendiz
 */
public class CcursoDAO extends Ccurso {

    PreparedStatement stmt = null;
    Connection cnn = Conectar.getInstace();
    ResultSet Rs = null;
    ArrayList<CcursoDAO> arreglo = new ArrayList();

    public ArrayList<CcursoDAO> lISTAR() {
        CcursoDAO objlogi = new CcursoDAO();
        Connection cnn = Conectar.getInstace();


        try {
            stmt = cnn.prepareStatement("select * from curso");

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CcursoDAO objlogin = new CcursoDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setCurso(Rs.getString("curso"));
                objlogin.setNivel(Rs.getString("nivel"));
                objlogin.setDias(Rs.getInt("dias"));
                objlogin.setDinicio(Rs.getString("dinicio"));
                objlogin.setDfinal(Rs.getString("dfinal"));
                objlogin.setInstructor(Rs.getLong("instructor"));
                objlogin.setCupo(Rs.getInt("cupo"));


                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setCurso(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
    public ArrayList<CcursoDAO> lISTARCINSTRUCTOR( long cedula) {
        CcursoDAO objlogi = new CcursoDAO();
        Connection cnn = Conectar.getInstace();


        try {
            stmt = cnn.prepareStatement("select * from curso where instructor =?");
            stmt.setLong(1, cedula);

            Rs = stmt.executeQuery();



            while (Rs.next()) {
                CcursoDAO objlogin = new CcursoDAO();
                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setCurso(Rs.getString("curso"));
                objlogin.setNivel(Rs.getString("nivel"));
                objlogin.setDias(Rs.getInt("dias"));
                objlogin.setDinicio(Rs.getString("dinicio"));
                objlogin.setDfinal(Rs.getString("dfinal"));
                objlogin.setInstructor(Rs.getLong("instructor"));
                objlogin.setCupo(Rs.getInt("cupo"));


                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setCurso(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }

    public ArrayList<CcursoDAO> lISTARxEstudiante(long cedula) {
        CcursoDAO objlogi = new CcursoDAO();
        Connection cnn = Conectar.getInstace();


        try {
            stmt = cnn.prepareStatement("select * from user_curso where cedula=?");
            stmt.setLong(1, cedula);

            Rs = stmt.executeQuery();





            while (Rs.next()) {
                CcursoDAO objlogin = new CcursoDAO();
                objlogin = objlogin.Escoger(Rs.getInt("codigo"));


                arreglo.add(objlogin);
            }


        } catch (SQLException ex) {
            objlogi.setCurso(ex.getMessage());
            arreglo.add(objlogi);

        }
        return arreglo;
    }
    
   
    

    public CcursoDAO lISTARXcurso(long curso) {

        Connection cnn = Conectar.getInstace();
        CcursoDAO objlogin = new CcursoDAO();
        try {
            stmt = cnn.prepareStatement("select * from curso where codigo=?");
            stmt.setLong(1, curso);

            Rs = stmt.executeQuery();



            if (Rs.next()) {


                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setCurso(Rs.getString("curso"));
                objlogin.setNivel(Rs.getString("nivel"));
                objlogin.setDias(Rs.getInt("dias"));
                objlogin.setDinicio(Rs.getString("dinicio"));
                objlogin.setDfinal(Rs.getString("dfinal"));
                objlogin.setInstructor(Rs.getLong("instructor"));
                objlogin.setCupo(Rs.getInt("cupo"));


            } else {
                objlogin.setCurso("NOEXISTE");
            }


        } catch (SQLException ex) {
            objlogin.setCurso(ex.getMessage());
            System.out.println(ex.getMessage());

        }
        return objlogin;
    }

    public String Borrar(int id) {
        Connection cnn = Conectar.getInstace();
        CcursoDAO objlogin = new CcursoDAO();
        String res = "";
        try {
          Borrarusercurso(id);
            stmt = cnn.prepareStatement("delete from curso where codigo=?");
            stmt.setLong(1, id);

            int e = stmt.executeUpdate();
            if (e != 0) {
                res = "se elimino correctamente";
            } else {
                res = "noelimino";
            }



        } catch (SQLException ex) {
            res = (ex.getMessage());


        }
        return res;
    }
 public String Borrarusercurso(int id) {
        Connection cnn = Conectar.getInstace();
        CcursoDAO objlogin = new CcursoDAO();
        String res = "";
        try {
          
            stmt = cnn.prepareStatement("delete from user_curso where codigo=?");
            stmt.setLong(1, id);

            int e = stmt.executeUpdate();
            if (e != 0) {
                res = "se elimino correctamente";
            } else {
                res = "noelimino";
            }



        } catch (SQLException ex) {
            res = (ex.getMessage());


        }
        return res;
    }
    public String Ingresar(CcursoDAO Usu) {
        String res = "";
        CcursoDAO Curso = new CcursoDAO();
        try {
            stmt = cnn.prepareStatement("INSERT INTO curso values (?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, Usu.getCodigo());
            stmt.setString(2, Usu.getCurso());
            stmt.setString(3, Usu.getNivel());
            stmt.setInt(4, Usu.getDias());
            stmt.setString(5, Usu.getDinicio());
            stmt.setString(6, Usu.getDfinal());
            stmt.setLong(7, Usu.getInstructor());
            stmt.setInt(8, Usu.getCupo());



            int result = stmt.executeUpdate();
            if (result != 0) {
                res = "si";
            } else {
                res = "Falló";
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = ex.getMessage();
        }

        return res;
    }

    public CcursoDAO Escoger(int id) {
        CcursoDAO objlogi = new CcursoDAO();
        Connection cnn = Conectar.getInstace();
        CcursoDAO objlogin = new CcursoDAO();
        try {
            stmt = cnn.prepareStatement("select * from curso where codigo=?");
            stmt.setInt(1, id);

            Rs = stmt.executeQuery();



            if (Rs.next()) {


                objlogin.setCodigo(Rs.getInt("codigo"));
                objlogin.setCurso(Rs.getString("curso"));
                objlogin.setNivel(Rs.getString("nivel"));
                objlogin.setDias(Rs.getInt("dias"));
                objlogin.setDinicio(Rs.getString("dinicio"));
                objlogin.setDfinal(Rs.getString("dfinal"));
                objlogin.setInstructor(Rs.getLong("instructor"));
                objlogin.setCupo(Rs.getInt("cupo"));


            } else {
                objlogin.setCodigo(0);
            }


        } catch (SQLException ex) {
            objlogin.setCurso(ex.getMessage());
            System.out.println(ex.getMessage());

        }
        return objlogin;
    }

    public String Edita(CcursoDAO Usu) {
        String res = "";
        CcursoDAO Curso = new CcursoDAO();
        try {
            stmt = cnn.prepareStatement("UPDATE curso SET curso=?, nivel=? ,horas=? where codigo=? ");


            stmt.setString(2, Usu.getCurso());
            stmt.setString(3, Usu.getNivel());
            stmt.setInt(4, Usu.getDias());
            stmt.setString(5, Usu.getDinicio());
            stmt.setString(6, Usu.getDfinal());
            stmt.setLong(7, Usu.getInstructor());
            stmt.setInt(8, Usu.getCupo());
            stmt.setInt(1, Usu.getCodigo());
            
            int result = stmt.executeUpdate();
            if (result != 0) {
                res = "si";
            } else {
                res = "Falló";
            }



        } catch (SQLException ex) {
            res = ex.getMessage();
        }

        return res;
    }
    public String Sumarfechas(String inicio, String finalo) throws ParseException{
       String dias="";  
       
       try{
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm");
    Date ini = new Date() ;
    Date fin = new Date() ;
    ini= sdf.parse(inicio);
    fin =sdf.parse(finalo);
    
    
    long diferencia = ( ini.getTime() - fin.getTime() /24 * 60 * 60 * 1000); 
        }catch(ParseException e){
        dias=0+""; }
        return dias;
    }
    
    public String Inscripcion(long cedula , int codigo) {
        String res = "";
        CcursoDAO Curso = new CcursoDAO();
        int random = (int) (Math.random()*999+1);
        try {
            stmt = cnn.prepareStatement("INSERT INTO user_curso values (?,?,?) ");
            stmt.setInt(1, random);
            stmt.setLong(2, cedula);
            stmt.setInt(3, codigo);
           



            int result = stmt.executeUpdate();
            if (result != 0) {
                res = "si";
            } else {
                res = "Falló";
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = ex.getMessage();
        }

        return res;
    }

    public boolean YAESTA(int curso, long cedula) {
       boolean esta=true;
        Connection cnn = Conectar.getInstace();


        try {
            stmt = cnn.prepareStatement("select * from user_curso where cedula=? and codigo=?");
            stmt.setLong(1, cedula);
            stmt.setInt(2, curso);

            Rs = stmt.executeQuery();
           





            while (Rs.next()) {
                CcursoDAO objlogin = new CcursoDAO();
                objlogin = objlogin.Escoger(Rs.getInt("codigo"));


                arreglo.add(objlogin);
            }
if(arreglo.size()==0){esta=false;}else{esta=true;}

        } catch (SQLException ex) {
           esta=false;

        }
       
       
       return esta;
    }
     public String Menosuncupo(  int codigo) {
        String res = "";
        CcursoDAO Curso = new CcursoDAO();
       Curso = Curso.Escoger(codigo);
       int nuevocupo=Curso.getCupo()-1;
       nuevocupo=nuevocupo<0?0:nuevocupo;
       
        int random = (int) (Math.random()*999+1);
        try {
            stmt = cnn.prepareStatement("update curso set cupo=? where codigo=?");
            stmt.setInt(1, nuevocupo);
            stmt.setInt(2, codigo);
            
           



            int result = stmt.executeUpdate();
            if (result != 0) {
                res = "si";
            } else {
                res = "Falló";
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            res = ex.getMessage();
        }

        return res;
    }
}
