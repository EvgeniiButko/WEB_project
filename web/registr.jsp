<%--
  Created by IntelliJ IDEA.
  User: Evgen
  Date: 26.01.2018
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Вы еще не зарегистрированы, пройдите регистрацию</h1>
<table>
     <form action="/regAction" method = "post">
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
             <td colspan="2">
                 <h5>Mail</h5>
                 <input name = "txtmail" type="text">
             </td>
         </tr>
         <tr>
             <td><input type ="submit"></td>
         </tr>
     </form>
</table>
</body>
</html>
