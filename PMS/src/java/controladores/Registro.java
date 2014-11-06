/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.pms.dao.DAOusuario;
import com.pms.dto.Genero;
import com.pms.dto.Rol;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DAOusuario user = new DAOusuario();
            if (request.getParameter("regis") != null) {
                String documento = request.getParameter("documento");
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String nacimiento = request.getParameter("nacimiento");
                String genero = request.getParameter("genero");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String ciudad = request.getParameter("ciudad");
                String barrio = request.getParameter("barrio");
                String clave = request.getParameter("clave");

                //settear
                Genero gene = new Genero(Integer.parseInt(genero));
                gene.setId(Integer.parseInt(genero));
                Rol rol = new Rol(3);//rol 4 Es usuario registrado
                user.setApellidos(apellidos);
                user.setBarrio(barrio);
                user.setCiudad(ciudad);
                user.setClave(clave);
                user.setCorreo(correo);
                user.setDireccion(direccion);
                user.setDocumento(documento);
                user.setEdad(12);
                user.setFechacreacion(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                user.setGenero(gene);
                user.setNacimiento(nacimiento);
                user.setNombres(nombres);
                user.setRol(rol);
                user.setTelefono(telefono);
                if(!DAOusuario.ExisteUsuario(documento) && !DAOusuario.ExisteUsuario(correo) ){
                switch (user.IngresarUser(user)) {
                    case 0:
                        response.sendRedirect("index.jsp?error=No se pudo hacer el registro");
                        break;
                    case 1:
                         response.sendRedirect("index.jsp?mensaje=Su registro ha sido exitoso");

                }
                }else{  
                       response.sendRedirect("index.jsp?mensaje=El documento y/o correo ya se encuentra registrado");
                }
                
                
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
