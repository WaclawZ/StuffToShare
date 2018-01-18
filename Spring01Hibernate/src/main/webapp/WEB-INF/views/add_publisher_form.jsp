<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Publisher</title>
</head>
<body>
<h1>Add publisher</h1>
<%--@elvariable id="publisher" type="pl.coderslab.entity.Publisher"--%>
<form:form method="post" action="/publisher/save" modelAttribute="publisher">
    Name: <form:input path="name"/>
    <form:errors path="name"/><br>
    Nip: <form:input path="nip"/>
    <form:errors path="nip"/><br>
    Regon <form:input path="regon"/>
    <form:errors path="regon"/><br>
    <input type="submit">
</form:form>
</body>
</html>
