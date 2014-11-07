
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="frente.jsp" %>
<% int numeroVenta = (int) (Math.random() * 9999 + 1);%>

<body onload="traerproductos(0,<%=numeroVenta%>)">
<div id="menuiz">
    <h2>Acciones</h2>
    <div id='cssmenu'>
        <ul>
            
            <li><a onclick="window.location.reload()" href='#'><span>Nueva venta</span></a></li>

        </ul>
    </div> 


</div>

<div id="content">
    <% 
        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    %>
    <Table>
        <tr>
            <th colspan="4"><center><H2>Nueva Venta</H2></center></th>
        </tr>
        <tr>
            <th>Venta Numero</th>
            <td>#<%=numeroVenta%></td>
            <th>Cajero</th>
            <td><%=USER.getNombre()+" "+USER.getApellido() %></td>

        </tr>
       
        <tr>
            <th>Codigo Producto</th>
            <td><input type="text" id="idproducto" onKeyPress="return soloNumeros(event)"  onkeyup ="traerproductos(this.value,<%=numeroVenta%>)" ></td>
            <td colspan="2" ><i>Ingrese el codigo del Producto y los que coincidan se listaran abajo</i></td>
            
            
        </tr>
        <tr>
            <td style="width:50%;" id="cambioproductos" colspan="2">
                
            </td>
            <td style="width:50%;" id="cambioingresados" colspan="2">
                
            </td>
        </tr>
            
    </Table>



</div>
