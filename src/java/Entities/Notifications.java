
package Entities;

import Classes.SqlHandler;
import static java.lang.System.out;

/**
 *
 * @author Halim
 */
public class Notifications  {
    String title;
    String content; 
    String date;
    String url;
    Integer id;
    
   
    

    
    
    //private ArrayList<Notification> Notifications;
    

    

    public  Notifications() {
        
    }
  

   public void createNotificationsList (String content, String date, String url) {
        
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
    
    public int getId()        {
        return this.id;
    }
   
   
    public static void addNotification(String content, Integer user_id, String url, String scope) {
        SqlHandler sqlhndl = new SqlHandler(out);
        sqlhndl.addNotification(content, user_id, url, scope);
        
    }
    
}