<%-- 
    Document   : showModule
    Created on : Oct 11, 2018, 10:51:24 AM
    Author     : Muhammad Ali
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Module Detail</title>
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
            .table{
                width:100%;
            }
        </style>
        
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1 align="center">Individual Detail!</h1>
       <div class="col-10"> 
                      <%-- Table implementation --%>
              <div class="table-responsive">
            <table class="table">
              
        <tr>
            <th> Module Name:</th>
            <th> Module ID:</th>
            <th> Teacher ID:</th>
            <th> Module Deadline:</th>
            <th> Learning Goals:</th>
        </tr>
        <tr>
              <td><p>${module.getName()}</td>
              <td>${module.getID().intValue()}</td>
              <td>${module.getTeacherID().intValue()}</td>
              <td>${module.getDeadline()}</td>
              <td>${module.getGoals()}</p></td>
        </tr>
    </table> 
              </div>
           </div>
      </div>
    </body>
</html>
