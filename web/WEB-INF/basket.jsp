<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 30.01.2018
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/cssFile.css"/>
    <title>Title</title>
</head>
<body>
    <table border="1" class="green">
    <c:forEach items="${requestScope.orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.city}</td>
            <td>${order.name}</td>
            <td>${order.sername}</td>
            <td>${order.number}</td>
            <td>${order.mail}</td>

            <td><form action="/delete" method="post">
                <button name = "iidd" value="${order.id}" class="button">delete</button>
            </form></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
