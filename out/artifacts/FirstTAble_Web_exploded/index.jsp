<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 22.01.2018
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h3><a href = enter.jsp>
        Enter
    </a></h3>
</div>
<div>
    <table border="1">
        <c:import url="/start"/>
        <c:forEach items="${requestScope.posts}" var = "post">
            <tr>
                <td>${post.ID}</td>
                <td><c:out value="${post.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
