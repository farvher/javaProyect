<%-- 
    Document   : ventana_profesor
    Created on : 15-oct-2014, 9:58:17
    Author     : DiegoV
--%>

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
        <form onsubmit="javascript: if(document.getElementById('es').value==0 || document.getElementById('no').value==0 ){return false ;}">
            <table>  

                <tr>
                    <th colspan="2"><h2>Nueva Novedad</h2></th>
                </tr>
                <tr>
                    <td>Profesor</td>
                    <td><%=user.getNombres() + " " + user.getApellidos()%></td>
                </tr>
                <tr>
                    <td>Estudiante</td>
                    <td>
                        <select name="estudiante"  required id="es">
                            <option value="0"> ---Escoge el Estudiante ---</option>
                            <%
                                ArrayList<DAOusuario> listaEstu = DAOcursos.getEstudiantesDelProfesor(user.getId());
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
                    <td>Tipo Novedad</td>
                    <td><select name="novedad" required id="no">
                            <option value="0">---Escoge el tipo de novedad ---</option>
                            <% ArrayList<TipoNovedad> lisNovedad = DAOnovedades.getTiposNovedades();
                                for (TipoNovedad tn : lisNovedad) {

                            %>
                            <option value="<%=tn.getId()%>"><%=tn.getTipoNovedad() + " - " + tn.getGravedad()%></option>
                            <%        }%>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Observacion</td>
                    <td><textarea name="observacion" required></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Ingresar Novedad" name="novedad"></td>
                </tr>

            </table>
        </form>
        <% if (request.getParameter("novedad") != null) {
                DAOnovedades Novedad = new DAOnovedades();
                DAOusuario estudiante = DAOusuario.getUsuario(Integer.parseInt(request.getParameter("estudiante")));
                TipoNovedad tiNovedad = DAOnovedades.getTiposNovedades(Integer.parseInt(request.getParameter("novedad")));

                Novedad.setEstado(3);//estado pendiente
                Novedad.setEstudiante(estudiante); // enviamos al estudiante
                Novedad.setFecha(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));//enviamos la fecha actual en string
                Novedad.setProfesor(user);// enviamos al profesor
                Novedad.setTipoNovedad(tiNovedad);//enviamos el tipo de novedad
                Novedad.setObservacion(request.getParameter("observacion"));

                int res = DAOnovedades.ingresarNovedad(Novedad);

                if(res==1){
                out.print("<script>alert ('Novedad Ingresada')</script>");
                out.print("<script>   opener.location.href='novedades.jsp';   </script>");
                out.print("<script>   window.close();   </script>");
                }else {
                 out.print("<script>alert ('Noo se pudo Ingresar la novedad')</script>");
                }




            }%>
    </body>
</html>
