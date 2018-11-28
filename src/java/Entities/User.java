/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.servlet.http.HttpServletRequest;
import Classes.SqlHandler;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oddandre
 */
public class User {

    private String firstName;
    private String surName;
    private Integer zip_code;
    private String rights;
    private String adress;
    private String email;
    private String datebirth;
    private Integer id;
    
    public String getfirstName(){return this.firstName;}
    public String getsurName(){return this.surName;}
    public Integer getzip_code(){return this. zip_code;}
    public String getrights(){return this.rights;}
    public String getadress(){return this.adress;}
    public String getemail(){return this.email;}
    public String getdatebirth(){return this.datebirth;}
    public Integer getid(){return this.id;}
    
    public void setfirstName(String firstName){this.firstName = firstName ;}
    public void setsurName(String surName){this.surName = surName ;}
    public void setzip_code(Integer zip_code){this.zip_code = zip_code ;}
    public void setrights(String rights){this.rights = rights ;}
    public void setadress(String adress){this.adress = adress ;}
    public void setemail(String email){this.email = email ;}
    public void setdatebirth(String datebirth){this.datebirth = datebirth ;}
    public void setid(Integer id){this.id = id ;}
    
    public String getUserType(HttpServletRequest request){
        String accessType = "Student";
            if(request.isUserInRole("Teacher")) {
                accessType = "Teacher";
            }
            return accessType;
    }
    
    public static Integer getUserIdByMail(PrintWriter out,String email){
        SqlHandler sqhndl = new SqlHandler(out);
        ResultSet rst = sqhndl.getUserIdByMail(email);
        
        try {
                int rowCount = 0;
                    while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                        Integer user_id = rst.getInt("user_id");
                        //commit and close connection
                        sqhndl.commitAndclose();
                        return user_id;
                     }
            } //End try
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
        //Return null in case the try for some reason does not work and does not get caught.
        return null;
    }
}