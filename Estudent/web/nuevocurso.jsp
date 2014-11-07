<%-- 
    Document   : nuevocurso
    Created on : 20/03/2014, 02:40:12 PM
    Author     : andres
--%>

<%@page import="Modelo.CcursoDAO"%>
<%@page import="Modelo.Ccurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabezera.jsp" %>
<div id="areatrabajo">
    <br>
    <center>
        <table style="width:60%;" class="tg">
            <form action="controlcursos" method="post">
                <%if (request.getAttribute("CURSO") == null) {%>
                <tr>
                    <th colspan="2">Nuevo Curso</th>

                </tr>
                <tr><% int ale = (int) (Math.random() * 99999 + 10000);%>
                    <td>Codigo</td>
                    <td><%=ale%><input type="hidden" name="codigo"  value="<%=ale%>" ></td>
                </tr>
                <tr>
                    <td>Nombre del Curso</td>
                    <td><input type="text" name="curso" required maxlength="20"></td>
                </tr>
                <tr>
                    <td> Descripcion </td>
                    <td><input type="text"   required maxlength="40" name="descripcion"></td>
                </tr>
                <tr>
                    <td  >Fecha de Inicio</td>
                    <td  > 
                        <input type="date" id="hdesde"  required onchange="validarFecha(this.value, this.name)" name="hdesde">
                      
                   
                </tr> 
                <tr>
                    <td  >Fecha de finalizacion</td>
                    <td > 
                        <input type="date" id="hhasta"  required  onchange="validarFecha(this.value, this.name)" name="hhasta">
                        
                </tr>  
                
                <tr>
                    <td> Cantidad de Dias</td>
                    <td><p id="error5">Dias</p></td><!--input name totaldias-->
                </tr>
                 
                <tr>
                    <td>Cupo Maximo</td>
                    <td>
                        <input type="text"  required maxlength="3" onKeyPress="return soloNumeros(event)" name="cupo"  >
                    </td>
                </tr>
                <tr>
                    <td><input type="hidden" name="instructor" value="<%=ObjUsuario.getCedula() %>"></td>
                    <td><input type="submit" name="boton"  value="Crear"></td>
                </tr>
                <%} else { }%>
            </form>
        </table>
    </center>


</div>