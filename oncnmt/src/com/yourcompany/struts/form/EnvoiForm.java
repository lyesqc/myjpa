/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class EnvoiForm extends ActionForm {
	
	private List nomArticle;
	private List listprof;
	private List resul;
	private List resulrang;
	private List listajouter;
	private String maga;
	private String parten;
	private String dat;
	private List listmaga;
	private List listparten;
	private String priorite;
	private String idcode;
	private String hidden;
	private String article;
	private String debut;
	private String fin;
	private String profil;
	private String magasin;
	
	
	
	private String note;
        private String doc;
        private String trans;
	
	private List packList= new ArrayList() ;
	
	private List	listmagasin;
	
private List listeordre;
	
	private String ordre;
	
private String hiddenTest;

private String  rng_id;
private String  act_id;

public String getRng_id() {
	return rng_id;
}

public void setRng_id(String rng_id) {
	this.rng_id = rng_id;
}



public String getAct_id() {
	return act_id;
}

public void setAct_id(String act_id) {
	this.act_id = act_id;
}


public String getMagasin() {
	return magasin;
}

public void setMagasin(String magasin) {
	this.magasin= magasin;
}

	
	public String getHiddenTest() {
		return hiddenTest;
	}

	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest= hiddenTest;
	}

	
	public List getListmagasin() {
		return listmagasin;
	}	
	
	public void setListmagasin(List listmagasin) {
		this.listmagasin= listmagasin;
	}
	
	
	
	public List getListeordre() {
		return listeordre;
	}	
	
	public void setListeordre(List listeordre) {
		this.listeordre= listeordre;
	}

	
	
	

public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre= ordre;
	}
	
	
public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}


	public List getListajouter() {
		return listajouter;
	}	
	
	public void setListajouter(List listajouter) {
		this.listajouter = listajouter;
	}
	
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	
	public List getPackList() {
		return packList;
	}	
	
	public void setPackList(List packList) {
		this.packList = packList;
	}
	
	
	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}
	
	
	public String getPriorite() {
		return priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	

	public List getListparten() {
		return listparten;
	}

	public void setListparten(List listparten) {
		this.listparten = listparten;
	}
	
	public List getResul() {
		return resul;
	}

	public void setResul(List resul) {
		this.resul= resul;
	}
	
	public List getResulrang() {
		return resulrang;
	}

	public void setResulrang(List resulrang) {
		this.resulrang = resulrang;
	}
	
	
	public List getListmaga() {
		return listmaga;
	}

	public void setListmaga(List listmaga) {
		this.listmaga = listmaga;
	}
	
	
	public String getMaga() {
		return maga;
	}

	public void setMaga(String maga) {
		this.maga = maga;
	}
	
	
	public String getParten() {
		return parten;
	}

	public void setParten(String parten) {
		this.parten = parten;
	}
	
	
	public String getDat() {
		return dat;
	}

	public void setDat(String dat) {
		this.dat = dat;
	}
	
	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}
	
	
	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
	
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	

	
	public List getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(List nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	
	public List getListprof() {
		return listprof;
	}

	public void setListprof(List listprof) {
		this.listprof = listprof;
	}
	
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
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
}