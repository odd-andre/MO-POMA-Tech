/**
 * @author Petr 
 * The purpose of this class is retrieve all deliverables in database.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Deliverable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "showDeliverable", urlPatterns = {"/showDeliverable"})
public class showDeliverable extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //The purpose of this method is retrieve all deliverables in database.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
      
           SqlHandler sqlHdl = new SqlHandler(out);
           ResultSet rst = sqlHdl.viewDeliverable();
         
           List<Deliverable> deliverable = new ArrayList();         
          
         try {
              
             int rowCount = 0;
             while (rst.next()) {
                 Deliverable deliverableObj = new Deliverable();
                 Integer deliverable_Id = rst.getInt("deliverable_Id");
                 Integer student_Id = rst.getInt("student_Id");
                 Integer module_Id = rst.getInt("module_Id");
                 Integer teacher_Id  = rst.getInt("teacher_Id");
                 String datetime_Of_Submit = rst.getString("datetime_Of_Submit");
                 String status = rst.getString("status");
                 Integer points = rst.getInt("points");
                 String feedback = rst.getString("feedback");
                 String progression = rst.getString("progression");
                 
                 deliverableObj.deliverableList(deliverable_Id, teacher_Id, student_Id, module_Id, datetime_Of_Submit, status, points, feedback, progression);                    
                 deliverable.add(deliverableObj);
                 
                 ++rowCount;                
             }
              }
             catch (SQLException ex){
                     out.println("Error");
                     }                     
     
            request.setAttribute("deliverable", deliverable);           
            RequestDispatcher view = request.getRequestDispatcher("/Users/showDeliverable.jsp");
            
            view.forward(request,response);        
        }
        }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(showDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(showDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
