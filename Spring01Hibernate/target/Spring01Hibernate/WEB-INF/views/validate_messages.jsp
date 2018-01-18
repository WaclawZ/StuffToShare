<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: walcaw
  Date: 17.01.18
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Validate Messages</title>
</head>
<body>
<h1>Validate Messages</h1>
    <c:forEach items="${list}" var="item">
        <p>${item}</p><br>
    </c:forEach>
</body>
</html>
