<%-- 
    Document   : showStudent
    Created on : Sep 4, 2018, 12:11:12 PM
    Author     : oddandre
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${students}" var="student">
            <p>${student.adress} ${student.getEmail()}</p>
        </c:forEach>
    </body>
</html>
