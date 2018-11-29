<%-- 
    Document   : addMessage
    Created on : Nov 27, 2018, 10:45:23 AM
    Author     : ;Mahamed Salad
--%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <head>
        <title>Add Message</title>
    </head>
    <jsp:include page="/WEB-INF/menu.jsp" />
  
    <body style="background-color: powderblue;">
        
        <style> 
        body {
                background-color: powderblue;
            }
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
            
        </style>
    <body>
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-10">
                    <h1>Add Message</h1>
                    <form action="/MO-POMA_Tech/creatMessagePost" method="POST">
                        <div class="form-row">
                          <div class="col-6">
                              <label for="message_Id">Message Id</label>
                              <input type="text" name="message_id" id="message_Id" class="form-control" placeholder="message_Id">
                                              
                          </div>
                          <div class="col-6">
                              <label for="datetime_message">datetime_message</label>
                              <input type="text" name="datetime_message" id="datetime_message" class="form-control" placeholder="datetime_message">
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-9">
                              <label for="Reciever">Reciever</label>
                              <input type="text" class="form-control" name="reciever" id="reciever" placeholder="Reciever">
                            </div>
                            <div class="col-3">
                                <label for="Sender">Sender</label>
                                <input type="text" name="Sender" id="Sender" class="form-control" placeholder="Sender">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-9">
                              <label for="Subject ">Subject </label>
                              <input type="text" class="form-control" name="Subject" id="Subject" placeholder="Subject">
                            </div>
                            <div class="col-3">
                                <label for="Content">Content</label>
                                <input type="text" name="Content" id="Content" class="form-control" placeholder="Content">
                            </div>
                        </div>
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">creat Message</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>