package jaom.org.listeners;

import jaom.org.utils.PropertiesReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	//Logic necessary for WebApplication startup
        PropertiesReader.getInstance();
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	//Logic necessary for WebApplication finish
    }

	
}
