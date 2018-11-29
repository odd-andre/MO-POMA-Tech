<%-- 
    Document   : showMessage
    Created on : 01.nov.2018, 14:03:01
    Author     : Mahamed Salad
--%>


<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <head>
        <title>View Page</title>
    </head>
        <jsp:include page="/WEB-INF/menu.jsp" />
         <body style="background-color: powderblue;">
        
        <style> 
        body {
                background-color: powderblue;
            }
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
            }
            th, td {
                text-align: center;
            }
            table tr:nth-child(even) {
                background-color: #eee;
            }
            table tr:nth-child(odd) {
                background-color: #fff;
            }
            
        </style>
    <body>
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1>Show Message!</h1>
       <div class="col-10"> 
                      
              <table style="width:100%">
              
        <tr>
            <th> Messsge ID</th>
            <th> Date & Time</th>
            <th> Subject</th>
            <th> Content </th>
            
        </tr>
       
        <c:forEach items="${Messages}" var="message"> 
              <tr>
              <td><p>${message.getMessageID().intValue()}</td>
              <td>${message.getdateTime_Message()}</td>
              <td>${message.getSubject()}</p></td>
              <td>${message.getContent()}</p></td>
              </tr> 
       </c:forEach> 
        
        
    </table> 
        
           </div>
      </div>
        </div>
    </body>
</html>
