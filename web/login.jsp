<%-- 
    Document   : login
    Created on : Mar 23, 2021, 11:20:02 PM
    Author     : Belmiro-Mungoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/login.css">
        <title>Acesso Ao Sistema</title>
    </head>
    <body>
        <form action="LoginUser" method="post" autocomplete="off" id="form_login">
            <h1>Iniciar Sessão</h1>
            <div class="field">
                <input type="hidden" id="url" name="url" value="<%= request.getParameter("url")%>">
                <input type="text" id="nome" name="nome" placeholder="Nome do Usuario">
            </div>
            <div class="field">
                <input type="password" id="pass" name="pass" placeholder="Insira a sua senha">
            </div>
            <button type="submit">Entrar</button>
        </form>
    </body>
</html>
