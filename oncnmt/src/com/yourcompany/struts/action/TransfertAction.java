
package com.yourcompany.struts.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yourcompany.struts.form.TransfertForm;

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
 
public class TransfertAction extends DispatchAction {
 
 
 
    public ActionForward load(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
     TransfertForm transfertForm = (TransfertForm) form;// TODO Auto-genera
     
     Connexion connexion=new Connexion();
     Connection con=connexion.createConnection(request);
     
     Statement st,st1 = null;
     ResultSet res,res1 = null;
     Integer R,R1;
     String whs=null,whh=null;
     String prio=null;
     String date=null;
     
     //Connection myConnection = Connexion.createConnection(request);
     Statement stm = null;
     stm = con.createStatement();
     String mm= (String)request.getSession().getAttribute("username");
     res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_id in (select d.whs_id from gss_droit_acces d where d.profil_act_id='PR02' and d.act_id=(select ac.act_id from gss_actor ac where ac.act_name='"+mm+"')) and w.whs_status='A'");
     transfertForm.getListdistId().clear();
	 transfertForm.getListdistLabel().clear();
     
     while (res.next()){
    	 System.out.println(" in loop :"+res.getString(1));
    	 transfertForm.getListdistId().add(res.getString(1));
    	 transfertForm.getListdistLabel().add(res.getString(2));
     }
     
     
     transfertForm.getListMagasinId().clear();  
	 transfertForm.getListMagasinLabel().clear();
     res = stm.executeQuery("select w.whs_id, w.whs_adresse from gss_warehouse w where w.whs_status='A'");
     while (res.next()){
    	 transfertForm.getListMagasinId().add(res.getString(1));  
    	 transfertForm.getListMagasinLabel().add(res.getString(2));
     }
     
     transfertForm.setHiddenTest("");
     System.out.println("");
     
  
     return mapping.findForward("transfert");
   }
    
    public ActionForward valider(ActionMapping mapping, ActionForm form,
    	     HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
    	TransfertForm transfertForm = (TransfertForm) form;// TODO Auto-genera
    	String tran_num = "";
    	     try{
    	     Connexion connexion=new Connexion();
    	     Connection con=connexion.createConnection(request);
    	     Helper2 helper = new Helper2();
    	     File file = Helper2.convertFormFileToFile(transfertForm.getFile());
    	     
    	     String result = Helper2.checkReceptionFileFormat(file);
             if(result.startsWith("ERROR"))  {
            	 transfertForm.setHiddenTest(result);
            	 return mapping.findForward("transfert");
             }
             result = helper.checkIfItemsInStockForStatus(file, con,"r.rng_sortie = 'N'",true);
             if(result.startsWith("ERROR"))  {
            	 transfertForm.setHiddenTest(result);
            	 return mapping.findForward("transfert");
             }
             String mm= (String)request.getSession().getAttribute("username");
             tran_num = helper.newTransaction("TRA", transfertForm.getMagasourc(), con, transfertForm.getNote(), mm, transfertForm.getDestId(), null);
             
    	     result = helper.updateItemsStatus(file, con, "r.rng_transfert_whs='"+transfertForm.getMagasourc()+"' , r.rng_transfert='T', r.rng_whs='"+transfertForm.getDestId()+"',r.trans_type='TRA',r.trans_no='"+tran_num+"',r.whs_id='"+transfertForm.getMagasourc()+"'", "TRA",tran_num,transfertForm.getMagasourc(),mm, true);
    	     if(result.startsWith("ERROR"))  {
    	    	 transfertForm.setHiddenTest(result);
            	 return mapping.findForward("transfert");
             }
    	     
    	     System.out.println("the file size is : "+transfertForm.getFile().getFileSize());
    	     }catch(Exception e){
    	    	 e.printStackTrace();
    	     }
    	     
    	     
    	     String num = "TRA" + "-" + transfertForm.getMagasourc() + "-" + tran_num;
    			request.setAttribute("num", num);
    	     return mapping.findForward("menu");
    }
    
    
}

      
  