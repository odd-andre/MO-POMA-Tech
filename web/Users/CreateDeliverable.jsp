<%-- 
    Document   : CreateDeliverable
    Created on : 6.11.2018, 11:16:16
    Author     : Petr
--%>
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>Create Deliverable</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Create deliverable</h1>
                    <form action="CreateDeliverable" method="POST">
                        <div class="form-row">
                          <div class="col-6">
                              <label for="deliverable_Id">Student id</label>
                              <input type="text" name="student_Id" id="student_Id" class="form-control" placeholder="Student Id">
                          </div>
                          <div class="col-6">
                              <label for="module_Id">Module Id</label>
                              <input type="text" name="module_Id" id="module_Id" class="form-control" placeholder="Module Id">
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                              <label for="teacher_Id">Teacher Id</label>
                              <input type="teacher_Id" class="form-control" name="teacher_Id" id="email" placeholder="Teacher Id">
                            </div>
                            <div class="col-6">
                                <label for="datetime_Of_Submit">Datetime of Submit</label>
                                <input type="text" name="datetime_Of_Submit" id="datetime_Of_Submit" class="form-control" placeholder="YEAR-MONTH-DAY">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                              <label for="status">Status</label>
                              <input type="text" class="form-control" name="status" id="status" placeholder="Status">
                            </div>
                            
          
                        </div>  
                            <p>
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Create Deliverable</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>