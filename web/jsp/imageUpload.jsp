<%-- 
    Document   : imageUpload
    Created on : May 27, 2021, 10:27:35 PM
    Author     : bbm29
--%>

<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <script src="../jQueryScripts/jquery.min.js" type="text/javascript"></script>
        <title>Upload de Imagens</title>
    </head>
    <body>
        <h1>Upload de Imagens</h1>
        <input type="file" id="upload" name="file" onchange="uploadImage()">
        <img alt="Imagem" src="" width="200px" height="200px">
    </body>
    <script type="text/javascript" src="../js/imageUpload.js"></script>
</html>
