<%-- 
    Document   : calendario
    Created on : 7/05/2014, 09:31:34 PM
    Author     : Farith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="../include/general.css" />
        <link rel="stylesheet" type="text/css" href="../include/pro_drop_1.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
        <style>
            #cale table{
                border-collapse:collapse;border-spacing:0;


            }
            #cale th{

                font-family:Arial, sans-serif;
                font-size:14px;
                font-weight:normal;
                padding:10px 5px;
                border-style:solid;
                border-width:2px;
                overflow:hidden;
                word-break:normal;
                text-align: center;

            }
            #cale td{
                border-style: solid;
                border-width:1px;
                overflow:hidden;
                width:100px;
                height:50px;
                vertical-align:top;
                font-size:14px;

            }
            #mese table{
                border-collapse:collapse;border-spacing:0;


            }

            #mese td{
                border-style: solid;
                border-width:1px;
                overflow:hidden;
                width:100px;
                height:50px;
                text-align: center;
                font-size: 20px;


            }



        </style>
        <script>

         



            // CUANDO SE HACE CLICK EN UNA CASILLA 
            $(document).ready(function() {
                $("[id^=h]").click(function() {
                    caleoriginal()

                    var aa = this.innerHTML.split("=")
                    var idfecha = aa[1].substr(1, 10);
                   
                    this.style.backgroundColor = "#ffcc66"
                });
            });//editar este metodo para q acepte dias antes y despues

//sumar restar años
            $(document).ready(function() {
                $("[id=anomas]").click(function() {
                    var ano = document.getElementById("fecha3").innerHTML
                    var mes = document.getElementById("titulomes").innerHTML

                    cambiarMes((parseInt(ano) + 1) + "-" + mes + "-01");
                }),
                        $("[id=anomenos]").click(function() {
                    caleoriginal()
                    var ano = document.getElementById("fecha3").innerHTML
                    var mes = document.getElementById("titulomes").innerHTML

                    cambiarMes((parseInt(ano) - 1) + "-" + mes + "-01");

                })
                        ;
            });

// CUANDO SE ESCOGE EL MES SE CARGA 
            $(document).ready(function() {
                $("[id|=mes]").click(function() {
                    caleoriginal()
                    var esm = this.id.split("-");
                    var finm = esm[1].length == 1 ? "0" + esm[1] : esm[1]
                    var ano = document.getElementById("fecha3").innerHTML
                    cambiarMes(ano + "-" + finm + "-01");

                    $("[id=mese]").hide();
                    $("[id=cale]").show();
                    document.getElementById("titulomes").innerHTML = finm
                });
            });
//ANIMACIONES
            $(document).ready(function() {
                $("[id|=mes]").hover(function() {
                    this.style.backgroundColor = "#ffcc66"
                },
                        function() {
                            this.style.backgroundColor = "white"
                        });

            });
            $(document).ready(function() {
                $("[id^=a]").hover(function() {
                    this.style.backgroundColor = "#ffcc66"
                },
                        function() {
                            this.style.backgroundColor = "white"
                        });

            });

            $(document).ready(function() {
                $("[id|=escogermes]").hover(function() {

                    this.style.backgroundColor = "#ffcc66"
                }, function() {
                    this.style.backgroundColor = "white"
                }),
                        $("[id|=escogermes]").click(function() {

                    $("[id=mese]").show();
                })
                        ;

            });


            $(document).ready(function() {
                $("[id=escogermes],[id=an]").click(function() {

                    $("[id=cale]").toggle();
                    $("[id=mese]").show();

                });
            });
//FUNCION PARA CUANDO CARGA LA PAGINA -- OCULTA LOS MESES
            $(document).ready(function ACTUAL() {
                var hoy = new Date();
                if (hoy.getMonth() == 10 || hoy.getMonth() == 11) {
                    var Shoy = hoy.getFullYear() + "-" + (hoy.getMonth() + 1) + "-" + hoy.getDate();
                } else {
                    var Shoy = hoy.getFullYear() + "-0" + (hoy.getMonth() + 1) + "-" + hoy.getDate();
                }
                cambiarMes(Shoy)
                var mes = Shoy.split("-")
                $("[id=mese]").hide();
                document.getElementById("titulomes").innerHTML = mes[1]

                document.getElementById("fecha3").innerHTML = hoy.getFullYear()

            });

// CARGA EL DISEÑO ORIGINAL
            function caleoriginal() {

                for (var a1 = 0; a1 < 6; a1++) {
                    for (var a2 = 0; a2 < 7; a2++) {
                        var defau = "hueco" + a1 + "-" + a2;


                        if (a2 == 0 || a2 == 6) {
                            document.getElementById(defau).style.backgroundColor = "#99ccff"
                        } else {
                            document.getElementById(defau).style.backgroundColor = "white"
                        }
                    }
                }


            }
//CANTIDAD DE DIAS SEGUN EL MES Y AÑO
            function cant_ds(mes, ano) {


                di = 28
                f = new Date(ano, mes - 1, di);
                while (f.getMonth() == mes - 1) {
                    di++;
                    f = new Date(ano, mes - 1, di);
                }
                return di - 1;
            }
//CAJUSTA EL MES A LA CUADRICULA
            function cambiarMes(fecha2) {


                caleoriginal()
                var fecha = fecha2.split("-");
                var dia = fecha[2];
                var mes = fecha[1];
                var ano = fecha[0];

                var Hoy = new Date(ano, (mes - 1), '01');
                var Hoyhoy = new Date(ano, (mes - 1), dia);


                ConsultaRequerimiento(ano + "-" + mes);





                var Dia = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
                var Mes = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                        "Octubre", "Noviembre", "Diciembre");
                document.getElementById("fecha").innerHTML = "<h1>" + Mes[Hoyhoy.getMonth()] + "</h1>";
                document.getElementById("fecha3").innerHTML = +ano + "</h1>";


                var cantdias = cant_ds(mes, ano); //CANTIDAD DE DIAS SEGUN EL MES ESCOGIDO
                var cantdiasant = cant_ds((mes - 1), ano)//CANTIDAD DE DIAS SEGUN EL MES ANTERIOR AL ESCOGIDO

                var id2 // VARIABLE PARA PINTAR LOS DIAS ANTERIORES DEL MES
                var id //VARIABLE UTILIZADA PARA PINTAR LOS DIAS DEL MES
                var con = 1 //contador dias del mes
                var conotro = 1 // contador dias despues del mes
                var conotroantes = cantdiasant - (Hoy.getDay() - 1) //contador dias antes del mes



                for (var a1 = 0; a1 < 6; a1++) {
                    var a3 = 0;
                    var d = 0;//VARIABLE SE RECARGA EN CERO CON CADA INICIO DE FILA
                    for (var a2 = 0; a2 < 7; a2++) {
                        if (a1 == 0 && d == 0) {
                            a3 = Hoy.getDay();
                            d = 1;
                        }// proceso solo para la primera fila 
                        id = "hueco" + a1 + "-" + a3++;

                        id2 = "hueco" + a1 + "-" + a2;

                        if (a1 == 0 && a2 < Hoy.getDay()) {

                            conotroantes
                            document.getElementById(id2).innerHTML = conotroantes;
                            document.getElementById(id2).style.color = "grey"
                            conotroantes++

                        }
                        if (document.getElementById(id) != null) {

                            if (con == dia) {
                            } //pinta el DIA ESGOGIDO
                            var esteday = con < 10 ? "0" + con : con


                            document.getElementById(id).innerHTML = con + "<p id='" + ano + "-" + mes + "-" + esteday + "'></p>"
                            document.getElementById(id).style.color = "black"
                            con++

                        }

                        if (con > cantdias + 1) {

                            document.getElementById(id).innerHTML = conotro
                            document.getElementById(id).style.color = "grey"
                            conotro++
                        }// este if sigue pintando los dias del MES siguiente
                    }


                }
            }



//CONSULTA EL REQUERIMIENTO POR FECHA
            function ConsultaRequerimiento(fecha) {

               
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
                        settings = "height=70,width=410,top=" + TopPosition + ",left=" + LeftPosition + ",resizable=yes,scrollbars=0";
                    }

                    miPopup = window.open(Ventana, "miwin", settings)
                    miPopup.focus()
                }
            }


        </script>
    </head>

    <body onload="">
        <table class="principal">
            <col />
            <col />
            <col />
            <tbody>



                <tr>
                    <td colspan="2">
                        <table class="secundaria">
                            <col />	<col />	<col />	<col />	<col />	<col />	<col />
                            <tbody>
                                <form method="post" action=""  name="frContrequedia" onsubmit="validar_Solicitud_Requerimiento();">

                                    <tr>

                                        <td id="escogermes"  >
                                            <font id="fecha"></font>

                                        </td>
                                        <td  id="an">

                                            <center>
                                                <h1><font id="fecha3"></font></H1>
                                            </center>
                                        </td>
                                        <td  id="anomenos">

                                            <center><h1>-</h1>
                                                <p id="anoanterior"></p>
                                            </center>
                                        </td>
                                        <td  id="anomas">

                                            <center><h1>+</h1>
                                                <p id="anosiguiente"></p>
                                            </center>
                                        </td>



                                    </tr>



                                    <tr>
                                        <td colspan="4">
                                            <table id="cale" colspan="4">
                                                <tr>
                                                    <th>Domingo</th>
                                                    <th>Lunes</th>
                                                    <th>Martes</th>
                                                    <th>Miercoles</th>
                                                    <th>Jueves</th>
                                                    <th>Viernes</th>
                                                    <th>Sabado</th>

                                                </tr>
                                                <%

                                                    String CALENDARIO[][] = new String[6][7];
                                                    int contador = 1;
                                                    for (int i = 0; i < CALENDARIO.length; i++) {
                                                %>
                                                <tr id="fila<%=i%>">
                                                    <%
                                                        for (int j = 0; j < CALENDARIO[i].length; j++) {
                                                            CALENDARIO[i][j] = "" + (contador++);
                                                    %>

                                                    <td id="hueco<%=i + "-" + j%>">

                                                    </td>

                                                    <%
                                                        }
                                                    %>


                                                </tr>

                                                <%

                                                    }
                                                %>                                           


                                            </table><font color="white" id="titulomes"></font>
                                            <div id="mese">
                                                <table >
                                                    <tr>
                                                        <td id="mes-1" >Enero</td>
                                                        <td id="mes-2" >Febrero</td>
                                                        <td id="mes-3" >Marzo</td>
                                                        <td id="mes-4" >Abril</td>
                                                        <td id="mes-5" >Mayo</td>
                                                        <td id="mes-6" >Junio</td>
                                                    </tr>
                                                    <tr>
                                                        <td id="mes-7" >Julio</td>
                                                        <td id="mes-8" >Agosto</td>
                                                        <td id="mes-9" >Septiembre</td>
                                                        <td id="mes-10" >Octubre</td>
                                                        <td id="mes-11" >Noviembre</td>
                                                        <td id="mes-12" >Diciembre</td>
                                                    </tr>



                                                </table>


                                            </div>
                                        </td>
                                    </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>

            </tbody>
        </table>
    </body>
</html>
