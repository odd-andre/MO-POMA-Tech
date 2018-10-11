/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Module;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Muhammad Ali
 */
@WebServlet(name = "View_Module", urlPatterns = {"/View_Module/*"})
public class View_Module extends HttpServlet {

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
            // Get the path after the url, anything after /showstudent/ will show here. In this case /showstudent/{studentId}
             String path = request.getPathInfo();
            // getPathInfo includes the / after showStudent, remove it
             String requestedModule = path.replace("/", "");
            //Create a sqlHandler to run database queries
            SqlHandler sqlHdl = new SqlHandler(out);
            //Queries return as ResultSets so we have to store it as such
            ResultSet rst = sqlHdl.viewModule(requestedModule);
            
            //We will return the student in the form of a ArrayList, this could be done better as there is only one user
            //List<Student> student = new ArrayList();
            //List<Module> module = new ArrayList();
            Module module = null;
            
            try {
            int rowCount = 0;
                while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                    String mName = rst.getString("name");
                    Integer mId   = rst.getInt("module_Id");
                    String mDeadline = rst.getString("deadline");
                    String mLearnGl = rst.getString("learning_Goals");
                    Integer tId   = rst.getInt("teacher_Id");
                    //student.add(new Student(mName,mDeadline,mId, mLearnGl, tId));
                    module = new Module (mName, mDeadline,mLearnGl, mId, tId);
                    ++rowCount;
                 }  // end while
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
            //Put data into the requset for the next page allowing us to use it.
            request.setAttribute("module", module);
            //Get the jsp file where we have put our html
            RequestDispatcher view = request.getRequestDispatcher("/Users/showModule.jsp");
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
