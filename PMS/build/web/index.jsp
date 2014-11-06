<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.pms.dao.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <script src="js/validacion.js"></script>
        <script src="js/jquery.js"></script>
    </head>
    <body  background="img/wall.jpg">
        <div id="logo"><h4> Psychological Management System - PMS</h4></div>
        <div id="section">


        </div>

        <div id="login">

            <form method="post" action="Login">
                <table >
                    <tr>
                        <td colspan="2"><h2>Iniciar Sesion</h2></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="documento" required placeholder="Documento"></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="clave" required placeholder="Contraseña"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" > Mantener la sesion iniciada
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="entrar" name="entrar"></td>
                    </tr>
                </table>
                <% if (request.getParameter("error") != null) {
                        out.print("<font color='red'>" + request.getParameter("error") + "</font>");
                    }%>
                <% if (request.getParameter("mensaje") != null) {
                        out.print("<font color='red'>" + request.getParameter("mensaje") + "</font>");
                    }%>
                <%
                    if (Conectar.getInstace() == null) {
                        out.print("<font color='red'>No se ha establecido conexion a la base de datos</font>");
                    }
                %>
            </form>
            <a href="#" onclick="registrarme()">Registrate</a>

            <p>profesor:111111111
            <p> profesor:1092352729
            <p>psicologo:123456789
            <p> administrador:1092352729
            <p> pass:123456
        </div>


        <div id="footer">
            <h2>Psychological Management System - PMS.</h2>
            Copyright &copy; <%= new SimpleDateFormat("yyyy").format(new Date())%> Todos los derechos reservados
        </div>
    </body>
</html>
