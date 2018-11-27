<%-- 
    Document   : newjsp
    Created on : 9.10.2018, 10:37:49
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

        <title>ShowDeliverables</title>
    </head>  
    <nav class="navbar navbar-inverse">
       <div class="container-fluid">
          <div class="navbar-header">
             <a class="navbar-brand" href="#">MO-POMA TECH</a>   
          </div>
            <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/MO-POMA_Tech/">HOME</a></li>
            <li><a href="http://localhost:8080/MO-POMA_Tech/Users/project_Info.jsp">PROJECT INFO</a></li>
                <li><a href="http://localhost:8080/MO-POMA_Tech/Users/user_stories.jsp">User Stories</a></li>
                      <li><a href="https://github.com/Oddpotatoman/MO-POMA-Tech/issues">Issues Done</a></li>
                      
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">STUDENT <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="#">Show student</a></li>
                <li><a href="#">Add New Student</a></li>
                <li><a href="#">Student List</a></li>
                </ul>   
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">MODULE <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/Show_Module_Detail/1">Individual Module</a></li>
                    <li><a href="/MO-POMA_Tech/Edit_Module/1">Update Module</a></li>
                    <li><a href="/MO-POMA_Tech/Module_List/">Module List</a></li>
                </ul>
            </li>
      
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">FORUM <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/View_Forum/1">View Forum</a></li>
                    <li><a href="#">Create Forum</a></li>
                    <li><a href="/MO-POMA_Tech/ViewForumlist">Forum List</a></li>
                </ul>
            </li>
            
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Deliverable <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="http://localhost:8084/MO-POMA_Tech/showDeliverable">Show Deliverable</a></li>
                    <li><a href="http://localhost:8084/MO-POMA_Tech/CreateDeliverable">Create Deliverable</a></li>
                    <li><a href="http://localhost:8084/MO-POMA_Tech/DeleteDeliverable/6">Delete Deliverable</a></li>
                    <li><a href="http://localhost:8084/MO-POMA_Tech/Edit_Deliverable/6">Edit Deliverable</a></li>
                    <li><a href="http://localhost:8084/MO-POMA_Tech/deliverableDetail/6">Show individual Deliverable</a></li>
                </ul>
            </li>
            
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Message <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">View Message</a></li>
                    <li><a href="#">Send Message</a></li>
                </ul>
            </li>
            
              <ul class="nav navbar-nav navbar-right">
                
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Switch Account</a></li>
                
              </ul>
              </ul>
        </div>
    </nav>
  
    <body style="background-color: powderblue;">
    <div class="container justify-content-center">
        <div class="col-12">
        <h1>Show deliverable</h1>
        <table class="table">
            <thead>
                <tr>
                  <th scope="col">deliverable_Id</th>
                  <th scope="col">student_Id</th>
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
                        <td>${deliverable.getDeliverable_Id()}</td>
                           <td>${deliverable.getStudent_Id()}</td>
                           <td>${deliverable.getModule_Id()}</td>
                              <td>${deliverable.getTeacher_Id()}</td>
                        <td>${deliverable.getDatetime_Of_Submit()}</td>
                        <td>${deliverable.getStatus()}</td>
                         <td>${deliverable.getPoints()}</td>
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