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
                    <li><a href="#">Show Deliverable</a></li>
                    <li><a href="#">Create Deliverable</a></li>
                    <li><a href="">Delete Deliverable</a></li>
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
