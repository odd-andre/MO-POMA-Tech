<%-- 
    Document   : CreateDeliverable
    Created on : 6.11.2018, 11:16:16
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

        <title>CreateDeliverable</title>
    </head>  
   
    <jsp:include page="/WEB-INF/menu.jsp" />
  
    <body style="background-color: powderblue;">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Create deliverable</h1>
                    <form action="/MO-POMA_Tech/CreateDeliverablePost" method="POST">
                        <div class="form-row">
                                <div class="col-sm-6">
                              <label for="student_Id">Student id</label>
                              <input type="text" name="student_Id" id="student_Id" class="form-control" placeholder="Student Id" required>
                          </div>
                          <div class="col-sm-6">
                              <label for="module_Id">Module Id</label>
                              <input type="text" name="module_Id" id="module_Id" class="form-control" placeholder="Module Id" required>
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="teacher_Id">Teacher Id</label>
                              <input type="text" class="form-control" name="teacher_Id" id="email" placeholder="Teacher Id" required>
                            </div>
                            <div class="col-sm-6">
                              <label for="datetime_Of_Submit">Datetime_Of_Submit</label>
                              <input type="text" class="form-control" name="datetime_Of_Submit" id="datetime_Of_Submit" placeholder="YEAR-MONTH-DAY" required>
                            </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="status">Status</label>
                              <input type="text" class="form-control" name="status" id="status" placeholder="Status" required>
                            </div>
                            <div class="col-sm-6">
                              <label for="points">points</label>
                              <input type="text" class="form-control" name="points" id="points" placeholder="Points" required>
                            </div>
                             <div class="form-row">
                            <div class="col-sm-6">
                              <label for="feedback">feedback</label>
                              <input type="text" class="form-control" name="feedback" id="feedback" placeholder="Feedback" required>
                            </div>
                                 
           
                                 <div class="col-sm-6">
                              <label for="progression">progression</label>
                              <input type="text" class="form-control" name="progression" id="points" placeholder="Progression" required>
                            </div>
                           </div> 
                           </div> 
            
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Create Deliverable</button>
                            <button style="margin-right: 10px;" type="reset" class="btn col-3">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>