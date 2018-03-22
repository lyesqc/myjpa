package com.yourcompany.struts.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.RequestProcessor;

public class MyRequestProcessor extends RequestProcessor
             {
	
	
	protected boolean isUserConnected(HttpServletRequest request) {
		
		String  user=null;
	    if (request != null) {
	    	HttpSession session = request.getSession(false);
	        if (session != null) {
	        	  user =  (String) session.getAttribute("user");
	        }
	              
	        return user != null;
	    }
	    return false;
	}
	
	
//	 On v�rifie si la session a expir�e : la session expire si l'id de la session n'est pas valide
	protected boolean isSessionValid(HttpServletRequest request) throws  ServletException {
		if (request != null) {
		    return request.isRequestedSessionIdValid();
		}
		        
		return  false;
	}
	
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
	String s = "";
	System.out.println("je suis dans MyRequestProcessor ");
	
	System.out.println("l'action demande est: "+request.getServletPath());
	Enumeration str  = request.getParameterNames();
	System.out.println("We are at : "+ request.getServletPath());
	for (;str.hasMoreElements();){
		s = (String) str.nextElement();
		System.out.println("param : "+s+" : "+request.getParameter(s));
	}

	
	HttpSession session = request.getSession(false); 
	
	if (request.getServletPath().equals("/login.do")) {
		return super.processPreprocess(request, response);
		}
	
	if (request.getServletPath().equals("/main.do")) {
		return super.processPreprocess(request, response);
		}



		try {
			if (isSessionValid(request)) {
			    if (isUserConnected(request)) {
			        return true;
			    } 
			    
			/*	String date = DateFormat.getInstance().format(new Date());
				System.out.println("date actuelle="+date);
				
				
				   String username= (String)request.getSession().getAttribute("username");
				   System.out.println("username"+username);
				   
				   String path_action=request.getServletPath();
				   
				   System.out.println("path_action"+path_action);
				   
				   
				
					
				System.out.println("je vais cr�er le fichier"); 
				File fichier = new File("D:\\gss_log\\"+username+".txt") ;
				PrintWriter out;
				try {
					out = new PrintWriter(new FileWriter(fichier));
					out.write(username+"+"+date+"+"+path_action) ; //�cris bonjour dans le fichier
					out.println() ; //fais un retour � la ligne dans le fichier
					//out.write("Comment allez vous") ; //�cris dans le fichier
				
					out.close() ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				*/
			

				
				
				
				
				
				
				
				
				
				
				
				

			    
			    return super.processPreprocess(request, response);  
			    
			} else {
				request.getRequestDispatcher("/forms/login.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return false;
	}

	
	
	
/*	if(request.getSession(false).getAttribute("username") == null)
	 {
		System.out.println("session est null");	
		
			try {
					
				 //request.getSession(true).setAttribute("utilisateur", true);
				request.getRequestDispatcher("/forms/session_timeout.jsp").forward(request, response);
			
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	else
	{
		System.out.println("session null");	
		return super.processPreprocess(request, response);
	}
	return false;
	}*/
}
