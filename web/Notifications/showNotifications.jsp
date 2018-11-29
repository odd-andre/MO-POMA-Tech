<%-- 
    Document   : showNotifications
    Created on : Nov 27, 2018, 5:19:31 PM
    Author     : oddi9
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Notifications"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>        
        <title>Show notifications</title>
    </head>
    
   <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body>
         <div class="container">
            <div class="row  justify-content-center">
                <div class="col-8"></div>
                <div class="col-4">
                    <h1>Hello World!</h1>
                    <br>
                    <c:forEach items="${notifications}" var="notification">
                        <div>
                            <p><a href="${notification.getUrl()}">${notification.getContent()}</a></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
         </div>
    </body>
</html>
