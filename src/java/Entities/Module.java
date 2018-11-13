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
    Teacher teach = new Teacher();

		
		public void setLearning_Goals(String learning_Goals) 
		{
			this.learnGl = learning_Goals;
		}
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
   
   /*show individual module detail */
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
                out.println("Ikke h entet fra DB " +ex);
            }
    }
   
   /*to show module list. */
   public void forModuleList(Integer Id, String Name, String Deadline, String learnGl, Integer TID){
       this.id=Id;
       this.name=Name;
       this.tId=TID;
       this.deadline=Deadline;
       this.learnGl=learnGl;
   }
   
   /*function that will fetch teacher name through handler and resultset. */
   public void getTeachName(PrintWriter out, Integer id) {
       SqlHandler sqlhndl= new SqlHandler(out);
       ResultSet rstst = sqlhndl.getTeacherName(id);
    try {
        while (rstst.next()){
        String teachrName = rstst.getString("firstname");
        teach.firstName= teachrName;
        }
            
    }
     catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
   }
   
   //to display teacher name through JSP
   public String getTeachName(){
       return teach.getFirstName();
   }
   
   /*create module function connected with handler. */
    public void createModule(PrintWriter out, String name, String deadline, String learnGl, Integer tID){
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.insertModule(name, tID, deadline, learnGl);
      
   }
    
    /*update existing module. */
    public void updateModule(PrintWriter out, String name, Integer id, Integer tId, String deadline, String learnGl){
   
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.updateModule(name, id, tId, deadline, learnGl);
   }
    
    public void deleteModule(PrintWriter out, Integer id){
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.slettModule(id);
    
}
    
   /* call method to save data connected to sqlhandler. */
   public void save(PrintWriter out, String name, Integer id, Integer tId, String deadline, String learnGl){
       SqlHandler sqlhdl = new SqlHandler(out);
       sqlhdl.updateModule(name, id, tId, deadline, learnGl);
   }

}