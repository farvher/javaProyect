<%-- 
    Document   : trae
    Created on : 27/07/2014, 04:57:37 PM
    Author     : Farith S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.js"></script>
        <title>JSP Page</title>
        <script> 
        function traer(id){
            
            $("#selec").css("b
            
        }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <select onchange="traer(this.value)">
            <option value="1">op1</option>
            <option value="2">op2</option>
            <option value="3">op3</option>
            <option value="4">op4</option>
            <option value="5">op5</option>
            
        </select>
        <div style="border:1px solid black;width:100px;height:200px;" id="selec">
            contenido a cambiar
            
        </div>
    </body>
</html>
