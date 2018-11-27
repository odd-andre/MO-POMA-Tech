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
import java.text.SimpleDateFormat;
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
            selectString = conn.prepareStatement("SELECT deliverable_Id,module_Id,teacher_Id,datetime_Of_Submit,status,points,feedback,progression " +
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

    public ResultSet getStudent(Integer id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT U.user_Id ,stu.semester, U.firstname, U.surname, U.adress, U.email, U.zip_code, U.date_Of_Birth " +
                    "FROM Student as stu " +
                    "INNER JOIN User as U ON stu.user_Id = U.user_Id " +
                    "WHERE stu.user_Id = ?");
            selectString.setInt(1, id);
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    public ResultSet getModule(Integer id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals FROM Modules WHERE module_Id = ?");
            selectString.setInt(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
     public void insertModule(String name, Integer tID, String deadline, String goals){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Modules "
                    + "(name, teacher_Id, deadline, learning_Goals) "
                    + "VALUES (?, ?, ?, ?)");
            
            //selectString.setInt(1, id);
            selectString.setString(1, name);
            selectString.setInt(2, tID);
            selectString.setString(3, deadline);
            selectString.setString(4, goals);
           // selectString.setInt("name1",1,11,"2018-09-28","Learn something 1");
            selectString.executeUpdate();
            
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        catch (Exception e){
        }
    }
    public void updateStudent(Integer id,String adress, String email,String firstName, String surName, Integer zip, String datebirth){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE User "
                    + "SET adress = ?,email = ?,firstname = ?, surname = ?, zip_code = ?, date_Of_Birth = ? "
                    + "WHERE user_Id = ?");
            
            selectString.setString(1, adress);
            selectString.setString(2,email);
            selectString.setString(3,firstName);
            selectString.setString(4,surName);
            selectString.setInt(5,zip);
            selectString.setString(6,datebirth);
            selectString.setInt(7,id);


            selectString.executeUpdate();
            this.closeConnection();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
    }
    public void updateModule(String name, Integer id, Integer tId, String deadline, String learnGl ){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE Modules "
                + "SET name = ?,teacher_Id = ?,deadline = ?,learning_Goals = ? "
                + "WHERE module_Id = ?");
            
            selectString.setString(1, name);
            selectString.setInt(5, id);
            selectString.setInt(2, tId);
            selectString.setString(3, deadline);
            selectString.setString(4, learnGl);
            
            selectString.executeUpdate();
            
        }//end try
            
            
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
    }
    public void slettModule(Integer id){
        PreparedStatement selectString;
        try {
            String sqlq = "DELETE FROM Modules WHERE module_Id=?";
            selectString = conn.prepareStatement(sqlq);
            
            selectString.setInt(1, id);
            if (id != null) {
                int i = selectString.executeUpdate();
                System.out.println(""+i+"Module deleted successfully");
            }
            conn.close();
            }     
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" + ex);
        }
    }
    public ResultSet getModuleList(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals " +
                    "FROM Modules ");
                     
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    public void insertStudent(Integer id){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Student "
                    + "(user_id, semester) "
                    + "VALUES (?, ?)");
            
            selectString.setInt(1, id);
            selectString.setInt(2,1);
            selectString.executeUpdate();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
    }
    
    public void insertUser(String address, Integer zip, String email, String password, String datebirth, String firstname, String surname){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO User "
                    + "(adress, zip_code, email, password, rights, created_Datetime, date_Of_Birth, firstname, surname) "
                    + "VALUES (?, ?, ? , ? , ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String created = formatter.format(date);
            selectString.setString(1, address);
            selectString.setInt(2, zip);
            selectString.setString(3, email);
            selectString.setString(4, password);
            selectString.setString(5, "student");
            selectString.setString(6, created);
            selectString.setString(7, datebirth);
            selectString.setString(8, firstname);
            selectString.setString(9, surname);
            selectString.executeUpdate();
            
            ResultSet rs = selectString.getGeneratedKeys();
            if(rs.next()){
                Integer id = rs.getInt(1);
                this.insertStudent(id);
            }
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
    }
    public ResultSet viewModule(String id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals FROM Modules WHERE module_Id = ?");
            selectString.setString(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    /*To get teacher name to present in module list*/
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
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    
    public ResultSet getStudents(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT U.user_Id , U.firstname, U.surname, U.email " +
                    "FROM Student as stu " +
                    "INNER JOIN User as U ON stu.user_Id = U.user_Id");
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
   
        
         public void createDeliverable(Integer student_Id, Integer module_Id, Integer teacher_Id,String datetime_Of_Submit, String status, Integer points,String feedback, String progression){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO deliverable "
                    + "(student_Id,module_Id,teacher_Id,datetime_Of_Submit,status,points,feedback,progression) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            selectString.setInt(1, student_Id);  
            selectString.setInt(2, module_Id);
            selectString.setInt(3, teacher_Id);
            selectString.setString(4, datetime_Of_Submit);
            selectString.setString(5, status);
            selectString.setInt(6, points);
            selectString.setString(7, feedback);
            selectString.setString(8, progression);
            selectString.executeUpdate();
            
            
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
         }
            public void updateDeliverable(Integer deliverable_Id, Integer module_Id, Integer teacher_Id, String datetime_Of_Submit, String status, Integer points,String feedback, String progression ){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE deliverable "
                + "SET module_Id = ?, teacher_Id = ?, datetime_Of_Submit = ?, status = ?,points = ?,feedback = ?,progression = ? "
                + "WHERE deliverable_Id = ?");
            
            selectString.setInt(1, module_Id);
            selectString.setInt(2, teacher_Id);        
            selectString.setString(3, datetime_Of_Submit);
            selectString.setString(4, status);
            selectString.setInt(5, points);
            selectString.setString(6, feedback);
            selectString.setString(7, progression);
            selectString.setInt(8, deliverable_Id);            
            selectString.executeUpdate();
            this.closeConnection();
            
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
     
      public void deleteDeliverable(Integer deliverable_Id){
        PreparedStatement selectString;
        try {
            String sqlq = "DELETE FROM deliverable WHERE deliverable_Id=?";
            selectString = conn.prepareStatement(sqlq);
            
            selectString.setInt(1, deliverable_Id);
            if (deliverable_Id != null) {
                int i = selectString.executeUpdate();
                System.out.println(""+i+"Deliverable deleted successfully");
            }
            conn.close();
            }     
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" + ex);
        }
    }
    
    public void clearState(){
        this.select = "";
        this.where = "";
        this.from = "";
    }
    public ResultSet getForum(Integer id){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT forum_Id,creator_Id,fName FROM Forum WHERE forum_Id = ? ");
            selectString.setInt(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
}

public ResultSet showForumList(){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT forum_Id,creator_Id,fName FROM Forum ");
            
            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
}
   
    // @Resource DataSource LocalhostDS;
    public void createForum(Integer forum_Id, Integer creator_Id, String fName){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Forum "
                    + "(forum_Id, creator_Id, fName) "
                    + "VALUES (?, ?, ?)");
            
            selectString.setInt(1, forum_Id);
            selectString.setInt(2, creator_Id);
            selectString.setString(3, fName);
            selectString.executeUpdate();
                
            //JOptionPane.showMessageDialog(null, "Forum created sucessfully");
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        //catch (Exception e){
          //  JOptionPane.showMessageDialog(null, e);
        //}
    }

}