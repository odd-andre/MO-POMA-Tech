<%-- 
    Document   : Create_Module
    Created on : Oct 11, 2018, 11:43:39 AM
    Author     : Muhammad Ali
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Add Module</title>
    </head>  
    <nav class="navbar navbar-inverse navbar-justified">
       <div class="container-fluid">
          <div class="navbar-header">
             <a class="navbar-brand" href="#">MO-POMA TECH</a>   
          </div>
            <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/MO-POMA_Tech/">HOME</a></li>  
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
                    <li><a href="/MO-POMA_Tech/Add_Module">Insert Module</a></li>
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
            
              <li class="nav-item justify-content-right" ><a href="#"><span class="glyphicon glyphicon-log-in"></span> Switch Account</a></li>
            
            
            
           </ul>
        </div>
    </nav>
  
    <body>
        
        <div class="container">
            <div class="row  justify-content-center">
                <div class="col-6">
                    <h1>Add Module</h1>
                    <form action="Create_Module" method="POST">
                        <div class="form-row">
                          <div class="col-6">
                              <label for="Module_Name">Module Name</label>
                              <input type="text" name="Module_Name" id="Module_Name" class="form-control" placeholder="String text" required>
                          </div>
                          <div class="col-6">
                              <label for="Module_ID">Module ID</label>
                              <input type="text" name="Module_ID" id="Module_ID" class="form-control" placeholder="numeric number" >
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                              <label for="Teacher_ID">Teacher ID</label>
                              <input type="Teacher_ID" class="form-control" name="Teacher_ID" id="teacher_id" placeholder="numeric value from 11-13" required>
                            </div>
                            <div class="col-6">
                                <label for="">Deadline</label>
                                <input type="text" name="deadline" id="deadline" class="form-control" placeholder="YEAR-MONTH-DAY" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                              <label for="address">Goals</label>
                              <input type="text" class="form-control" name="learn_Goals" id="goals" placeholder="string text" required>
                            </div>
                        </div>

                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Add Module</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-3">Clear</button>
                    </form>
            </div>
        </div>
        </div>
    </body>
</html>
