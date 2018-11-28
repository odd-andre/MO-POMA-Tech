<%-- 
    Document   : deleteDeliverable
    Created on : 13.11.2018, 12:11:00
    Author     : Petr
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Deliverable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>CreateDeliverable</title>
    </head>  
    
    <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">
     <h1>Delete deliverable</h1>
        <form action="/MO-POMA_Tech/deleteDeliverablePost" method="POST">
                        
                          <div class="col-sm-6">
                              <label for="deliverable_Id">Deliverable_Id</label>
                              <input type="text" name="deliverable_Id" id="deliverable_Id" value = "${deliverable.getDeliverable_Id().intValue()}" class="form-control" placeholder="numeric number" required>
                          </div>
                        
                            
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Delete it</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-2">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
