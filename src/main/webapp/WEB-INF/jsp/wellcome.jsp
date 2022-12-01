<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    </head>
    <body>
        <h1>Bienvenido a The Legend Of Java</h1>
        <h2>Selecciona la mazmorra a la que quieras acceder</h2>
        <form class="button" action="/start" method="post">
            <select id="mapId" name="mapId">
                <option value="1">Tutorial</option>
                <option value="2">La cueva de los kesse</option>
            </select>
            <input  type="submit" value="Empezar"></input>
        </form>

    </body>
</html>