
<%@page import="com.pms.dao.DAOusuario"%>
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
                document.getElementById("pagina").innerHTML = ("Administrador - Usuarios");
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
                    <th></th>
                    <th>Documento</th>
                    <th>Rol</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Genero</th>
                    <th>Edad</th>
                    <th>Direccion</th>
                    <th>Barrio</th>
                    <th>Ciudad</th>
                    <th>Nacimiento</th>
                    <th>Telefono</th>
                    <th>Editar</th>
                    <th>Borrar</th>

                </tr>
                <%
                    ArrayList<DAOusuario> lista = new ArrayList();
                    lista = DAOcursos.getUsuariostodos();

                    for (DAOusuario E : lista) {
                        if (E.getRol().getId() != 1) {

                %> 
                <tr>
                    <td><input type="radio" onclick="infoEstudiante('<%=E.getId()%>')" name="estudi"></td>
                    <td><%=E.getDocumento()%></td>
                    <td><%=E.getRol().getRol()%></td>
                    <td><%=E.getNombres()%></td>
                    <td><%=E.getApellidos()%></td>
                    <td><%=E.getGenero().getGenero()%></td>
                    <td><%=E.getEdad()%></td>
                    <td><%=E.getDireccion()%></td>
                    <td><%=E.getBarrio()%></td>
                    <td><%=E.getCiudad()%></td>
                    <td><%=E.getNacimiento()%></td>
                    <td><%=E.getTelefono()%></td>
                    <td><img src="img/edita.png"></td>
                    <td><img src="img/borra.png"></td>
                </tr>

                <%
                        }
                    }


                %>


            </table>
            <script type="text/javascript">


            var pager = new Pager('resultados', 6);
            pager.init();
            pager.showPageNav('pager', 'NavPosicion');
            pager.showPage(1);



            </script>

        </div>
    </body>
</html>
