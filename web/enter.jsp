<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 28.01.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
<form action = "/timeaction" method="post">
<tr>
<td colspan="2">
<h5>Login</h5>
<input name = "txtlogin" type="text">
</td>
</tr>
<tr>
<td colspan="2">
<h5>Password</h5>
<input name = "txtpassword" type="text">
</td>
</tr>
<tr>
<td>
<input type = "submit">
</td>
</tr>
<tr>
<td><a href="registr.jsp">регистрация</a></td>
</tr>
</form>
</table>
</body>
</html>
