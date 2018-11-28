<%-- 
    Document   : viewForum
    Created on : 02-Nov-2018, 12:43:37
    Author     : ThunderCow
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Forum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>View Forum List</title>
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
        
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1>View Forum!</h1>
       <div class="col-10"> 
                      
              <table style="width:100%">
              
        <tr>
            <th> Forum ID</th>
            <th> Creator ID</th>
            <th> Forum Name</th>
            
        </tr>
        <tr>
            <c:forEach items="${forum}" var="forum">
              <td><p><a href="/MO-POMA_Tech/View_ForumCom/${forum.getFroumID().intValue()}"/>${forum.getFroumID().intValue()}</td>
              <td><p>${forum.getCreatorID().intValue()}</td>
              <td><p>${forum.getForumName()}</td>     
        </tr>
            </c:forEach>
    </table> 
        
           </div>
      </div>
        </div>
    </body>
</html>