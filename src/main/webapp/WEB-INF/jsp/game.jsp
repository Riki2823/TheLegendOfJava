<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    </head>
    <body>
        <h1>Bienvenido al Mapa ${mapId}</h1>
        <div id=canvaContainer>
            <canvas id="game" width="1024" height="768" style="border:2px solid #000000;"></canvas>
        </div>

    </body>
</html>