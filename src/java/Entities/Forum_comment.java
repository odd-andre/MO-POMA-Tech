/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author cyber
 */
public class Forum_comment {

    private final Integer comment_ID;
    private final Integer forum_Id;
    private final Integer forumpost_Id;
    private final String datetime_upload_comment;
    private final Integer poster;
    
     public Forum_comment(Integer comment_ID, Integer forum_Id, Integer forumpost_Id, String datetime_upload_comment, Integer poster){
        this.comment_ID = comment_ID;
        this.forum_Id = forum_Id;
        this.forumpost_Id = forumpost_Id;
        this.datetime_upload_comment = datetime_upload_comment;
        this.poster = poster;
        
    }
    public Integer getcomment_ID(){return this.comment_ID;}
    public Integer getforum_Id(){return this.forum_Id;}
    public String getdatetime_upload_comment(){return this.datetime_upload_comment;}
    public Integer getposter(){return this.poster;}
}
