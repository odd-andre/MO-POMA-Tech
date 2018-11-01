<%-- 
    Document   : addStudent
    Created on : Oct 8, 2018, 10:01:23 AM
    Author     : oddandre
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>Add student</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Edit student</h1>
                    <form action="/MO-POMA_Tech/editStudentPost" method="POST">
                        <input hidden type="text" name="user_id" id="user_id" value="${student.getId().intValue()}">
                        <div class="form-row">
                          <div class="col-6">
                              <label for="firstname">First name</label>
                              <input type="text" name="firstname" id="firstname" value="${student.getFirstName()}" class="form-control" placeholder="First name">
                          </div>
                          <div class="col-6">
                              <label for="lastname">Surname</label>
                              <input type="text" name="lastname" id="lastname" value="${student.getSurName()}" class="form-control" placeholder="Last name">
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-9">
                              <label for="email">Email</label>
                              <input type="email" class="form-control" name="email" value="${student.getEmail()}" id="email" placeholder="Email">
                            </div>
                            <div class="col-3">
                                <label for="datebirth">Birth date</label>
                                <input type="text" name="datebirth" id="datebirth" value="${student.getBirthDate()}" class="form-control" placeholder="YEAR-MONTH-DAY">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-9">
                              <label for="address">Address</label>
                              <input type="text" class="form-control" name="address" value="${student.getAdress()}" id="address" placeholder="Address">
                            </div>
                            <div class="col-3">
                                <label for="datebirth">Zip-code</label>
                                <input type="text" name="zipcode" id="zipcode" value="${student.getZipCode().intValue()}" class="form-control" placeholder="Zip-code">
                            </div>
                        </div>
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Edit student</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
