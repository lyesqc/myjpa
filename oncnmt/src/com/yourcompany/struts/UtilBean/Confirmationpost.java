package com.yourcompany.struts.UtilBean;

public class Confirmationpost {
	private String demande;
	private String destination;
	private String ouvrir;
	private String no;
	private String dest;
	
	public Confirmationpost(){
		this.demande = demande;
		this.destination = destination;
		this.no = no;
		this.ouvrir = ouvrir;
		this.dest = dest;
	}
	
	
	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getOuvrir() {
		return ouvrir;
	}

	public void setOuvrir(String ouvrir) {
		this.ouvrir = ouvrir;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
}
