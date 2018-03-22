package com.yourcompany.struts.action;

import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class CustomizedRequestProcessor extends RequestProcessor {
	
	public void process(HttpServletRequest request,  HttpServletResponse response){
		Enumeration str  = request.getParameterNames();
		System.out.println("We are at : "+ request.getPathInfo());
		for (;str.hasMoreElements();){
			System.out.println(str.nextElement());
		}
	}

}
