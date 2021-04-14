<%-- 
    Document   : firstPage
    Created on : Apr 14, 2021, 11:25:08 PM
    Author     : Belmiro-Mungoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Pai</title>
        <script src="../jQueryScripts/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
    <center>
        <h1>Pagina pai que fara o load Page</h1>
        <button onclick="loadPage();">Load Page</button>
        <div id="loadSecondPage">

        </div>
    </center>

    <script type="text/javascript">
        function loadPage() {
            $("#loadSecondPage").load('secondPage.jsp');
        }
    </script>
</body>
</html>
