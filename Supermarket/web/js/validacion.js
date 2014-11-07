/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function elimina() {

    var e = confirm('Desea eliminar este producto?');
    return e;
}



var miPopup
{
    function abreVentana(Ventana, configuraciones)
    {
        LeftPosition = (screen.width) ? (screen.width - 410) / 2 : 0;
        TopPosition = (screen.height) ? (screen.height - 70) / 2 : 0;

        settings = configuraciones;
        if (configuraciones == '1')
        {
            settings = "height=330  ,width=410,top=100,left=" + LeftPosition + ",resizable=yes,scrollbars=0";
        }else if (configuraciones == '2'){
             settings = "height=480  ,width=410,top=100,left=" + LeftPosition + ",resizable=yes,scrollbars=0";
            
        }

        miPopup = window.open(Ventana, "miwin", settings)
        miPopup.focus()
    }
}
function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode
    return ((key >= 48 && key <= 57) || (key == 8) || (key == 13))
}

function traerproductos(id, factura) {

    var url = "consultas.jsp?productos=" + id + "&fact=" + factura
    var url2 = "consultas.jsp?factura=" + factura
    $.get(url, function(data, status) {

        document.getElementById("cambioproductos").innerHTML = data;
    });
    $.get(url2, function(data, status) {

        document.getElementById("cambioingresados").innerHTML = data;
    });

}
function agregar(producto, factura) {
    var url = "Controlventa?profact=" + factura + "&pro=" + producto;
    $.get(url, function(data, status) {

    });
    var url2 = "consultas.jsp?factura=" + factura
    $.get(url2, function(data, status) {

        document.getElementById("cambioingresados").innerHTML = data;
    });


}
function Reiniciar(factura) {

    var url = "Controlventa?borrar=" + factura
    $.get(url, function(data, status) {

    });
    var url2 = "consultas.jsp?factura=" + factura
    $.get(url2, function(data, status) {

        document.getElementById("cambioingresados").innerHTML = data;
    });

}

function comprar(fact, total) {
    var url = "ventana.jsp?venta=" + fact + "&total=" + total
    abreVentana(url, "2");
}
function finalizoventa() {
    window.close();
    window.opener.href = "factura.jsp"

}
function verventa(id) {

    var url2 = "consultas.jsp?idfactura=" + id
    $.get(url2, function(data, status) {

        document.getElementById("content").innerHTML = data;
    });

}

function habilitar(id) {

    var url2 = "consultas.jsp?habilitar=" + id
    $.get(url2, function(data, status) {

        window.location.reload();
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