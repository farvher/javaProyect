<%-- 
    Document   : cursos
    Created on : 19/03/2014, 03:22:49 PM
    Author     : win
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CcursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabezera.jsp"%>
<div id="areatrabajo">
    
    <br>
    <div id="buscar">
       <h1>Cursos Disponibles </h1>  
        
       <form style="float:right;" action="#">
           <input type="text" name="documento" Style="width:200px;" placeholder="Buscar Curso" maxlength="10">
           <input type="submit" name="boton" value="Buscar">
           
       </form>
       
    </div>
    <iframe src="ajaxcurso.jsp" width="1050" height="300"></iframe>  
       <% if (coor){%> <div id="curso"><a href="nuevocurso.jsp"><img title="Nuevo Curso" src="img/nuevo.png"><i>Nuevo Curso</i></a></div>
    <%}%>
    <% if (request.getParameter("estado")!=null){
if(request.getParameter("estado").equals("ok")){
  out.print("<script> alert ('Curso eliminado Correctamente')</script>");
}else if(request.getParameter("estado").equals("NO")){
  out.print("<script> alert ('NO puedes eliminar este curso')</script>");
}
}
%>
</div>