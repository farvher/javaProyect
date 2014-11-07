<%-- 
    Document   : cabezera
    Created on : 17-mar-2014, 11:26:31
    Author     : Aprendiz
--%>

<%@page import="Modelo.Conectar"%>
<%@page import="Modelo.CuserDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><% response.setHeader("Cache-Control", "no-store"); %>
<html><%String fecha="";%>
    <head><link rel="stylesheet" href="css/estilo.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
       <script type="text/javascript" src="js/validaciones.js"></script>
    </head>
    <%


        HttpSession Adsi = request.getSession();
        CuserDAO ObjUsuario = new CuserDAO();
        boolean sexo = false; 
        boolean estu=true;
        boolean coor=true;
        if (Adsi.getAttribute("Usuario") != null) {
            ObjUsuario = (CuserDAO) Adsi.getAttribute("Usuario");
            
            
        if(ObjUsuario.getRol().equals("Estudiante") ){
        estu=true;
        coor=false;
        }else if(ObjUsuario.getRol().equals("Instructor") ){
        coor=true;
        estu=false;
        }

            
        } else {
            response.sendRedirect("index.jsp?estado=logeese");
        }
       

    %>

    <body >
        <div id="logo"> <img src="img/logo.png"></div>

        <div id="cabeza">
           
           
            
         
            <img src="img/banner.jpg">
            <div id='cssmenu'>

                <ul>
                    <% if(estu){%><li class='active'><a href='registro.jsp'><span>Registro</span></a></li><%}%>
                    <% if(estu){%><li><a href='datos.jsp'><span>Mis Asistencia</span></a></li><%}%>
                    <% if(coor){%><li><a href='estudiantes.jsp'><span>Estudiantes</span></a></li><%}%>
                    <% if(coor){%><li><a href='asistencia.jsp'><span>Asistencia</span></a></li><%}%>
                    
                   <li><a href='cursos.jsp'><span>Cursos</span></a></li>
                    <li><a href='controlusuario?salir=salir'><span>Salir</span></a></li>
                   
                </ul>
            </div>
                   

        </div>
        <div id="menuiz">
           
            <table class="tg">
                <tr ><th colspan="2"><font  size="3"><b>Bienvendido<p><%=ObjUsuario.getRol()%></b></font></th></tr>
                <tr>
                    <td>Nombre</td>
                    <td><%=ObjUsuario.getNombre()%></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><%=ObjUsuario.getApellido()%></td>
                </tr>
               
                <tr>
                    <td>email</td>
                    <td><%=ObjUsuario.getEmail()%></td>
                </tr>
                <tr>
                    <td>telefono</td>
                    <td><%=ObjUsuario.getTelefono()%></td>
                </tr>



            </table>
<% if (request.getParameter("mensaje") != null) {
                        
                        out.print("<CENTER><font color='red' size='5'>Mensaje: " +request.getParameter("mensaje") + "</font></center>");

                    }%>
        </div>


    </body>
</html>
