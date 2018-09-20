/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Petr
 */
@WebServlet(name = "AddModule", urlPatterns = {"/AddModule"})
public class addModule extends HttpServlet {

    Connection conn;

    Statement pst; 
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get the path
            String path = request.getPathInfo();
            // getPathInfo includes the / after showStudent, remove it
            String requestedStudent = path.replace("/", "");
            //Create a sqlHandler to run database queries
            SqlHandler sqlHdl = new SqlHandler(out);
            //Queries return as ResultSets so we have to store it as such
            ResultSet rst = sqlHdl.getStudent(requestedStudent);
            
                  Context cont = new InitialContext();
              DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");  
              //DataSource ds = (DataSource)cont.lookup("jdbc/LocalhostDS");
		  conn =  ds.getConnection();
                   name =
		 try {String query="insert into Module (id,name,deadline,learning_Goals) values (?,?,?,?)";
			pst.setString(1,id.getText());
			pst.setString(2,name.getText());
			pst.setString(3,deadline.getText());
			pst.setString(4,learning_Goals.getText());
			
			pst.execute();
			
			showMessageDialog(null, "Module created");
		
            }
            catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
            }
            //Put data into the requset for the next page allowing us to use it.
            request.setAttribute("students", module);
            //Get the jsp file where we have put our html
            RequestDispatcher view = request.getRequestDispatcher("/Users/Addmodule.jsp");
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
        return "A servlet to get a students information";
    }// </editor-fold>

}
