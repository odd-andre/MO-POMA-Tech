<%-- 
    Document   : user_stories
    Created on : Nov 17, 2018, 9:02:20 PM
    Author     : Muhammad Ali
&#10068 for ?
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
         
        <title>User Stories</title>
    </head>
    <body>
        
        <%-- table formatting part --%>
        <style> 
        table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
            }
            th, td {
                text-align: center;
            }
            table tr:nth-child(even) {
                background-color: #eee;
            }
            table tr:nth-child(odd) {
                background-color: #fff;
            }
            body {
                background-color: powderblue;
                background-image: cross-fade;
            }
            .check {
                font-size: 18px;
                color: green;
                
            }
            .check2 {
                font-size: 18px;
                color: yellow;
            }
        </style>
        
        <%-- check symbol formatting
        <style>
            .check {
                font-size: 18px;
                color: green;
                
            }
         </style>  --%>
              
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                   <div class="navbar-header">
                    <a class="navbar-brand" href="#">MO-POMA TECH</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                      <li class="active"><a href="http://localhost:8084/MO-POMA_Tech/">Home</a></li>
                      <li><a href="http://localhost:8084/MO-POMA_Tech/Users/project_Info.jsp">Project Info</a></li>
                      <li><a href="https://github.com/Oddpotatoman/MO-POMA-Tech/issues">Issues Done</a></li>

                    </ul>
                </div>
             </nav>
        
       <h1 align="center">Implementation of User Stories</h1><br>
       
       <p style="font-family: courier; font-size: medium">
           The following user stories are implemented while coding & developing this system.
       </p>
       
       <div class="table-responsive">
            <table class="table" style="width:90%" align="center">
               <tr>
                <th>User story 1</th>
                <th>User story 2 </th>
                <th>User story 3</th>
                <th>User story 4</th>
                
                
                </tr>
                
                <tr>
                    <td> 
                        2: In order to get a good grade as a student I want an easy overview on the learning goals for the given module.
                    </td>
                    <td>
                        6: As a teacher I want to add students to my course so that I can do it on my own and I do not always have to contact with student office.
                    </td>
                    
                    <td>
                        7: As a student I want to get in touch with other students, so that I have a discussion board to discuss and get feedback about different queries.
                    </td>
                    
                    <td>
                        8: As a teacher I want to be able to upload some project materials easily so that the students can follow up well with the project specifications.
                    </td>
                </tr>
                <tr>
                    <td>
                        <p class="check">Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/Show_Module_Detail/2" type="get">
                            <input type="submit" class="btn btn-link" value="Show_Module">
                        </form>
                    </td>
                    
                    <td>
                        <p class="check">Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/addStudent" type="get">
                            <input type="submit" class="btn btn-link" value="Add_Student">
                        </form>
                    </td>
                    
                    <td>
                        <p class="check">Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/View_Forum/2" type="get">
                            <input type="submit" class="btn btn-link" value="View_Forum">
                        </form>
                    </td>
                    
                    <td>
                        <p class="check1">Implemented &#10068;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/" type="get">
                            <input type="submit" class="btn btn-link" value="Posted">
                        </form>
                    </td>
                </tr>
                
            </table>
                </div>
       
       <div class="table-responsive">
            <table class="table" style="width:80%" align="center">
                <tr>
                <th>User story 5</th>
                <th>User story 6 </th>
                <th>User story 7</th>
                
                
                </tr>
                
                <tr>
                    <td>  
                      3: In order to improve the project and fill up the gaps as a student I want to be able to contact teachers easily.
                   </td>
                   
                    <td>
                      8: As a teacher I want to be able to upload some project materials easily so that the students can follow up well with the project specifications.
                    </td>
                    
                    <td>
                      10: In order to know when something important needs my attention as a student I want a place where I can see any important notifications about the course which relates to me.
                    </td>
                    
                </tr>
                
                <tr>
                    <td>
                        <p class="check2">Partially Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/showMessages" type="get">
                            <input type="submit" class="btn btn-link" value="View_Message">
                        </form>
                    </td>
                    
                    <td>
                        <p class="check">Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/showDeliverable" type="get">
                            <input type="submit" class="btn btn-link" value="Show_Deliverable">
                        </form>
                    </td>
                    
                    
                    <td>
                        <p class="check">Implemented &#9989;</p>
                        <form action="http://localhost:8084/MO-POMA_Tech/showNotifications" type="get">
                            <input type="submit" class="btn btn-link" value="Notification">
                        </form>
                    </td>
                </tr>
            </table>
       </div>
       
       <h3>Criteria and testing of user story</h3>
       <p style="font-family: courier; font-size: medium">
           We have testes our user stories that what we have done while programming.<br>
           <a href="https://docs.google.com/document/d/1QEymXSdTSaQf7i8L-qYi6StrG6dmcJV4Y-dUESReRl0/edit#heading=h.m4e0q3xgds6f">Test_Detail</a>
       </p>
       
       
    </body>
</html>

