<%-- 
    Document   : showStudents
    Created on : Oct 9, 2018, 11:33:39 AM
    Author     : oddandre
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Show Students</title>
    </head>

    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">    
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
                        <td><a href="/MO-POMA_Tech/showStudent/${student.getid().intValue()}"/> ${student.getfirstName()} ${student.getsurName()}</td>
                        <td>${student.email}</td>
                        <td><a href="/MO-POMA_Tech/editStudent/${student.getid().intValue()}"> edit </a></td>

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