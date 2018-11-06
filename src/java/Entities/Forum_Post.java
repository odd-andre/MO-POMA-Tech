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

public void getForum_Post(Integer forumpost_Id,PrintWriter out){
        SqlHandler sqlHdl = new SqlHandler(out);
        ResultSet rst = sqlHdl.getForum_Post(forumpost_Id);
        try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    this.forumpost_Id = rst.getInt("forumpost_Id");
                    this.forum_Id = rst.getInt("forum_Id");
                    this.datetime_upload = rst.getString("datetime_upload");
                    this.fPostname = rst.getString("fPostname");
                    this.creator = rst.getInt("creator");
                    
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
}

public void buildStudentForList(Integer fp_Id, Integer f_Id, String date, String fname, Integer cId){
        forumpost_Id = fp_Id;
        forum_Id = f_Id;
        datetime_upload = date;
        fPostname = fname;
        creator = cId;
}
}
    