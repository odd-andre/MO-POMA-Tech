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

    String firstName;
    String surName;
    Integer zip_code;
    String rights;
    String adress;
    String email;
    String datebirth;
    Integer id;
    
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