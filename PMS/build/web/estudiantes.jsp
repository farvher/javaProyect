
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
                document.getElementById("pagina").innerHTML = ("Profesor - Estudiantes");
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
                    <th colspan="12">Estudiantes <% if(user.getRol().getId()==5){ out.print("del profesor "+user.getNombres()+" "+ user.getApellidos());}%></th>
                </tr>
                <tr>
                    <th></th>
                    <th>Documento</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Genero</th>
                    <th>Correo</th>
                    <th>Edad</th>
                    <th>Direccion</th>
                    <th>Barrio</th>
                    <th>Ciudad</th>
                    <th>Telefono</th>
                </tr>
                <%
                    ArrayList<DAOusuario> lista = new ArrayList();
                    lista = DAOcursos.getEstudiantesDelProfesor(user.getId());
                    if(user.getRol().getId()==1 ||user.getRol().getId()==1 ){
                    
                    lista = DAOcursos.getEstudiantes();
                    }

                    for (DAOusuario E : lista) {

                %> 
                <tr>
                    <td><input type="radio" onclick="infoEstudiante('<%=E.getId()%>')" name="estudi"></td>
                    <td><%=E.getDocumento()%></td>
                    <td><%=E.getNombres()%></td>
                    <td><%=E.getApellidos()%></td>
                    <td><%=E.getGenero().getGenero()%></td>
                    <td><%=E.getCorreo()%></td>
                    <td><%=E.getEdad()%></td>
                    <td><%=E.getDireccion()%></td>
                    <td><%=E.getBarrio()%></td>
                    <td><%=E.getCiudad()%></td>
                    <td><%=E.getTelefono()%></td>
                </tr>

                <%
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
