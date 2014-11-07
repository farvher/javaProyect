

<%@page import="Modelo.CuserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Frente principal</title>
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <script src="js/validacion.js"></script>
        <script src="js/jquery.js"></script>
        <script >
            $(document).ready(function() {
                $("#user").animate({
                    width: '200px',
                    heigth: '300px',
                    right: '130px'
                });

            });


        </script>

        <%
            HttpSession Adsi = request.getSession();
            CuserDAO USER = new CuserDAO();
            boolean admin = false;
            boolean habili = true;

            if (Adsi.getAttribute("Usuario") != null) {
                USER = (CuserDAO) Adsi.getAttribute("Usuario");
                admin = USER.getRol().equals("Administrado");
                habili = USER.getRol().equals("Inactivo") ? false : true;
                
                
                
                
            } else {
                response.sendRedirect("index.jsp?mensaje=Inicia sesion");
            }
        %>
    </head>
    <body background="img/imagenfondo.jpg">
        <div id="logo"><center><img src="img/logo.png"> 
                <h1>SuperMarket</h1>
            </center></div>
        <div id="header">


            <div id='cssmenu2'>
                <ul>
                 <% if (habili) {%>    <li><a href='nuevoregistro.jsp'><span>Registro</span></a></li><%}%>
                    <li><a href='productos.jsp'><span>Productos</span></a></li>
                    <li><a href='facturas.jsp'><span>Ventas</span></a></li>
                    <% if (admin) {%>  <li><a href='cajeros.jsp'><span>Cajeros</span></a></li><%}%>

                </ul>
            </div>
            <%
                if (request.getParameter("mensaje") != null) {
                    String mensaje = request.getParameter("mensaje");
                    out.print("<h2>" + mensaje + "</h2>");
                }
            %>
        </div>
        <div id="user">
            <CENTER>

                <h2><%= USER.getRol()%></h2>
                <H1><%= USER.getNombre() + " " + USER.getApellido()%></H1>
                <A href='Controlsesion'>Cerrar Sesion</A>

            </CENTER>

        </div>



    </body>
</html>
