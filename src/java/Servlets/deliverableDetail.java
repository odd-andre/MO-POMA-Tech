/**
 * @author Petr 
 * The purpose of this class is retrieve individual deliverable, which deliverable 
 * is going to be retrieved depends on path of link.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entities.Deliverable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "deliverableDetail", urlPatterns = {"/deliverableDetail/*"})
public class deliverableDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // The purpose of this method is retrieve individual deliverable, which deliverable 
 //    is going to be retrieved depends on path of link.
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String path = request.getPathInfo();
            String requestedDeliverable = path.replace("/", "");
            
            List<Deliverable> deliverable = new ArrayList();
            Deliverable delObj = new Deliverable();
            delObj.getDeliverableDetail(Integer.parseInt(requestedDeliverable), out);
            deliverable.add(delObj);
            
            request.setAttribute("deliverable", deliverable);
            
            RequestDispatcher view = request.getRequestDispatcher("/Users/deliverableDetail.jsp");
           
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
        return "A servlet to get a students information";
    }// </editor-fold>

}