
<%@page import="java.util.ArrayList"%>
<%@page import="com.pms.dao.DAOusuario"%>
<%@page import="com.pms.dao.DAOcursos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="#" onclick="javascript:window.location.reload()">Volver</a>
<% DAOusuario user = new DAOusuario();
    if (session.getAttribute("usuario") == null) {
        user = (DAOusuario) session.getAttribute("usuario");
    }

    if (request.getParameter("idcurso") != null) {

        DAOcursos C = DAOcursos.getCursos(Integer.parseInt(request.getParameter("idcurso")));

%>

<table style="border: 1px solid green">
    <tr>
        <th colspan="5"><b><i>Curso Escogido</i></b></th>
    </tr>
    <tr>
        <th></th>
        <th>#</th>
        <th>Curso</th>
        <th>Descripcion</th>
        <th>Cantidad Estudiantes</th>
    </tr>

    <tr>
        <td><input type="radio"></td>
        <td><%=C.getId()%></td>
        <td><%=C.getCurso()%></td>
        <td><%=C.getDescripcion()%></td>
        <td><%=DAOcursos.getEstudiantesDelCurso(C.getId()).size()%></td>

    </tr>
    <tr>
        <td colspan="5">
            <table >
                     <tr><th colspan="11">Estudiantes Inscritos en el curso</th></tr>
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
                    <th>Nacimiento</th>
                </tr>
                <%
                    ArrayList<DAOusuario> lista = new ArrayList();
                    lista = DAOcursos.getEstudiantesDelCurso(C.getId());

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
                    <td><%=E.getNacimiento()%></td>
                </tr>

                <%
                    }



                %>

            </table>


        </td>
    </tr>
</table>
<%
} else if (request.getParameter("idestudiante") != null) {

    DAOusuario E = new DAOusuario();

    E = DAOusuario.getUsuario(Integer.parseInt(request.getParameter("idestudiante")));

%>

<table style="border: 1px solid blue">
    <tr>
        <th colspan="11"><b><i>Estudiante Escogido</i></b></th>
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
        <th>Nacimiento</th>
    </tr>
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
        <td><%=E.getNacimiento()%></td>
    </tr>
    <tr>
        <td colspan="11">
            <table>
                <tr><th colspan="5">Cursos Donde se Encuentra Inscrito</th></tr>
                <tr><th></th>
                    <th>#</th>
                    <th>Curso</th>
                    <th>Descripcion</th>
                    <th>Cantidad Estudiantes</th>
                </tr>
                <%
                    ArrayList<DAOcursos> lista = new ArrayList();
                    lista = DAOcursos.getCursosdelEstudiante(Integer.parseInt(request.getParameter("idestudiante")));

                    for (DAOcursos C : lista) {


                %> 
                <tr>
                    <td><input type="radio" onclick="infoCurso('<%=C.getId()%>')"></td>
                    <td><%=C.getId()%></td>
                    <td><%=C.getCurso()%></td>
                    <td><%=C.getDescripcion()%></td>
                    <td><%=DAOcursos.getEstudiantesDelCurso(C.getId()).size()%></td>

                </tr>

                <%

                    }


                %>
                <tr>

                </tr>


            </table>
        </td>
    </tr>
</table>
<%
    }
%>


