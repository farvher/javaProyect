
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.CproductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
    function enviar() {

        document.nuevoproducto.submit();

    }
    function soloNumeros(e) {
        var key = window.Event ? e.which : e.keyCode
        return ((key >= 48 && key <= 57) || (key == 8) || (key == 13))
    }
</script>
<% if (request.getParameter("nuevoproducto") != null) {
        CproductoDAO PRODUCTO = new CproductoDAO();

        int id = Integer.parseInt(request.getParameter("nuevoproducto"));
        PRODUCTO = PRODUCTO.Escoger(id);
        int ren = (int) (Math.random() * 9999 + 1);
        boolean existe = PRODUCTO.getId_producto() != 0 ? true : false;
        String titulo = existe ? "Actualizar" : "Nuevo";

%>
<head>
    <link rel="stylesheet" href="css/estilo.css" type="text/css">
</head>
<body>
    <table>
        <form name="nuevoproducto" action="Controlproducto" onsubmit="enviar()">
            <tr><th colspan="2"><h2><%=titulo%> Producto</h2></th></tr>
            <tr>
                <td>Codigo</td>
                <td><% if (existe) {
                        out.print(PRODUCTO.getId_producto());
                    } else {
                        out.print(ren);
                    }%>
                    <input type="hidden" name="codigo" value="<% if (existe) {
                            out.print(PRODUCTO.getId_producto());
                        } else {
                            out.print(ren);
                        }%>"></td>
            </tr>
            <tr>
                <td>Producto</td>
                <td><input type="text" required name="producto" value="<% if (existe) {
                        out.print(PRODUCTO.getProducto());
                    }%>"></td>
            </tr>
            <tr>
                <td>Precio</td>
                <td><input onKeyPress="return soloNumeros(event)" type="text" required name="precio" value="<% if (existe) {
                        out.print(PRODUCTO.getPrecio());
                    }%>"></td>
            </tr>
            <tr>
                <td>Medida</td>
                <td><select name="medida">
                        <option value="unidad">Unidad</option>
                        <option value="kilo">Kilo</option>
                        <option value="libra">Libra</option>
                        <option value="paquete">Paquete</option>
                        <option value="litro">Litro</option>
                    </select></td>
            </tr>
            <tr>
                <td></td>
                <td> <input type="submit"  name="boton" value="<% if (existe) {
                        out.print("Actualizar");
                    } else {
                        out.print("Crear");
                    }%>"></td>
            </tr>

        </form>
    </table>

</body>


<%    } else if (request.getParameter("mensaje") != null) {
    String men = request.getParameter("mensaje");
%>
<h2><%=men%><br><a onclick="window.opener.location.reload(), window.close();"href="#">Volver</h2>
    <%

    } else if (request.getParameter("venta") != null) {
        int venta = Integer.parseInt(request.getParameter("venta"));
        int total = Integer.parseInt(request.getParameter("total"));
        Date hoy = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    %>
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<script src="js/validacion.js"></script>
<script src="js/jquery.js"></script>
<table>
    <form name="venta" action="Controlventa">
        <tr>
            <th colspan="2"> <h2>Datos de la Venta</h2></th>
        </tr>
        <tr>
            <td>Venta Numero</td>
            <td><%=venta%><input type="hidden" name="venta" value="<%=venta%>"></td>
        </tr>
        <tr>
            <td>CC Cliente</td>
            <td><input type="text" onKeyPress="return soloNumeros(event)" maxlength="11"  name="cliente" required></td>
        </tr>
        
        <tr>
            <td>Forma de Pago</td>
            <td><select name="pago" >
                    <option value="efectivo">Efectivo</option>
                    <option value="credito">Credito</option>
                    
                </select>
            </td>

        </tr>
        <tr>
            <td>Fecha</td>
            <td><%=sdf.format(hoy)%></td>
        </tr>
        <tr>
            <td>Total</td>
            <td>$<%=total%><input type="hidden" name="total" value="<%=total%>"></td>

        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="boton" value="Comprar">
                <a href="#" onclick="window.close()">Cancelar</a>
            </td>

        </tr>
</table>



<%
} else if (request.getParameter("registrarse") != null) {

%>
<head>
    <link rel="stylesheet" href="css/estilo.css" type="text/css">
    <script >
    function validauser() {


        var documento, nombre, apellido, contrasena, vcontrasena, email, telefono, sexo;
        var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        var error;
        contrasena = document.getElementById("contrasena").value;
        vcontrasena = document.getElementById("vcontrasena").value;
        documento = document.getElementById("cedula").value;
        nombre = document.getElementById("nombre").value;
        apellido = document.getElementById("apellido").value;
        email = document.getElementById("email").value;
        telefono = document.getElementById("telefono").value;
        sexo = document.getElementById("sexo").value;
        if (documento.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese el documento</font>"
            return false
        } else
        if (nombre.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese su Nombre</font>"
            return false

        }
        else
        if (apellido.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese su Apellido</font>"
            return false

        }
        else
        if (contrasena.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese una Contraseña</font>"
            return false

        }
        else
        if (vcontrasena.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Repita su Contraseña</font>"
            return false

        }
        else
        if (contrasena != vcontrasena) {
            document.getElementById("error").innerHTML = "<font color='red'>Contraseñas no Coinciden</font>"
            return false

        }

        else
        if (email.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese un correo </font>"
            return false

        } else
        if (!expr.test(email)) {
            document.getElementById("error").innerHTML = "<font color='red'>Correo NO VALIDO </font>"
            return false

        }
        else
        if (telefono.length == 0) {
            document.getElementById("error").innerHTML = "<font color='red'>Ingrese un telefono</font>"
            return false

        } else {

            document.registro.submit();



        }




    }
    </script>
    <script src="js/jquery.js"></script>
</head>
<body background="img/imagenfondo.jpg">
    <table class="tg" style="background-color: white">
        <form name="registro" action="nuevouser">
            <tr>
                <th colspan="2"><center>Registro<br > <font size="1"><i>Campos requeridos</i></font><font size="1" color="red">*</font> </center> </th>

            </tr>


            <tr>


                <td>
                    <input type="text"  name="cedula" id="cedula" onKeyPress="return soloNumeros(event)" placeholder="documento" maxlength="12" value="" />
                    <font size="1" color="red">*</font>
                </td> 
                <td></td>
            </tr>
            <tr>

                <td><input type="text" id="nombre" name="nombre" placeholder="nombre"  maxlength="15" value="" /> <font size="1" color="red">*</font> </td>
                <td></td>
            </tr>
            <tr>

                <td><input type="text"  id="apellido" name="apellido" placeholder="Apellido" maxlength="15" value="" /> <font size="1" color="red">*</font></td>
                <td></td>
            </tr>


            <tr>

                <td><input  type="password" id="contrasena"  name="contrasena" placeholder="contraseña"   maxlength="8" value="" />
                    <font size="1" color="red">*</font>
                </td>
                <td></td>
            </tr>
            <tr>

                <td><input  type="password" id="vcontrasena"   name="vcontrasena" placeholder="Confirmar contraseña "   maxlength="8" value="" />
                    <font size="1" color="red">*</font>
                </td>
                <td></td>
            </tr>


            <tr>

                <td><input  type="text" id="email"  name="email"  placeholder="Email" maxlength="30" value=""> <font size="1" color="red">*</font></td>

                <td><span>hombre</span>
                    <input type ="radio" checked id="sexo"name="sexo" value="hombre"></td>
            </tr>
            <tr>

                <td><input type="text" id="telefono"   name="telefono" placeholder="telefono" onKeyPress="return soloNumeros(event)" maxlength="10" value="" />
                    <font size="1" color="red">*</font>
                </td>
                <td><span>mujer</span>
                    <input type ="radio" id="sexo"name="sexo" value="mujer"></td>
            </tr>
            <tr>

                <td> 
                    <p id="error"></p> 

                </td>
                <td>  <input type="button" onclick="validauser()" value="Enviar"></td>
            </tr>

        </form>
    </table>


    <%    }

    %>