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
<h1>
    Введите логин and password
</h1>
   <%--<jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>--%>
   <%--<form name = "Simple" action="timeaction" method="POST">--%>
      <%--<input type="hidden" name="time" value="${calendar.timeInMillis}"/>--%>
      <%--<input type="submit" name="button" value="Count the time"/>--%>
   <%--</form>--%>
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
</form>
</table>
</body>
</html>
