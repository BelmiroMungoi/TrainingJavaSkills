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
        <link rel="stylesheet" href="../css/jquery-ui.css">
        <script src="../jQueryScripts/jquery.min.js" type="text/javascript"></script>
        <script src="../jQueryScripts/jquery-ui.js"></script>
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

            .ui-progressbar{
                position: relative;
            }

            .progress-label{
                position: relative;
                left: 50%;
                top: 4px;
                bottom: 3px;
                font-weight: bold;
                text-shadow: 1px 1px 0 blue;
            }
        </style>

    </head>
    <body>
        <h1>Exemplo de Barra de Progresso com JavaScript</h1>
        <div id="myProgressBar">
            <div id="myBar">

            </div>
        </div>
        </br>
    <center>
        <button onclick="exibirBarra()">Start Progress Bar</button>
    </center></br>

    <h1>Exemplo de Barra de Progresso com jQuery</h1>
    <div id="progressbar">
        <div class="progress-label">
            loading...
        </div>
    </div>


    <script type="text/javascript">

        //codigo pra a barra de progresso em javaScript
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

        //codigo para a barra de progresso usando jQuery
        $(function () {
            var progressbar = $("#progressbar"),
                    progressLabel = $(".progress-label");
            // vai criar a barra na div
            progressbar.progressbar({
                value: false,
                change: function () {
                    progressLabel.text(progressbar.progressbar('value') + "%");
                },
                // Quando  a barra de progresso estiver completa
                complete: function () {
                    progressLabel.text('Completed!');
                }
            });

            //Vai mostrar o progresso na barra
            function progress() {
                var valor = progressbar.progressbar('value') || 0;
                
                progressbar.progressbar('value', valor + 2)
                if (valor < 99) {
                    setTimeout(progress, 80);
                }
            }
            setTimeout(progress, 2000);// sera chamada na abertura da tela
        });
    </script>
</body>
</html>
