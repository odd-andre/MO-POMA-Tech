<%-- 
    Document   : addStudent
    Created on : Oct 8, 2018, 10:01:23 AM
    Author     : oddandre
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>Add student</title>
    </head>
    
    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Edit student</h1>
                    <form action="/MO-POMA_Tech/editStudentPost" method="POST">
                        <input hidden type="text" name="user_id" id="user_id" value="${student.getid().intValue()}">
                        <div class="form-row">
                          <div class="col-sm-6">
                              <label for="firstname">First name</label>
                              <input type="text" name="firstname" id="firstname" value="${student.getfirstName()}" class="form-control" placeholder="First name" required>
                          </div>
                          <div class="col-sm-6">
                              <label for="lastname">Surname</label>
                              <input type="text" name="lastname" id="lastname" value="${student.getsurName()}" class="form-control" placeholder="Last name" required>
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="email">Email</label>
                              <input type="email" class="form-control" name="email" value="${student.getemail()}" id="email" placeholder="Email" required>
                            </div>
                            <div class="col-sm-6">
                                <label for="datebirth">Birth date</label>
                                <input type="text" name="datebirth" id="datebirth" value="${student.getdatebirth()}" class="form-control" placeholder="YEAR-MONTH-DAY" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                              <label for="address">Address</label>
                              <input type="text" class="form-control" name="address" value="${student.getadress()}" id="address" placeholder="Address" required>
                            </div>
                            <div class="col-sm-6">
                                <label for="datebirth">Zip-code</label>
                                <input type="text" name="zipcode" id="zipcode" value="${student.getzip_code().intValue()}" class="form-control" placeholder="Zip-code" required>
                            </div>
                        </div>
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Edit student</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
