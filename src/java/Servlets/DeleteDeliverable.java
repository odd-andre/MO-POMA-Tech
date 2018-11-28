/**
 * @author Petr
 * The purpose of this class is to retrieve deliverable_Id from database to form for deleting deliverable.
 */
package Servlets;

import Entities.Deliverable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteDeliverable", urlPatterns = {"/DeleteDeliverable/*"})
public class DeleteDeliverable extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //This method retrieves deliverableId from database. Which deliverableId is going to be retrieve depends on path of URL.
    // /1 - first deliverable
    // /2 - second deliverable etc.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
           response.setContentType("text/html;charset=UTF-8");
               try (PrintWriter out = response.getWriter()) {
                        
            String path = request.getPathInfo();
            String requestedDeliverable = path.replace("/", "");
            Deliverable delObj = new Deliverable();
            delObj.getDeliverableDetail(Integer.parseInt(requestedDeliverable), out);           
            request.setAttribute("deliverable", delObj);            
            
            RequestDispatcher view = request.getRequestDispatcher("/Users/deleteDeliverable.jsp");
            view.forward(request, response);
            
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
