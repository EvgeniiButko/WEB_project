<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 22.01.2018
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Anna</title>
</head>
<body>

<h1>
    Таблица
    ${requestScope.posts.size()}
</h1>
<table border="1">
    <c:forEach items="${requestScope.posts}" var = "post">
        <tr>
            <td>${post.ID}</td>
            <td><c:out value="${post.name}"/></td>
            <td><a href="delete?id=${post.ID}">
                delete
            </a></td>
        </tr>
    </c:forEach>
    <form action = "/add" method="post">
        <tr>
            <td colspan="2">
                <input name = "txt" type="text">
            </td>
            <td>
                <input type = "submit">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
