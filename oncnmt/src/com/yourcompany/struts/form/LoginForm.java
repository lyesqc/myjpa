
package com.yourcompany.struts.form;

import javax.servlet.http.HttpServletRequest;
import java.lang.*;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;
import java.util.List;


public class LoginForm extends ActionForm {
	
	String nom;

	/** password property */
	private String password;

	/** username property */
	private String username;
	private String werhs;
	private ArrayList privilege;
	private String hiddenTest;
	private String hidden;
	private List listprofil;
	private String profil;
	private String warehouse;
	
	
	
	public String getWarehouse() {
		return warehouse;
	}

	
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	public String getProfil() {
		return profil;
	}

	
	public void setProfil(String profil) {
		this.profil = profil;
	}

	
	
	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ArrayList getPrivilege() {
		return privilege;
	}

	
	public void setPrivilege(ArrayList privilege) {
		this.privilege = privilege;
	}
	
	public String getWerhs() {
		return werhs;
	}

	
	public void setWerhs(String werhs) {
		this.werhs = werhs;
	}
	
	public String getHiddenTest() {
		return hiddenTest;
	}

	
	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	
	public String getHidden() {
		return hidden;
	}

	
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	
	public List getListprofil() {
		return listprofil;
	}

	
	public void setListprofil(List listprofil) {
		this.listprofil = listprofil;
	}	
	
	
	
}


