/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.pms.dao.DAOusuario;
import com.pms.dao.Modulos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farith S
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DAOusuario user = new DAOusuario();

            if (request.getParameter("entrar") != null) {
                String documento = request.getParameter("documento");
                String clave = request.getParameter("clave");
                user.setDocumento(documento);
                user.setClave(clave);
                if (user.login(user)) {
                    Modulos modulo = new Modulos();

                    user = user.getUsuario(documento);
                    modulo = Modulos.Permisos(user.getRol());
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", user);
                    sesion.setAttribute("modulos", modulo);

                    if (user.getRol().getId() == 1) {
                        //es administrador
                        response.sendRedirect("admin.jsp");
                    } else if (user.getRol().getId() == 5) {
                        //es profesor
                        response.sendRedirect("novedades.jsp");
                    } else if (user.getRol().getId() == 2) {
                        //es psicologo
                        response.sendRedirect("psicologo.jsp");
                    } else {
                        response.sendRedirect("index.jsp?error=" + "No estas Autorizado");
                    }

                } else {

                    response.sendRedirect("index.jsp?error=" + "Usuario y/o Clave incorrectas");
                }

            } else if (request.getParameter("salir") != null) {
                request.getSession().invalidate();
                response.sendRedirect("index.jsp?mensaje=Su sesion ha finalizado");
            }

        } catch (Exception e) {
            out.print(e.getMessage());
        } finally {
            out.close();;
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
