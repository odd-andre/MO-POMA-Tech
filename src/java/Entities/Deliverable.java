/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Classes.SqlHandler;
import Entities.Deliverable;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oddandre
 */
public class Deliverable {
    Integer deliverable_Id;
    Integer student_Id;
    Integer teacher_Id;
    Integer module_Id;
    String datetime_Of_Submit;
    String status;
    Integer points;
    String feedback;
    String progression;
    Teacher teach = new Teacher();
    
   
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


 public void getTeachName(PrintWriter out, Integer id) {
       SqlHandler sqlhndl= new SqlHandler(out);
       ResultSet rstst = sqlhndl.getTeacherName(id);
    try {
        while (rstst.next()){
        String teachName = rstst.getString("firstname");
        teach.firstName= teachName;
       } 
        }
     catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
     }
    }


 
 
    