/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ThunderCow
 */
/*public class Forum_comment extends Forum {

    Integer comment_Id;
    Integer forum_Id;
    
    String forumPost_Name;
    String forumPost_DateTime;
    Integer forumPost_creator;
    
    Integer forumpost_Id;
    String datetime_upload_comment;
    String content;
    Integer poster;*/

public class Forum_comment extends Forum_Post {

    Integer comment_Id;
    //Integer forum_Id;
    
    //String fPostname;
    //String datetime_upload;
    //Integer creator;
    //Integer forumpost_Id;
    
   
    String datetime_upload_comment;
    String content;
    Integer poster;
       
    
     public Forum_comment(){
        /*
        (Integer comment_Id, Integer forum_Id, Integer forumpost_Id, String datetime_upload_comment, String content, Integer poster){
        this.comment_Id = comment_Id;
        this.forum_Id = forum_Id;
        this.forumpost_Id = forumpost_Id;
        this.datetime_upload_comment = datetime_upload_comment;
        this.content = content;
        this.poster = poster;
        */
             
    }
    /*public Integer getcomment_ID(){return this.comment_Id;}
    public Integer getforum_Id(){return this.forum_Id;}
    public String getdatetime_upload_comment(){return this.datetime_upload_comment;}
    public Integer getposter(){return this.poster;}*/
     
     Forum_Post frmPost = new Forum_Post();
     Forum forum = new Forum();
     
       public void getForumCommDetail(PrintWriter out, Integer id){
        SqlHandler sqlhandl = new SqlHandler(out);
        ResultSet rst = sqlhandl.getForumCom(id);
        
        try {
                
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    
                    this.forumpost_Id= rst.getInt("forumpost_Id");    
                    this.datetime_upload= rst.getString("dateime_upload");
                    this.fPostname= rst.getString("fPostname");
                    this.creator=rst.getInt("creator");          
                    this.content=rst.getString("content");
                    this.poster=rst.getInt("poster");
                    this.comment_Id= rst.getInt("comment_Id");
                    this.datetime_upload_comment=rst.getString("datetime_upload_comment");
                    this.forum_Id = rst.getInt("forum_Id");
                    this.creator_Id = rst.getInt("creator_Id");
                    this.fName = rst.getString("fName");           
                    
                    
          
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                
                out.println("Ikke hentet fra DB " +ex);
            }
    }
  
     
     
    public void getforumCom(Integer Comment_Id, Integer Forum_Id, Integer Forumpost_Id, String Datetime_upload_comment, String Content, Integer Poster){
        this.comment_Id = Comment_Id;
        this.forum_Id = Forum_Id;
        this.forumpost_Id = Forumpost_Id;
        this.datetime_upload_comment = Datetime_upload_comment;
        this.content = Content;
        this.poster = Poster;
        
    }
   
        public int getFroumID(){return this.forum_Id;}
        public int getCreatorID(){return this.creator_Id;}
        public String getFroumName(){return this.fName;}
    
        public int getForumPostID(){return  this.forumpost_Id;}
        public String getForumPostDate(){return  this.datetime_upload;}
        public String getForumPostName(){return  this.fPostname;}
        public int getForumPostCreator(){return  this.creator;}
        
        public int getCommentID() {return this.comment_Id;}
        public String getForumContent(){return  this.content;}
        public int getForumPoster(){return  this.poster;}
        public String getForumComDate() {return this.datetime_upload_comment;}
        
     
     
    public void createCom(PrintWriter out, Integer comment_Id, Integer forum_Id, Integer forumpost_Id, String datetime_upload_comment, String content, Integer poster){
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.createCom(comment_Id, forum_Id, forumpost_Id, datetime_upload_comment, content, poster);
}
}