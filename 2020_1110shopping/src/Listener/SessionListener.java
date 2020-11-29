package Listener;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener{

    /**
     * Default constructor. 
     */
   
    public void sessionCreated(HttpSessionEvent event)  { 
    	HttpSession session=event.getSession();
    	HashMap books=new HashMap();
    	session.setAttribute("books", books);
         // TODO Auto-generated method stub
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	
	
}