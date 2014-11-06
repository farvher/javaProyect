<%-- 
    Document   : inicio
    Created on : 7/10/2014, 09:40:35 PM
    Author     : Farith S
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.pms.dao.Modulos"%>
<%@page import="com.pms.dao.DAOusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PMS Inicio</title>

        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <link rel="stylesheet" href="../css/estilo.css" type="text/css">
        <script src="js/validacion.js"></script>
        <script src="js/jquery.js"></script>
        <script src="js/paging.js"></script>
        <script src="../js/jquery.js"></script>
        <%

            HttpSession sesion = request.getSession();
            DAOusuario user = new DAOusuario();
            boolean sesione = false;
            Modulos modulo = new Modulos();
            if (sesion.getAttribute("usuario") == null || sesion.getAttribute("modulos") == null) {
        %>
        <jsp:forward page="index.jsp">
            <jsp:param name="error" value="Su sesion ha finalizado , debe Ingresar como usuario" />
        </jsp:forward>
        <%            } else {
                user = (DAOusuario) session.getAttribute("usuario");
                modulo = (Modulos) session.getAttribute("modulos");
                sesione = true;
            }


        %>
    </head>
    <body >
        <div id="logo"><h4> Psychological Management System - PMS</h4></div>
        <header>
            <h1 style="float:right;">Bienvenido <%= user.getNombres() + " " + user.getApellidos() + " <b>" + user.getRol().getRol() + " </b> "%> 

        </header>
        <div id="banner"> 
            <nav id="cssmenu">
                <ul>
                    <% if (modulo.isProfe()) {%>  
                    <li><a href='novedades.jsp'><span>Profesor</span></a>
                        <ul>
                            <li><a href='#' onclick="abreVentana('ventana_profesor.jsp', '2')"><span>Crear Novedad</span></a></li>
                            <li><a href='novedades.jsp'><span>Novedades Estudiantes</span></a></li>
                            <li><a href='estudiantes.jsp'><span>Estudiantes</span></a></li>
                            <li><a href='cursos.jsp'><span>Cursos</span></a></li>
                        </ul>
                    </li><%}%>
                    <% if (modulo.isPsico()) {%>  
                    <li><a href='citas.jsp'><span>Psicologo</span></a>
                        <ul>
                            <li><a href='novedades.jsp'><span>Novedades</span></a></li>
                            <li><a href='#' onclick="abreVentana('ventana_psico.jsp', '2')"><span>Crear Cita</span></a></li>
                            <li><a href='citas.jsp'><span>Citas Estudiantes</span></a></li>
                            <li><a href='historias.jsp'><span>Historias</span></a></li>
                        </ul>
                    </li><%}%>
                    <% if (modulo.isAdmin()) {%>  
                    <li><a href=''><span>Administrador</span></a>
                        <ul>
                            <li><a href='productos.jsp'><span>Modulos</span></a></li>
                            <li><a href='usuarios.jsp'><span>Usuarios</span></a></li>
                            <li><a href='cursos.jsp'><span>Cursos</span></a></li>
                        </ul>
                    </li><%}%>
                    <% if (sesione) {%>  <li><a  href="Login?salir=true"><span>Cerrar Session</span></a> </li><%}%>

                </ul>


            </nav>
            <br>
            <div id="pagina"></div>

        </div>



        <div id="footer">
            <h2>Psychological Management System - PMS.</h2>
            Copyright &copy; <%= new SimpleDateFormat("yyyy").format(new Date())%> Todos los derechos reservados
        </div>
    </body>
</html>
