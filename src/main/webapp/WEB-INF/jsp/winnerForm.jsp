<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    </head>
    <body>
        <h1>Enorabuea has superado la Mazmorra</h1>
        <h2>Introduce tus iniciales!!!</h2>
        <form action="/endform" method="post">
            <input type="text" name="name" id="name"></input>
            <input type="submit" value="Guardar Partida"></input>
        </form>

    </body>
</html>