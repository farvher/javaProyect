/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Ccifrar;
import Modelo.CuserDAO;
import Modelo.Cvalida;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andres
 */
public class Rolbajo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher Rd;
        try {
            CuserDAO objdao = new CuserDAO();
            Cvalida tempvalida = new Cvalida();
            
                out.print("1");
                Ccifrar cifrar = new Ccifrar();
               objdao.setApellido(request.getParameter("apellido"));out.print("1");
               objdao.setCedula(Long.parseLong(request.getParameter("cedula")));out.print("1");
               
               objdao.setEmail(request.getParameter("email"));out.print("1");
               objdao.setNombre(request.getParameter("nombre"));out.print("1");
               objdao.setRol("Estudiante");out.print("1");
               objdao.setSexo(request.getParameter("sexo"));out.print("1");
               objdao.setTelefono(request.getParameter("telefono"));out.print("fin");
                
                
               
               String cifrado=cifrar.Encriptar(request.getParameter("contrasena"),12);
               objdao.setClave(cifrado);
               String des=cifrar.Desencriptar(cifrado,12); 
               
               Cvalida valida = new Cvalida();
               if(valida.valida(objdao.getEmail())){
                   
                 String res = objdao.Ingresaruser(objdao);
               
              if(res.equals("si")){response.sendRedirect("index.jsp?mensaje=Se ha registrado con Exito");}else
               {response.sendRedirect("index.jsp?mensaje="+res); ;}  
               
               }else{ 
               response.sendRedirect("index.jsp?estado=registro&mensaje=EmailNoVALIDO");
               }
               
             
            
          } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
