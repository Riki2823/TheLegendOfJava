<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    </head>
    <body>
        <h1>A continuacion tienes la lista de partias realizadas</h1>
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
    </body>
</html>