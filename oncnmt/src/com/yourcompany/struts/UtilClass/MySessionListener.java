package com.yourcompany.struts.UtilClass;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;

public class MySessionListener
implements HttpSessionListener {
public MySessionListener() throws NamingException {
		
}


public void contextInitialized(ServletContextEvent event) throws NamingException {

	Context ctx = new InitialContext();
	HashMap map = new HashMap();
	ctx.rebind("ListeUtilisateur",map);	

	    }



public void sessionCreated(HttpSessionEvent sessionEvent) {
// Get the session 
HttpSession session = sessionEvent.getSession();
try {
System.out.println("Session created: "+session);
session.setAttribute("foo","bar");





} catch (Exception e) {
System.out.println("Error in setting session attribute:");
}
}

public void sessionDestroyed(HttpSessionEvent sessionEvent) {
// Get the session that was invalidated
HttpSession session = sessionEvent.getSession();
// Log a message
System.out.println("Session invalidated: "+session);
System.out.println("The name is: " + session.getAttribute("foo"));
}
}
