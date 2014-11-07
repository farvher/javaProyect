/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ccurso;
import Modelo.CcursoDAO;
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
public class controlcursos extends HttpServlet {

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
        RequestDispatcher rs;
        PrintWriter out = response.getWriter();
        try {
            CcursoDAO CURSO = new CcursoDAO();
            if (request.getParameter("boton") != null) {
                String boton = request.getParameter("boton");
                if (boton.equals("Crear")) {
                    out.print("1");

                    CURSO.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                    out.print("1");
                    CURSO.setCupo(Integer.parseInt(request.getParameter("cupo")));
                    out.print("1");
                    CURSO.setCurso(request.getParameter("curso"));
                    out.print("1");
                    CURSO.setDfinal(request.getParameter("hhasta"));
                    out.print("2");

                    CURSO.setDinicio(request.getParameter("hdesde"));
                    out.print("1");
                    CURSO.setInstructor(Long.parseLong(request.getParameter("instructor")));
                    out.print("1");
                    CURSO.setNivel(request.getParameter("descripcion"));
                    out.print("1");

                    

                    String res = CURSO.Ingresar(CURSO);

                    response.sendRedirect("cursos.jsp?estado=" + res);


                }

            }else if(request.getParameter("inscripcion")!=null){
                int curso=Integer.parseInt(request.getParameter("codigo"));
                   long cedula=Long.parseLong(request.getParameter("inscripcion"));
               boolean esta= CURSO.YAESTA(curso,cedula); 
               CURSO=CURSO.Escoger(curso);
                if (esta){response.sendRedirect("registro.jsp?mensaje=Ya se encuentra inscrito al curso");}
                else if(CURSO.getCupo()==0){response.sendRedirect("registro.jsp?mensaje=No hay cupo suficiente para este curso");}
                else{   
                    CURSO.Menosuncupo(curso);
            String res= CURSO.Inscripcion(cedula, curso);//metodo para la inscripcion
            response.sendRedirect("registro.jsp?estado="+res);
                }
            }else if(request.getParameter("borra")!=null){
            int idborra= Integer.parseInt(request.getParameter("borra"));
            
            String res = CURSO.Borrar(idborra);
            
            response.sendRedirect("cursos.jsp?mensaje=Curso borrado");
            
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
