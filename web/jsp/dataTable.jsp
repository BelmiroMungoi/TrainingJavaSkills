<%-- 
    Document   : dataTable
    Created on : Jun 19, 2021, 3:19:42 PM
    Author     : bbm29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/dataTables.min.css">
        <script src="../jQueryScripts/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="../jQueryScripts/dataTables.min.js" type="text/javascript"></script>
        <title>DataTable jQuery</title>
    </head>
    <body>
        <h1>DataTable Com jQuery</h1>
        <table id="table" class="display" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Nome</td>
                    <td>Idade</td>
                    <td>PassWord</td>
                </tr>
            </thead>
        </table>
    </body>
    <script>
        $(document).ready(function(){
            $("#table").DataTable( {
                "processing": true,
                "serverSide": true,
                "ajax": "loadData" // retorna a resposta do servidor
            });
        } );
    </script>
</html>
