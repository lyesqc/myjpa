package com.yourcompany.struts.UtilBean;




public class Ordre {

private String ordre;
	private String type;
	private String whs;
	private String code;
	private String ouvrir;
	private String	partt;
	private String	mag;

	private String date;
	private String prio;
	private String part;
	private String pri; 
private String dat; 
private String distributeur;
private String dist;
private String cmd;
private String codreserv;
private String aprob;	
private String aprobb;	
private String user;
private String annuler;

private Integer consommation;
	
public String getAnnuler() {
	return annuler;
}

public void setAnnuler(String annuler) {
	this.annuler = annuler;
}
	
	
	public Ordre()
	{
		this.consommation=consommation;
		this.ordre=ordre;
		this.type=type;
		this.whs=whs;
		this.code=code;
		this.date=date;
		this.prio=prio;
		this.part=part;
		this.ouvrir=ouvrir;
		this.pri=pri;
		this.dat=dat;
		this.mag=mag;
		this.distributeur=distributeur;
		this.cmd=cmd;
		this.codreserv=codreserv;
		this.dist=dist;
		this.aprob=aprob;
		this.aprobb=aprobb;
	}
	public Integer getConsommation() {
		return consommation;
	}

	public void setConsommation(Integer consommation) {
		this.consommation = consommation;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getAprob() {
		return aprob;
	}

	public void setAprob(String aprob) {
		this.aprob = aprob;
	}
	
	public String getAprobb() {
		return aprobb;
	}

	public void setAprobb(String aprobb) {
		this.aprobb = aprobb;
	}
	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public String getCodreserv() {
		return codreserv;
	}

	public void setCodreserv(String codreserv) {
		this.codreserv = codreserv;
	}
	
	 public String getDist() {
	  		return dist;
	  	}

	  	public void setDist(String dist) {
	  		this.dist = dist;
	  	}
	
	  public String getDistributeur() {
	  		return distributeur;
	  	}

	  	public void setDistributeur(String distributeur) {
	  		this.distributeur = distributeur;
	  	}
	
	
	
	public String getMag() {
		return mag;
	}
	
	public void setMag(String mag) {
		this.mag= mag;
	}
	
	public String getDat() {
		return dat;
	}
	
	public void setDat(String dat) {
		this.dat= dat;
	}
	

	public String getPri() {
		return pri;
	}
	
	public void setPri(String pri) {
		this.pri= pri;
	}
	
	public String getOrdre() {
		return ordre;
	}



public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	


	public void setType(String type) {
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}

	
	
	public String getWhs() {
		return whs;
	}

	public void setWhs(String whs) {
		this.whs = whs;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code= code;
	}
	
	public String getOuvrir() {
		return ouvrir;
	}

	public void setOuvrir(String ouvrir) {
		this.ouvrir= ouvrir;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date= date;
	}
	
	
	
	
	public String getPrio() {
		return prio;
	}
	
	public void setPrio(String prio) {
		this.prio= prio;
	}
	
	
	
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part= part;
	}
	

	public String getPartt() {
		return partt;
	}



public void setPartt(String partt) {
		this.partt = partt;
	}
	
	
	
}
