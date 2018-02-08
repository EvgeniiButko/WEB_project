<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 30.01.2018
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/cssFile.css"/>
    <title>Title</title>
</head>
<body class="green">
      <table>
          <form action="/buying" method="post">
              <tr>
                  <td><h2>Orders Number</h2></td></td>
                  <td>${requestScope.id}</td>
              </tr>
              <tr>
                  <td>
                      <h3>Enter the City</h3>
                      <input name = "city" type = "text"/>
                  </td>
              </tr>
              <tr> <td>
                  <h3>Enter your personal information</h3>
              </td></tr>
              <tr><td>
                  <input name = "name" type = "text"/>
              </td><td><h5>Name</h5></td></tr>
              <tr> <td>
                  <input name = "sername" type = "text"/>
              </td><td><h5>Sername</h5></td></tr>
              <tr> <td>
                  <input name = "number" type = "text"/>
              </td><td><h5>Phone number</h5></td></tr>
              <tr> <td>
                  <input name = "mail" type = " text">
              </td> <td><h5>Your mail</h5></td></tr>
              <tr>
                  <td>
                      <input type="submit" name="id" value="${requestScope.id}"/>
              </td></tr>

          </form>
      </table>
</body>
</html>
