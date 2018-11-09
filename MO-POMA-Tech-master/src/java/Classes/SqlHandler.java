/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.PrintStream;
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



    public SqlHandler(PrintStream out) {
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
    public ResultSet getStudent(String id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT user_Id,adress,email FROM User WHERE user_Id = ?");
            selectString.setString(1, id);
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    
    public void clearState(){
        this.select = "";
        this.where = "";
        this.from = "";
    }

    public ResultSet displayNotifications() {
       PreparedStatement selectString;
       try {
           selectString =  conn.prepareStatement("SELECT title, content, datetime_date, url FROM Notifications ");
           //selectString.setString(1, title);
           return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
       }

    
    public void addNotification(String title, String content, Integer user_id, String url) {
        PreparedStatement selectString;
        try {
            
            selectString =  conn.prepareStatement("INSERT INTO Notifications(title, content, datetime_date, url, user_id) values (?,'?','?', '?', '?', '?')");
            SimpleDateFormat formatter = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
           
            String dateOfTime = formatter.format(date);
            selectString.setString(1, title);
            selectString.setString(2, content);
            selectString.setString(3, dateOfTime);
            selectString.setString(4, url);
            selectString.setInt(5, user_id);
            selectString.executeUpdate();
          } 
          catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
    }

    public ResultSet getNotifications(String requestedNotifications) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
   
}
