<%-- 
    Document   : index
    Created on : 17-mar-2014, 10:47:30
    Author     : Aprendiz
--%>

<%@page import="Modelo.Conectar"%>
<%@page import="Modelo.CcursoDAO"%>
<%@page import="Modelo.Csexo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CuserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><% response.setHeader("Cache-Control", "no-store"); %>
    <head><link rel="stylesheet" href="css/estilo.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/validaciones.js"></script>
        <title>JSP Page</title>
    </head>
    <body >
  <div id="logo"> <img src="img/logo.png"></div>
        <div id="cabeza">

           
       
            <img src="img/banner.jpg">


            <div id='cssmenu'>

                <ul>
                    <li class='active'><a href='index.jsp'><span>Inicio</span></a></li>

                    <li><a href='index.jsp?estado=registro'><span>Registro</span></a></li>
                    <li><a href='index.jsp?estado=documentos'><span>Documentos</span></a></li>
                    
                   
                </ul>
            </div>

        </div>
        <div id="menuiz">
           
            <center>

                <form action="controlusuario" method="POST">           
                    <table  class="tg">
                        <tr><th colspan="2"><font color="white" size="3"><b>Ingresa</b></font></th></tr>
                        <tr>
                            <td class="tg-031e">Documento</td>
                            <th class="tg-k6pi"> <input type="text" onKeyPress="return soloNumeros(event)"  placeholder="Solo Numeros" name="cedula"  maxlength="10" required ></th>

                        </tr>
                        <tr>
                            <td class="tg-031e">Contraseña</td>
                            <th class="tg-k6pi"> <input type="password"  placeholder="Solo Numeros" name="pass" required maxlength="10" ></th>
                        </tr>
                        <tr>
                            <td class="tg-031e"></td>
                            <th class="tg-k6pi"> <input type="Submit" name="boton"  value="Entrar" ></th>
                        </tr>
                       

                    </table>
                </form>  
                
                   <% if(Conectar.getInstace()==null){
                   out.print("<script>alert('No hay conexion a la base de datos!')</script>");
                       System.out.println("NO hay conexion a la base de datos!!");
                   } 
                   
                   %>
                  
                        

                <% if (request.getParameter("mensaje") != null) {
                        
                        out.print("<font color='red' size='5'>Mensaje: " +request.getParameter("mensaje") + "</font>");

                    }else if(request.getAttribute("error")!=null){
                    out.print("<font color='red' size='5'>Mensaje: " +request.getAttribute("error") + "</font>");
                    }
                %>    </center>
        </div>

    </div>
    <div id="areatrabajo"><BR>
        
        <% if (request.getParameter("estado")!=null){
            String estado=request.getParameter("estado");
            if(estado.equals("registro")){
        %>
        <!--INICIA REGISTRO-->
        <center>
            <form class="form" name="registro" id="registro" action="Rolbajo" method="post">
                <table style="width:50%;text-align: left;" class="tg" border="1">
                    <thead>
                        <tr>
                            <th colspan="3">Registro de Estudiante<br>(<font size="1"><b>Campos requeridos <font color="red">*</font> </b></font>)</th>

                        </tr>
                    </thead>
                
                    <tbody>

                        <tr>

                            <td>Documento <font color="red">*</font> </td>
                            <td>
                    <input type="text"  name="cedula" id="cedula" onKeyPress="return soloNumeros(event)" placeholder="Solo Numeros" maxlength="12" value="" />
                   
                            </td> 
                        </tr>
                        <tr>
                            <td>Nombre <font color="red">*</font></td>
                            <td><input type="text" id="nombre" name="nombre"   maxlength="15" value="" />  </td>
                        </tr>
                        <tr>
                            <td>Apellido <font color="red">*</font></td>
                            <td><input type="text"  id="apellido" name="apellido" maxlength="15" value="" /></td>
                        </tr>


                        <tr>
                            <td>Contraseña <font color="red">*</font></td>
                            <td><input  type="password" id="contrasena"  name="contrasena" placeholder="Solo Numeros "   maxlength="8" value="" />
                           
                            </td>
                        </tr>
                        <tr>
                            <td>Confirmar Contraseña <font color="red">*</font></td>
                            <td><input  type="password" id="vcontrasena"   name="vcontrasena" placeholder="Solo Numeros "   maxlength="8" value="" />
                           
                            </td>
                        </tr>
                       

                        <tr>
                            <td>Email <font color="red">*</font></td>
                            <td><input  type="text" id="email"  name="email"  placeholder="Ejemplo@dominio.com" maxlength="30" value=""><p id="error6"></p>  </td>
                        
                        </tr>
                        <tr>
                            <td>Telefono <font color="red">*</font></td>
                            <td><input type="text" id="telefono"   name="telefono" placeholder="Solo Numeros" onKeyPress="return soloNumeros(event)" maxlength="10" value="" />
                            
                            </td>
                        </tr>
                        <tr>
                            <td>Sexo <font color="red">*</font></td>
                            <td>


                                <%
                                    ArrayList<Csexo> option = new ArrayList();
                                    Csexo opt = new Csexo();
                                    option = opt.Pintar();
                                    for (int a1 = 0; a1 < option.size(); a1++) {
                                %>
                                <input type ="radio" id="sexo" <% if (a1 == 0) {%>checked<% }%> name="sexo" value="<%=option.get(a1).getSexo()%>">
                                <%= option.get(a1).getSexo()%>
                                <%
                                    }
                                %>
                                

                            </td>
                        </tr>
                        <tr>
                            <td><p id="error"></p></td>
                    
                            <td>

                                <input type="button" onclick="validauser()" value="Enviar">
                                <br><a href="index.jsp" >Volver</a> </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </center> 
        <% }else if(estado.equals("documentos")){
        %>
        <BR>
        <a href="css/"><H1>Documento IEEE</H1></a><br>
        <a href="css/"><H1>Manual Tecnico</H1></a><br>
        <a href="css/"><H1>Manual del Usuario</H1></a><br>
        <%
        
        }
        
}else{

%>
<center> 

    
    <!--AQUI VA EL LOGOTIPO DE LA EMPRESA-->



</center>
        <%

}%>
        <!--TERMINA REGISTRO-->

<% if (request.getParameter("estado")!=null){
if(request.getParameter("estado").equals("ok")){
  out.print("<script> alert ('Su registro fue exitoso')</script>");
}
}
%>
</body>

<script type="text/javascript">

    function mostrar(valor)
    {
        document.getElementById("resultado").innerHTML = valor;
    }

    // Solo permite ingresar numeros.
    function soloNumeros(e) {
        var key = window.Event ? e.which : e.keyCode
        return ((key >= 48 && key <= 57) || (key == 8) || (key == 13))
    }
</script>
</html>
