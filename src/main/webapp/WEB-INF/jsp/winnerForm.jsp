<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
        <link rel="stylesheet" href="../../styles/winnerForm.css">
    </head>
    <body>
        <div>
            <h1>Enhorabuena has superado la Mazmorra</h1>
            <h2>Introduce tu nombre!!!</h2>
            <form action="/endform" method="post">
                <input type="text" name="name" id="name" id="inicials"></input>
                <input type="submit" value="Guardar Partida" id="envia"></input>
            </form>
        </div>

    </body>
</html>