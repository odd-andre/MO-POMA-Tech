/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ThunderCow
 */
public class Forum_Post extends Forum {

    String fName;
    private Integer forumpost_Id;
    private String datetime_upload;
    private String fPostname;
    private Integer creator;
   
    public Forum_Post(Integer forumpost_Id, Integer forum_Id, String datetime_upload, String fPostname, Integer creator){
        this.forumpost_Id = forumpost_Id;
        this.forum_Id = forum_Id;
        this.datetime_upload = datetime_upload;
        this.fPostname = fPostname;
        this.creator = creator;
        
    }
    public Integer getforumpost_Id(){return this.forumpost_Id;}
    public Integer getforum_Id(){return this.forum_Id;}
    public String getdatetime_upload(){return this.datetime_upload;}
    public String getfPostname(){return this.fPostname;}
    public Integer getcreator(){return this.creator;}
}