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
     <h1>Delete / Remove Deliverable_Id</h1>
        <form action="/MO-POMA_Tech/DeleteDeliverablePost" method="POST">
                        
                          <div class="col-6">
                              <label for="deliverable_Id">Deliverable_Id</label>
                              <input type="text" name="deliverable_Id" id="deliverable_Id" value = "${deliverable.getDeliverable_Id().intValue()}" class="form-control" placeholder="numeric number">
                          </div>
                        
                            
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Delete it</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-2">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
