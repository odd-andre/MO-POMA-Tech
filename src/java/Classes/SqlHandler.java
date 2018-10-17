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
    public ResultSet viewModule(String id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals FROM Modules WHERE module_Id =2");
            //selectString.setString(1, id);
            
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
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals " +
                    "FROM Modules " +
                    "WHERE module_Id = ?");
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
            selectString = conn.prepareStatement("INSERT INTO Modules VALUES"
                    + "( module_name, teacher_Id, deadline, learning_Goals) "
                    + "VALUES (?, ?, ?, ?)");
            
            //selectString.setInt(1, id);
            selectString.setString(1, name);
            selectString.setInt(2, tID);
            selectString.setString(3, deadline);
            selectString.setString(4, goals);
           // selectString.setInt("name1",1,11,"2018-09-28","Learn something 1");
            selectString.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Module created sucessfully");
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void updateModule(String name, Integer id, Integer tId, String deadline, String learnGl ){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("UPDATE Modules " 
                + "(SET name = ?,module_Id = ?,teacher_Id = ?,deadline = ?,learning_Goals = ?)"
                + "WHERE module_Id = ?");
            
            selectString.setString(1, name);
            selectString.setInt(2, id);
            selectString.setInt(3, tId);
            selectString.setString(4, deadline);
            selectString.setString(5, learnGl);
            
            selectString.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Saved");
        }//end try
            
            
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
        
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clearState(){
        this.select = "";
        this.where = "";
        this.from = "";
    }
    
    
    // @Resource DataSource LocalhostDS;
    public Connection getConnection(PrintWriter out) {
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
            
        return conn;
    }
    
}


