/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.PrintWriter;
import java.sql.*; 
import java.text.SimpleDateFormat;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Date;

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

    public SqlHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
     public ResultSet getDeliverable(Integer id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT deliverable_Id,student_Id,module_Id,teacher_Id,datetime_Of_Submit,status,points,feedback,progression " +
                    "FROM deliverable " +
                    "WHERE deliverable_Id = ?");
            selectString.setInt(1, id);
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
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
        
         public void createDeliverable(Integer student_Id, Integer module_Id, Integer teacher_Id, String status, Integer points,String feedback, String progression){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO deliverable "
                    + "(student_Id,module_Id,teacher_Id,status,points,feedback,progression) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            selectString.setInt(1, student_Id);  
            selectString.setInt(2, module_Id);
            selectString.setInt(3, teacher_Id);
            selectString.setString(4, status);
            selectString.setInt(5, points);
            selectString.setString(6, feedback);
            selectString.setString(7, progression);
            selectString.executeUpdate();
            
            
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
         }
            public void updateDeliverable(Integer deliverable_Id,String status, Integer points,String feedback, String progression ){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE deliverable "
                + "SET status = ?,points = ?,feedback = ?,progression = ? "
                + "WHERE deliverable_Id = ?");
            
            selectString.setInt(1,deliverable_Id);
            selectString.setString(2, status);
            selectString.setInt(3, points);
            selectString.setString(4, feedback);
            selectString.setString(5, progression);            
            selectString.executeUpdate();
            
        }//end try
            
            
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
    
        
    
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
