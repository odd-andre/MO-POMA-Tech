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
    
    Connection conn;        /* Must be defined here as class variables, get their value in the login method*/
    Statement stmt;    
    
    
    public SqlHandler (PrintWriter out){
        this.out = out;
        this.connectDb(out);
    }

    public SqlHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*establishing the connection to database*/
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
            
            ResultSet lagre = selectString.executeQuery();
            /*calling close connectino*/
            this.commitAndclose();
            /*returning the result through variable*/
            return lagre;
        } // end try     
          catch (SQLException ex) {
                out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    /*using separate function to close the connection*/
    public void closeConnection(){
        try {
            conn.close();
        }
        catch (SQLException ex) {
                System.out.println("Ikke lukke DB " +ex);
        }
    }
    /*separate function to commit on DB*/
    public void commit(){
        try {           
             conn.commit();
         } // end try     
          
             catch (SQLException ex) {
                System.out.println("Ikke close DB " +ex);
        }
    }
    /*creating function to commit and close our connection*/
    public void commitAndclose(){
        try {
            conn.commit();
            conn.close();
        }catch (Exception ex){
            System.out.println("Sorry, it could not commit: " +ex);
        }   
    }
    public ResultSet viewModule(String id){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals FROM Modules WHERE module_Id =2");
            //selectString.setString(1, id);
            
            ResultSet lagre = selectString.executeQuery();
            /*calling close connectino*/
            this.commitAndclose();
            /*returning the result through variable*/
            return lagre; 
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
            /*close the connection and retruning the executed result */
            ResultSet vld = selectString.executeQuery();
            this.commitAndclose();
            return vld;
        } // end try     
        catch (SQLException ex) {
             out.println("Ikke lagre i DB " +ex);
        }
        return null;
    }
    
    /*this is what we can have balance by checking the id and set different methods as well */
    public void moduleStorePoint(Integer id, String mName, Integer tID, String deadline, String goals){
        if (id == 0)
            insertModule(mName, tID, deadline, goals);
        else
            updateModule(mName, id, tID, deadline, goals);
        
        getModuleList();
    }
    /*to create new module by the teacher*/
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
            /*commit and closing the connection after execution.*/
            this.commitAndclose();
        } // end try
        catch (SQLException ex) {
            out.println("Ikke lagre i DB " +ex);
        }    
    }
    
    /*updating the existing module in the database*/
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
            /*calling the function to commit and close connection*/
            this.commitAndclose();
        }//end try
            
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" +ex);
        }
    }
    /*delete the module inside by while showing module detail*/
    public void slettModule(Integer id){
        PreparedStatement selectString;
        try {
           /* String sqlq = "DELETE FROM Modules WHERE module_Id=?";
            selectString = conn.prepareStatement(sqlq);
            
            selectString.setInt(1, id);
            if (id != null) {
                int i = selectString.executeUpdate();
                System.out.println(""+i+"Module deleted successfully");
            } */
           
           selectString = conn.prepareStatement("DELETE FROM Modules WHERE module_Id=?");
           selectString.setInt(1, id);
           selectString.executeUpdate();
           /*calling the commit and close the connection*/
            this.commitAndclose();
            }     
        catch (SQLException ex) {
            out.println("Ikke lagre i DB" + ex);
        }
    }
    
    /*displaying all modules at one place*/
    public ResultSet getModuleList(){
        PreparedStatement selectString;
        try {
            selectString = conn.prepareStatement("SELECT module_Id,name,deadline,teacher_Id,learning_Goals " +
                    "FROM Modules ");
                     
            ResultSet lagre = selectString.executeQuery();
            /*calling close connectino*/
            this.commitAndclose();
            /*returning the result through variable*/
            return lagre;
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
            selectString = conn.prepareStatement("SELECT firstname FROM User WHERE user_Id = ?");
                    //"INNER JOIN User as U ON stu.user_Id = U.user_Id " +
                  //  "WHERE stu.user_Id = ?;");
            selectString.setInt(1, id);
            
            ResultSet lagre = selectString.executeQuery();
            /*calling close connectino*/
            this.commitAndclose();
            /*returning the result through variable*/
            return lagre;
        }
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


