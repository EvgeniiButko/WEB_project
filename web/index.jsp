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
    <link rel="stylesheet" href="CSS/cssFile.css"/>
    <title>Title</title>
</head>
<body>
<div class="Head">
    <form action = "/order" method = post>
        <input type = "submit" name = "id" value="Enter"/>
    </form>
</div>
<div class="green">
        <c:import url="/start"/>
        <c:forEach items="${requestScope.posts}" var = "post">
            <div class="forItems">
            <h4>
                <c:out value="${post.ID}"/>
                <c:out value="${post.name}"/>
            </h4>
            <h4 class="information"><c:out value="${post.inf}"/></h4>
            <form action = "/order" method = post>
                <button name = "id" value="${post.ID}" class="button">
                    Заказать
                </button>
            </form>
            </div>
            <hr class="poloska">
        </c:forEach>
</div>
</body>
</html>
