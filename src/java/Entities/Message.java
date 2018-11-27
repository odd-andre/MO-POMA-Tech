/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Classes.SqlHandler;
import Entities.Message;
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;




/**
 *
 * @author Mahamed Salad
 *
 */
public class Message {
    Integer message_Id;
    Integer sender;
    Integer reciever;
    // Datetime is a string, not an integer
    String dateTime_Message;
    String  subject;
    String  content;
     
    public Message(){
          
}
     public void messageList(Integer message_Id, Integer Sender, Integer Reciever, String dateTime_Message, String Subject, String Content){
         this.message_Id = message_Id;
         // Not the same name as parameters
         this.sender = Sender;
         this.reciever = Reciever;
         // Duplicate
         //this.sender = sender;
         this.dateTime_Message = dateTime_Message;
         // Not same name as parameters
         this.subject = Subject;
         this.content = Content;
     }
     
     
        public Integer getMessageID(){return this.message_Id;}
        public Integer getSender(){return this.sender;}
        public Integer getReciever(){return this.reciever;}
        public String getdateTime_Message(){return this.dateTime_Message;}
        public String getSubject(){return this.subject;}
        public String getContent(){return this.content;}
        
        
        
        public void creatMessage(PrintWriter out,Integer message_Id, Integer Sender, Integer Reciever, String dateTime_Message, String Subject, String Content){
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.createMessage(message_Id, Sender,Reciever,dateTime_Message,Subject,Content);               
     }
     
         
     }


     

