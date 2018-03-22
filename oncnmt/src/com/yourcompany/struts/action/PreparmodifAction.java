/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.yourcompany.struts.form.ParametreForm;

/** 
 * MyEclipse Struts
 * Creation date: 11-14-2008
 * 
 * XDoclet definition:
 * @struts.action path="/preparmodif" name="parametreForm" scope="request" validate="true"
 * @struts.action-forward name="modif" path="/forms/modifacteur.jsp"
 */
public class PreparmodifAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ParametreForm parametreForm = (ParametreForm) form;// TODO Auto-generated method stub
		System.out.println("je s8 ds prepare");
		parametreForm.setHiddenTest("");
		parametreForm.setActeur("");
		parametreForm.setMagaberaki(false);
		parametreForm.setMagaregh(false);
		parametreForm.setMagasmar(false);
		parametreForm.setSuperdist(false);
		parametreForm.setAdmin(false);
		parametreForm.setMagablida(false);
		parametreForm.setMagaconst(false);
		parametreForm.setMagaoran(false);
		parametreForm.setSupereport(false);
		parametreForm.setSuperpre(false);	
		parametreForm.setSuperpost(false)	;
		
		
		return mapping.findForward("modif");
	}
}