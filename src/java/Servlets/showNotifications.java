/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Notifications;
import Entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Halim
 */
@WebServlet(name = "showNotifications", urlPatterns = {"/showNotifications"})
public class showNotifications extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String scope = "Student";
            if(request.isUserInRole("Teacher")) {
                scope = "Teacher";
            }
            Integer user_Id = User.getUserIdByMail(out,request.getRemoteUser()); 
            
            List<Notifications> notifications = new ArrayList();
            SqlHandler sqlhndl = new SqlHandler(out);
           
            ResultSet rst = sqlhndl.displayNotifications(user_Id, scope);
           
            try {
               int rowCount = 0;             
               while (rst.next()){
                   
                   Notifications notifs = new Notifications();
                                     
                   String content = rst.getString("content");
                   String date = rst.getString("date_Created");
                   String url = rst.getString("url");
                   
                   notifs.createNotificationsList(content, date, url);
                   notifications.add(notifs);

                  ++rowCount;
             } 
            }
            catch (SQLException ex)  {
                out.println("couldnt retrieve data");
            }     
            //Commit and close database connection
            sqlhndl.commitAndclose();
   
           //Put data into the requset for the next page allowing us to use it.
            request.setAttribute("notifications", notifications);
            //Get the jsp file where we have put our html
            RequestDispatcher view = request.getRequestDispatcher("/Notifications/showNotifications.jsp");
            //Send our data from request into the jsp file
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
        return "Short description";
    }// </editor-fold>

}
