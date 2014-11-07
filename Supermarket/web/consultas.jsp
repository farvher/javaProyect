

<%@page import="Modelo.CuserDAO"%>
<%@page import="Modelo.CfacturaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CproductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (request.getParameter("productos") != null) {
        CproductoDAO PRODUCTO = new CproductoDAO();
        ArrayList<CproductoDAO> LISTA = new ArrayList();

        int pro = Integer.parseInt(request.getParameter("productos"));
        int fact = Integer.parseInt(request.getParameter("fact"));

        if (pro != 0) {
            LISTA = PRODUCTO.lISTARlike(pro);
        }
        if (LISTA.size() != 0) {

%>
<table>
    <tr><th colspan="4"><h2>Productos por Codigo</h2></th></tr>

<%

    for (int a1 = 0; a1 < LISTA.size(); a1++) {

%>
<tr>
    <td><%=LISTA.get(a1).getId_producto()%></td>
    <td><%=LISTA.get(a1).getProducto()%></td>

    <td>$<%=LISTA.get(a1).getPrecio()%></td>
    <td><%=LISTA.get(a1).getMedida()%></td>
    <td><a href="#" onclick="agregar(<%=LISTA.get(a1).getId_producto()%>,<%=fact%>)"><img src="img/sumar.png" title="Agregar Producto"></a></td>

</tr>
<%}%>
</table>


<%
} else {
%>
<table>
    <tr><th ><h2>Productos por Codigo</h2></th></tr>
<tr><td>Producto con el Codigo <B><%=pro%></B> No Existe</td></tr>
</table>
<%
    }

} else if (request.getParameter("factura") != null) {

    CproductoDAO PRODUCTO = new CproductoDAO();
    ArrayList<CproductoDAO> LISTA = new ArrayList();

    int pro = Integer.parseInt(request.getParameter("factura"));
    LISTA = PRODUCTO.lISTARfactura(pro);
    if (LISTA.size() != 0) {

%>
<table>
    <tr><th colspan="3"><h2>Productos Ingresados</h2></th>
<td><a href="#" onclick="Reiniciar(<%=pro%>)">Borrar Todo</a>

    </tr>
    <%
        int total = 0;
        int subtotal=0;
        for (int a1 = 0; a1 < LISTA.size(); a1++) {
           total =  (LISTA.get(a1).getPrecio()*LISTA.get(a1).getCant());
           subtotal=subtotal+total;
    %>
<tr>
    <td><%=LISTA.get(a1).getId_producto()%></td>
    <td><%=LISTA.get(a1).getProducto()%></td>
    <td>$<%=LISTA.get(a1).getPrecio()%></td>
    <td><%=LISTA.get(a1).getMedida()%> </td>
    <td><b>x</b> <%=LISTA.get(a1).getCant() %> = <%=total%></td>

</tr>
<%
 
    }%>
<tr><td colspan="4"><b>Total = <%=subtotal%><input type="hidden" id="total" value="<%=subtotal%>"></b><input type="button" onclick="comprar(<%=pro%>,<%=subtotal%>)" value="Comprar"></td></td></tr>
</table>


<%
} else {

%>
<table>
    <tr><th ><h2>Productos Ingresados</h2></th></tr>
<tr><td>Ningun Producto Ingresado en la Venta <B><%=pro%></B></td></tr>
</table>
<%        }


} else if (request.getParameter("idfactura") != null) {

    int idfact = Integer.parseInt(request.getParameter("idfactura"));
    CfacturaDAO FACT = new CfacturaDAO();
    FACT = FACT.Escoger(idfact);
    CuserDAO TEMP = new CuserDAO();
    TEMP = TEMP.escogerxid(FACT.getCedula());


%>
<table>
    <tr><th colspan="9"><center><h2>Ventas</h2></center></th></tr>
<tr>
    <th>Codigo</th>
    <th>Cajero</th>
    <th>Cliente</th>
    <th>Fecha de venta</th>
    <th>Tipo de pago</th>
    <th>Total</th>
    <th>Volver</th>


</tr>

<tr>
    <td><%=FACT.getId_factura()%></td>
    <td><%=TEMP.getNombre() + " " + TEMP.getApellido()%></td>
    <td><b>CC:</b><%=FACT.getId_usuario()%></td>
    <td><%=FACT.getF_factura()%></td>
    <td><%=FACT.getT_pago()%></td>
    <td>$<%=FACT.getTotal()%></td>
    <td><a  href="#" onclick="window.location.href='facturas.jsp'"><img src="img/atras.png" ></a></td>

</tr>


</table>
<table>
    <tr><th colspan="7"><center><h2>Productos</h2></center></th></tr>
<tr>
    <th>Codigo</th>
    <th>Producto</th>
    <th>Creado el dia</th>
    <th>Precio </th>
    <th>Cantidad</th>


</tr>
<%
    CproductoDAO PRODUCTO = new CproductoDAO();
    ArrayList<CproductoDAO> LISTA = new ArrayList();
    LISTA = PRODUCTO.lISTARfactura(idfact);
    int total=0;
    int subtotal=0;
    for (int a1 = 0; a1 < LISTA.size(); a1++) {
           total =  (LISTA.get(a1).getPrecio()*LISTA.get(a1).getCant());
           subtotal=subtotal+total;
    %>
<tr>
    <td><%=LISTA.get(a1).getId_producto()%></td>
    <td><%=LISTA.get(a1).getProducto()%></td>
    <td>$<%=LISTA.get(a1).getPrecio()%></td>
    <td><%=LISTA.get(a1).getMedida()%> </td>
    <td><b>x</b> <%=LISTA.get(a1).getCant() %> = $<%=total%></td>

</tr>
<%
 
    }%>



</table>
<%

    }else if(request.getParameter("habilitar")!=null){
    
    long id = Long.parseLong(request.getParameter("habilitar"));
    
    CuserDAO OBJ = new CuserDAO();
    OBJ = OBJ.escogerxid(id); 
    
    OBJ.HABILITAR(OBJ);
    out.print(OBJ.getCedula() + OBJ.getRol());
    
    
    }

%>

