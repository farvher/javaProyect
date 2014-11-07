<%-- 
    Document   : asistencia
    Created on : 17-mar-2014, 11:27:53
    Author     : Aprendiz
--%>

<%@page import="Modelo.CcursoDAO"%>
<%@page import="Modelo.CuserDAO"%>
<%@page import="Modelo.CasisteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabezera.jsp"%>
<div id="areatrabajo">
    <%
        java.util.Date hoy2 = new java.util.Date();
        SimpleDateFormat sy2 = new SimpleDateFormat("yyyy-MM-dd");
        String fecha2 = sy2.format(hoy2);
        CasisteDAO ASISTE = new CasisteDAO();

        if (request.getAttribute("fecha") != null) {
            String fechaalter = (String) request.getAttribute("fecha");
            fecha2 = fechaalter;

        }
    %>
    <br>
    <div id="buscar">
        <h1>Asistencias para <%=fecha2%></h1>  

        <form style="float:right;" action="#">
            <input type="text" name="documento" Style="width:200px;" placeholder="Buscar por Documento" maxlenght="10">
            <input type="submit" name="boton" value="Buscar">
        </form> 
    </div>
    <center>
        <form  action="controlasistencia" method="post"> 
            <table style="width:50%;" class="tg">
                <tr>

                    <td>

                        <input type="hidden" name="user" value="<%=ObjUsuario.getCedula()%>">
                        <input type="hidden" name="curso" value="<%=ObjUsuario.getCurso()%>">
                        <i>  Escoge un curso para tomar Asistencia</i>
                        <select id="cursos" width="100" onchange="estudiantes(this.value)">
                            <%
                                CcursoDAO SEDE = new CcursoDAO();
                                ArrayList<CcursoDAO> LISTA = new ArrayList();
                                LISTA = SEDE.lISTARCINSTRUCTOR(ObjUsuario.getCedula());
                                out.print("<option>---</option>");
                                for (int a1 = 0; a1 < LISTA.size(); a1++) {

                                    out.print("<option value='" + LISTA.get(a1).getCodigo() + "'>" + LISTA.get(a1).getCurso() + "</option>");

                                }
                                if (LISTA.size() == 0) {
                                    out.print("<option>No has creado Ningun curso</option>");
                                }%>

                        </select>



                    </td>
                </tr>


            </table> 
        </form> 
    </center>


    <table class="tg" id="consulta">
        <tr>
            <th class="tg-031e">Documento</th>
            <th class="tg-031e">Nombre</th>
            <th class="tg-031e">Apellido</th>

            <th class="tg-031e">Estado</th>





        </tr>      



    </table>     


</div>