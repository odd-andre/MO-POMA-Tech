<%-- 
    Document   : viewForumCom
    Created on : 14-Nov-2018, 14:21:57
    Author     : cyber
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Forum"%>
<%@page import="Entities.Forum_comment"%>
<%@page import="Entities.Forum_Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>View Forum Comments</title>
    </head>  
   
    <jsp:include page="/WEB-INF/menu.jsp" />
    
         <body>
        <%-- table formatting part --%>
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
        <h1 align='center'>View Complete Forum!</h1>
       <div class="col-10"> 

             <div class="table-responsive">
            <table class="table" style="width:100%"     
           <tr>
               <th>Forum_Name</th>
            <th>Forum Post name</th>
            <th>Content</th>
           </tr>
           
            <c:forEach items="${forum.getHash()}" var="forumPost">
                <c:forEach items="${forumPost.getValue().getCommentArray()}" var="forumComments">
            <tr>
                <td> ${forum.getForumName()}</td>
            <td>${forumPost.getValue().getfPostName()}</td>
            
            <td>${forumComments.getForumContent()}</td>
            </tr>
           
            </c:forEach>
          
       </c:forEach>
           </table> 
           </div>
      </div>
        </div>
    </body>
</html>