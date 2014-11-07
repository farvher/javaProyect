/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CasisteDAO;
import Modelo.Ctiempo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FABIOLA
 */
public class controlregistro extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rs;
        try {
            
           
         Ctiempo temp =new Ctiempo();  
                
            
            
            CasisteDAO ASIS= new CasisteDAO();
            int random = (int) (Math.random()*9999+1);
            java.util.Date hoy =new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fds = new SimpleDateFormat("HH:mm");
            String fecha=sdf.format(hoy);
            String hora = fds.format(hoy);
            int entradas=ASIS.EntroSALIO(Long.parseLong(request.getParameter("documento")));
            //VARIABLE NOVEDAD
            String novedad="";
            if(hoy.after(temp.getTerminamañana()) && hoy.before(temp.getHora3()) && entradas%2==0){
            novedad="Entro tarde a la jornada Mañana";}
            else if(hoy.after(temp.getTerminatarde()) && hoy.before(temp.getHora4())&& entradas%2==0){
            novedad="Entro tarde a la jornada Tarde";
            }else{novedad="OK";}
            //VARIABLE ESTADO
         String estado="";
         
         if(hoy.after(temp.getIniciaañana()) && hoy.before(temp.getHora3())){
         if(entradas%2==0){
             estado="entro mañana";}else{estado="salio mañana";}
         }else if(hoy.after(temp.getIniciatarde()) && hoy.before(temp.getHora4())){
         if(entradas%2==0){
             estado="entro tarde";}else{estado="salio tarde";}
         }else{estado="novalido"+hoy;}
         
         
            
          if(request.getParameter("boton")!=null){
          String boton=request.getParameter("boton");
          if(boton.equals("Registrar")){
              String error="";
              if(!request.getParameter("user").equals(request.getParameter("documento"))){
                  error="Documento Incorrecto";
                 request.setAttribute("error", error);
                rs=getServletContext().getRequestDispatcher("/registro.jsp");
                rs.forward(request, response);
              
              }else if(hoy.after(temp.getHora3()) && hoy.before(temp.getIniciatarde())){
               error="No Puedes ingresar Entre las 12:00 PM y las 1:45 PM";
                 request.setAttribute("error", error);
                rs=getServletContext().getRequestDispatcher("/registro.jsp");
                rs.forward(request, response);
              
              }else if(hoy.before(temp.getIniciaañana()) || hoy.after(temp.getHora4())){
               error="Ingresa en el Horario Establecido<br>7:45 AM - 12:00PM Jornada Mañana"
                       + "<BR>1:45 PM - 6:00PM Jornada Tarde";
                 request.setAttribute("error", error);
                rs=getServletContext().getRequestDispatcher("/registro.jsp");
                rs.forward(request, response);
              
              }else if(ASIS.Entro((Long.parseLong(request.getParameter("documento"))))){
               error="Ya Se encuentra Ingresado en Esta jornada";
                 request.setAttribute("error", error);
                rs=getServletContext().getRequestDispatcher("/registro.jsp");
                rs.forward(request, response);
              
              }
             
              else{
              
             ASIS.setCodigo(random);
              ASIS.setUser(Long.parseLong(request.getParameter("documento")));
              ASIS.setEvento("Clase");
              ASIS.setCurso(Long.parseLong(request.getParameter("curso")));
              ASIS.setFecha(fecha);
              ASIS.setHora(hora);
              ASIS.setEstado(estado);
              ASIS.setNovedad(novedad);
          String res=ASIS.Ingresaruser(ASIS);
          response.sendRedirect("datos.jsp"); }
          }
          
          }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controlregistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(controlregistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
