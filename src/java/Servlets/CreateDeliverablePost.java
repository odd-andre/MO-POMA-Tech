/**
 * @author Petr
 * The purpose of this class is to POST form of creating deliverable and save data in database.
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

@WebServlet(urlPatterns = {"/CreateDeliverablePost"})
public class CreateDeliverablePost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // This method guarantees storage of data to database, which are filled in by teacher.
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer student_Id = Integer.parseInt(request.getParameter("student_Id"));
            Integer module_Id = Integer.parseInt(request.getParameter("module_Id"));
            Integer teacher_Id = Integer.parseInt(request.getParameter("teacher_Id"));
            String datetime_Of_Submit = request.getParameter("datetime_Of_Submit");
            String status = request.getParameter("status");
            Integer points = Integer.parseInt(request.getParameter("points"));
            String feedback = request.getParameter("feedback");
            String progression = request.getParameter("progression");
            Deliverable deliverable = new Deliverable();
            deliverable.createDeliverable(out,student_Id, module_Id, teacher_Id,datetime_Of_Submit, status, points, feedback,progression);
            response.sendRedirect("/MO-POMA_Tech/showDeliverable?view_Deliverable=view_Deliverable");
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

