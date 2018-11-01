/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author oddandre
 */
public class SqlHandler {
    String select;
    String where;
    String from;
    
    PrintWriter out;
    
    Connection conn;        // Must be defined here as class variables, get their value in the login method
    Statement stmt;    
    
    
    public SqlHandler (PrintWriter out){
        this.out = out;
        this.connectDb(out);
    }
    private void connectDb(PrintWriter out){
        try {
             // Step 1: Allocate a database 'Connection' object
              Context cont = new InitialContext();
              DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");  
              //DataSource ds = (DataSource)cont.lookup("jdbc/LocalhostDS");
              conn =  ds.getConnection();

             // Step 2: Allocate a 'Statement' object in the Connection
             stmt = conn.createStatement();
            }
            catch (SQLException ex ) {
                out.println("Not connected to database " +ex);
            }
            catch (NamingException nex) {
                out.println("Not correct naming" + nex);
            }
    }
    
    public void select(String selectString){
        this.select = selectString;
    }
    public void where(String whereString){
        this.where = whereString;
    }
    public void from(String fromString){
        this.from = fromString;
    }
    
    public ResultSet runSelect(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT "+this.select+" FROM "+this.from);
            //selectString.setString(1,this.select);
            //selectString.setString(2,this.from);
            
            return selectString.executeQuery();
        } // end try     
          catch (SQLException ex) {
                out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }

    public void closeConnection(){
        try {
            conn.close();
        }
        catch (SQLException ex) {
                System.out.println("Ikke lukke DB " +ex);
        }
    }
    public void commit(){
        try {           
             conn.commit();
         } // end try     
          
             catch (SQLException ex) {
                System.out.println("Ikke close DB " +ex);
                    
        }
    }
    public ResultSet getStudent(String id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT U.user_Id ,stu.semester, U.firstname, U.surname, U.adress, U.email " +
                    "FROM Student as stu " +
                    "INNER JOIN User as U ON stu.user_Id = U.user_Id " +
                    "WHERE stu.user_Id = ?");
            selectString.setString(1, id);
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    public ResultSet viewModule(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals FROM Modules WHERE module_Id = 2");
            //selectString.setString(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    
        public ResultSet getTeacherName(Integer id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT firstname FROM User WHERE user_Id = ?;");
                    //"INNER JOIN User as U ON stu.user_Id = U.user_Id " +
                  //  "WHERE stu.user_Id = ?;");
            selectString.setInt(1, id);
            return selectString.executeQuery();
        }
        catch (SQLException ex) {
             out.println("Error in connection " +ex);
        }
        return null;
    }
    
     public ResultSet viewDeliverable(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT deliverable_Id,student_Id,module_Id,teacher_Id,datetime_Of_Submit,status,points,feedback,progression FROM deliverable ");
           
 

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Connection does not work " +ex);
        }
        return null;
    }
    
    public void clearState(){
        this.select = "";
        this.where = "";
        this.from = "";
    }
    
}
