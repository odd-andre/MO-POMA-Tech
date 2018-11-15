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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThunderCow
 */
public class Forum {
    
    Integer forum_Id;
    Integer creator_Id;
    String fName;
    
    List<Forum_Post> forumPosts = new ArrayList();
    
    public Forum(){
       /* this.forum_Id=Forum_Id;
        this.creator_Id=Creator_Id;
        this.fName=ForumName*/
    }
    
    /*public void getForum(Integer Forum_Id, Integer Creator_Id, String ForumName){
        this.forum_Id=Forum_Id;
        this.creator_Id=Creator_Id;
        this.fName=ForumName;
 
    }*/
    
    public void getForumDetail(PrintWriter out, Integer id){
        SqlHandler sqlhandl = new SqlHandler(out);
        ResultSet rst = sqlhandl.getForum(id);
        
        try {
                
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    
                    this.forum_Id = rst.getInt("forum_Id");
                    this.fName = rst.getString("fName");
                    this.creator_Id = rst.getInt("creator_Id");

          
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                
                out.println("Ikke hentet fra DB " +ex);
            }
    }

    public void getforumlist(Integer Forum_Id, Integer Creator_Id, String ForumName){
        this.forum_Id = Forum_Id;
        this.creator_Id = Creator_Id;
        this.fName=ForumName;
    }
   
        public int getFroumID(){return this.forum_Id;}
        public int getCreatorID(){return this.creator_Id;}
        public String getFroumName(){return this.fName;}
    
       /* public void getForumNumber(PrintWriter out, Integer id){
        SqlHandler sqlhandl = new SqlHandler(out);
        sqlhandl.getForum(id);
     }*/
    
       public void createForum(PrintWriter out, Integer forum_Id, Integer creator_Id, String fName){
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.createForum(forum_Id, creator_Id, fName);
   }
        
}
    