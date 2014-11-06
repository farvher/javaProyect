
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
                document.getElementById("pagina").innerHTML = ("Profesor - Novedades");
            });
        </script>
    </head>
    <body>
        <div id="menuiz">
            <form>

                <input type="search" id="buscarnovedad" style ="width:90%;" placeholder="Buscar Novedad">

                <input type="submit" value="Buscar">


            </form>

        </div>
        <div id="content">
            <div style=" border: 0px;" id="NavPosicion"></div>
            <table  id="resultados">

                <tr>
                    <td><a href="novedades.jsp?estado=3"><img src="img/gris.png">Pendiente</a></td>
                    <td><a href="novedades.jsp?estado=5"><img src="img/verde.png">En proceso</a></td>
                    <td><a href="novedades.jsp?estado=6"><img src="img/amarillo.png">Cumplidas</a></td>
                    <td><a href="novedades.jsp?estado=4"><img src="img/rojo.png">Cancelado</a></td>
                </tr>
                <tr>
                    <th colspan="8">Novedades <% if(user.getRol().getId()==5){ out.print("del profesor "+user.getNombres()+" "+ user.getApellidos());}%></th>
                </tr>
                <tr>
                    <th># Novedad</th>
                    <th>Estado</th>
                    <th>Estudiante</th>
                    <th>Fecha Creado</th>
                    <th>Tipo Novedad</th>
                    <th>Observacion</th>
                    <th>Editar</th>
                    <th>Cancelar</th>
                </tr>
                <%
                    ArrayList<DAOnovedades> lista = new ArrayList();
                    if (request.getParameter("estado") != null) {
                        lista = DAOnovedades.getNovedadesEstado(request.getParameter("estado"));
                    } else {
                        lista = DAOnovedades.getNovedades();
                    }
                    for (DAOnovedades n : lista) {
                        if (n.getProfesor().getId().equals(user.getId()) || user.getRol().getId() == 2|| user.getRol().getId() == 1) {
                %>
                <tr>
                    <td><%=n.getId()%></td>
                    <td><img src="img/<%= DAOnovedades.getEstadoN(n.getEstado())%>.png"></td>
                    <td><%=n.getEstudiante().getNombres() + " " + n.getEstudiante().getApellidos()%></td>
                    <td><%=n.getFecha()%></td>
                    <td><%=n.getTipoNovedad().getTipoNovedad()%></td>
                    <td><%=n.getObservacion()%></td>
                    <td><img src="img/edita.png"></td>
                    <td><img src="img/borra.png"></td>
                </tr>


                <%
                        }


                    }


                %>

            </table>

            <script type="text/javascript">


                var pager = new Pager('resultados', 7);
                pager.init();
                pager.showPageNav('pager', 'NavPosicion');
                pager.showPage(1);



            </script>
        </div>
    </body>
</html>
