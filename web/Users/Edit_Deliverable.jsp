<%-- 
    Document   : Edit_Deliverable
    Created on : 12.11.2018, 0:34:29
    Author     : Petr
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="Entities.Deliverable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Deliverable</title>
    </head>
    <body>
         <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Edit /Update Deliverable</h1>
                    <form action="/MO-POMA_Tech/Edit_DeliverablePost" method="POST">
                        <div class="form-row">
                                 <div class="col-3">
                              <label for="deliverable_Id">Deliverable_Id</label>
                              <input type="text" name="deliverable_Id" id="deliverable_Id" value="${deliverable.getDeliverable_Id().intValue()}" class="form-control" placeholder="deliverable_Id">
                          </div>
    
                         <div class="col-6">
                              <label for="status">status</label>
                              <input type="text" name="status" id="status" value = "${deliverable.getStatus()}" class="form-control" placeholder="string">
                          </div>
                        
                        <div class="form-row">
                            <div class="col-9">
                              <label for="feedback">feedback</label>
                              <input type="text" name="feedback" id="feedback" value="${deliverable.getFeedback()}" class="form-control" placeholder="string">
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