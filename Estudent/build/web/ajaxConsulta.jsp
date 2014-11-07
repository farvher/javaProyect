<%-- 
    Document   : cursos
    Created on : 19/03/2014, 03:22:49 PM
    Author     : win
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.CuserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CcursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><link rel="stylesheet" href="css/estilo.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<script type="text/javascript" src="js/validaciones.js"></script>

<%if (request.getParameter("curso") != null) {

        int curso = Integer.parseInt(request.getParameter("curso"));
        CcursoDAO CURSO = new CcursoDAO();
        CURSO = CURSO.Escoger(curso);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hoy = new Date();
        Date inicurso =sdf.parse(CURSO.getDinicio());
        boolean inicio=hoy.after(inicurso);
        
        String estado="";
        boolean ok=false;
        if(inicio){
        if(CURSO.getCupo()>15){
        estado="<font color='red'><i>El curso ha iniciado pero no cumple con el cupo minimo </i></font>"
                + "<br><a href='controlcursos?borra="+CURSO.getCodigo() +"' >Click para eliminar el Curso de "+CURSO.getCurso()+"</a>"; 
        }else{
        estado="<font color=''><i>El curso Ya ha iniciado</i></font>"; 
        ok=true;
         
        }
        
        }else{
        
        estado="<font color='red'><i>El curso aun NO ha iniciado</i></font>";    
        }

%>
<table>
    <tr>
        <td><b><i>Curso: </i></b><%=CURSO.getCurso() %></td>
        <td><b><i>Cupo: </i></b><%=CURSO.getCupo() %></td>
        <td><b><i>Inicia: </i></b><%=CURSO.getDinicio()%></td>
         <td><b><i>Finaliza: </i></b><%=CURSO.getDfinal()%></td>
        
    </tr>
    <tr>
        <td colspan="4"><b><i>Estado: </i></b><%=estado%></td>
    </tr>
</table>

<table class="tg">
    <tr>
        <th class="tg-031e">Documento</th>
        <th class="tg-031e">Nombre</th>
        <th class="tg-031e">Apellido</th>
        <th class="tg-031e">Asitio</th>






    </tr>      
    <%
        CuserDAO USUARIO = new CuserDAO();
        ArrayList<CuserDAO> LISTAUSER = new ArrayList();
        LISTAUSER = USUARIO.lISTARxcurso(curso);

        for (int a1 = 0; a1 < LISTAUSER.size(); a1++) {
if(ok){
    %>
    <tr>
        <td class="tg-031e"><%=LISTAUSER.get(a1).getCedula()%></td>
        <td class="tg-031e"><%=LISTAUSER.get(a1).getNombre()%></td>
        <td class="tg-031e"><%=LISTAUSER.get(a1).getApellido()%></td>
        <td class="tg-031e"><input type="checkbox" value="<%=LISTAUSER.get(a1).getCedula()%>"  onclick="check(this.value)" ></td>


    </tr>    


    <%}}

        if (LISTAUSER.size() == 0) {
            out.print("<h1>No hay Inscritos en este curso</h1>");
        }
        if(!ok) {
            out.print("<h3><i>El curso debe haber iniciado y cumplir con el cupo minimo para tomar asistencia</i></h3>");
        }
    %>  


</table> 


<%


%>




<%

    }%>