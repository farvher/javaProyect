<%-- 
    Document   : registro
    Created on : 18/03/2014, 01:38:56 PM
    Author     : FABIOLA
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CcursoDAO"%>
<%@page import="Modelo.Ctiempo"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>





<%@include file="cabezera.jsp" %>
<div id="areatrabajo">
    
    <h1>Cursos Inscritos</h1>  
    <% CcursoDAO curso = new CcursoDAO();
   ArrayList  <CcursoDAO> ListaCurso = new ArrayList();
   ListaCurso = curso.lISTARxEstudiante(ObjUsuario.getCedula());
   
   if(ListaCurso.size()!=0){
       
       %>
       <table class="tg">
           <tr>
               <th>Codigo del Curso</th>
               <th>Nombre</th>
               <th>Instructor</th>
               <th>Fecha de Inicio</th>
               <th>Fecha Finalizacion</th>
               <th>Duracion</th>
               <th>Descripcion</th>
            </tr>
           <%
           for (int a1=0; a1<ListaCurso.size();a1++){
   %>
   <tr>
       <td><%=ListaCurso.get(a1).getCodigo() %></td>
       <td><%=ListaCurso.get(a1).getCurso() %></td>
       <td><%=ListaCurso.get(a1).getInstructor()%></td>
       <td><%=ListaCurso.get(a1).getDinicio()%></td>
       <td><%=ListaCurso.get(a1).getDfinal()%></td>
       <td><%=ListaCurso.get(a1).getDias() %> Dias</td>
       <td><%=ListaCurso.get(a1).getNivel()%></td>
       
   </tr>
            
            <%
   }
           
           %>
       </table>
    
    
    <%
  
   
   }else {
   
       %> 
       <h1>Actualente No ha inscrito Ningun Curso</h1>
    
    <%
   
   }
    
    %>
    
<div id="curso"><a href="cursos.jsp"><img title="Nuevo Curso" src="img/nuevo.png"><i>Incribirse en un Curso</i></a></div>
    
    
    
    
         <%
          if(request.getAttribute("error")!=null){
          String error=(String)request.getAttribute("error");
          out.print("<font color='white' size='5'>"+error+"</font>");
          
          }
         
         %>           
                    
                    
</center>
</div>