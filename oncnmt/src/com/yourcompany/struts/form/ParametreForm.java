/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 11-12-2008
 * 
 * XDoclet definition:
 * @struts.form name="parametreForm"
 */
public class ParametreForm extends ActionForm {
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
		
		
	
	}
	
	private boolean magaberaki;
      
	private boolean magasmar;
           
	private boolean magaregh;
       
	private boolean magablida;
        
	private boolean magaconst;
        
	private boolean magaoran;
        
	private boolean admin;
          
	private boolean superdist;
          
	private boolean supereport;
          
	private boolean superpre;
          
	private boolean superpost;
          
	private String acteur;
	private String hidden;
	private String hiddenTest;
	 
	private String test;
	

	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	public String getHiddenTest() {
		return hiddenTest;
	}

	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	public String getActeur() {
		return acteur;
	}

	public void setActeur(String acteur) {
		this.acteur = acteur;
	}
	
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	public boolean getMagaberaki() {
		return magaberaki;
	}

	public void setMagaberaki(boolean magaberaki) {
		this.magaberaki = magaberaki;
	} 
	
	public void setMagasmar(boolean magasmar) {
		this.magasmar = magasmar;
	}
	
	public boolean getMagasmar() {
		return magasmar;
	}

	
	public void setMagaregh(boolean magaregh) {
		this.magaregh = magaregh;
	}
	
	public boolean getMagaregh() {
		return magaregh;
	}

	
	public void setMagablida(boolean magablida) {
		this.magablida = magablida;
	}
	
	public boolean getMagablida() {
		return magablida;
	}
	
	
	public void setMagaconst(boolean magaconst) {
		this.magaconst = magaconst;
	}
	
	public boolean getMagaconst() {
		return magaconst;
	}

	
	public void setMagaoran(boolean magaoran) {
		this.magaoran = magaoran;
	}
	
	public boolean getMagaoran() {
		return magaconst;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	
	public void setSupereport(boolean supereport) {
		this.supereport = supereport;
	}
	
	public boolean getSupereport() {
		return supereport;
	}
	
	public void setSuperdist(boolean superdist) {
		this.superdist = superdist;
	}
	
	public boolean getSuperdist() {
		return superdist;
	}
	
	public void setSuperpre(boolean superpre) {
		this.superpre = superpre;
	}
	
	public boolean getSuperpre() {
		return superpre;
	}
	
	public void setSuperpost(boolean superpost) {
		this.superpost = superpost;
	}
	
	public boolean getSuperpost() {
		return superpost;
	}
	
}