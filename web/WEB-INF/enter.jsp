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
    <link rel="stylesheet" href="CSS/cssFile.css"/>
    <title>Title</title>
</head>
<body class="green">
  <form action = "/timeaction" method="post">
  <div class="login">
        <div>
         <h5>Login</h5>
         <input name = "txtlogin" type="text">
        </div>

        <div>
            <h5>Password</h5>
            <input name = "txtpassword" type="text">
        </div>


        <div>
         <input type = "submit">
        </div>

        <div>
         <input type = "submit" name = "reg" value="Registration">
        </div>
  </div>
  </form>

</table>
</body>
</html>
