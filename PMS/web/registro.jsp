
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilo.css" type="text/css">
        <script src="js/validacion.js"></script>
        <script src="js/jquery.js"></script>
    </head>
    <body>
        <div>
            <form  action="Registro" id="formregistro" method="POST" onsubmit="return validaform()" >
                <div id="errorl"></div>
                <table id="registro" >
                    <tr>
                        <td colspan="2"><H2>Formulario de registro</H2></td>
                    </tr>
                    <tr>
                        <td>Documento</td>
                        <td><input type="text" id="documento" name="documento" ></td>
                    </tr>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" id="nombres" name="nombres"></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" id="apellidos" name="apellidos"></td>
                    </tr>
                    <tr>
                        <td>Fecha de Nacimiento</td>
                        <td><input type="date" style="width:170px ;" id="nacimiento" name="nacimiento"></td>
                    </tr>
                    <tr>
                        <td>Genero</td>
                        <td>
                            <select id="genero" style="width:190px ;" name="genero">
                                <option value="1">Hombre</option>
                                <option value="2">Mujer</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Direccion</td>
                        <td><input type="text" id="direccion" placeholder="Direccion de domicilio" name="direccion"></td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td><input type="text" id="telefono" placeholder="Celular o fijo" name="telefono"></td>
                    </tr>
                    <tr>
                        <td>Correo</td>
                        <td><input type="text" id="correo" onkeyup ="validarEmail(this.value)" placeholder="example@correo.com" name="correo"></td>
                    </tr>
                    <tr>
                        <td>Ciudad</td>
                        <td><input type="text" id="ciudad" name="ciudad"></td>
                    </tr>
                    <tr>
                        <td>Barrio</td>
                        <td><input type="text" id="barrio" name="barrio"></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>  
                        <td><input type="password" id="clave" name="clave"></td>  
                    </tr>
                    <tr>
                        <td>Confirmar Contraseña</td>  
                        <td><input type="password" id="reclave"></td>  
                    </tr>
                    <tr>
                        <td>
                            <a onclick="window.location.href='index.jsp' " href="#">Ingresar</a><br>
                            
                        </td>  
                        <td><input type="submit" value="Registrarme" name="regis"></td>  
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
