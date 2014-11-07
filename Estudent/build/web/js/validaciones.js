function validarFecha(fecha2, campo) {

    try {
        var frsuper = document.frsupernumerario;
        var fecha = fecha2.split("-");
        var dia = parseInt(fecha[2]);
        var mes = parseInt(fecha[1]);
        var ano = fecha[0];
        var hoy = new Date();
        var fechaDate = new Date(ano, mes, dia);
        if (hoy.getFullYear() <= ano)
        {
            if (hoy.getFullYear() == ano)
            {
                if (mes >= (hoy.getMonth() + 1)) {
                    if ((hoy.getMonth() + 1) == mes) {
                        if (hoy.getDate() <= dia) {
                        } else {
                            document.getElementById("error5").innerHTML = "<font color='red'>  fecha no valida</font>";
                            if (campo == "hdesde") {
                                return document.getElementById("hdesde").value = ""
                            } else {
                                return document.getElementById("hhasta").value = ""
                            }
                            ;
                        }
                    } else {
                    }
                } else {
                    document.getElementById("error5").innerHTML = "<font color='red'> fecha no valida</font>";
                    if (campo == "hdesde") {
                        return document.getElementById("hdesde").value = ""
                    } else {
                        return document.getElementById("hhasta").value = ""
                    }
                    ;
                }
            } else {
            }
        } else {
            document.getElementById("error5").innerHTML = "<font color='red'> fecha no valida</font>";
            if (campo == "hdesde") {
                return document.getElementById("hdesde").value = "";
            } else {
                return document.getElementById("hhasta").value = "";
            }
            ;
        }




    } catch (error)
    {
        alert(error);
    }
    if (document.getElementById("hdesde").value != "" && document.getElementById("hhasta").value != "") {

        var fechadesde = document.getElementById("hdesde").value.split("-");
        var fechahasta = document.getElementById("hhasta").value.split("-");

        var dia1 = parseInt(fechadesde[2]);
        var mes1 = parseInt(fechadesde[1]);
        var ano1 = fechadesde[0];

        var dia2 = parseInt(fechahasta[2]);
        var mes2 = parseInt(fechahasta[1]);
        var ano2 = fechahasta[0];

        var fecha1 = new Date(ano1, mes1, dia1);
        var fecha2 = new Date(ano2, mes2, dia2);


        var diasDif = fecha2.getTime() - fecha1.getTime();
        var dias = Math.round(diasDif / (1000 * 60 * 60 * 24));
        if (dias == 0) {
            dias = 1;
        }
        if (dias < 0) {
            document.getElementById("error5").innerHTML = "<font color='red'>fecha no valida</font>";
            if (campo == "hdesde") {
                return document.getElementById("hdesde").value = "";
            } else {
                return document.getElementById("hhasta").value = "";
            }
            ;
        } else {

            return document.getElementById("error5").innerHTML = dias


        }
    }

}

function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode
    return ((key >= 48 && key <= 57) || (key == 8) || (key == 13))
}

function estudiantes(curso) {
    var url = "ajaxConsulta.jsp?curso=" + curso

    $.get(url, function(data, status) {


        document.getElementById("consulta").innerHTML = data
    });



}


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

    }else{
    
    document.registro.submit();
    
    
    
    }




}

function check(id){
    
    alert(id);
    
}