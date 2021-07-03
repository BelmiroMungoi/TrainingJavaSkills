<%-- 
    Document   : datas
    Created on : Jul 2, 2021, 11:00:43 AM
    Author     : bbm29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculo de Datas</title>
        <link rel="stylesheet" href="../css/jquery-ui.css">
        <script src="../jQueryScripts/jquery.min.js" type="text/javascript"></script>
        <script src="../jQueryScripts/jquery-ui.js"></script>
    </head>
    <body>
        <h1>Calculo de Datas</h1> 
        <form action="calcularData" method="post">
            <label for="initialDate">Data Inicial:</label>
            <input type="text" id="initialDate" name="initialDate">

            <label for="finalDate">Tempo Em Horas</label>
            <input type="text" id="time" name="time">

            <button type="submit">Calcular</button>
        </form>
        <br/>
        <label for="finalDate">Data Final:</label> 
        <input type="text" id="final" name="finalDate" readonly="readonly" 
               value="${finalData}">

        <label for="dias">Total de Dias:</label> 
        <input type="text" id="dias" name="dias" readonly="readonly" value="${dias}">
        
    </body>
    <script>
        $( function() {
            $( "#initialDate" ).datepicker({dateFormat: 'dd/mm/yy'});
        } );
    </script>
</html>
