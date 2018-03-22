
package com.yourcompany.struts.form;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class EtaStkForm extends ActionForm {
	private String dat_au;
	private String dat_du;
//	private Date dat_du;
	private String typ;
	private String sdu;
	private String sau;
	private String profil;
	private String article;
	private List nomArticle;
	private List nomProfil;
	private String warehouse;
	private List nomWarehouse;
	private String dist;
	private String cds;
	private String part;
	private List nomDist;
	private List nomCds;
	private List nomPart;
	private String PQ;
	private String packaging;
	private String HLR;
	private String hidden;
	private String hiddenTest;
	private String  hiddensorti;
	private String hiddentdp;
	private String position;
	
	
	private boolean sortie;
	private boolean tdp;
	
	private String promotion;	
	
	//private String sortie;
//	private String tdp;
	
	private String result;
	private List etat;
	private List etat_stock;
	
	
	
	private String heur1;


	public String getHeur1() {
		return heur1;
	}

	public void setHeur1(String heur1) {
		this.heur1 = heur1;
	}
	
	
	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	public List getEtat_stock() {
		return etat_stock;
	}

	public void setEtat_stock(List etat_stock) {
		this.etat_stock = etat_stock;
	}
	
	
	public String getHiddenTest() {
		return hiddenTest;
	}

	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	public String getDat_au() {
		return dat_au;
	}
	public void setDat_au(String dat_au) {
		this.dat_au = dat_au;
	}
	
	public String getDat_du() {
		return dat_du;
	}
	public void setDat_du(String dat_du) {
		this.dat_du = dat_du;
	}
	
/*	public Date getDat_du() {
		return dat_du;
	}
	public void setDat_du(Date dat_du) {
		this.dat_du = dat_du;
	}*/
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}

	
	public String getTyp() {
		return typ;
	}
	
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	
	public String getSdu() {
		return sdu;
	}
	public void setSdu(String sdu) {
		this.sdu = sdu;
	}
	
	public String getSau() {
		return sau;
	}
	
	public void setSau(String sau) {
		this.sau = sau;
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
	
	public List getNomArticle() {
		return nomArticle;
	}	
	
	public void setNomArticle(List nomArticle) {
		this.nomArticle = nomArticle;
	}	
	
	public List getNomProfil() {
		return nomProfil;
	}	
	
	public void setNomProfil(List nomProfil) {
		this.nomProfil = nomProfil;
	}	
	
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
 
	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}
	
	public String getCds() {
		return cds;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	public List getNomDist() {
		return nomDist;
	}	
	
	public void setNomDist(List nomDist) {
		this.nomDist = nomDist;
	}	
	public List getNomCds() {
		return nomCds;
	}	
	
	public void setNomCds(List nomCds) {
		this.nomCds = nomCds;
	}	
	
	public List getNomPart() {
		return nomPart;
	}	
	
	public void setNomPart(List nomPart) {
		this.nomPart = nomPart;
	}	
	
	
	public String getPQ() {
		return PQ;
	}

	public void setPQ(String PQ) {
		this.PQ = PQ;
	}
	
	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getHLR() {
		return HLR;
	}

	public void setHLR(String HLR) {
		this.HLR = HLR;
	}
	
	public String getHiddenSorti() {
		return hiddensorti;
	}

	public void setHiddenSorti(String hiddensorti) {
		this.hiddensorti = hiddensorti;
	}
	
	public String getHiddenTdp() {
		return hiddentdp;
	}

	public void setHiddenTdp(String hiddentdp) {
		this.hiddentdp = hiddentdp;
	}
	
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public boolean getSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}
	
	public boolean getTdp() {
		return tdp;
	}

	public void setTdp(boolean tdp) {
		this.tdp = tdp;
	}
	
	public List getEtat() {
		return etat;
	}

	public void setEtat(List etat) {
		this.etat = etat;
	}
}