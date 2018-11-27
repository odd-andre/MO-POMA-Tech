<%-- 
    Document   : addMessage
    Created on : Nov 27, 2018, 10:45:23 AM
    Author     : ;Mahamed Salad
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
        <title>Add Message</title>
    </head>
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
                              <input type="Reciever " class="form-control" name="Reciever " id="email" placeholder="Reciever ">
                            </div>
                            <div class="col-3">
                                <label for="Sender">Sender</label>
                                <input type="text" name="Sender" id="Sender" class="form-control" placeholder="Sender">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-9">
                              <label for="Subject ">Subject </label>
                              <input type="text" class="form-control" name="Subject " id="Subject " placeholder="Subject ">
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