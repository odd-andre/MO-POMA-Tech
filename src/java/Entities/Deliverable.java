/**
 *
 * @author Petr Netolický
 * The purpose is definite all variables of entity deliverables, and create there getters.
 * Also called there all methods from sql handlers which are connected with entity deliverable 
 * which makes code less confusing.
 *
 * 
 */
package Entities;
import Classes.SqlHandler;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

//private variables
public class Deliverable {
    private Integer deliverable_Id;
    private Integer student_Id;
    private Integer teacher_Id;
    private Integer module_Id;
    private String datetime_Of_Submit;
    private String status;
    private Integer points;
    private String feedback;
    private String progression;
     
   //constructor
public Deliverable(){
         
    }  
    public Deliverable(Integer deliverable_Id, Integer student_Id, Integer module_Id, String datetime_Of_Submit, String status, Integer points,String feedback, String progression){
        this.deliverable_Id = deliverable_Id;
        this.student_Id = student_Id;
        this.module_Id = module_Id;
        this.datetime_Of_Submit = datetime_Of_Submit;
        this.status = status;
        this.points = points;
        this.feedback = feedback;
        this.progression= progression;
         } 
      public void deliverableList(Integer deliverable_Id, Integer teacher_Id, Integer student_Id, Integer module_Id, String datetime_Of_Submit, String status, Integer points,String feedback, String progression){
     this.deliverable_Id = deliverable_Id;
     this.teacher_Id = teacher_Id;
        this.student_Id = student_Id;
        this.module_Id = module_Id;
        this.datetime_Of_Submit = datetime_Of_Submit;
        this.status = status;
        this.points = points;
        this.feedback = feedback;
        this.progression= progression;
         
       }
    public Integer getDeliverable_Id(){return this.deliverable_Id;}
    public Integer getStudent_Id(){return this.student_Id;}
    public Integer getTeacher_Id(){return this.teacher_Id;}
    public Integer getModule_Id(){return this.module_Id;}
    public String getDatetime_Of_Submit(){return this.datetime_Of_Submit;}
    public String getStatus(){return this.status;}
    public Integer getPoints(){return this.points;}
    public String getFeedback(){return this.feedback;}
    public String getProgression(){return this.progression;}
    
    // This method allows us to retrive data from database in our system
       public void getDeliverableDetail(Integer id,PrintWriter out){ 
        SqlHandler sqlHdl = new SqlHandler(out);
        ResultSet rst = sqlHdl.getDeliverable(id);
         try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                 this.deliverable_Id = rst.getInt("deliverable_Id");
                 this.module_Id = rst.getInt("module_Id");
                 this.teacher_Id = rst.getInt("teacher_Id");
                 this.datetime_Of_Submit = rst.getString("datetime_Of_Submit");
                 this.status = rst.getString("status");
                 this.points = rst.getInt("points");
                 this.feedback = rst.getString("feedback");
                 this.progression = rst.getString("progression");
                    ++rowCount;
                 }  
            }
            catch (SQLException ex) {
                out.println("Ikke h entet fra DB " +ex);
            }
    }
    
       // Creating deliverable (calling method from sql handler)
    public void createDeliverable(PrintWriter out,Integer student_Id, Integer module_Id, Integer teacher_Id, String datetime_Of_Submit, String status, Integer points,String feedback, String progression){
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.createDeliverable(student_Id, module_Id, teacher_Id, datetime_Of_Submit, status, points, feedback, progression);
    sqlhndl.commitAndclose();
    }
      // Deleting deliverable (calling method from sql handler)
     public void deleteDeliverable(PrintWriter out, Integer deliverable_Id){
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.deleteDeliverable(deliverable_Id);   
         sqlhndl.commitAndclose();
}
     // Updating deliverable (calling method from sql handler)
  public void updateDeliverable(PrintWriter out, Integer deliverable_Id, Integer module_Id, Integer teacher_Id, String datetime_Of_Submit, String status, Integer points, String feedback, String progression){
   
       SqlHandler sqlhndl = new SqlHandler(out);
       sqlhndl.updateDeliverable(deliverable_Id, module_Id, teacher_Id, datetime_Of_Submit, status, points, feedback, progression);
       sqlhndl.commitAndclose();
  }
   
  // Saving deliverable in system (calling method from sql handler)
   public void save(PrintWriter out, Integer deliverable_Id, Integer module_Id, Integer teacher_Id, String datetime_Of_Submit, String status, Integer points, String feedback, String progression){
       SqlHandler sqlhndl = new SqlHandler();
       sqlhndl.updateDeliverable(deliverable_Id, module_Id, teacher_Id, datetime_Of_Submit, status, points, feedback, progression);
       sqlhndl.commitAndclose();
   }
   
   }
 
    