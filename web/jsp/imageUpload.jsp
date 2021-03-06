<%-- 
    Document   : imageUpload
    Created on : May 27, 2021, 10:27:35 PM
    Author     : bbm29
--%>

<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <script src="../jQueryScripts/jquery.min-3.1.1.js" type="text/javascript"></script>
        <link href="../css/main.css">
        <title>Upload de Imagens</title>
    </head>
    <body>
    <center>
        <h1>Upload de Imagens</h1>
        <div class="field-group">
            <div class="field">
                <label for="username">Nome do Usuário</label>
                <input type="text" id="usernamee" name="user">
            </div>
            <div class="field">
                <label for="password">Palavra-Passe</label>
                <input type="password" id="passwordd" name="pass">
            </div>
        </div>
        <div class="field">
            <input type="file" id="upload" name="file" onchange="uploadImage()">
            <img alt="Imagem" src="" width="200px" height="200px">
        </div>
        <a href="fileUpload?action=load">Carregar Imagens</a>
        <table>
            <c:forEach items="${images}" var="user">
                <tr>
                    <td>${user.idUser}</td> 
                    <td>${user.userName}</td>
                    <td><a href="fileUpload?action=download&idUser=${user.idUser}">Download</a></td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
<script type="text/javascript" src="../js/imageUpload.js"></script>
</html>
