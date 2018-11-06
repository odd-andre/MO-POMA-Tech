/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;
import java.io.PrintWriter;

/**
 *
 * @author ThunderCow
 */
public class Forum {
    
    Integer forum_Id;
    Integer creator_Id;
    String fName;
    
    public Forum(){
       /* this.forum_Id=Forum_Id;
        this.creator_Id=Creator_Id;
        this.fName=ForumName*/
    }
    
    public void getForum(Integer Forum_Id, Integer Creator_Id, String ForumName){
        this.forum_Id=Forum_Id;
        this.creator_Id=Creator_Id;
        this.fName=ForumName;
    }

   
        public int getFroumID(){return this.forum_Id;}
        public int getCreatorID(){return this.creator_Id;}
        public String getFroumName(){return this.fName;}
    
       /* public void getForum(PrintWriter out, Integer fId, Integer crtId, String fName){
        SqlHandler sqlhandl = new SqlHandler(out);
        sqlhandl.getForum();
     }*/
    
   
}
    