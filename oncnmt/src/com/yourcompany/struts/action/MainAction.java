
package com.yourcompany.struts.action;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yourcompany.struts.form.LoginForm;





public class MainAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		LoginForm loginForm = (LoginForm) form;
		HttpSession session = request.getSession();
		session.invalidate();
		loginForm.setHiddenTest("");
		System.out.println("main action 2");
		
		
		
		System.out.println("succes ds l'import");
		
		
			
		
		
		return mapping.findForward("initial"); 
	}
}