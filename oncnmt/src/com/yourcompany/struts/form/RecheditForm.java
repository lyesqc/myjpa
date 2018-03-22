/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import java.util.List;

/** 
 * MyEclipse Struts
 * Creation date: 08-19-2008
 * 
 * XDoclet definition:
 * @struts.form name="recheditForm"
 */
public class RecheditForm extends ActionForm {
	
	

	private String nrec;
	private String fournisseur;
	private List nomFournisseur;
	private String warehouse;
	private List nomWarehouse;
	private String dat_rec_du;
	private String dat_rec_au;
	private String hidden;
	 
	private String transaction;
	private List typeTrans;
	private String responsable;
	private List nomResp;
	
	private List resultat;
	private String code;
	private String dest;
	private String whs;
	private String date;
	private String resp;
	
	private String hiddenTest;
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	public String getHiddenTest() {
		return hiddenTest;
	}
	
	
	public void setNrec(String nrec) {
		this.nrec = nrec;
	}
	
	public String getNrec() {
		return nrec;
	}

	public void setFournisseur(String fournisseur) {
		
		this.fournisseur = fournisseur;
	}
	
	public String getFournisseur() {
		return fournisseur;
	}
	
	public List getNomFournisseur() {
		return nomFournisseur;
	}	
	
	public void setNomFournisseur(List nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}	
	
 public void setWarehouse(String warehouse) {
		
		this.warehouse = warehouse;
	}
	
	public String getWarehouse() {
		return warehouse;
	}
	
	public List getNomWarehouse() {
		return nomWarehouse;
	}	
	
	public void setNomWarehouse(List nomWarehouse) {
		this.nomWarehouse = nomWarehouse;
	}	
	
public void setDat_rec_du(String dat_rec_du) {
		
		this.dat_rec_du = dat_rec_du;
	}
	
	public String getDat_rec_du() {
		return dat_rec_du;
	}
	
public void setDat_rec_au(String dat_rec_au) {
		
		this.dat_rec_au = dat_rec_au;
	}
	
	public String getDat_rec_au() {
		return dat_rec_au;
	}	
	
 public void setHidden(String hidden) {
		
		this.hidden = hidden;
	}
	
	public String getHidden() {
		return hidden;
	}
	
	public List getResultat() {
		return resultat;
	}

	public void setResultat(List resultat) {
		this.resultat = resultat;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	
	public String getWhs() {
		return whs;
	}

	public void setWhs(String whs) {
		this.whs = whs;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}
	
	
	
	public List getTypeTrans() {
		return typeTrans;
	}	
	
	public void setTypeTrans(List typeTrans) {
		this.typeTrans = typeTrans;
	}
	
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	
	public List getNomResp() {
		return nomResp;
	}	
	
	public void setNomResp(List nomResp) {
		this.nomResp = nomResp;
	}
}