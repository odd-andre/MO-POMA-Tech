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

    public ResultSet getForum_Post(Integer forumpost_Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public ResultSet getForum(Integer id){
    PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT forum_Id,creator_Id,fName FROM Forum WHERE forum_Id = ?");
            selectString.setInt(1, id);

            return selectString.executeQuery();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        return null;
}

    public ResultSet getForum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}