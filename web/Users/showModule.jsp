<%--
    Document   : showStudent
    Created on : Sep 4, 2018, 12:11:12 PM
    Author     : oddandre
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Our JSP Page</title>
</head>
<body>
<h1>Database result page</h1>
<%-- <c:forEach items="${module}" var="module">--%>
<p>${module.getName()}</p>
<p>${module.getId().intValue()}</p>
<p>${module.getLearning_Goals()}</p>
<p>${module.deadline()}</p>
<%--</c:forEach>--%>
</body>
</html>
