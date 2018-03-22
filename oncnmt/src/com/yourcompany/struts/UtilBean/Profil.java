package com.yourcompany.struts.UtilBean;

public class Profil {
	
	
	
	private String prof;
	private String whs;
	private String profil;
	private String profil_user;
	private String supprimer;
	
	
	public String getSupprimer() {
		return supprimer;
	}

	public void setSupprimer(String supprimer) {
		this.supprimer = supprimer;
	}
	
	public String getProfil_user() {
		return profil_user;
	}

	public void setProfil_user(String profil_user) {
		this.profil_user = profil_user;
	}
	
	
	public Profil()
	{
		this.prof=prof;
		this.whs=whs;
	}	
	
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getWhs() {
		return whs;
	}
	public void setWhs(String whs) {
		this.whs = whs;
	}

}
