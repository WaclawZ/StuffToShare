<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jspf"%>
<table border="1">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Pesel</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${authors}" var="author">
    <tr>
        <td>${author.firstName}</td>
        <td>${author.lastName}</td>
        <td>${author.pesel}</td>
        <td>${author.email}</td>
        <td><a href="/author/edit/${author.id}">Edit</a> | <a href="/author/delete/${author.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
