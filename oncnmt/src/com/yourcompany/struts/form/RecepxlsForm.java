/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yourcompany.struts.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Lyes.BENSAADA
 */
public class RecepxlsForm extends org.apache.struts.action.ActionForm {
    
    
    

   public String getWhId() {
        return whId;
    }

    public void setWhId(String whId) {
        this.whId = whId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }
    private String whId;
    private String note;
    private String description;
    private Collection  listMagasinId = new ArrayList();
    private Collection  listMagasinLabel = new ArrayList();

    public Collection getListMagasinLabel() {
        return listMagasinLabel;
    }

    public void setListMagasinLabel(Collection listMagasinLabel) {
        this.listMagasinLabel = listMagasinLabel;
    }
    private String fourId;
    private String arId;
    private Collection listArtId = new ArrayList();
    private Collection listArtLabel = new ArrayList();
    private String hiddenTest;
    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getProfilId() {
        return profilId;
    }

    public void setProfilId(String profilId) {
        this.profilId = profilId;
    }

    public Collection getListProfileId() {
        return listProfileId;
    }

    public void setListProfileId(Collection listProfile) {
        this.listProfileId = listProfile;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }
    private String profilId;
    private Collection listProfileId = new ArrayList();
    private Collection listProfileLabel = new ArrayList();

    public Collection getListArtLabel() {
        return listArtLabel;
    }

    public void setListArtLabel(Collection listArtLabel) {
        this.listArtLabel = listArtLabel;
    }

    public Collection getListProfileLabel() {
        return listProfileLabel;
    }

    public void setListProfileLabel(Collection listProfileLabel) {
        this.listProfileLabel = listProfileLabel;
    }
    private String hidden;
    
    
    public void setHiddenTest(String hiddenTest) {
		this.hiddenTest = hiddenTest;
	}
	
	public String getHiddenTest() {
		return hiddenTest;
	}
    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

    public Collection getListArtId() {
        return listArtId;
    }

    public void setListArtId(Collection listArt) {
        this.listArtId = listArt;
    }

    public String getFourId() {
        return fourId;
    }

    public void setFourId(String fourId) {
        this.fourId = fourId;
    }

    public Collection getListMagasinId() {
        return listMagasinId;
    }

    public void setListMagasinId(List listMagasin) {
        this.listMagasinId = listMagasin;
    }

    public String getNumPo() {
        return numPo;
    }

    public void setNumPo(String numPo) {
        this.numPo = numPo;
    }
    private Collection listFournisseursId = new ArrayList();
    private Collection listFournisseursLabel = new ArrayList();

    public Collection getListFournisseursId() {
        return listFournisseursId;
    }

    public void setListFournisseursId(Collection listFournisseursId) {
        this.listFournisseursId = listFournisseursId;
    }

    public Collection getListFournisseursLabel() {
        return listFournisseursLabel;
    }

    public void setListFournisseursLabel(Collection listFournisseursLabel) {
        this.listFournisseursLabel = listFournisseursLabel;
    }
    private String numPo;
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private FormFile file;

    /**
     * @return
     */
    
    /**
     * @return
     */
    
    /**
     *
     */
    public RecepxlsForm() {
        super();
        System.out.println("Instantiate RecepxlsForm....");
        /*
        listFournisseurs = new HashMap();
        listMagasin = new HashMap();
        listArt = new HashMap();
        */
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        return errors;
    }
}
