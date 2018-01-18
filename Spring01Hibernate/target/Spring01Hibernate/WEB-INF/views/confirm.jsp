<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Delete book</title>
</head>
<body>
<h1>Are you sure?</h1>
<table>
    <tr>
        <td><a href="/book/all">Cancel</a> </td>
        <td><a href="/book/delete/${id}">Confirm</a> </td>
    </tr>
</table>
</body>
</html>
