<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
        <link rel="stylesheet" href="../../styles/winnerTab.css">
    </head>
    <body>
        <div id="container">
            <h1>A continuacion tienes la lista de partias realizadas</h1>
            <div id="tableContainer">
                <table>
                    <tr>
                        <th>Nombre registrado</th>
                        <th>Mapa Utilizado</th>
                        <th>Tiempo en finalizar la mazmorra</th>
                    </tr>
                    <c:forEach items="${winners}" var="user">
                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.mapUsed}"/></td>
                            <td><c:out value="${user.elapsTime}"/></td>
                        </tr>
                    </c:forEach>
                </table>  
            </div>    
        </div>
    </body>
</html>