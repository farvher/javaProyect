
<%@page import="Modelo.CuserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CproductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="frente.jsp" %>
<div id="menuiz">
    <h2>Acciones</h2>
    <div id='cssmenu'>
        <ul>
            <li><a onclick="abreVentana('ventana.jsp?nuevoproducto=0', '1')"><span>Nuevo Producto</span></a></li>
            <li><a href=''><span>Reportes</span></a></li>

        </ul>
    </div> 


</div>
<div id="content">


    <table>
        <tr><th colspan="9"><center><h2>Personal</h2></center></th></tr>
        <tr>
            <th>Documento</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Genero</th>
            <th>Email</th>
            <th>Telefono</th>
            <th>Rol</th>

            <th>Activador</th>
            

        </tr>
        <%
            CuserDAO USERe = new CuserDAO();
            ArrayList< CuserDAO> LISTA = new ArrayList();
            LISTA = USERe.lISTAR();
            for (int a1 = 0; a1 < LISTA.size(); a1++) {
              if(!LISTA.get(a1).getRol().equals("Administrado")){
                  
                  String estado=LISTA.get(a1).getRol().equals("cajero")?"activo":"inactivo";

        %>
        <tr>
            <td><%=LISTA.get(a1).getCedula()%></td>
            <td><%=LISTA.get(a1).getNombre()%></td>
            <td><%=LISTA.get(a1).getApellido()%></td>
            <td><%=LISTA.get(a1).getSexo()%></td>
            <td><%=LISTA.get(a1).getEmail()%></td>
            <td><%=LISTA.get(a1).getTelefono()%></td>
            <td><%=LISTA.get(a1).getRol()%></td>


            <td><a  href="#" onclick="habilitar(<%=LISTA.get(a1).getCedula()%>)"><img src="img/<%=estado%>.png" title="Editar "></a></td>
            
        </tr>


        <%         }   }


        %>

</div>
