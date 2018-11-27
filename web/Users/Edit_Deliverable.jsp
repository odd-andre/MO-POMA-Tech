<%-- 
    Document   : Edit_Deliverable
    Created on : 12.11.2018, 0:34:29
    Author     : Petr
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Entities.Deliverable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Edit_Deliverable</title>
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

<
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Edit Deliverable</h1>
                    <form action="/MO-POMA_Tech/Edit_DeliverablePost" method="POST">
                           <input hidden type="text" name="deliverable_Id" id="deliverable_Id" value="${deliverable.getDeliverable_Id().intValue()}">
                        <div class="form-row">                     
                            <div class="col-6">
                              <label for="module_Id">module_Id</label>
                              <input type="text" name="module_Id" id="module_Id" value="${deliverable.getModule_Id().intValue()}" class="form-control" placeholder="module_Id">
                          </div>
                          <div class="col-3">
                              <label for="teacher_Id">teacher_Id</label>
                              <input type="text" name="teacher_Id" id="teacher_Id" value="${deliverable.getTeacher_Id().intValue()}" class="form-control" placeholder="teacher_Id">
                          </div>
                          
  
                           <div class="col-6">
                              <label for="datetime_Of_Submit">Datetime_Of_Submit</label>
                              <input type="text" name="datetime_Of_Submit" id="datetime_Of_Submit" value = "${deliverable.getDatetime_Of_Submit()}" class="form-control" placeholder="YEAR-MONTH-DAY">
                          </div>
                         <div class="col-3">
                              <label for="status">status</label>
                              <input type="text" name="status" id="status" value = "${deliverable.getStatus()}" class="form-control" placeholder="status">
                          </div>
                        
                        <div class="form-row">
                            <div class="col-9">
                              <label for="feedback">feedback</label>
                              <input type="text" name="feedback" id="feedback" value="${deliverable.getFeedback()}" class="form-control" placeholder="feedback">
                            </div>
                            <div class="col-3">
                                <label for="progression">progression</label>
                                <input type="text" name="progression" id="progression" value = "${deliverable.getProgression()}" class="form-control" placeholder="progression">
                            </div>
                        </div>
                        <div class="col-3">
                                <label for="points">points</label>
                                <input type="text" name="points" id="points" value = "${deliverable.getPoints().intValue()}" class="form-control" placeholder="points">
                            </div>
                        </div>
                
                           
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Update Deliverable</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-3">Clear</button>
                    </form>
                </div>
             </div>
        </div>
    </body>
</html>