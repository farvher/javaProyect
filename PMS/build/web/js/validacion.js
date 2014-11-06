/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaform() {

    var formu = document.getElementById("formregistro");

    for (var a1 = 0; a1 < formu.length; a1++) {
        if (formu.elements[a1].value == "") {
            document.getElementById("errorl").innerHTML = "<font color='red'>" + ("Complete el campo " + formu.elements[a1].id) + "</font>"
            formu.elements[a1].focus();
            return false;
        }


    }
    var pass = document.getElementById("clave").value;
    var repass = document.getElementById("reclave").value;

    if (pass != repass) {
        alert("Las contraseñas no coinciden");
        document.getElementById("reclave").focus();
        return false;
    }
    if (pass.length < 6) {
        alert("Las contraseñas debe contener minimo 6 caracteres ");
        document.getElementById("clave").focus();
        return false;
    }


    return true;
}
function registrarme() {
    var url = "registro.jsp"
    $.get(url, function(data, status) {
        document.getElementById("login").innerHTML = data

    });

}
function validarEmail(email) {
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!expr.test(email)) {
        document.getElementById("correo").style.color = "red"
        return false;
    } else {
        document.getElementById("correo").style.color = "black"
        return true;
    }

}

var miPopup
{
    function abreVentana(Ventana, configuraciones)
    {
        LeftPosition = (screen.width) ? (screen.width - 300) / 2 : 0;
        TopPosition = (screen.height) ? (screen.height - 70) / 2 : 0;

        settings = configuraciones;
        if (configuraciones == '1')
        {
            settings = "top=" + TopPosition + ",height=400,width=1000,left=200,resizable=yes,scrollbars=0";
        } else if (configuraciones == '2') {

            settings = "top=200,height=450,width=400,left=500,resizable=yes,scrollbars=0";
        }

        miPopup = window.open(Ventana, "miwin", settings)
        miPopup.focus()
    }
    function infoCurso(id) {
        var url = "ajax_profesor.jsp?idcurso=" + id
        $.get(url, function(data, status) {
            document.getElementById("content").innerHTML = data;
        });

    }
    function infoEstudiante(id) {
        var url = "ajax_profesor.jsp?idestudiante=" + id
        $.get(url, function(data, status) {
            document.getElementById("content").innerHTML = data;
        });

    }
}
