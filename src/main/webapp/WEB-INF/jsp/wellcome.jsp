<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    </head>
    <body>
        <h1>Bienvenido a The Legend Of Java, vas a probar el mapa 1</h1>
        <form class="button" action="/start" method="post">
            <input  type="submit" value="Empezar"></input>
            <input name="mapId" type="hidden" value="1"></input>
        </form>

    </body>
</html>