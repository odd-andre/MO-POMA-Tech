<%-- 
    Document   : menu
    Created on : 28-Nov-2018, 14:41:49
    Author     : cyber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%-- navigation part --%>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MO-POMA TECH</a>
        </div>
            <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/MO-POMA_Tech/">HOME</a></li>
            <li><a href="http://localhost:8080/MO-POMA_Tech/Users/project_Info.jsp">PROJECT INFO</a></li>
                <li><a href="http://localhost:8080/MO-POMA_Tech/Users/user_stories.jsp">User Stories</a></li>
                      <li><a href="https://github.com/Oddpotatoman/MO-POMA-Tech/issues">Issues Done</a></li>
                      
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">STUDENT <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="/MO-POMA_Tech/showStudent/1">Show student</a></li>
                <li><a href="/MO-POMA_Tech/addStudent">Add New Student</a></li>
                <li><a href="/MO-POMA_Tech/showStudents">Student List</a></li>
                </ul>   
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">MODULE <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/Show_Module_Detail/1">Show Module</a></li>
                    <li><a href="/MO-POMA_Tech/Add_Module">Insert Module</a></li>
                    <li><a href="/MO-POMA_Tech/Edit_Module/1">Update Module</a></li>
                    <li><a href="/MO-POMA_Tech/Module_List/">Module List</a></li>
                </ul>
            </li>
      
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">FORUM <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/View_Forum/1">View Forum</a></li>
                    <li><a href="/MO-POMA_Tech/createForum">Create Forum</a></li>
                    <li><a href="/MO-POMA_Tech/View_Forumlist">Forum List</a></li>
                    <li><a href="/MO-POMA_Tech/createPost">Create Post</a></li>
                    <li><a href="/MO-POMA_Tech/createForumCom">Create Comment</a></li>
                    <li><a href="/MO-POMA_Tech//View_ForumCom/1">View Comment List</a></li>                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Deliverable <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/showDeliverable">Show Deliverable</a></li>
                    <li><a href="/MO-POMA_Tech/CreateDeliverable">Create Deliverable</a></li>
                    <li><a href="/MO-POMA_Tech/DeleteDeliverable/6">Delete Deliverable</a></li>
                    <li><a href="/MO-POMA_Tech/Edit_Deliverable/6">Edit Deliverable</a></li>
                    <li><a href="/MO-POMA_Tech/deliverableDetail/6">Show individual Deliverable</a></li>

                </ul>
            </li>
            
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Message <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">View Message</a></li>
                    <li><a href="#">Send Message</a></li>
                </ul>
            </li>
            
              <ul class="nav navbar-nav navbar-right">
                
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Switch Account</a></li>
                
              </ul>
            
         </ul>
        </div>
    </nav>
   