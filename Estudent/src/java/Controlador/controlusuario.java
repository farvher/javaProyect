/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ccifrar;
import Modelo.CuserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FABIOLA
 */
public class controlusuario extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rs;
        try {
            CuserDAO USER = new CuserDAO();
            Ccifrar cifrar = new Ccifrar();
           if (request.getParameter("boton")!=null){
           
           long cedula = Long.parseLong(request.getParameter("cedula"));
           String pass=(request.getParameter("pass"));
           pass=cifrar.Encriptar(pass, 12);
           USER=USER.login(cedula, pass);
             if(USER.getCedula()!=0){
           HttpSession Adsi=request.getSession();
           Adsi.setAttribute("Usuario",USER);
          
           Adsi.setAttribute("valida","ok");
           if(USER.getRol().equals("Estudiante")){
          response.sendRedirect("registro.jsp");
           }else{ response.sendRedirect("estudiantes.jsp");}
           }else if (USER.getCedula() == 0){
           request.setAttribute("error", "Usuario y/o Contraseña Incorrectas");
           rs = getServletContext().getRequestDispatcher("/index.jsp");
                 rs.forward(request, response);
           
            
            }else {request.setAttribute("error", "Usuario y/o Contraseña Incorrectas");
           rs = getServletContext().getRequestDispatcher("/index.jsp");
                 rs.forward(request, response);}
           
           
           
           
           }else if(request.getParameter("salir")!=null ){
                  
          response.sendRedirect("index.jsp");
           
           
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
        processRequest(request, response);
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
