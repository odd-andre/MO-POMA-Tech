<%-- 
    Document   : viewForumCom
    Created on : 14-Nov-2018, 14:21:57
    Author     : cyber
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Forum"%>
<%@page import="Entities.Forum_comment"%>
<%@page import="Entities.Forum_Post"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>View Forum Comments</title>
    </head>  
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MO-POMA TECH</a>
        </div>
            <ul class="nav navbar-nav">
            <li class="active"><a href="http://localhost:8080/MO-POMA_Tech/">HOME</a></li>  
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">STUDENT <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="#">Show student</a></li>
                <li><a href="#">Add New Student</a></li>
                <li><a href="#">Student List</a></li>
                </ul>   
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">MODULE <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/Show_Module_Detail/1">Individual Module</a></li>
                    <li><a href="/MO-POMA_Tech/Add_Module">Insert Module</a></li>
                    <li><a href="/MO-POMA_Tech/Edit_Module/1">Update Module</a></li>
                    <li><a href="/MO-POMA_Tech/Delete_Module">Remove Module</a></li>
                    <li><a href="/MO-POMA_Tech/Module_List/">Module List</a></li>
                </ul>
            </li>
      
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">FORUM <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/MO-POMA_Tech/View_Forum/1">View Forum</a></li>
                    <li><a href="/MO-POMA_Tech/createForum">Create Forum</a></li>
                    <li><a href="/MO-POMA_Tech/View_Forumlist">Forum List</a></li>
                    <li><a href="/MO-POMA_Tech/createPost">Create Post</a></li>
                    <li><a href="/MO-POMA_Tech/createPost">Create Comment</a></li>
                    <li><a href="/MO-POMA_Tech//View_ForumCom/1">View Comment List</a></li>
                </ul>
            </li>
         </ul>
        </div>
    </nav>
    
    
    <body>
        <div class="container"> 
            <div class="row justify-content-md-center">
        <h1>View Forum!</h1>
       <div class="col-10"> 
                      
              <table style="width:100%">
              
        <tr>
            <th> Forum ID</th>
            <th> Creator ID</th>
            <th> Forum Name</th>
             <th> Forum Post ID</th>
              <th> Forum Post DateTime</th>
               <th> Forum Post Name</th>
                <th> Forum Post Creator</th>
                 <th> Forum Content</th>
                  <th> Forum Poster</th>
                  <th> Comment ID</th>
                  <th> Comment Date</th>

            
        </tr>
        <tr>
            <c:forEach items="${frmComm}" var="frmComm">
              <td><p>${Forum_comment.getFroumID().intValue()}</td>
              <td>${Forum_comment.getCreatorID().intValue()}</td>
              <td>${Forum_comment.getFroumName()}</p></td>
              <td>${Forum_comment.getForumPostID().intValue()}</p></td>
              <td>${Forum_comment.getForumPostDate()}</p></td>
              <td>${Forum_comment.getForumPostName()}</p></td>
              <td>${Forum_comment.getForumPostCreator().intValue()}</p></td>
              <td>${Forum_comment.getForumContent()}</p></td>
              <td>${Forum_comment.getForumPoster()}</p></td>
              <td>${Forum_comment.getForumCommentID()}</p></td>
              <td>${Forum_comment.getForumComDate()}</p></td>
        </tr>
       </c:forEach>
    </table> 
        
           </div>
      </div>
        </div>
    </body>
</html>