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
    <link rel="stylesheet" href="CSS/cssFile.css"/>
    <title>Hello Anna</title>
</head>
<body class = "green">
<div>
    <div><h1>
        Таблица
        ${requestScope.posts.size()}
    </h1></div>
    <div>
        <form action = /add method="post">
            <button name = "txt" value="ZAKAZI" class="button">
                <h3>Orders</h3>
            </button>
        </form>
    </div>
</div>

    <c:forEach items="${requestScope.posts}" var = "post">
        <div class="forItems">
            <hr/>
            <h4 class="h4">
                    <c:out value="${post.ID}"/><c:out value="${post.name}"/>
            </h4>
            <h6>
                <c:out value="${post.inf}"/>
            </h6>
            <form action="/delete" method="post">
                <button name="id" value="${post.ID}" class="button">delete</button>
            </form>
        </div>
    </c:forEach>
    <form action = "/add" method="post">
        <hr><div class="forAdding">
            <div colspan="2">
                <input name = "txt" type="text">
            </div>
            <div colspan="2">
                <input name = "inform" type = "text">
            </div>
            <div>
                <input type = "submit">
            </div>
    </div>
    </form>

</body>
</html>
