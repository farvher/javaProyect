/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author FABIOLA
 */
public class Ctiempo {
  
   private Date hora1 //hora de entrada a las 8:00
           ,hora2//hora de entrada tarde 2:00
           ,hora3//hora de salida 12:00
           ,hora4;//hora salida 6:00
   
private Date Iniciaañana,Iniciatarde ; //desde  que horas se pueden regitrar
private Date terminamañana,terminatarde ; //hasta que horas se pueden regitrar
    /**
     * @return the hora1
     */
    public Date getHora1() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       hora1=sdf.parse(hoy+"8:00");
        return hora1;
    }

    /**
     * @param hora1 the hora1 to set
     */
   

    /**
     * @return the hora2
     */
     public Date getHora2() throws ParseException {
         java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       hora2=sdf.parse(hoy+"14:00");
        return hora2;
    }

    /**
     * @param hora2 the hora2 to set
     */
   

    /**
     * @return the hora3
     */
    public Date getHora3() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       hora3=sdf.parse(hoy+"12:00");
        return hora3;
    }

    /**
     * @param hora3 the hora3 to set
     */
    public Date getHora4() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       hora4=sdf.parse(hoy+"18:00");
        return hora4;
    }

    /**
     * @param hora4 the hora4 to set
     */
    
    /**
     * @return the Iniciaañana
     */
    public Date getIniciaañana() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       Iniciaañana=sdf.parse(hoy+"7:45");
        return Iniciaañana;
    }

    /**
     * @param Iniciaañana the Iniciaañana to set
   

    /**
     * @return the Iniciatarde
     */
    public Date getIniciatarde() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       Iniciatarde=sdf.parse(hoy+"13:45");
         return Iniciatarde;
    }

    /**
     * @return the terminamañana
     */
    public Date getTerminamañana() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
       terminamañana=sdf.parse(hoy+"8:15");
       return terminamañana;
    }

    /**
     * @return the terminatarde
     */
    public Date getTerminatarde() throws ParseException {
        java.util.Date hoyfecha = new java.util.Date();
             SimpleDateFormat ddd=new SimpleDateFormat("yyyy-MM-dd");
             String hoy=ddd.format(hoyfecha); 
       SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-ddHH:mm");
        terminatarde =sdf.parse(hoy+"14:15");
       return terminatarde;
    }

    /**
     * @param Iniciatarde the Iniciatarde to set
     */
   

    /**
     * @return the hora1
     */}
