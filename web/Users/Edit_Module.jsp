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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Edit/Update Module</title>
    </head>  
    
    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-6">
                    <h1>Edit /Update Module</h1>
                    <form action="/MO-POMA_Tech/Edit_ModulePost" method="POST">
                        <div class="form-row">
                          <div class="col-sm-6">
                              <label for="Module_Name">Module Name</label>
                              <input type="text" name="Module_Name" id="Module_Name" value = "${module.getName()}" class="form-control" placeholder="String text" required>                       
                          </div>
                          <div class="col-sm-6">
                              <label for="Module_ID">Module ID</label>
                              <input type="text" name="Module_ID" id="Module_ID" value = "${module.getID().intValue()}" class="form-control" placeholder="numeric number">
                          </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="Teacher_ID">Teacher ID</label>
                              <input type="Teacher_ID" class="form-control" name="Teacher_ID" id="teacher_id" value="${module.getTeacherID().intValue()}" placeholder="numeric value" required>
                            </div>
                            <div class="col-sm-6">
                                <label for="">Deadline</label>
                                <input type="text" name="Deadline" id="deadline" value = "${module.getDeadline()}" class="form-control" placeholder="YEAR-MONTH-DAY" required>
                            </div>
                        </div>
                            
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="address">Goals</label>
                              <input type="text" class="form-control" name="learn_Goals" id="goals" value = "${module.getGoals()}" placeholder="string text" required>
                            </div>
                            
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Update Module</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-3">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
