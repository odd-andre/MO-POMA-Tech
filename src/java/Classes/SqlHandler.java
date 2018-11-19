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
    private void connectDb(PrintWriter out){
        try {
             // Step 1: Allocate a database 'Connection' object
              Context cont = new InitialContext();
              DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");  
              //DataSource ds = (DataSource)cont.lookup("jdbc/LocalhostDS");
             // Step 2: Allocate a 'Statement' object in the Connection
             
            conn =  ds.getConnection();
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
    public ResultSet getMessageDetail(Integer id){
        PreparedStatement selectString;
        try {
                selectString = conn.prepareStatement("SELECT message_Id,datetime_Message,Reciever,Sender,Subject,Content FROM Messages WHERE message_Id=? ");
            selectString.setInt(1, id);
            
            return selectString.executeQuery();
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    
    
    public void createMessage(Integer user_Id,Integer message_id,Integer Reciever, Integer dateTime_message,String Subject, String Content){
    PreparedStatement selectString;
    
    try{
        selectString = conn.prepareStatement("INSERT INTO Messages " +"(user_Id, message_id, Sender, Reciever, dateTime_message,Subject,Content)" + "VALUES(?,?,?,?,?,?,?)");
            
            selectString.setInt(1, user_Id);
            selectString.setInt(2,message_id);
            selectString.setInt(4,Reciever);
            selectString.setInt(5,dateTime_message);
            selectString.setString(6, Subject);
            selectString.setString(7, Content);
           
            selectString.executeUpdate();
                
                
                
    }
    catch (SQLException ex){
        out.println("ikke lagre i DB " + ex);
    }
    
    }
           
    
             public void updatemessage(Integer message_Id,Integer dateTime_message,String Subject, String Content ){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE Messages "
                + "SET dateTime_message = ?,Subject = ?,Content = ? "
                + "WHERE messages_Id = ?");
            
            selectString.setInt(1,message_Id);
            selectString.setInt(2, dateTime_message);
            selectString.setString(3,Subject);
            selectString.setString(4, Content);
                      
            selectString.executeUpdate();
            
        }//end try
            
            
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
        
             }
    
        public void insertMessages(Integer message_Id,Integer dateTime_message,String Subject, String Content){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("INSERT INTO Messages "
                    + "(message_Id, datetime_message,Subject,Content) "
                    + "VALUES (?, ?, ? , ? , ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String created = formatter.format(date);
            
            selectString.setInt(1, message_Id);
            selectString.setInt(2, dateTime_message);
            selectString.setString(3, Subject);
            selectString.setString(4, Content);
         
            selectString.executeUpdate();
            
            ResultSet rs = selectString.getGeneratedKeys();
            
            
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
    
    }
   
    public ResultSet viewMessages(){
                PreparedStatement selectString;
                
                try{                                               //lower case on I in message_Id 
                    selectString = conn.prepareStatement("SELECT message_Id , datetime_Message, Reciever, Sender , Subject , Content FROM Messages");
                    
                    return selectString.executeQuery();
                }
                    catch (SQLException ex){
                        out.println("Connection does not work " + ex);
                    
                    }
                       return null;
            }  

    public void insertMessage(Integer message_Id, Integer Sender, Integer Reciever, Integer dateTime_Message, String Subject, String Content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
   
    /**
     *clearState 
     */
   /* public void clearState(){
        this.select = "";
        this.where = "";
        this.from = "";
    }*/
    
}
             


 






