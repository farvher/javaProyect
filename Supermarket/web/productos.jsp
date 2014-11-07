
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CproductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="frente.jsp" %>
<div id="menuiz">
    <h2>Acciones</h2>
    <div id='cssmenu'>
        <ul>
            <%if (admin) {%>   <li><a onclick="abreVentana('ventana.jsp?nuevoproducto=0', '1')"><span>Nuevo Producto</span></a></li> <%}%>
            

          <%if (admin) {%>  <li><a href='reportes'><span>Reporte de Productos</span></a></li><%}%>
          <%if (admin) {%>  <li><a href='reportesventas?vendidos=12'><span>Reporte de vendidos al mes</span></a></li><%}%>
          

        </ul>
    </div> 


</div>
<div id="content">


    <table>
        <tr><th colspan="7"><center><h2>Productos</h2></center></th></tr>
        <tr>
            <th>Codigo</th>
            <th>Producto</th>
            <th>Registrado el dia</th>
            <th>Precio </th>
            <th>Medida</th>

            <%if (admin) {%>      <th>Editar</th><%}%>
            <%if (admin) {%>      <th>Eliminar</th><%}%>

        </tr>
        <%
            CproductoDAO PRODUCTO = new CproductoDAO();
            ArrayList<CproductoDAO> LISTA = new ArrayList();
            LISTA = PRODUCTO.lISTAR();
            for (int a1 = 0; a1 < LISTA.size(); a1++) {

        %>
        <tr>
            <td><%=LISTA.get(a1).getId_producto()%></td>
            <td><%=LISTA.get(a1).getProducto()%></td>
            <td><%=LISTA.get(a1).getF_creacion() %></td>
            <td>$<%=LISTA.get(a1).getPrecio()%></td>
            <td><%=LISTA.get(a1).getMedida()%></td>

            <%if (admin) {%>      <td><a href="#"  onclick="abreVentana('ventana.jsp?nuevoproducto=<%=LISTA.get(a1).getId_producto()%>', '1')"><img src="img/edita.png" title="Editar <%=LISTA.get(a1).getProducto()%>"></a></td><%}%>
            <%if (admin) {%>      <td><a onclick="return elimina()" href="Controlproducto?elimina=<%=LISTA.get(a1).getId_producto()%>"><img src="img/borra.png" title="Eliminar <%=LISTA.get(a1).getProducto()%>"></a></td><%}%>
        </tr>


        <%            }


        %>

</div>
