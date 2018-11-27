/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Message;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Mahamed Salad
 */
@WebServlet(urlPatterns = {"/creatMessagePost"})
public class creatMessagePost extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            
            Integer message_Id = Integer.parseInt(request.getParameter("message_Id"));
            
            Integer Sender = Integer.parseInt(request.getParameter("Sender"));
            Integer Reciever = Integer.parseInt(request.getParameter("Reciever"));
            String datetime_message = request.getParameter("datetime_Message");
            String Subject = request.getParameter("Subject");
            String Content = request.getParameter("Content");
            
            Message message = new Message();
            message.creatMessage(out, message_Id,Sender,Reciever,datetime_message,Subject,Content);
            response.sendRedirect("/MO-POMA_Tech/showMessages");
            

          
        }
    }

    
     /**
             * Handles the HTTP <code>GET</code> method.
             *
             * @param request servlet request
             * @param response servlet response
             * @throws ServletException if a servlet-specific error occurs
             * @throws IOException if an I/O error occurs
             */
                @Override
                 protected void doPost  (HttpServletRequest request, HttpServletResponse response)
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
