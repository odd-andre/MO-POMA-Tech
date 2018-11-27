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
 * @author oddandre
 */
public class User {

  
    String adress;
    String email;
    Integer id;
    
    

public static Integer getUserIdByMail(PrintWriter out,String email){
        SqlHandler sqhndl = new SqlHandler(out);
        ResultSet rst = sqhndl.getUserIdByMail(email);
        
        try {
                int rowCount = 0;
                    while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                        Integer user_id = rst.getInt("user_id");
                        sqhndl.commit();
                        sqhndl.closeConnection();
                        return user_id;
                     }
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
        return null;
        
    }
}