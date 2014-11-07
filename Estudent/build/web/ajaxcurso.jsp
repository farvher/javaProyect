<%-- 
    Document   : cursos
    Created on : 19/03/2014, 03:22:49 PM
    Author     : win
--%>

<%@page import="Modelo.CuserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.CcursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><link rel="stylesheet" href="css/estilo.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <script type="text/javascript" src="js/validaciones.js"></script>
<%
 HttpSession Adsi = request.getSession();
        CuserDAO ObjUsuario = new CuserDAO();
        
        if (Adsi.getAttribute("Usuario") != null) {
            ObjUsuario = (CuserDAO) Adsi.getAttribute("Usuario");}
       boolean ins=ObjUsuario.getRol().equals("Instructor")?true:false;
        boolean estu=ObjUsuario.getRol().equals("Estudiante")?true:false; 
%>
    <table class="tg">
        <tr>
            <th class="tg-031e">Codigo</th>
            <th class="tg-031e">Curso</th>
            <th class="tg-031e">Descripcion  </th>
            <th class="tg-031e">Dias</th>
            <th class="tg-031e">Inicia</th>
            <th class="tg-031e">Termina</th>
            <th class="tg-031e">Cupo</th>
            <th class="tg-031e">Instructor</th>
      <%if(estu){%>     <th class="tg-031e">Inscribirse</th><%}%>
            
        <%if(ins){%>    <th class="tg-031e">Editar</th><%}%>
       <%if(ins){%>     <th class="tg-031e">Borrar</th><%}%>
          
          
            
            
        </tr>      
        <%
            CcursoDAO SEDE = new CcursoDAO();
            ArrayList<CcursoDAO> LISTA = new ArrayList();
            LISTA = SEDE.lISTAR();
            

            for (int a1 = 0; a1 < LISTA.size(); a1++) {
                CuserDAO tem = new CuserDAO();
               tem=tem.escogerxid(LISTA.get(a1).getInstructor());

        %>
        <tr>
            <td class="tg-031e"><%=LISTA.get(a1).getCodigo() %></td>
            <td class="tg-031e"><b><%=LISTA.get(a1).getCurso()%></b></td>
            <td class="tg-031e"><%=LISTA.get(a1).getNivel() %></td>
            <td class="tg-031e"><%=LISTA.get(a1).getDias() %> Dias</td>
            <td class="tg-031e"><%=LISTA.get(a1).getDinicio()  %></td>
            <td class="tg-031e"><%=LISTA.get(a1).getDfinal() %></td>
            <td class="tg-031e"><%=LISTA.get(a1).getCupo() %></td>
            <td class="tg-031e"><%=tem.getNombre()+" "+tem.getApellido() %></td>
         <%if(estu){%>    <td class="tg-031e"><a target="_parent" href="controlcursos?inscripcion=<%=ObjUsuario.getCedula() %>&codigo=<%=LISTA.get(a1).getCodigo()  %>"><img src="img/inscripcion.png"></a></td><%}%>
        <%if(ins){%>    <td class="tg-031e"><a target="_parent" href="controlcursos?edita=<%=LISTA.get(a1).getCodigo()  %>"><img src="img/editar.png"></a></td><%}%>
           <%if(ins){%>     <td class="tg-031e"><a target="_parent" href="controlcursos?borra=<%=LISTA.get(a1).getCodigo()  %>"><img src="img/borrar.png"></a></td><%}%>
         </tr>    


        <%}
        %>  
       
        
    </table>   