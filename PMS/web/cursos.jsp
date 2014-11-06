
<%@page import="com.pms.dao.DAOcursos"%>
<%@page import="com.pms.dto.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pms.dao.DAOnovedades"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="inicio.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/paging.js"></script>
        <script>
            $(document).ready(function() {
                document.getElementById("pagina").innerHTML = ("Profesor - Cursos");
            });
        </script>
    </head>
    <body>
        <div id="menuiz">


        </div>
        <div id="content">
            <div style=" border: 0px;" id="NavPosicion"></div>
            <table  id="resultados">  
               <tr>
                    <th colspan="8">Cursos <% if(user.getRol().getId()==5){ out.print("del profesor "+user.getNombres()+" "+ user.getApellidos());}%></th>
                </tr>
                <tr><th></th>
                    <th>#</th>
                    <th>Curso</th>
                    <th>Descripcion</th>
                    <th>Cantidad Estudiantes</th>
                </tr>
                <%
                    ArrayList<DAOcursos> lista = new ArrayList();
                    lista = DAOcursos.getCursos();
                  

                    for (DAOcursos C : lista) {
                        if (C.getUsuarios().getId().equals(user.getId()) || user.getRol().getId()==1 || user.getRol().getId()==2) {

                %> 
                <tr>
                    <td><input type="radio" onclick="infoCurso('<%=C.getId()%>')" name="curs"></td>
                    <td><%=C.getId()%></td>
                    <td><%=C.getCurso()%></td>
                    <td><%=C.getDescripcion()%></td>
                    <td><%=DAOcursos.getEstudiantesDelCurso(C.getId()).size()%></td>

                </tr>

                <%
                        }
                    }


                %>
                <tr>

                </tr>


            </table>
            <script type="text/javascript">


                       var pager = new Pager('resultados', 8);
                       pager.init();
                       pager.showPageNav('pager', 'NavPosicion');
                       pager.showPage(1);



            </script>

        </div>
    </body>
</html>
