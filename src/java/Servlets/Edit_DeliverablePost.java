/**
 * @author Petr
 * The purpose of this class is to POST editing deliverable and edits the values in database.
 */
package Servlets;

import Entities.Deliverable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Edit_DeliverablePost", urlPatterns = {"/Edit_DeliverablePost"})
public class Edit_DeliverablePost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // The aim of this method is edit the record of that deliverable which was retrieved by method editDeliverable*/

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
                Deliverable deliverable = new Deliverable();
                Integer deliverable_Id = Integer.parseInt(request.getParameter("deliverable_Id"));
                Integer module_Id = Integer.parseInt(request.getParameter("module_Id"));
                Integer teacher_Id = Integer.parseInt(request.getParameter("teacher_Id"));
                String datetime_Of_Submit = request.getParameter("datetime_Of_Submit");
                String status = request.getParameter("status");
                Integer points = Integer.parseInt(request.getParameter("points"));
                String feedback = request.getParameter("feedback");
                String progression = request.getParameter("progression");
            
                deliverable.updateDeliverable(out, deliverable_Id, module_Id,teacher_Id, datetime_Of_Submit, status, points, feedback, progression);
                response.sendRedirect("/MO-POMA_Tech/deliverableDetail/"+deliverable_Id);                        
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
        processRequest(request, response);
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
        processRequest(request, response);
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