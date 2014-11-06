
<%@page import="java.util.ArrayList"%>
<%@page import="com.pms.dao.DAOcitas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="inicio.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/paging.js"></script>
        <script>
            $(document).ready(function() {
                document.getElementById("pagina").innerHTML = ("Psicologo - Citas");
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
                    <th colspan="7">Citas de <%=user.getNombres()+" "+user.getApellidos() %></th>
                </tr>
                <tr>
                    <th>#</th>
                    <th>Estado</th>
                    <th>Estudiante</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Editar</th>
                    <th>Cancelar</th>
                </tr>
                <%
                    ArrayList<DAOcitas> citas = DAOcitas.getCitas();
                    for (DAOcitas c : citas) {
                        if(c.getPsicologo().getId().equals(user.getId()) || user.getRol().getId()==1 ){
                %>
                <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getEstudiante().getNombres() + " " + c.getEstudiante().getApellidos()%></td>
                    <td><%=c.getFecha() %></td>
                    <td><%=c.getHora() %></td>
                    <td><%=c.getObservacion() %></td>
                    <td></td>
                    <td></td>

                </tr>


                <%
                        }
                    }
                %>



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
