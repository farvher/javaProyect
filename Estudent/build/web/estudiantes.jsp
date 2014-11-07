<%-- 
    Document   : estudiantes
    Created on : 18/03/2014, 12:03:36 PM
    Author     : FABIOLA
--%>

<%@page import="Modelo.CuserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Cuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabezera.jsp" %>
<div id="areatrabajo">
    <br>
    <div id="buscar">
        <h1>Estudiantes</h1>  
        
       <form style="float:right;" action="#">
           <input type="text" name="documento" Style="width:200px;" placeholder="Buscar por Documento" maxlenght="10">
           <input type="submit" name="boton" value="Buscar">
       </form> 
    </div>
    <table class="tg">
        <tr>
            <th class="tg-031e">Documento</th>
            <th class="tg-031e">Nombre</th>
            <th class="tg-031e">Apellido</th>
            <th class="tg-031e">Sexo</th>
           
            <th class="tg-031e">Email</th>
            <th class="tg-031e">Telefono</th>
            
            
        </tr>      
        <%
            CuserDAO USUARIO = new CuserDAO();
            ArrayList<CuserDAO> LISTAUSER = new ArrayList();
            LISTAUSER = USUARIO.lISTAR();

            for (int a1 = 0; a1 < LISTAUSER.size(); a1++) {
                if(LISTAUSER.get(a1).getRol().equals("Estudiante")){

        %>
        <tr>
            <td class="tg-031e"><%=LISTAUSER.get(a1).getCedula() %></td>
            <td class="tg-031e"><%=LISTAUSER.get(a1).getNombre() %></td>
            <td class="tg-031e"><%=LISTAUSER.get(a1).getApellido() %></td>
            <td class="tg-031e"><%=LISTAUSER.get(a1).getSexo() %></td>
          
            <td class="tg-031e"><%=LISTAUSER.get(a1).getEmail() %></td>
            <td class="tg-031e"><%=LISTAUSER.get(a1).getTelefono() %></td>
            
            
        </tr>    


        <%}}
        %>  
       
      
    </table>     

</div>
