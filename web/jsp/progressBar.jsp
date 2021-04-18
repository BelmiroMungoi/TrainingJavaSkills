<%-- 
    Document   : progressBar
    Created on : Apr 18, 2021, 6:19:10 PM
    Author     : Belmiro-Mungoi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Barra de Progresso</title>
        <style type="text/css">
            /*fundo da barra de progresso*/
            #myProgressBar{
                width: 100%;
                background-color: #ddd;
            }

            /*cor da barra de progreso*/
            #myBar{
                width: 1%;
                height: 30px;
                background-color: #4CAF50;
            }
        </style>
    </head>
    <body>
        <h1>Exemplo de Barra com JavaScript</h1>
        <div id="myProgressBar">
            <div id="myBar">

            </div>
        </div>
        <button onclick="exibirBarra()">Start</button>

        <script type="text/javascript">
            function exibirBarra() {
                var bar = document.getElementById("myBar");
                var width = 1;
                var id = setInterval(frame, 10);

                function frame() {
                    if (width >= 100) {
                        clearInterval(id);// para a barra de progresso
                    } else {
                        width++;
                        bar.style.width = width + "%";// preenche a barra de progresso
                    }
                }
            }
        </script>
    </body>
</html>
