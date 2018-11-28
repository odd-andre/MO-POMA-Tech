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
   
    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">

<
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Edit Deliverable</h1>
                    <form action="/MO-POMA_Tech/Edit_DeliverablePost" method="POST">
                           <input hidden type="text" name="deliverable_Id" id="deliverable_Id" value="${deliverable.getDeliverable_Id().intValue()}">
                        <div class="form-row">                     
                            <div class="col-sm-6">
                              <label for="module_Id">module_Id</label>
                              <input type="text" name="module_Id" id="module_Id" value="${deliverable.getModule_Id().intValue()}" class="form-control" placeholder="module_Id" required>
                          </div>
                          <div class="col-sm-6">
                              <label for="teacher_Id">teacher_Id</label>
                              <input type="text" name="teacher_Id" id="teacher_Id" value="${deliverable.getTeacher_Id().intValue()}" class="form-control" placeholder="teacher_Id" required>
                          </div>
                          
  
                           <div class="col-sm-6">
                              <label for="datetime_Of_Submit">Datetime_Of_Submit</label>
                              <input type="text" name="datetime_Of_Submit" id="datetime_Of_Submit" value = "${deliverable.getDatetime_Of_Submit()}" class="form-control" placeholder="YEAR-MONTH-DAY" required>
                          </div>
                         <div class="col-sm-6">
                              <label for="status">status</label>
                              <input type="text" name="status" id="status" value = "${deliverable.getStatus()}" class="form-control" placeholder="status" required>
                          </div>
                        
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="feedback">feedback</label>
                              <input type="text" name="feedback" id="feedback" value="${deliverable.getFeedback()}" class="form-control" placeholder="feedback" required>
                            </div>
                            <div class="col-sm-6">
                                <label for="progression">progression</label>
                                <input type="text" name="progression" id="progression" value = "${deliverable.getProgression()}" class="form-control" placeholder="progression" required>
                            </div>
                        </div>
                        <div class="col-sm-6">
                                <label for="points">points</label>
                                <input type="text" name="points" id="points" value = "${deliverable.getPoints().intValue()}" class="form-control" placeholder="points" required>
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