<%-- 
    Document   : calendar
    Created on : Jul 3, 2021, 2:20:26 PM
    Author     : bbm29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendário</title>
        <link rel="stylesheet" href="../css/codepen.css">
        <link rel="stylesheet" href="../css/fullCalendar-main.css">
        <script type="text/javascript" src="../js/fullCalendar-main.js"></script>
        <script type="text/javascript" src="../js/codepen.js"></script>   
        <script type="text/javascript" src="../jQueryScripts/jquery-3.3.1.js"></script>
        <style>

            html, body {
                margin: 0;
                padding: 0;
                font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
                font-size: 14px;
            }

            #calendar {
                max-width: 1100px;
                margin: 40px auto;
            }

        </style>
    </head>
    <body>
        <div class='demo-topbar'>
            <h1>Calendário</h1>
        </div>
        <div id='calendar'></div>

    </body>
    <script>
        
  
        document.addEventListener('DOMContentLoaded', function() {
            $.get("buscarCalendario", function(response) {
            
            var calendarEl = document.getElementById('calendar');
            alert(response);
            var dates = JSON.parse(response);
            
            
                
                var calendar = new FullCalendar.Calendar(calendarEl, {
                    timeZone: 'UTC',
                    initialView: 'dayGridMonth',
                    events: dates,
                    editable: true,
                    selectable: true
                });    
                calendar.render();
            });        
        });

    </script>
</html>
