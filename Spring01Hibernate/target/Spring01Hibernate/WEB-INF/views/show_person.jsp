<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 00:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Show Person</title>
</head>
<body>
<table>
    <tr>
        <td>Login</td>
        <td>${person.login}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${person.password}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${person.email}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${person.detail.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${person.details.lastName}</td>
    </tr>
</table>
</body>
</html>
