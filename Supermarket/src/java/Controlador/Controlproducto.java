/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CproductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlproducto extends HttpServlet {

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
        try {
            CproductoDAO PRODUCTO = new CproductoDAO();
            Date hoy = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
            String respuesta = "";

            if (request.getParameter("boton") != null) {
               
                String boton = request.getParameter("boton");


                PRODUCTO.setF_creacion(sdf.format(hoy));
                PRODUCTO.setId_producto(Integer.parseInt(request.getParameter("codigo")));
                PRODUCTO.setMedida(request.getParameter("medida"));
                PRODUCTO.setPrecio(Integer.parseInt(request.getParameter("precio")));
                PRODUCTO.setProducto(request.getParameter("producto"));


                if (boton.equals("Crear")) {
                    respuesta = PRODUCTO.Ingresarproducto(PRODUCTO);
                    response.sendRedirect("ventana.jsp?mensaje=" + respuesta);
                } else if (boton.equals("Actualizar")) {
                    respuesta = PRODUCTO.actualizar(PRODUCTO);
                    response.sendRedirect("ventana.jsp?mensaje=" + respuesta);
                }


            } else if (request.getParameter("elimina") != null) {

                int id = Integer.parseInt(request.getParameter("elimina"));
                respuesta = PRODUCTO.eliminar(id);
                response.sendRedirect("productos.jsp?mensaje=" + respuesta);

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
