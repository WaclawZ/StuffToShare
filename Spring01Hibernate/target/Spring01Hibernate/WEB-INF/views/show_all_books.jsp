<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>All Books</title>
</head>
<body>
<h1>All books</h1>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Authors</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Rating</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${books}" var="book">
    <tr>
        <td>${book.title}</td>
        <td>
            <c:forEach items="${book.authors}" var="aut">
                ${aut.firstName} ${aut.lastName}<br>
            </c:forEach>
        </td>
        <td>${book.publisher.name}</td>
        <td>${book.description}</td>
        <td>${book.rating}</td>
        <td><a href="edit/${book.id}">Edit book</a> </td>
        <td><a href="confirm/${book.id}">Delete book</a> </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
