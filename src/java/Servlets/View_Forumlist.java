/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Forum;
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
 * @author ThunderCow
 */
@WebServlet(name = "View_Forumlist", urlPatterns = {"/View_Forumlist"})
public class View_Forumlist extends HttpServlet {

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
            
            /*Create a sqlHandler to run database queries*/
            SqlHandler sqlHdl = new SqlHandler(out);
            
            /*Queries return as ResultSets so we have to store it as such*/
            ResultSet rst = sqlHdl.showForumList();
                       
            /*We will return the Modules in the form of a ArrayList, this could be done better as there are number of modules.*/
            List<Forum> forum = new ArrayList();
            
            
            try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    Forum forumObj = new Forum();
 
                    Integer fId = rst.getInt("forum_Id");
                    Integer cId = rst.getInt("creator_Id");
                    String fName = rst.getString("fName");
                    
                    /*creating module instance to call these functions & object after that*/
                    forumObj.getforumlist(fId, cId, fName);
                    
                    forum.add(forumObj);
                                        
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
                         
            /*Put data into the requset for the next page allowing us to use it.*/
            request.setAttribute("forum", forum);
            
            /*Get the jsp file where we have put our html*/
            RequestDispatcher view = request.getRequestDispatcher("/Users/viewForumlist.jsp");
            /*Send our data from request into the jsp file*/
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
