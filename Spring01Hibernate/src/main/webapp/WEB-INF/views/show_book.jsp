<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Title</td>
        <td>${book.title}</td>
    </tr>
    <tr>
        <td>Authors</td>
        <td>
            <C:forEach items="${book.authors}" var="aut">
                ${aut.firstName} ${aut.lastName}<br>
            </C:forEach>
        </td>
    </tr>
    <tr>
        <td>Publisher</td>
        <td>${book.publisher.name}</td>
    </tr>
    <tr>
        <td>Description</td>
        <td>${book.description}</td>
    </tr>
    <tr>
        <td>Rating</td>
        <td>${book.rating}</td>
    </tr>
</table>
</body>
</html>
