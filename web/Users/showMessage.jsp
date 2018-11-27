<%-- 
    Document   : showMessage
    Created on : 01.nov.2018, 14:03:01
    Author     : Mahamed Salad
--%>


<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
    <head>
        <title>View Page</title>
    </head>
    <body>
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1>Show Message!</h1>
       <div class="col-10"> 
                      
              <table style="width:100%">
              
        <tr>
            <th> Messsge ID</th>
            <th> Date & Time</th>
            <th> Subject</th>
            <th> Content </th>
            
        </tr>
       
        <c:forEach items="${Messages}" var="message"> 
              <tr>
              <td><p>${message.getMessageID().intValue()}</td>
              <td>${message.getdateTime_Message()}</td>
              <td>${message.getSubject()}</p></td>
              <td>${message.getContent()}</p></td>
              </tr> 
       </c:forEach> 
        
        
    </table> 
        
           </div>
      </div>
        </div>
    </body>
</html>
