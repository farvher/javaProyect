/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Csexo {
    private String sexo;

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
     public ArrayList <Csexo> Pintar (){
    Csexo  obj =new Csexo(); 
   Connection cnn = Conectar.getInstace();
   PreparedStatement stmt = null;
    ResultSet Rs =null;
    ArrayList <Csexo> arreglosexo=new ArrayList();
    
    try {
            stmt= cnn. prepareStatement("select * from sexo");
            
            Rs = stmt.executeQuery();
            
            
            while(Rs.next()){
                Csexo objl = new Csexo ();
                objl.setSexo(Rs.getString("sexo"));
               arreglosexo.add(objl);
            }
            
            
        }
        catch(SQLException ex){
            obj.setSexo(ex.getMessage());
             
        }
            return arreglosexo ;
    }
     
     public String LISTAsex() {
        String listado = "";
        ArrayList<Csexo> option = new ArrayList();
        Csexo opt = new Csexo();
        option = opt.Pintar() ;
        for (int a1 = 0; a1 < option.size(); a1++) {
            
            listado= listado+ 
      ("<option value='" + option.get(a1).getSexo()  + "' >"+ option.get(a1).getSexo() + "</option>");
        }
        
                            
                                        
           return listado;

    }
    
    
}
