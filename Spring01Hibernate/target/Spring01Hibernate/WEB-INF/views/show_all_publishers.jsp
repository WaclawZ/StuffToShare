<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Nip</td>
        <td>Regon</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${publishers}" var="publisher">
    <tr>
        <td>${publisher.name}</td>
        <td>${publisher.nip}</td>
        <td>${publisher.regon}</td>
        <td><a href="/publisher/edit/${publisher.id}">Edit</a> | <a href="/publisher/delete/${publisher.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
