<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
        <link rel="stylesheet" href="../../styles/wellcome.css">
    </head>
    <body>
        <header>
            <h1 id="title">Bienvenido a The Legend Of Java</h1>
        </header>

        <main>
            <h2>Selecciona la mazmorra a la que quieras acceder</h2>
            <div id="formulariDIV">
                <form class="button" action="/start" method="post" id="formulari">
                    <select id="mapId" name="mapId">
                        <option value="1">Tutorial</option>
                            <option value="2">La cueva de los kesse</option>
                    </select>
                    <input  type="submit" value="Empezar"></input>
                </form>
            </div>
        </main>

    </body>
</html>