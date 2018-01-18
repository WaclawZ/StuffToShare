<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h1>Edit book</h1>
<%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
<form:form method="post" action="/book/edit" modelAttribute="book">
    Title: <form:input path="title"/><br>
    <form:errors path="title"/><br>
    Authors: <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/><br>
    <form:errors path="authors"/><br>
    Publisher: <form:select path="publisher" items="${publisher}" itemLabel="name" itemValue="id"/><br>
    <form:errors path="publisher"/><br>
    Description <form:input path="description"/><br>
    <form:errors path="description"/><br>
    Rating: <form:input path="rating"/><br>
    <form:errors path="rating"/><br>
    <form:hidden path="id"/>
    <input type="submit" value="zapisz"/>
</form:form>
</body>
</html>
