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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

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
    public void createPost(Integer forumpost_Id, Integer forum_Id, String datetime_upload, String fPostname, Integer creator){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Forum_post "
                    + "(forumpost_Id, forum_Id, datetime_upload, fPostname, creator) "
                    + "VALUES (?, ?, ?, ?, ?)");
                    
                selectString.setInt(1, forumpost_Id);
                selectString.setInt(2, forum_Id);
                selectString.setString(3, datetime_upload);
                selectString.setString(4, fPostname);
                selectString.setInt(5, creator);
                selectString.executeUpdate();
        }
               
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
    }
        
    public void createCom(Integer comment_Id, Integer forum_Id, Integer forumpost_Id, String datetime_upload_comment, String content, Integer poster){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Forum_comment "
                    + "(comment_Id, forum_Id, forumpost_Id, datetime_upload_comment, content, poster) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");
                    
                selectString.setInt(1, comment_Id);
                selectString.setInt(2, forum_Id);
                selectString.setInt(3, forumpost_Id);
                selectString.setString(4, datetime_upload_comment);
                selectString.setString(5, content);
                selectString.setInt(6, poster);
                selectString.executeUpdate();
                
        }
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
}
}
    public ResultSet getForumCom(Integer id){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT f.forum_Id,f.creator_Id,f.fName, fp.forumpost_Id,fp.datetime_upload,fp.fPostname,fp.creator,fc.comment_Id,fc.datetime_upload_comment,fc.content,fc.poster FROM Forum_post AS fp INNER JOIN Forum as f ON fp.forum_Id=f.forum_Id INNER JOIN Forum_comment AS fc ON fp.forumpost_Id=fc.forumpost_Id WHERE f.forum_Id=?" );
            selectString.setInt(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
}
    
    
}