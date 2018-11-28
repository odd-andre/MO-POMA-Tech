<%-- 
    Document   : project_Info
    Created on : Nov 13, 2018, 12:07:53 PM
    Author     : Muhammad Ali
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
         
        <title>PROJECT INFO</title>
    </head>
    <body>
              
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                   <div class="navbar-header">
                    <a class="navbar-brand" href="#">MO-POMA TECH</a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                      <li class="active"><a href="http://localhost:8080/MO-POMA_Tech/">Home</a></li>
                      <li><a href="http://localhost:8080/MO-POMA_Tech/Users/user_stories.jsp">User Stories</a></li>
                      <li><a href="https://github.com/Oddpotatoman/MO-POMA-Tech/issues">Issues Done</a></li>

                    </ul>
                </div>
             </nav>
        
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
            .paragraph {
                font-family: courier;
                font-size: medium;
                align-content: justified;
            }
            .image-set {
            display: block;
            margin-left: auto;
            margin-right: auto;
            }
        </style>
        
        <%---- css part for images 
        <style>
            .image-set {
            display: block;
            margin-left: auto;
            margin-right: auto;        
        }
            </style> --%>
        <%----  <style>
            
            .bg-2 {
                background-color: gainsboro;
            }
            .text {
                align-content: stretch;
            }
</style> --%>
        
        <h1  align="center">Project Information for IS-202</h1>
        <div class="container-fluid bg-2 text-left">
            <h2 class="heading2">Short Description.</h2>
            
            <p class="paragraph">We as students at University of Agder created a group named MO-POMA that is an acronym stands for the first letter of each name member. We are glad to be called as the most international group that may encourage us to work better. In this semester, we have given a task to develop a better functionality of the existing Learning Management System (LMS). We have chosen some of the major parts of the system and developed them.
            </p>
            <br>
            
            <p class="paragraph">The short description of whom and what parts are done in this project: </p>
            <div class="table-responsive">
            <table class="table" style="width:80%" align="center">
               <tr>
                <th>Student part</th>
                <th>Module part </th>
                <th>Deliverable part</th>
                <th>Forum part </th>
                <th>Message part</th>
                <th>Notification part</th>
                <th>Front-end part</th>
                <th>Version Control part</th>
                </tr>
                
                <tr>
                    <td> Odd Andre</td>
                    <td> Muhammad Ali</td>
                    <td> Petr Net..</td>
                    <td> Ole Morten</td>
                    <td> Mahamed Salad</td>
                    <td> Abdul Halim</td>
                    <td> Muhammad Ali</td>
                    <td> Odd Andre</td>
                </tr>
            </table>
                </div>
                
                <h3 class="heading3">Implementation of user stories </h3>
                <p class="paragraph">
                    we have implemented <b>7 user stories out of 11</b> which means we have focused on what are the needs of the users.
                    The details, which user stories we have implemented is placed at user stories section.<br>
                Click here!
                <a href="http://localhost:8080/MO-POMA_Tech/Users/user_stories.jsp"> User Stories</a>
                </p>
            
                <p class="paragraph">
                    Project structure is illustrated through this diagram.
                </p>
                <img src="C:/Users/Muhammad Ali/Documents/NetBeansProjects/MO-POMA-Tech-master/MO-POMA-Tech/web/firstdiagram.PNG" alt="overall structure" width="450"  class="image-set" >
                
                <p class="paragraph">
                    The inner part of this structure.
                </p>
                <img src="C:/Users/Muhammad Ali/Documents/NetBeansProjects/MO-POMA-Tech-master/MO-POMA-Tech/web/seconddiagram.PNG" alt="inner structure" width="450"  class="image-set">
    </body>
</html>
