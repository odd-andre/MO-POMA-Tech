
package Entities;

import Classes.SqlHandler;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.management.Notification;

/**
 *
 * @author Halim
 */
public class Notifications  {
    String title;
    String content; 
    String date;
    String url;
    

    
    
    //private ArrayList<Notification> Notifications;
    

    

    public  Notifications() {
        
    }
  

   public void createNotificationsList (String title, String content, String date, String url) {
        
       this.title = title;
       this.content = content;
       this.date = date;
       this.url = url;
          
   }
  
    public String getTitle()  {
        return this.title;
   } 
    
    public String getContent() {
        return this.content;
   }
    
    public String getDate()   {
        return this.date;
    }
    
    public String getUrl()    {
        return this.url;
    }
            
    public void dispNotification(){
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.displayNotifications();
    
    
   } 
   
    public void addNotification(String title, String content, Integer user_id, String url) {
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.addNotification(title, content, user_id, url);
        
    }

    
}