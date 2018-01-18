<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<%@include file="header.jspf"%>
    <h1>Add author</h1>
    <%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>
    <form:form method="post" action="/author/save" modelAttribute="author">
        FirstName: <form:input path="firstName"/>
        <form:errors path="firstName"/><br>
        LastName: <form:input path="lastName"/>
        <form:errors path="lastName"/><br>
        Pesel: <form:input path="pesel"/>
        <form:errors path="pesel"/><br>
        Email: <form:input path="email"/>
        <form:errors path="email"/><br>
        Year of birth: <form:input path="yearOfBirth"/>
        <form:errors path="yearOfBirth"/><br>
        <input type="submit">
    </form:form>
</body>
</html>
