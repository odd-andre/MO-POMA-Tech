<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Forum_Post;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Create_ForumCom", urlPatterns = {"/Create_ForumCom"})
public class Create_ForumCom extends HttpServlet {

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
             
                Integer forumpost_Id = Integer.parseInt(request.getParameter("ForumPost_ID"));
                Integer forum_Id = Integer.parseInt(request.getParameter("Forum_ID"));
                String datetime_upload = request.getParameter("Date");
                String fPostname = request.getParameter("ForumPost_Name");
                Integer creator = Integer.parseInt(request.getParameter("Creator"));
                
                Forum_Post forum_post = new Forum_Post();
                forum_post.createPost(out, forumpost_Id, forum_Id, datetime_upload, fPostname, creator);
                
                /*Get the jsp file where we have put our html */
            RequestDispatcher view = request.getRequestDispatcher("/Users/createForumCom.jsp");
            /*Send our data from request into the jsp file */
            view.forward(request,response);
        response.sendRedirect("/MO-POMA_Tech");
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Forum_Post;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Create_ForumCom", urlPatterns = {"/Create_ForumCom"})
public class Create_ForumCom extends HttpServlet {

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
             
                Integer forumpost_Id = Integer.parseInt(request.getParameter("ForumPost_ID"));
                Integer forum_Id = Integer.parseInt(request.getParameter("Forum_ID"));
                String datetime_upload = request.getParameter("Date");
                String fPostname = request.getParameter("ForumPost_Name");
                Integer creator = Integer.parseInt(request.getParameter("Creator"));
                
                Forum_Post forum_post = new Forum_Post();
                forum_post.createPost(out, forumpost_Id, forum_Id, datetime_upload, fPostname, creator);
                
                /*Get the jsp file where we have put our html */
            RequestDispatcher view = request.getRequestDispatcher("/Users/createForumCom.jsp");
            /*Send our data from request into the jsp file */
            view.forward(request,response);
        response.sendRedirect("/MO-POMA_Tech");
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
>>>>>>> ThunderCow
