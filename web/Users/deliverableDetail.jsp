<%-- 
    Document   : deliverableDetail
    Created on : 23.11.2018, 10:57:58
    Author     : Petr
--%>


<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Deliverable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Individual Deliverable</title>
    </head>  

    <jsp:include page="/WEB-INF/menu.jsp" />
   
    <body style="background-color: powderblue;">
    <div class="container justify-content-center">
        <div class="col-12">
        <h1>Show individual deliverable</h1>
        <table class="table">
            <thead>
                <tr>
                  <th scope="col">deliverable_Id</th>
                  <th scope="col">module_Id</th>
                  <th scope="col">teacher_Id</th>
                  <th scope="col">datetime_Of_Submit</th>
                  <th scope="col">status</th>
                   <th scope="col">points</th>
                  <th scope="col">feedback</th>
                  <th scope="col">progression</th>
                 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${deliverable}" var="deliverable">
                    <tr>
                        <td>${deliverable.getDeliverable_Id().intValue()}</td>
                        <td>${deliverable.getModule_Id().intValue()}</td>
                        <td>${deliverable.getTeacher_Id().intValue()}</td>
                        <td>${deliverable.getDatetime_Of_Submit()}</td>
                        <td>${deliverable.getStatus()}</td>
                        <td>${deliverable.getPoints().intValue()}</td>
                        <td>${deliverable.getFeedback()}</td>
                         <td>${deliverable.getProgression()}</td>
                        
                      

                    </tr>
                </c:forEach>
           </tbody>
         </table>
        </div>
    </div>
    </body>
</html>