<%-- 
    Document   : ventana_profesor
    Created on : 15-oct-2014, 9:58:17
    Author     : DiegoV
--%>

<%@page import="com.pms.dao.DAOcitas"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.pms.dao.DAOcursos"%>
<%@page import="com.pms.dto.TipoNovedad"%>
<%@page import="com.pms.dao.DAOnovedades"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pms.dao.DAOusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <script src="js/validacion.js"></script>
        <script src="js/jquery.js"></script>
    </head>
    <%        
        DAOusuario user = new DAOusuario();
        user = (DAOusuario) session.getAttribute("usuario");
    %>
    <body>
        <form >
            <table>  

                <tr>
                    <th colspan="2"><h2>Nueva Cita</h2></th>
                </tr>
                <tr>
                    <td>Psicologo</td>
                    <td><%=user.getNombres() + " " + user.getApellidos()%></td>
                </tr>
                <tr>
                    <td>Estudiante</td>
                    <td>
                        <select name="estudiante"  required id="es">
                            <option value="0"> ---Escoge el Estudiante ---</option>
                            <%                                
                                ArrayList<DAOusuario> listaEstu = DAOcursos.getEstudiantes();
                                for (DAOusuario u : listaEstu) {
                            %>
                            <option value="<%=u.getId()%>"><%=u.getNombres() + " " + u.getApellidos()%></option>

                            <%                                    
                                }
                            %>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type='date' name='fecha' required></td>

                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type='time' name='hora' required></td>

                </tr>
                <tr>
                    <td>Observacion</td>
                    <td><textarea name="observacion" required></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Crear Cita" name="cita"></td>
                </tr>

            </table>
        </form>
        <% if (request.getParameter("cita") != null) {
                DAOcitas cita = new DAOcitas();
                DAOusuario estudiante = DAOusuario.getUsuario(Integer.parseInt(request.getParameter("estudiante")));
                
                cita.setEstudiante(estudiante);
                cita.setFecha(request.getParameter("fecha"));
                cita.setHora(request.getParameter("hora"));
                cita.setObservacion(request.getParameter("observacion"));
                cita.setPsicologo(user);
                cita.setEstado("3");//estado pendiente
                
                
                int res = DAOcitas.ingresarCita(cita);
                
                if (res == 1) {
                    out.print("<script>alert ('Cita Ingresada')</script>");
                    out.print("<script>   opener.location.href='citas.jsp';   </script>");
                    out.print("<script>   window.close();   </script>");
                } else {
                    out.print("<script>alert ('Noo se pudo Ingresar la cita')</script>");
                }
                
                
                
                
            }%>
    </body>
</html>
