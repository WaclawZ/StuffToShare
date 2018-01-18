<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit Publisher</title>
</head>
<body>
<h1>Edit publisher</h1>
<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form method="post" action="/publisher/edit" modelAttribute="publisher">
    Name: <form:input path="name"/>
    <form:errors path="name"/><br>
    Nip: <form:input path="nip"/>
    <form:errors path="nip"/><br>
    Regon <form:input path="regon"/>
    <form:errors path="regon"/><br>
    <form:hidden path="id"/>
    <input type="submit">
</form:form>
</body>
</html>
