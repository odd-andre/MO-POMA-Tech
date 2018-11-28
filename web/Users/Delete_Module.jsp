<%-- 
    Document   : Delete_Module
    Created on : Oct 20, 2018, 11:01:37 PM
    Author     : Muhammad Ali
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Module"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Delete Module</title>
    </head>  
    
   <jsp:include page="/WEB-INF/menu.jsp" />
    
    <body style="background-color: powderblue;">
        <h1>Delete / Remove Module</h1>
        <form action="/MO-POMA_Tech/Delete_ModulePost" method="POST">
                        
                          <div class="col-6">
                              <label for="Module_ID">Module ID</label>
                              <input type="text" name="Module_ID" id="Module_ID" value = "${module.getID().intValue()}" class="form-control" placeholder="numeric number">
                          </div>
                        
                            
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Delete it</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-2">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>