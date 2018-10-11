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
public class Module {
    String name;
    Integer id;
    String deadline;
    Integer tId;
    String learnGl;

   /*Constructor for the class*/
   public Module (String name, String deadline, String learnGl, Integer id, Integer tId){
       
       this.deadline = deadline;
       this.id = id;
       this.learnGl = learnGl;
       this.tId = tId;
       this.name = name;
   }

    /*public Module() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Module(String mName, Integer mId, String mDeadline, String mLearnGl, Integer tId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
   
   /*These are the methods through them we will get our results.*/
   public String getName(){ 
       return this.name; 
   }
   
   public String getDeadline(){ 
       return this.deadline; 
   }
   
   public Integer getID(){ 
       return this.id; 
   }
   
   public String getGoals(){
       return this.learnGl;
   }
   
   public Integer getTeacherID(){ 
       return this.tId; 
   }
   
   public void getModuleDetail(Integer id,PrintWriter out){
        SqlHandler sqlHdl = new SqlHandler(out);
        ResultSet rst = sqlHdl.getModule(id);
         try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    this.name = rst.getString("name");
                    this.id   = rst.getInt("module_Id");
                    this.tId = rst.getInt("teacher_Id");
                    this.deadline = rst.getString("deadline");
                    this.learnGl = rst.getString("learning_Goals");
                    
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
    }
   
   public void createModule(PrintWriter out, String name, Integer id, String deadline, String learnGl, Integer tID){
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.insertModule(id, name, tID, deadline, learnGl);
  
   }
   //to save using printwriter object.
   public void save(PrintWriter out){
   }
}// slutt
    
