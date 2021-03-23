<%-- 
    Document   : catchExceptions
    Created on : Mar 23, 2021, 11:09:56 AM
    Author     : Belmiro-Mungoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="../jQueryScripts/jquery.min.js" type="text/javascript"></script>
        <title>Capturando uma Excepcao</title>
    </head>
    <body>
        <h1>Capturando uma Excepcao com Jquery</h1>
        <label for="teste">Insira Alguma Coisa</label>
        <input type="text" id="testee" name="teste">
        <button onclick="teste()">Capturar</button>
    </body>
    <script type="text/javascript" src="../js/catchExceptions.js"></script>
</html>
