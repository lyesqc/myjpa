/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yourcompany.struts.action;

import com.yourcompany.struts.UtilClass.Connexion;
import com.yourcompany.struts.UtilClass.Helper;
import com.yourcompany.struts.UtilClass.Helper2;
import com.yourcompany.struts.form.RecepxlsForm;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

/**
 *
 * @author Lyes.BENSAADA
 */
public class RecepxlsAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    
    public ActionForward initial(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        RecepxlsForm recepForm = (RecepxlsForm) form;
        Connection myConnection = Connexion.createConnection(request);
        Statement stm = null;
        stm = myConnection.createStatement();
        recepForm.getListMagasinId().clear();
        recepForm.getListMagasinLabel().clear();
        String mm= (String)request.getSession().getAttribute("username");
        ResultSet res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_id in (select d.whs_id from gss_droit_acces d where d.profil_act_id='PR02' and d.act_id=(select ac.act_id from gss_actor ac where ac.act_name='"+mm+"')) and   w.whs_type ='CENTRAL' and w.whs_status='A'");
        	//ResultSet res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_id in (select d.whs_id from gss_droit_acces d where d.profil_act_id='PR02' and d.act_id='"+mm+"') and a.whs_type='CENTRAL' and a.whs_region='CENTRE and w.whs_status='A'");
        		//ResultSet res = stm.executeQuery("select a.whs_id, a.whs_adresse from gss_warehouse a where a.whs_status='A' and a.whs_type='CENTRAL' and a.whs_region='CENTRE' ");
        while (res.next()){
            recepForm.getListMagasinId().add (res.getString(1));
            recepForm.getListMagasinLabel().add(res.getString(2));
            System.out.println("plpulate : "+res.getString(1)+" : "+res.getString(2));
        }
        
        recepForm.getListFournisseursId().clear();
        recepForm.getListFournisseursLabel().clear();
        
        res = stm.executeQuery("select t.dest_id, t.dest_nom  from gss_destinataire t where t.dest_type='FOURNISSEUR' and t.dest_status='A'");
        while (res.next()){
            recepForm.getListFournisseursId().add(res.getString(1));
            recepForm.getListFournisseursLabel().add(res.getString(2));
        }
        /*
        res = stm.executeQuery("select p.profil_id, p.profil_libelle from gss_article_profil p where p.profil_statut='A'");
        while (res.next()){
            recepForm.getListProfileId().add(res.getString(1));
            recepForm.getListProfileLabel().add(res.getString(2));
        }
                */
        res = stm.executeQuery("select ar.art_id, ar.art_art_libelle from gss_article ar where ar.art_status='A'");
        recepForm.getListArtId().clear();
        recepForm.getListArtLabel().clear();
        while (res.next()){
            recepForm.getListArtId().add(res.getString(1));
            recepForm.getListArtLabel().add(res.getString(2));
        }
        myConnection.close();
        recepForm.setHiddenTest("");
        return mapping.findForward("recep");
    }
    
     public ActionForward valider(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
         RecepxlsForm recepForm = (RecepxlsForm) form;
         System.out.println("in Validate Recepxls");
         Helper2 helper = null;
         Connection myConnection =null;
         String trans_num = "";
         try{
        	 myConnection = Connexion.createConnection(request);
             if(recepForm.getFile() == null) System.out.println("The file is null");
             else System.out.println("the file is not null");
         File file = Helper2.convertFormFileToFile(recepForm.getFile());
         String result = Helper2.checkReceptionFileFormat(file);
         if(result.startsWith("ERROR"))  {
        	 recepForm.setHiddenTest(result);
        	 return mapping.findForward("recep");
         }
         result = Helper2.checkSerialsExistInDb(file, myConnection);
         if(result.startsWith("ERROR"))  {
        	 recepForm.setHiddenTest(result);
        	 return mapping.findForward("recep");
         }
         
         String mm= (String)request.getSession().getAttribute("username");
         trans_num = Helper2.newTransaction("REC", recepForm.getWhId(), myConnection, recepForm.getNote(), mm, recepForm.getFourId(), recepForm.getDescription());
         helper = new Helper2();
         helper.insertNewItem(recepForm.getFile(), myConnection, mm, recepForm.getArId(), recepForm.getWhId(), trans_num);
         myConnection.commit();
         System.out.println("check result is "+result);
         System.out.println("The size of File is : "+ file.length());
         recepForm.setFile(null);
         }catch(Exception e){
             System.out.println("exception occured in validate reception");
             if(myConnection !=null) myConnection.rollback();
             e.printStackTrace();
         }
         //Connection myConnection = Connexion.createConnection(request);
        System.out.println("inside validate, call recep.jsp");
        request.setAttribute("num", "REC-"+recepForm.getWhId()+"-"+trans_num);
         return mapping.findForward("menu");
     }
}
