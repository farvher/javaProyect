/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CfacturaDAO;
import Modelo.CuserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlventa extends HttpServlet {

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
            out.print("<script>"
                    + "function finalizoventa(id){\n"
                    + "    window.close();\n"
                    + "    window.opener.location='facturas.jsp?men='+id"
                    + "}"
                    + "</script>");

            HttpSession Adsi = request.getSession();
            CuserDAO USER = new CuserDAO();
            Date hoy = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            if (Adsi.getAttribute("Usuario") != null) {
                USER = (CuserDAO) Adsi.getAttribute("Usuario");
            }

            if (request.getParameter("profact") != null) {

                int fact = Integer.parseInt(request.getParameter("profact"));
                int pro = Integer.parseInt(request.getParameter("pro"));

                CfacturaDAO FACT = new CfacturaDAO();
                FACT.setId_factura(fact);
                FACT.setId_producto(pro);
                String res = FACT.IngresarPorductoFactura(FACT);
                System.out.print(res);

            } else if (request.getParameter("borrar") != null) {

                int factborra = Integer.parseInt(request.getParameter("borrar"));
                CfacturaDAO FACT = new CfacturaDAO();
                String res = FACT.reiniciarFactura(factborra);
                System.out.print(res);
            } else if (request.getParameter("boton") != null) {
                CfacturaDAO FACT = new CfacturaDAO();
                FACT.setCedula(Long.parseLong(request.getParameter("cliente")));
                FACT.setF_factura(sdf.format(hoy));
                FACT.setId_factura(Integer.parseInt(request.getParameter("venta")));
                FACT.setId_usuario(USER.getCedula());
                FACT.setT_pago(request.getParameter("pago"));
                FACT.setTotal(Integer.parseInt(request.getParameter("total")));

               

                String res = FACT.IngresarVenta(FACT);
                out.print("<h2>" + res + "</h2>");
                out.print("<a href='#' onclick='finalizoventa(" + FACT.getId_factura() + ")'>Ver Detalles</a>");

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
