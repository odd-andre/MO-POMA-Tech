<%-- 
    Document   : showStudents
    Created on : Oct 9, 2018, 11:33:39 AM
    Author     : oddandre
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<html>
    <head>
        <title>Show students</title>
    </head>
    <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/MO-POMA_Tech">MO-Poma</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="/MO-POMA_Tech/showStudents">Students</a>
      <a class="nav-item nav-link" href="#">Modules</a>
      <a class="nav-item nav-link" href="#">Forum</a>
      <a class="nav-item nav-link" href="/MO-POMA_Tech/signOut">Sign Out</a>
    </div>
  </div>
</nav>
    <div class="container justify-content-center">
        <div class="col-12">
        <h1>Student list</h1>
        <table class="table">
            <thead>
                <tr>
                  <th scope="col">Name</th>
                  <th scope="col">Email</th>
                  <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><a href="/MO-POMA_Tech/showStudent/${student.getId().intValue()}"/> ${student.getFirstName()} ${student.getSurName()}</td>
                        <td>${student.email}</td>
                        <td><a href="/MO-POMA_Tech/editStudent/${student.getId().intValue()}"> edit </a></td>

                    </tr>
                </c:forEach>
           </tbody>
         </table>
        <c:set var="condition" value="Teacher"/>
        <c:if test="${accessType == 'Teacher'}" >
            <form action="addStudent" type="get">
                <button type="Submit" action="addStudent" class="btn btn-primary">Add Student</button>
            </form>   
        </c:if>
        </div>
    </div>
    </body>
</html>
