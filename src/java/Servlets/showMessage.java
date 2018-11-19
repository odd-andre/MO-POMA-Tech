/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.SqlHandler;
import Entities.Message;
import static java.lang.System.out;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oddandre
 */
@WebServlet(name = "showMessages", urlPatterns = {"/showMessages"})
public class showMessage extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {  
            
            SqlHandler sqlHdl = new SqlHandler(out);
            ResultSet rst = sqlHdl. viewMessages();
            List <Message> messages = new ArrayList();

            try {
                int rowCount = 0;
                    while(rst.next()) {   // Move the cursor to the next row, return false if no more row
                       Message messageObj = new Message();
                      
                        Integer message_id = rst.getInt("message_Id");
                        // Integer instead of string?
                        String datetime_message = rst.getString("datetime_Message");
                        Integer Reciever = rst.getInt("Reciever");
                        Integer Sender = rst.getInt("sender");
                        String Subject = rst.getString("Subject");
                        String Content = rst.getString("Content");
                        
                        
                       
                        messageObj.messageList(message_id, Sender,Reciever, datetime_message, Subject, Content);
                        
                        messages.add(messageObj);
                        
                        
                 
                        ++rowCount;
                     } 
            }
            catch (SQLException ex){
                out.println("Error");
            }
            
            //Put data into the requset for the next page allowing us to use it.
            request.setAttribute("Messages",messages);
            //Get the jsp file where we have put our html
            RequestDispatcher view = request.getRequestDispatcher("/Users/showMessage.jsp");
            //Send our data from request into the jsp file
            view.forward(request,response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request3
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        processRequest(request, response);
    }
        
        catch(SQLException ex){
            
            Logger.getLogger(showMessage.class.getName()).log(Level.SEVERE, null, ex);
            //Logger.getLogger(showMessage.class.getName()).log().log(Level.SEVERE, null, ex);
            
                
        }}
        

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
        try{
        processRequest(request, response);
    }   catch(SQLException ex){
        
        Logger.getLogger(showMessage.class.getName()).log(Level.SEVERE, null, ex);
        
        //Logger.getLogger(showMessage.class.getName()).log()).log(Level.SEVERE, null, ex);
                
    }}

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