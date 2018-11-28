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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Show Student</title>
    </head>  
    
    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">
        
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
        
            <h1 align='center'>Individual Student Detail</h1>
            <div class="table-responsive">
            <table class="table" style="width:80%" align="center">
               <tr>
                <th>Student ID</th>
                <th>Student First_name </th>
                <th>Student Sur_name</th>
                <th>Student Email </th>
                <th>Student Address</th>
                </tr>
                
                <tr>
                    <td> ${student.getid().intValue()}</td>
                    <td> ${student.getfirstName()}</td>
                    <td> ${student.getsurName()}</td>
                    <td> ${student.email}</td>
                    <td> ${student.getadress()}</td>
                </tr>
            </table>
            </div>
    </body>
</html>



