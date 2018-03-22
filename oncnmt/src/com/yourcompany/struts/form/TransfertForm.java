/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/** 
 * MyEclipse Struts
 * Creation date: 11-16-2008
 * 
 * XDoclet definition:
 * @struts.form name="sortiForm"
 */
public class TransfertForm extends ActionForm {

	private List listarticle;
	private List listprof;
	private List resul;
	private List resulrang;
	private List listajouter;
	private List listmaga;
	private List listdist;
	private List listmagasin; 
	private List listaprob;
	private String codaprob;
	private String magasourc;
	private String distination;
	private String reserv;
    private String idcode;
	private String hidden;
	private String article;
	private String debut;
	private String fin;
	private String profil;
	private String transaction;
	private String note;
	private String ajouter;
	private String hiddenTest;
	private String mag;
	private String dis;
	private String magasin;
	private String codreserv;
	private String pq;
	private String hlr;
	private String qt;
	private List nomArticle;
	private FormFile file;
	private String destId;
	private String magasdist;
	public String getMagasdist() {
		return magasdist;
	}

	public void setMagasdist(String magasdist) {
		this.magasdist = magasdist;
	}

	public String getDestId() {
		return destId;
	}

	public void setDestId(String destId) {
		this.destId = destId;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	private String trans;
	private Collection  listMagasinId = new ArrayList();
    private Collection  listMagasinLabel = new ArrayList();
    
    private Collection  listdistId = new ArrayList();
    private Collection  listdistLabel = new ArrayList();
    
    
    private List listarticle1;

public List getListarticle1() {
		return listarticle1;
	}

	public void setListarticle1(List listarticle1) {
		this.listarticle1 = listarticle1;
	}

public Collection getListdistId() {
		return listdistId;
	}

	public void setListdistId(Collection listdistId) {
		this.listdistId = listdistId;
	}

	public Collection getListdistLabel() {
		return listdistLabel;
	}

	public void setListdistLabel(Collection listdistLabel) {
		this.listdistLabel = listdistLabel;
	}

public Collection getListMagasinId() {
		return listMagasinId;
	}

	public void setListMagasinId(Collection listMagasinId) {
		this.listMagasinId = listMagasinId;
	}

	public Collection getListMagasinLabel() {
		return listMagasinLabel;
	}

	public void setListMagasinLabel(Collection listMagasinLabel) {
		this.listMagasinLabel = listMagasinLabel;
	}

private List listeordre;
private String doc;
private String  rng_id;
private String  act_id;

private String article1;
private String profil1;
private String destinataire_visible;
private List snocOrders = new ArrayList();
     private   int qteTotal;
       private int qteServed;
        private String order;
        private String orderType;
        private int qteToServe;

    public int getQteToServe() {
        return qteToServe;
    }

    public void setQteToServe(int qteToServe) {
        this.qteToServe = qteToServe;
    }

    public List getSnocOrders() {
        return snocOrders;
    }

    public void setSnocOrders(List snocOrders) {
        this.snocOrders = snocOrders;
    }
// add for snoc change
    

    public int getQteTotal() {
        return qteTotal;
    }

    public void setQteTotal(int qteTotal) {
        this.qteTotal = qteTotal;
    }

    public int getQteServed() {
        return qteServed;
    }

    public void setQteServed(int qteServed) {
        this.qteServed = qteServed;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String numOrder) {
        this.order = numOrder;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
        
 

public String getDestinataire_visible() {
	return destinataire_visible;
}

public void setDestinataire_visible(String destinataire_visible) {
	this.destinataire_visible = destinataire_visible;
}



public String getArticle1() {
	return article1;
}

public void setArticle1(String article1) {
	this.article1 = article1;
}

public String getProfil1() {
	return profil1;
}

public void setProfil1(String profil1) {
	this.profil1 = profil1;
}




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

public String getQt() {
	return qt;
}

public void setQt(String qt) {
	this.qt = qt;
}

public String getPq() {
	return pq;
}

public void setPq(String pq) {
	this.pq = pq;
}


public String getHlr() {
	return hlr;
}

public void setHlr(String hlr) {
	this.hlr = hlr;
}

public String getCodreserv() {
	return codreserv;
}

public void setCodreserv(String codreserv) {
	this.codreserv = codreserv;
}

public String getDoc() {
	return doc;
}

public void setDoc(String doc) {
	this.doc = doc;
}
	
	public List getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(List nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	
	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}
	
	public List getListeordre() {
		return listeordre;
	}

	public void setListeordre(List listeordre) {
		this.listeordre = listeordre;
	}
	
	
	public List getListaprob() {
		return listaprob;
	}

	public void setListaprob(List listaprob) {
		this.listaprob = listaprob;
	}
	
	
	public List getListmagasin() {
		return listmagasin;
	}

	public void setListmagasin(List listmagasin) {
		this.listmagasin = listmagasin;
	}
	
	 public String getMagasin() {
	  		return magasin;
	  	}

	  	public void setMagasin(String magasin) {
	  		this.magasin = magasin;
	  	}

	  public String getMag() {
	  		return mag;
	  	}

	  	public void setMag(String mag) {
	  		this.mag = mag;
	  	}
      
	 public String getDis() {
 		return dis;
 	}

 	public void setDis(String dis) {
 		this.dis = dis;
 	}
      
      
      public String getDistination() {
    		return distination;
    	}

    	public void setDistination(String distination) {
    		this.distination = distination;
    	}
      
      public String getMagasourc() {
  		return magasourc;
  	}

  	public void setMagasourc(String magasourc) {
  		this.magasourc = magasourc;
  	}
      
	
	public String getHiddenTest() {
		return hiddenTest;
	}

	public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	
	
	public String getAjouter() {
		return ajouter;
	}

	public void setAjouter(String ajouter) {
		this.ajouter = ajouter;
	}
	
	private List packList= new ArrayList() ;
	
	
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
	
	


	public List getListdist() {
		return listdist;
	}

	public void setListdist(List listdist) {
		this.listdist = listdist;
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
	
	
	public String getCodaprob() {
		return codaprob;
	}

	public void setCodaprob(String codaprob) {
		this.codaprob = codaprob;
	}
	
	

	
	
	public String getReserv() {
		return reserv;
	}

	public void setReserv(String reserv) {
		this.reserv = reserv;
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
	
	

	
	public List getListarticle() {
		return listarticle;
	}

	public void setListarticle(List listarticle) {
		this.listarticle = listarticle;
	}
	
	
	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	
	
	
	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
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
	
	
	