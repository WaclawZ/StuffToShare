<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 15.01.18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<div>
    <h1>Add book</h1>
    <%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
    <form:form method="post" action="/book/save" modelAttribute="book">
        Title: <form:input path="title"/>
        <form:errors path="title"/><br>
        Authors: <form:select path="authors" items="${authors}" itemLabel="lastName" itemValue="id"/>
        <form:errors path="authors"/><br>
        Publisher: <form:select path="publisher" items="${publisher}" itemLabel="name" itemValue="id"/>
        <form:errors path="publisher"/><br>
        Description <form:input path="description"/>
        <form:errors path="description"/><br>
        Rating: <form:input path="rating"/>
        <form:errors path="rating"/><br>
        <form:hidden path="id"/>
        <input type="submit" value="zapisz"/>
    </form:form>
</div>
</body>
</html>
