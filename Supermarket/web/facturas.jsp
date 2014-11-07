<%@page import="Modelo.CfacturaDAO"%>
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
        <%if (admin) {%>    <li><a href='reportesventas?tipo=efectivo'><span>Pagos en Efectivo</span></a></li><%}%>
       <%if (admin) {%>     <li><a href='reportesventas?tipo=credito'><span>Pagos en Credito</span></a></li><%}%>

        </ul>
    </div> 



</div>
<div id="content">

    <%if (request.getParameter("men")!=null){
out.print("<script>verventa("+request.getParameter("men")+")</script>");    
}%>

    <table>
        <tr><th colspan="9"><center><h2>Ventas</h2></center></th></tr>
        <tr>
            <th>Codigo</th>
            <th>Cajero</th>
            <th>Cliente</th>
            <th>Fecha de venta</th>
            <th>Tipo de pago</th>
            <th>Total</th>
            <th>Ver</th>


        </tr>
        <%
            CfacturaDAO FACTURA = new CfacturaDAO();
            ArrayList< CfacturaDAO> LISTA = new ArrayList();
            LISTA = FACTURA.lISTAR();
            for (int a1 = 0; a1 < LISTA.size(); a1++) {
                  CuserDAO TEMP= new CuserDAO();
                TEMP=TEMP.escogerxid(LISTA.get(a1).getCedula());

        %>
        <tr>
            <td><%=LISTA.get(a1).getId_factura()%></td>
            <td><%=TEMP.getNombre()+" "+TEMP.getApellido() %></td>
            <td><b>CC:</b><%=LISTA.get(a1).getId_usuario()%></td>
            <td><%=LISTA.get(a1).getF_factura()%></td>
            <td><%=LISTA.get(a1).getT_pago()%></td>
            <td>$<%=LISTA.get(a1).getTotal()%></td>
            <td><a href="#" onclick="verventa(<%=LISTA.get(a1).getId_factura()%>)"><img src="img/ver.png" title="Editar "></a></td>

        </tr>


        <%            }


        %>
    </table>
</div>
