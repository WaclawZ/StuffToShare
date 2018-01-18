<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 16.01.18
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ADD</h1>
    <%--@elvariable id="person" type="pl.coderslab.entity.Person"--%>
    <form:form method="post" action="/person/add" modelAttribute="person">
        Login: <form:input path="login"/><br>
        Password: <form:password path="password"/><br>
        Email: <form:input path="email"/><br>
        FirstName: <form:input path="details.firstName"/><br>
        LastName: <form:input path="details.lastName"/><br>
        Street: <form:input path="details.street"/><br>
        StreetNumber: <form:input path="details.streetNumber"/><br>
        City: <form:input path="details.city"/><br>
        Gender: <form:radiobuttons path="details.gender" items="${genders}"/><br>
        <%--Female: <form:radiobutton path="details.gender" value="F"/><br>--%>
        Country: <form:select path="details.country" items="${countries}"/><br>
        Notes: <form:textarea path="details.notes"/><br>
        MailingList: <form:checkbox path="details.mailingList"/><br>
        ProgrammingSkills:<br>
        Hobbies: <br>
        <input type="submit" value="zapisz"/>
    </form:form>

</body>
</html>
