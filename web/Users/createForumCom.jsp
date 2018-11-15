<%-- 
    Document   : createForum
    Author     : ThunderCow
--%>

<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Entities.Forum"%>
<%@page import="Entities.Forum_Post"%>
<%@page import="Entities.Forum_comment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>Create Forum Post</title>
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
                <div class="col-10">
                    <h1>Insert Comment</h1>
                    <form action="Create_ForumCom" method="POST">
                        <div class="form-row">
                          <div class="col-3">
                              <label for="Comment_ID">Comment ID</label>
                              <input type="text" name="Comment_ID" id="Comment_ID" class="form-control" placeholder="numeric value">
                          </div>
                            <div class="col-3">
                              <label for="Forum_ID">Forum ID</label>
                              <input type="text" name="Forum_ID" id="Forum_ID" class="form-control" placeholder="numeric value">
                          </div>
                        </div>
                        <div class="form-row">
                            <div class="col-6">
                              <label for="ForumPost_ID">ForumPost_ID</label>
                              <input type="text" name="ForumPost_ID" id="ForumPost_ID" class="form-control" placeholder="numeric value">    
                            </div>
                         <div class="col-6">
                              <label for="DateTime">Date</label>
                              <input type="text" name="DateTime" id="DateTime" class="form-control" placeholder="String text">    
                            </div>
                        </div>
                        <div class="form-row">
                         <div class="col-9">
                              <label for="Content">Content</label>
                              <input type="text" name="Content" id="Content" class="form-control" placeholder="String text">    
                            </div>
                         <div class="col-9">
                              <label for="Poster">Poster</label>
                              <input type="text" name="Poster" id="Poster" class="form-control" placeholder="numeric value">    
                            </div>         
                            <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Add Comment</button><br>
                            <button style="margin-right: 10px;" type="reset" class="btn col-3">Clear</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>