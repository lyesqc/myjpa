
package com.yourcompany.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.yourcompany.struts.form.SortiForm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.yourcompany.struts.UtilBean.*;
import com.yourcompany.struts.UtilClass.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RedirectingActionForward;
import org.apache.struts.actions.DispatchAction;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.*;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
 
public class SortieAction extends DispatchAction {
 
 
 
    public ActionForward load(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
     SortiForm sortiForm = (SortiForm) form;// TODO Auto-genera
     
     Connexion connexion=new Connexion();
     Connection con=connexion.createConnection(request);
     
     Statement st,st1 = null;
     ResultSet res,res1 = null;
     Integer R,R1;
     String whs=null,whh=null;
     String prio=null;
     String date=null;
     
     Connection myConnection = Connexion.createConnection(request);
     Statement stm = null;
     
     stm = con.createStatement();
     /*
     res = stm.executeQuery("select t.dest_id, t.dest_nom  from gss_destinataire t where t.dest_type<>'FOURNISSEUR' and t.dest_status='A'");
     while (res.next()){
    	 sortiForm.getListdistId().add(res.getString(1));
    	 sortiForm.getListdistLabel().add(res.getString(2));
     }
     */
     String mm= (String)request.getSession().getAttribute("username");
     res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_id in (select d.whs_id from gss_droit_acces d where d.profil_act_id='PR02' and d.act_id=(select ac.act_id from gss_actor ac where ac.act_name='"+mm+"')) and w.whs_status='A'");

     //res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_status='A'");
     sortiForm.getListMagasinId().clear();  
	 sortiForm.getListMagasinLabel().clear();
     
     while (res.next()){
    	 sortiForm.getListMagasinId().add(res.getString(1));  
    	 sortiForm.getListMagasinLabel().add(res.getString(2));
     }
     
     System.out.println("");
     sortiForm.setHiddenTest("");
  
     return mapping.findForward("sortie");
   }
    
    
    public ActionForward loadDest(ActionMapping mapping, ActionForm form,
    	      HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
    	     SortiForm sortiForm = (SortiForm) form;// TODO Auto-genera
    	     
    	     Connexion connexion=new Connexion();
    	     Connection con=connexion.createConnection(request);
    	     
    	     Statement st,st1 = null;
    	     ResultSet res,res1 = null;
    	     Integer R,R1;
    	     String whs=null,whh=null;
    	     String prio=null;
    	     String date=null;
    	     String magsrc = sortiForm.getMagasourc();
    	     System.out.println("magasin source :"+magsrc);
    	     Connection myConnection = Connexion.createConnection(request);
    	     Statement stm = null;
    	     sortiForm.getListdistId().clear();
    	     sortiForm.getListdistLabel().clear();
    	     stm = con.createStatement();
    	     res = stm.executeQuery("select t.dest_id, t.dest_nom  from gss_destinataire t where t.dest_type<>'FOURNISSEUR' and t.dest_status='A' and t.dest_region =trim((select w.whs_region from gss_warehouse w where w.whs_id='"+magsrc+"' and w.whs_status='A'))");
    	     while (res.next()){
    	    	 sortiForm.getListdistId().add(res.getString(1));
    	    	 sortiForm.getListdistLabel().add(res.getString(2));
    	     }
    	     
    	     /*res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_status='A'");
    	     while (res.next()){
    	    	 sortiForm.getListMagasinId().add(res.getString(1));  
    	    	 sortiForm.getListMagasinLabel().add(res.getString(2));
    	     }*/
    	     
    	     System.out.println("");
    	     sortiForm.setHiddenTest("");
    	  
    	     return mapping.findForward("sortie");
    	   }
    
    
    
    
    
    
    
    public ActionForward valider(ActionMapping mapping, ActionForm form,
    	     HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
    	     SortiForm sortiForm = (SortiForm) form;// TODO Auto-genera
    	     String tran_num  ="";
    	     try{
    	     Connexion connexion=new Connexion();
    	     Connection con=connexion.createConnection(request);
    	     Helper2 helper = new Helper2();
    	     File file = Helper2.convertFormFileToFile(sortiForm.getFile());
    	     
    	     String result = Helper2.checkReceptionFileFormat(file);
             if(result.startsWith("ERROR"))  {
            	 sortiForm.setHiddenTest(result);
            	 return mapping.findForward("sortie");
             }
             result = helper.checkIfItemsInStockForStatus(file, con,"(r.rng_sortie<>'S' and r.rng_tpd is  null)",true);
             if(result.startsWith("ERROR"))  {
            	 sortiForm.setHiddenTest(result);
            	 return mapping.findForward("sortie");
             }
             String mm= (String)request.getSession().getAttribute("username");
             tran_num = helper.newTransaction("SOR", sortiForm.getMagasourc(), con, sortiForm.getNote(), mm, sortiForm.getDestId(), null);
             
    	     result = helper.updateItemsStatus(file, con, "r.rng_sortie='S', r.rng_sortie_whs='"+sortiForm.getDestId()+"',r.trans_type='SOR',r.trans_no='"+tran_num+"',r.whs_id='"+sortiForm.getMagasourc()+"'", "SOR",tran_num,sortiForm.getMagasourc(),mm, true);
    	     if(result.startsWith("ERROR"))  {
    	    	 System.out.println("Error ocuured in update "+result);
            	 sortiForm.setHiddenTest(result);
            	 return mapping.findForward("sortie");
             }
    	     
    	     System.out.println("the file size is : "+sortiForm.getFile().getFileSize());
    	     }
    	     
    	     catch(Exception e){
    	    	 
    	    	 e.printStackTrace();
    	     }
    	     
    	     String num = "SOR-"+sortiForm.getMagasourc()+"-"+tran_num;
    	     request.setAttribute("num", num);
    	     System.out.println("num :"+num);
    	     return mapping.findForward("menu");
    	     
    	     //return mapping.findForward("sortie");
    }
    
    
}

      
  