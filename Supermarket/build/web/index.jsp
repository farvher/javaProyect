

<%@page import="Modelo.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <script src="js/validacion.js"></script>
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <script src="js/jquery.js"></script>
        <script>

            $(document).ready(function() {

                $("#logocentro").animate({
                    width: '50%',
                    height: "500px",
                    
                }, "slow");

            });

        </script>


    </head>
    <body background="img/imagenfondo.jpg">
        <div id="logo"><center><img src="img/logo.png"> 
                <h1>SuperMarket</h1>
            </center></div>
        <div id="header">
 <div id='cssmenu2'>
        <ul>
             <li><a href="#" onclick="abreVentana('ventana.jsp?registrarse=1', '2')"><span>Registrate</span></a></li> 
            

       
          

        </ul>
    </div> 

           
        </div>
        <div id="menuiz">
            <center>

                <form action="Controlusuario" method="POST">           
                    <table  class="tg">
                        <tr><th ><center><h2>Ingresa</h2></center></th></tr>
                        <tr>

                            <td class="tg-k6pi"> <center><input type="text" onKeyPress="return soloNumeros(event)"  placeholder="Documento" name="cedula"  maxlength="10" required ></center></td>

                        </tr>
                        <tr>

                            <td class="tg-k6pi"><center> <input type="password"  placeholder="Clave" name="pass" required maxlength="10" ></center></td>
                        </tr>
                        <tr>

                            <td class="tg-k6pi"><center> <input type="Submit" name="boton"  value="Entrar" ></center></td>
                        </tr>


                    </table>
                </form> 
                <%
                    if (request.getParameter("mensaje") != null) {
                        String mensaje = request.getParameter("mensaje");
                        out.print("<h2>" + mensaje + "</h2>");
                    }
                %>
            </center>

        </div>
        <div id="content">
            <br>

            <% if (Conectar.getInstace() == null) {
                    out.print("<script>alert('Sin conexion')</script>");
                };
            %>  
            <center>
                <div id="logocentro" >
                    
                    <img style="width:60%;"src="img/logo.png">
                    <h2>SuperMarket</h2>
                    <h1>Sistema de Informacion para Supermercados</h1>
                </div>
            </center>
        </div>

    </body>
</html>
