<%-- 
    Document   : showNotifications
    Created on : Nov 6, 2018, 11:17:10 AM
    Author     : Halim
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Notifications"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1 align="center">Notifications List!</h1>
       <div class="col-10"> 
                      
              <table style="width:100%">
              
        <tr>
            <th> Title</th>
            <th> Content</th>
            <th> Date</th>
            <th> Url</th>
        </tr>
        <c:forEach items="${notifications}" var="notifications">
        <tr>
              <td><p>${notifications.getTitle()}</td>
              <td>${notifications.getContent()}</td>
              <td>${notifications.getDate()}</td>
              <td>${notifications.getUrl()}</p></td>
       
        </tr>
        </c:forEach>
    </table> 
        
           </div>
      </div>
            </div>
    </body>
</html>
