

package com.yourcompany.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yourcompany.struts.form.EtaStkForm;
import com.yourcompany.struts.UtilBean.Article;
import com.yourcompany.struts.UtilBean.Rang3;
import com.yourcompany.struts.UtilBean.Rapport_reservation;
import com.yourcompany.struts.UtilClass.Connexion;

public class Rapport_globalAction extends DispatchAction {
	
	
	public ActionForward initial_rapport_reservation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, RowsExceededException, WriteException, BiffException {
          EtaStkForm etaStkForm = (EtaStkForm) form;

          ArrayList list = new ArrayList();  
          
      String profil=(String)request.getSession().getAttribute("profil_visualiser_rapport");
      System.out.println("profil"+profil);
          if (profil.equals("SUPERVISEUR DE COMPTE"))
          {
        	  list.add("DISTRIBUTEUR"); 
          }
          else
          {
        	  if ((profil.equals("RESPONSABLE CDS"))||(profil.equals("COORDINATEUR REGION")))
              {
        		  list.add("CDS");
              }
        	  else
        	  {
        		     list.add("CDS");
        		  	 list.add("DISTRIBUTEUR");
        		  
        	  }
        	  
          }
         
          
  		etaStkForm.setDat_au("");
  		etaStkForm.setDat_du("");
        etaStkForm.setDist("");
   
  		etaStkForm.setNomDist(list);
  		return mapping.findForward("rapportreservation");

	}
	
	
	
	public ActionForward initial_rapport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, RowsExceededException, WriteException, BiffException {
          EtaStkForm etaStkForm = (EtaStkForm) form;

  		etaStkForm.setDat_au("");
  		etaStkForm.setDat_du("");
  		
  			return mapping.findForward("rapportglobal");

	}

	
	public ActionForward edit_rapport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, RowsExceededException, WriteException, BiffException {


	EtaStkForm etaStkForm = (EtaStkForm) form;
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		String date=null;
		Statement st,st1,st2 = null;
		ResultSet rs,rs1,rs2 = null;
		int i=0,j=0;
		st=con.createStatement();
		st1=con.createStatement();
		st2=con.createStatement();
		File file;
		
		String debut=etaStkForm.getDat_du();
		System.out.println("debut"+debut);
		
		String fin= etaStkForm.getDat_au();
		System.out.println("fin"+fin);

		
		
		 File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
	        file=new File(projectRealPath,"bon/logistic_report.xls");
	         System.out.println(file.getAbsolutePath());

	Workbook workbook = Workbook.getWorkbook (new File(projectRealPath,"bon/logistic_report.xls"));

	WritableWorkbook copy = Workbook.createWorkbook(new File("Rapport_global_logistique.xls"), workbook);//copie du fichier source 
	WritableSheet sheet0 = copy.getSheet(0);//on travail sur la feuile n°1 
	  

	System.out.println("je s8 ds la 1ere feuille des sim BRUTE NON PACKAGE ");
	System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ where (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged in ('N','O','C') and r.rng_tpd is null and r.rng_sortie <>'S' group by  a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))");
	rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ where (a.art_id(+)=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged in ('N','O','C') and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle,nvl(p.profil_libelle,'_')order by art_art_libelle");


	 while (rs.next())
		{
			String article=rs.getString(1).trim();
			System.out.println("article"+article);
			
			String profil=rs.getString(2).trim();
			System.out.println("profil"+profil);
			
			
	if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
	if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
	if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
	if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
	if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
	if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
        
    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
	
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
	
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
	
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
	
	if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
	if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
	
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
	if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
	if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
	if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}


	

			 String qte=rs.getString(3).trim();
			 System.out.println(qte);	
			 System.out.println("les indices"+2+"+"+j);
			 
			/* Number num=new Number (i, j,Integer.parseInt(qte));
			 sheet4.addCell(num); */
			 
			 
			 WritableCell cell = sheet0.getWritableCell(2, j);
			 
			 if ((cell.getType() == CellType.NUMBER) )
			 { 
				      Number num=(Number) cell;
					   num.setValue(Integer.parseInt(qte));
			}
			 if ((cell.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (2, j, qte); 
			   sheet0.addCell(labelpre);  
	 
			 }
			 


		}	
	 
	 
		System.out.println("je s8 ds la 1ere feuille des sim BRUTE PACKAGE CHEZ OTA ");
		System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ where (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged='P' and r.rng_tpd is null and r.rng_sortie <>'S' group by  a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) ");
		rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ,gss_warehouse w where r.rng_whs=w.whs_id and w.whs_region in ('CENTRE','EST','OUEST') and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged='P' and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle,nvl(p.profil_libelle,'_') order by art_art_libelle  ");


		 while (rs.next())
			{
				String article=rs.getString(1).trim();
				System.out.println("article"+article);
				
				String profil=rs.getString(2).trim();
				System.out.println("profil"+profil);
				
				
				if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
				if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
				if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
				if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
				if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
				if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

			    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
			    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
			        
			    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
			    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
				
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
				
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
				
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
				
				if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
				if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
				
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
				if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
				if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
				if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}
			
				 String qte=rs.getString(3).trim();
				 System.out.println("qte"+qte);	
				 System.out.println("les indices"+3+"+"+j);
				 
				/* Number num=new Number (i, j,Integer.parseInt(qte));
				 sheet4.addCell(num); */
				 
				 
				 WritableCell cell = sheet0.getWritableCell(3, j);
				 
				 if ((cell.getType() == CellType.NUMBER) )
				 { 
					      Number num=(Number) cell;
						   num.setValue(Integer.parseInt(qte));
				}
				 if ((cell.getType()==CellType.EMPTY) )
				 {
					 Label labelpre = new Label (3, j, qte); 
				   sheet0.addCell(labelpre);  
		 
				 }
	
			}
		 
		 
		 System.out.println("je s8 ds la 1ere feuille des sim BRUTE PACKAGE CHEZ sous traitant ");
			System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ where (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged='P' and r.rng_tpd is null and r.rng_sortie <>'S' group by  a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) ");
			rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ,gss_warehouse w where r.rng_whs=w.whs_id and w.whs_region in ('sous_traitant') and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='BRUTE' and r.rng_packaged='P' and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle,nvl(p.profil_libelle,'_') order by art_art_libelle  ");


			 while (rs.next())
				{
					String article=rs.getString(1).trim();
					System.out.println("article"+article);
					
					String profil=rs.getString(2).trim();
					System.out.println("profil"+profil);
					
					
					if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
					if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
					if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
					if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
					if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
					if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

				    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
				    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
				        
				    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
				    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
					
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
					
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
					
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
					
					if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
					if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
					
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}
				
					 String qte=rs.getString(3).trim();
					 System.out.println("qte"+qte);	
					 System.out.println("les indices"+4+"+"+j);
					 
					/* Number num=new Number (i, j,Integer.parseInt(qte));
					 sheet4.addCell(num); */
					 
					 
					 WritableCell cell = sheet0.getWritableCell(4, j);
					 
					 if ((cell.getType() == CellType.NUMBER) )
					 { 
						      Number num=(Number) cell;
							   num.setValue(Integer.parseInt(qte));
					}
					 if ((cell.getType()==CellType.EMPTY) )
					 {
						 Label labelpre = new Label (4, j, qte); 
					   sheet0.addCell(labelpre);  
			 
					 }
		
				}
		 
		 
		 System.out.println("je s8 ds la 1ere feuille des sim SWAP");
			System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte,w.whs_region from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ,gss_warehouse w where w.whs_id(+)=r.rng_whs and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST') and p.profil_libelle='SWAP' and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and r.rng_sortie <>'S' group by  w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))");
			rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte,w.whs_region from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ,gss_warehouse w where w.whs_id(+)=r.rng_whs and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST') and nvl(p.profil_libelle,'_')='SWAP' and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_') order by art_art_libelle");

			 while (rs.next())
				{
				 
					String whs=rs.getString(4).trim();
					System.out.println("whs"+whs);
					
					if (whs.equals("CENTRE")){i=6;};
					if (whs.equals("EST")){i=7;};
					if (whs.equals("OUEST")){i=8;};
					
					String article=rs.getString(1).trim();
					System.out.println("article"+article);
					

				        
				    if ((article.equals("SIM PREPAID ALLO"))){j=12;}
				    if ((article.equals("SIM PREPAID DJEZZY"))){j=13;} 
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))){j=16;}				
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))){j=19;}					
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))){j=23;}				
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))){j=27;}
					if ((article.equals("SIM POSTPAID DJEZZY"))){j=29;}					
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))){j=34;}
					if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))){j=35;}
					if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))){j=36;}
					if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))){j=37;}         
                                        
                 

					 String qte=rs.getString(3).trim();
					 System.out.println("qte"+qte);	
					 System.out.println("les indices"+i+"+"+j);
					 
					/* Number num=new Number (i, j,Integer.parseInt(qte));
					 sheet4.addCell(num); */
					 
					 
					 WritableCell cell = sheet0.getWritableCell(i, j);
					 
					 if ((cell.getType() == CellType.NUMBER) )
					 { 
						      Number num=(Number) cell;
							   num.setValue(Integer.parseInt(qte));
					}
					 if ((cell.getType()==CellType.EMPTY) )
					 {
						 Label labelpre = new Label (i, j, qte); 
					   sheet0.addCell(labelpre);  
			 
					 }

				}	
			 

		 
			 System.out.println("je s8 ds la 1ere feuille des sim EN COUR D'ACTIVATION");
				System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ  where   (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='EN COURS'  and r.rng_tpd is null and r.rng_sortie <>'S' group by  a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))");
				rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_profil p,gss_article_type typ  where (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='EN COURS'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle,nvl(p.profil_libelle,'_') order by art_art_libelle");

				 while (rs.next())
					{
						String article=rs.getString(1).trim();
						System.out.println("article"+article);
						
						String profil=rs.getString(2).trim();
						System.out.println("profil"+profil);
						
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
					        
					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
						
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}
						
						
						
						
						 String qte=rs.getString(3).trim();
						 System.out.println("qte"+qte);	
						 System.out.println("les indices"+11+"+"+j);
						 
						/* Number num=new Number (i, j,Integer.parseInt(qte));
						 sheet4.addCell(num); */
						 
						 
						 WritableCell cell = sheet0.getWritableCell(11, j);
						 
						 if ((cell.getType() == CellType.NUMBER) )
						 { 
							      Number num=(Number) cell;
								   num.setValue(Integer.parseInt(qte));
						}
						 if ((cell.getType()==CellType.EMPTY) )
						 {
							 Label labelpre = new Label (11, j, qte); 
						   sheet0.addCell(labelpre);  
				 
						 }

					}			
				
		
				
			 
				System.out.println("je s8 ds la 1ere feuille des sim ready for distribution ");
				System.out.println("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte,w.whs_region from gss_warehouse w,gss_range r,gss_article a,gss_article_profil p,gss_article_type typ  where  p.profil_libelle<>'SWAP' AND w.whs_id(+)=r.rng_whs and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPRE','SIMPOST')  and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null and r.rng_sortie <>'O' AND r.rng_sortie <>'S' group by  w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by art_art_libelle,decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))");
				rs=st.executeQuery("select distinct a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte,w.whs_region from gss_warehouse w,gss_range r,gss_article a,gss_article_profil p,gss_article_type typ  where  nvl(p.profil_libelle,'_')<>'SWAP' AND w.whs_id(+)=r.rng_whs and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id  and typ.art_type_libelle in ('SIMPOST','SIMPRE') and r.profil_id=p.profil_id(+)  and r.rng_inactif='A'   and   ((nvl(P.profil_pre_non_active,'_')<>'N' and r.rng_statut='ACTIVE')or   (P.profil_pre_non_active='N')) and r.rng_packaged='P' and r.rng_tpd is null and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') group by  w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_')order by art_art_libelle");

				 while (rs.next())
					{
					 
					 String whs=rs.getString(4).trim();
						System.out.println("whs"+whs);
						
						
						if (whs.equals("CENTRE")){i=15;};
					
						if (whs.equals("OUEST")){i=16;};
						if (whs.equals("EST")){i=17;};
						
						String article=rs.getString(1).trim();
						System.out.println("article"+article);
						
						String profil=rs.getString(2).trim();
						System.out.println("profil"+profil);
						
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
					        
					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
						
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}
						

						 String qte=rs.getString(3).trim();
						 System.out.println("qte"+qte);	
						 System.out.println("les indices"+i+"+"+j);
						 
						/* Number num=new Number (i, j,Integer.parseInt(qte));
						 sheet4.addCell(num); */
						 
						 
						 WritableCell cell = sheet0.getWritableCell(i, j);
						 
						 if ((cell.getType() == CellType.NUMBER) )
						 { 
							      Number num=(Number) cell;
								   num.setValue(Integer.parseInt(qte));
						}
						 if ((cell.getType()==CellType.EMPTY) )
						 {
							 Label labelpre = new Label (i, j, qte); 
						   sheet0.addCell(labelpre);  
				 
						 }

					}	
				
				 
				
				 

	
				System.out.println("je s8 ds la 1ere feuille des sim  distribution ");
				System.out.println("select  t.whs_region,t.art_art_libelle,nvl(t.profil_libelle,'_') as profil,t.hlr,sum(t.qte) Quantite from gss_rep_transactions t,gss_article_type typ ,gss_article a  where   a.art_art_libelle(+) =t.art_art_libelle and typ.art_type_id=a.art_type_id and typ.art_type_libelle in ('SIMPRE','SIMPOST')AND t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.art_art_libelle,t.profil_libelle,t.hlr order by 1 desc, 2 desc, 3 desc");
				rs=st.executeQuery("select  t.whs_region,t.art_art_libelle,nvl(t.profil_libelle,'_') as profil,sum(t.qte) Quantite from gss_rep_transactions t,gss_article_type typ ,gss_article a  where   a.art_art_libelle(+) =t.art_art_libelle and typ.art_type_id=a.art_type_id and typ.art_type_libelle in ('SIMPOST','SIMPRE')AND t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.art_art_libelle,nvl(t.profil_libelle,'_') order by 1 desc, 2 desc, 3 desc");

			
				 while (rs.next())
					{
					 
					 String whs=rs.getString(1).trim();
						System.out.println("whs"+whs);
						
						
						if (whs.equals("CENTRE")){i=19;};
						if (whs.equals("EST")){i=20;};
						if (whs.equals("OUEST")){i=21;};
						
						String article=rs.getString(2).trim();
						System.out.println("article"+article);
						
						String profil=rs.getString(3).trim();
						System.out.println("profil"+profil);
						
						
						
						
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("_")){j=4;}
						if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("PACK_LAHBAB")){j=5;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("_")){j=6;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_PRINTEMPS")){j=7;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("P_DIRECT")){j=8;}
						if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("PSM")){j=9;} 

					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("ALLO  NON ACTIVE")){j=10;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("DJEZZY NON ACTIVE")){j=11;} 
					        
					    if ((article.equals("SIM PREPAID ALLO"))&&profil.equals("SWAP")){j=12;}
					    if ((article.equals("SIM PREPAID DJEZZY"))&&profil.equals("SWAP")){j=13;} 

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("_")){j=14;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("BUSINESS")){j=15;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS"))&&profil.equals("SWAP")){j=16;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("_")){j=17;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("BUSINESS CONTROL")){j=18;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL"))&&profil.equals("SWAP")){j=19;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("_")){j=20;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("CLASSIC NON ACTIVE")){j=21;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("DJEZZY CLASSIC")){j=22;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC"))&&profil.equals("SWAP")){j=23;}
						
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("_")){j=24;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("CONTROL NON ACTIVE")){j=25;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("DJEZZY CONTROL")){j=26;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL"))&&profil.equals("SWAP")){j=27;}
						
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("_")){j=28;}
						if ((article.equals("SIM POSTPAID DJEZZY"))&&profil.equals("SWAP")){j=29;}

						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("BUSINESS")){j=30;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("BUSINESS CONTROL")){j=31;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("CLASSIC NON ACTIVE")){j=32;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("CONTROL NON ACTIVE")){j=33;}
						
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS 128K"))&&profil.equals("SWAP")){j=34;}
						if ((article.equals("SIM POSTPAID DJEZZY BUSINESS CONTROL 128K"))&&profil.equals("SWAP")){j=35;}
						if ((article.equals("SIM POSTPAID DJEZZY CLASSIC  128 K"))&&profil.equals("SWAP")){j=36;}
						if ((article.equals("SIM POSTPAID DJEZZY CONTROL 128 K"))&&profil.equals("SWAP")){j=37;}
					
					
						 String qte=rs.getString(4).trim();
						 System.out.println("qte"+qte);	
						 System.out.println("les indices"+i+"+"+j);
						 
						/* Number num=new Number (i, j,Integer.parseInt(qte));
						 sheet4.addCell(num); */
						 
						 
						 WritableCell cell = sheet0.getWritableCell(i, j);
						 
						 if ((cell.getType() == CellType.NUMBER) )
						 { 
							      Number num=(Number) cell;
								   num.setValue(Integer.parseInt(qte));
						}
						 if ((cell.getType()==CellType.EMPTY) )
						 {
							 Label labelpre = new Label (i, j, qte); 
						   sheet0.addCell(labelpre);  
				 
						 }

					}	
				 
				 
				 
				
					
		
/// le rapport des scratch 
			 
 WritableSheet sheet1 = copy.getSheet(1);//on travail sur la feuile n°1 
 
 
	System.out.println("je s8 ds la 1ere feuille des scratch stock brute");
	System.out.println(" select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where     (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')    and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null  AND r.rng_sortie <>'S' group by  a.art_art_libelle");
	rs=st.executeQuery(" select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where     a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER') and     r.rng_promotion is null  and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


	 while (rs.next())
		{

			
			String article=rs.getString(1).trim();
			System.out.println("article"+article);
			
	
			if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
			if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
			if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
			if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
			if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
			if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
			
			if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
			if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
			if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
			if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
			if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
			if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
			
			
			if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
			if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
			if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
			if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
			if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
			
			if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
			if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
			if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
			if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}
			
			

			 String qte=rs.getString(2).trim();
			 System.out.println("qte"+qte);	
			 System.out.println("les indices"+4+"+"+j);
			 
			/* Number num=new Number (i, j,Integer.parseInt(qte));
			 sheet4.addCell(num); */
			 
			 
			 WritableCell cell = sheet1.getWritableCell(2, j);
			 
			 if ((cell.getType() == CellType.NUMBER) )
			 { 
				      Number num=(Number) cell;
					   num.setValue(Integer.parseInt(qte));
			}
			 if ((cell.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (2, j, qte); 
			   sheet1.addCell(labelpre);  
	 
			 }

		}	
 

		System.out.println("je s8 ds la 1ere feuille des scratch stock sous ordre");
		System.out.println("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_type typ    where     (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')    and r.rng_inactif='A'   and r.rng_statut='EN COURS'  and r.rng_tpd is null    AND r.rng_sortie <>'S' group by  a.art_art_libelle");
		rs=st.executeQuery("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_article_type typ    where    a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER') and   r.rng_promotion is null   and r.rng_inactif='A'   and r.rng_statut='EN COURS'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


		 while (rs.next())
			{

				
				String article=rs.getString(1).trim();
				System.out.println("article"+article);
				
		
				if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
				if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
				if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
				if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
				if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
				if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
				
				if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
				if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
				if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
				if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
				if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
				if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
				
				
				if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
				if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
				if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
				if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
				if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
				
				if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
				if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
				if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
				if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

				 String qte=rs.getString(2).trim();
				 System.out.println("qte"+qte);	
				 System.out.println("les indices"+4+"+"+j);
				 
				/* Number num=new Number (i, j,Integer.parseInt(qte));
				 sheet4.addCell(num); */
				 
				 
				 WritableCell cell = sheet1.getWritableCell(3, j);
				 
				 if ((cell.getType() == CellType.NUMBER) )
				 { 
					      Number num=(Number) cell;
						   num.setValue(Integer.parseInt(qte));
				}
				 if ((cell.getType()==CellType.EMPTY) )
				 {
					 Label labelpre = new Label (3, j, qte); 
				   sheet1.addCell(labelpre);  
		 
				 }

			}	
	 
		
			System.out.println("je s8 ds la 1ere feuille des scratch stock activé");
			System.out.println("    select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where     (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')    and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null    AND r.rng_sortie <>'S' group by  a.art_art_libelle");
			rs=st.executeQuery(" select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where    a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and   (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')  and   r.rng_promotion is null   and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


			 while (rs.next())
				{

					
					String article=rs.getString(1).trim();
					System.out.println("article"+article);
					
			
					if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
					if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
					if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
					if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
					if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
					if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
					
					if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
					if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
					if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
					if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
					if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
					if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
					
					
					if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
					if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
					if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
					if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
					if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
					
					if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
					if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
					if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
					if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

					 String qte=rs.getString(2).trim();
					 System.out.println("qte"+qte);	
					 System.out.println("les indices"+4+"+"+j);
					 
					/* Number num=new Number (i, j,Integer.parseInt(qte));
					 sheet4.addCell(num); */
					 
					 
					 WritableCell cell = sheet1.getWritableCell(4, j);
					 
					 if ((cell.getType() == CellType.NUMBER) )
					 { 
						      Number num=(Number) cell;
							   num.setValue(Integer.parseInt(qte));
					}
					 if ((cell.getType()==CellType.EMPTY) )
					 {
						 Label labelpre = new Label (4, j, qte); 
					   sheet1.addCell(labelpre);  
			 
					 }

				}	
		

				System.out.println("je s8 ds la 1ere feuille des scratch stock sécurité");
				System.out.println("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where   r.rng_promotion='Scratch securite' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')   and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null and r.rng_sortie <>'O'   AND r.rng_sortie <>'S' group by  a.art_art_libelle");
				rs=st.executeQuery("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where   a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and   r.rng_promotion='Scratch securite' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')   and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


				 while (rs.next())
					{

						
						String article=rs.getString(1).trim();
						System.out.println("article"+article);
						
				
						if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
						if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
						if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
						if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
						if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
						if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
						
						if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
						if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
						if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
						if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
						if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
						if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
						
						
						if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
						if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
						if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
						if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
						if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
						
						if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
						if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
						if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
						if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

						 String qte=rs.getString(2).trim();
						 System.out.println("qte"+qte);	
						 System.out.println("les indices"+4+"+"+j);
						 
					
						 WritableCell cell = sheet1.getWritableCell(6, j);
						 
						 if ((cell.getType() == CellType.NUMBER) )
						 { 
							      Number num=(Number) cell;
								   num.setValue(Integer.parseInt(qte));
						}
						 if ((cell.getType()==CellType.EMPTY) )
						 {
							 Label labelpre = new Label (6, j, qte); 
						   sheet1.addCell(labelpre);  
				 
						 }
						 
						 
				

					}	
			 	
					System.out.println("je s8 ds la 1ere feuille des scratch stock secutite");
					System.out.println("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ  where   r.rng_promotion='Scratch securite' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH')   and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and r.rng_sortie <>'O'   AND r.rng_sortie <>'S' group by  a.art_art_libelle");
					rs=st.executeQuery("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ  where a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and  r.rng_promotion='Scratch securite' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')   and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


					 while (rs.next())
						{

							
							String article=rs.getString(1).trim();
							System.out.println("article"+article);
							
					
							if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
							if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
							if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
							if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
							if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
							if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
							
							if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
							if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
							if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
							if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
							if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
							if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
							
							
							if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
							if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
							if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
							if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
							if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
							
							if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
							if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
							if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
							if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}
							
							

							 String qte=rs.getString(2).trim();
							 System.out.println("qte"+qte);	
							 System.out.println("les indices"+4+"+"+j);
							 
						
							 WritableCell cell = sheet1.getWritableCell(7, j);
							 
							 if ((cell.getType() == CellType.NUMBER) )
							 { 
								      Number num=(Number) cell;
									   num.setValue(Integer.parseInt(qte));
							}
							 if ((cell.getType()==CellType.EMPTY) )
							 {
								 Label labelpre = new Label (7, j, qte); 
							   sheet1.addCell(labelpre);  
					 
							 }
							 }	
				 			 	 
					 
					 
						System.out.println("je s8 ds la 1ere feuille des scratch stock promotion");
						System.out.println("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where   r.rng_promotion='Scratch promotionnel' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH')   and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null and r.rng_sortie <>'O'   AND r.rng_sortie <>'S' group by  a.art_art_libelle");
						rs=st.executeQuery("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ    where a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and  r.rng_promotion='Scratch promotionnel' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')   and r.rng_inactif='A'   and r.rng_statut='BRUTE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


						 while (rs.next())
							{

								
								String article=rs.getString(1).trim();
								System.out.println("article"+article);
								
						
								if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
								if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
								if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
								if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
								if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
								if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
								
								if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
								if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
								if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
								if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
								if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
								if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
								
								
								if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
								if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
								if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
								if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
								if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
								
								if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
								if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
								if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
								if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

								 String qte=rs.getString(2).trim();
								 System.out.println("qte"+qte);	
								 System.out.println("les indices"+4+"+"+j);
								 
							
								 WritableCell cell = sheet1.getWritableCell(9, j);
								 
								 if ((cell.getType() == CellType.NUMBER) )
								 { 
									      Number num=(Number) cell;
										   num.setValue(Integer.parseInt(qte));
								}
								 if ((cell.getType()==CellType.EMPTY) )
								 {
									 Label labelpre = new Label (9, j, qte); 
								   sheet1.addCell(labelpre);  
						 
								 }
								 }
						 
						 
						 
						 System.out.println("je s8 ds la 1ere feuille des scratch stock promotion");
							System.out.println("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ  where   r.rng_promotion='Scratch promotionnel' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH')   and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and r.rng_sortie <>'O'   AND r.rng_sortie <>'S' group by  a.art_art_libelle");
							rs=st.executeQuery("  select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte  from gss_range r,gss_article a,gss_article_type typ  where  a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and r.rng_promotion='Scratch promotionnel' and  (a.art_id=r.art_id)  and a.art_type_id=typ.art_type_id   and typ.art_type_libelle in ('SCRATCH','E_VOUTCHER')   and r.rng_inactif='A'   and r.rng_statut='ACTIVE'  and r.rng_tpd is null and  r.rng_sortie <> ('S') group by  a.art_art_libelle");


							 while (rs.next())
								{

									
									String article=rs.getString(1).trim();
									System.out.println("article"+article);
									
							
									if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
									if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
									if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
									if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
									if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
									if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
									
									if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
									if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
									if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
									if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
									if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
									if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
									
									
									if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
									if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
									if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
									if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
									if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
									
									if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
									if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
									if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
									if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

									 String qte=rs.getString(2).trim();
									 System.out.println("qte"+qte);	
									 System.out.println("les indices"+4+"+"+j);
									 
								
									 WritableCell cell = sheet1.getWritableCell(10, j);
									 
									 if ((cell.getType() == CellType.NUMBER) )
									 { 
										      Number num=(Number) cell;
											   num.setValue(Integer.parseInt(qte));
									}
									 if ((cell.getType()==CellType.EMPTY) )
									 {
										 Label labelpre = new Label (10, j, qte); 
									   sheet1.addCell(labelpre);  
							 
									 }
									 }
							 
							 
						
								 
					System.out.println("je s8 ds la 1ere feuille des scratch  distribution");
					System.out.println("select  t.whs_region,t.art_art_libelle,t.profil_libelle as article, sum(t.qte) Quantite from gss_rep_transactions t,gss_article_type typ ,gss_article a  where a.art_art_libelle =t.art_art_libelle and typ.art_type_id=a.art_type_id and typ.art_type_libelle in ('SCRATCH')AND t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.art_art_libelle,t.profil_libelle order by 1 desc, 2 desc, 3 desc");
					rs=st.executeQuery("select  t.whs_region,t.art_art_libelle, sum(t.qte) Quantite from gss_rep_transactions t,gss_article_type typ ,gss_article a  where a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') and a.art_art_libelle =t.art_art_libelle and typ.art_type_id=a.art_type_id and typ.art_type_libelle in  ('SCRATCH','E_VOUTCHER') AND t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.art_art_libelle order by 1 desc, 2 desc");

					 while (rs.next())
										{
						 String whs=rs.getString(1).trim();
											System.out.println("whs"+whs);
                           if (whs.equals("CENTRE")){i=15;};
							if (whs.equals("EST")){i=16;};
							if (whs.equals("OUEST")){i=17;};
											
											String article=rs.getString(2).trim();
											System.out.println("article"+article);
											
									
											if ((article.equals("SCRATCH DJEZ   500 DA"))){j=4;}
											if ((article.equals("SCRATCH DJEZ 1200 DA"))){j=5;}
											if ((article.equals("SCRATCH DJEZ 2300 DA"))){j=6;}
											if ((article.equals("SCRATCH ALLO   200 DA"))){j=8;}
											if ((article.equals("SCRATCH ALLO   500 DA"))){j=9;}
											if ((article.equals("SCRATCH ALLO 1000 DA"))){j=10;}
											
											if ((article.equals("SCRATCH DJEZ   500 Cadeaux"))){j=12;}
											if ((article.equals("SCRATCH DJEZ 1200 Cadeaux"))){j=13;}
											if ((article.equals("SCRATCH ALLO   500 Cadeaux"))){j=14;}
											if ((article.equals("SCRATCH ALLO 1000 Cadeaux"))){j=15;}
											if ((article.equals("SCRATCH ALLO   500 Bonus"))){j=16;}
											if ((article.equals("SCRATCH ALLO 1000 Bonus"))){j=17;}
											
											
											if ((article.equals("E_VOUTCHER   DJEZ _100 DA"))){j=20;}
											if ((article.equals("E_VOUTCHER   DJEZ _200 DA"))){j=21;}
											if ((article.equals("E_VOUTCHER   DJEZ _500 DA"))){j=22;}
											if ((article.equals("E_VOUTCHER   DJEZ _1200 DA"))){j=23;}
											if ((article.equals("E_VOUTCHER   DJEZ _2300 DA"))){j=24;}
											
											if ((article.equals("E_VOUTCHER   ALLO_100 DA"))){j=26;}
											if ((article.equals("E_VOUTCHER   ALLO_200 DA"))){j=27;}
											if ((article.equals("E_VOUTCHER   ALLO_500 DA"))){j=28;}
											if ((article.equals("E_VOUTCHER   ALLO_1000 DA"))){j=29;}

											 String qte=rs.getString(3).trim();
											 System.out.println("qte"+qte);	
											 System.out.println("les indices"+4+"+"+j);
											 
										
											 WritableCell cell = sheet1.getWritableCell(i, j);
											 
											 if ((cell.getType() == CellType.NUMBER) )
											 { 
												      Number num=(Number) cell;
													   num.setValue(Integer.parseInt(qte));
											}
											 if ((cell.getType()==CellType.EMPTY) )
											 {
												 Label labelpre = new Label (i, j, qte); 
											   sheet1.addCell(labelpre);  
									 
											 }		
											
											
											
											
											
										}
											
				 
		 copy.write(); 
		 copy.close();
		 
		
		 response.setContentType("application/octet-stream");
		 response.setHeader("Content-Disposition","attachment; filename=\"Rapport_global_logistique.xls\"");


//FileInputStream is = new FileInputStream(new File(projectRealPath,"bon/ready.xls"));
FileInputStream is = new FileInputStream("Rapport_global_logistique.xls");

byte buffer[] = new byte[1024];
int nbLecture;
//Envoyer le flux dans la réponse
OutputStream os = response.getOutputStream();
while ((nbLecture = is.read(buffer)) != -1) {
os.write(buffer, 0, nbLecture);
}
os.close(); 
con.close();

return null;
}
	

	
	

	public ActionForward edit_rapport_reservation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, RowsExceededException, WriteException, BiffException {


	EtaStkForm etaStkForm = (EtaStkForm) form;
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		String date=null;
		Statement st,st1,st2 = null;
		ResultSet rs,rs1,rs2 = null;
		int i=0,j=0;
		//st=con.createStatement();
		st1=con.createStatement();
		st2=con.createStatement();
		File file;
		ArrayList listindex = new ArrayList();
		int colon=0;
		String debut=etaStkForm.getDat_du();
       System.out.println("debut"+debut);
       
	  String fin= etaStkForm.getDat_au();
	  System.out.println("fin"+fin); 
		
		
		String dest=etaStkForm.getDist();
		System.out.println("dist"+dest);

		if (dest.equals("DISTRIBUTEUR"))
		{
			dest="DIS";	
		}
		
		 File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
	        file=new File(projectRealPath,"bon/rapport_reservation.xls");
	         System.out.println(file.getAbsolutePath());

	Workbook workbook = Workbook.getWorkbook (new File(projectRealPath,"bon/rapport_reservation.xls"));

	WritableWorkbook copy = Workbook.createWorkbook(new File("Rapport_global_reservation.xls"), workbook);//copie du fichier source 
	WritableSheet sheet0 = copy.getSheet(0);//on travail sur la feuile n°1 
	
	System.out.println("select distinct a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v ,gss_article a ,gss_destinataire d ,gss_transaction t,gss_article_type typ where v.trans_type=t.trans_type and v.whs_id=t.whs_id and v.trans_no=t.trans_no  and v.art_id=a.art_id and t.dest_id=d.dest_id  and v.annuler='N'and  t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and v.whs_id='"+dest+"' and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' order by  a.art_art_libelle||' / '||v.profil_id");
	rs1=st1.executeQuery("select distinct a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v ,gss_article a ,gss_destinataire d ,gss_transaction t,gss_article_type typ where v.trans_type=t.trans_type and v.whs_id=t.whs_id and v.trans_no=t.trans_no  and v.art_id=a.art_id and t.dest_id=d.dest_id  and v.annuler='N'and  t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and v.whs_id='"+dest+"' and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' order by  a.art_art_libelle||' / '||v.profil_id");
	int compte=2;
	
	 while (rs1.next())
		{
       Rapport_reservation index=new Rapport_reservation();
			
			String article=rs1.getString(1).trim();
			System.out.println("article"+article);
			
			String art=rs1.getString(2).trim();
			System.out.println("art"+art);
			
			String prof=rs1.getString(3).trim();
			System.out.println("prof"+prof);
			
			index.setArticle(article);
			index.setIndex(compte);
			listindex.add(index);
		
			 WritableCell cell = sheet0.getWritableCell(compte, 3);
				
			 if ((cell.getType() == CellType.LABEL) )
			 { 
				      Label num=(Label) cell;
				      
					   num.setString(art);
			 }
			 if ((cell.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (compte, 3, art); 
				sheet0.addCell(labelpre);  

			 }	
			
			 WritableCell cell2 = sheet0.getWritableCell(compte, 4);
				
			 if ((cell2.getType() == CellType.LABEL) )
			 { 
				      Label num=(Label) cell2;
				      
					   num.setString(prof);
			 }
			 if ((cell2.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (compte, 4, prof); 
				sheet0.addCell(labelpre);  

			 }	
			 
				compte=compte+1;
			
		}
	
	 
	 /*rs2=st2.executeQuery("select t.dest_nom from gss_destinataire t where t.dest_type='DISTRIBUTEUR' and t.dest_status='A' order by  dest_nom ");
	
	j=6;
	while (rs2.next())
	{
		String dist=rs2.getString(1).trim();
		System.out.println("dist"+dist);
		
		 WritableCell cell = sheet0.getWritableCell(1, j);
		 
		 if ((cell.getType() == CellType.NUMBER) )
		 { 
			      Number num=(Number) cell;
				   num.setValue(Integer.parseInt(dist));
		}
		 if ((cell.getType()==CellType.EMPTY) )
		 {
			 Label labelpre = new Label (1, j, dist); 
		   sheet0.addCell(labelpre);  
 
		 }
		j=j+1;
	}*/
	
	
	st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	System.out.println("select v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id,sum(v.quantite_article) from gss_reserv_approb v ,gss_article a ,gss_destinataire d ,gss_transaction t,gss_article_type typ where  v.trans_type=t.trans_type and v.whs_id=t.whs_id and v.trans_no=t.trans_no  and v.art_id=a.art_id and t.dest_id=d.dest_id  and v.annuler='N'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and v.whs_id='"+dest+"' and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' GROUP by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id order by  v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id");
   rs=st.executeQuery("select v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id,sum(v.quantite_article) from gss_reserv_approb v ,gss_article a ,gss_destinataire d ,gss_transaction t,gss_article_type typ where  v.trans_type=t.trans_type and v.whs_id=t.whs_id and v.trans_no=t.trans_no  and v.art_id=a.art_id and t.dest_id=d.dest_id  and v.annuler='N'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and v.whs_id='"+dest+"'  and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' GROUP by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id order by  v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id");
	
     int compte_centre=0;
	 int compte_est=0;
	 int compte_ouest=0;
	 
   int cpt=1;
 //int step=2;
 rs.last();
 int step = rs.getRow();

 rs.first();
	
 while ((cpt<=step))
	{
		String whs=rs.getString(1).trim();
		System.out.println(whs);
		if (whs.equals("CENTRE")){j=6;}
	    if (whs.equals("EST")){j=48;}
	    if (whs.equals("OUEST")){j=80;}
	    
	    
	     
	 while ((cpt<=step)&& (rs.getString(1).trim().equals(whs)))
	 
	 {	
		 

		 
     String  dist=rs.getString(2).trim();
		System.out.println(dist);
		if (whs.equals("CENTRE")){compte_centre=compte_centre+1;}
		if (whs.equals("EST")){compte_est=compte_est+1;}
		if (whs.equals("OUEST")){compte_ouest=compte_ouest+1;}
		
		 WritableCell cell = sheet0.getWritableCell(1, j);
		
		 if ((cell.getType() == CellType.LABEL) )
		 { 
			      Label num=(Label) cell;
			      
				   num.setString(dist);
		}
		 if ((cell.getType()==CellType.EMPTY) )
		 {
			 Label labelpre = new Label (1, j, dist); 
			sheet0.addCell(labelpre);  

		 }	
		 
		 while ((cpt<=step)&& (rs.getString(1).trim().equals(whs))&&rs.getString(2).trim().equals(dist)) 
		 {
			 
			 String  art=rs.getString(3).trim();
				System.out.println("art de la requete "+art);
				System.out.println("listindex.size()  "+listindex.size());
			
				 for (int k=0; k<listindex.size();k++){
					 System.out.println("j'ai rentré dans la boucle");
					 Rapport_reservation list2= (Rapport_reservation)listindex.get(k); 
					 System.out.println("art de l'index"+list2.getArticle());
					 System.out.println("list2.getIndex()"+ list2.getIndex());
					
					 if ((list2.getArticle()).equals(art))
					 {
						
						 System.out.println("j'ai trouvé l'élément ");
						colon=list2.getIndex();
						System.out.println("colon"+colon);
						 break;
					 }

				 }

		    String qte=rs.getString(4).trim();
		    System.out.println("qte"+qte);
		   System.out.println(i+"+"+j);
		   
		   
	/*	   WritableCell cellcds = sheet0.getWritableCell(i, j);
		   System.out.println("lei"+i+"le je"+j);	
Number num=(Number) cellcds;
		   num.setValue(Integer.parseInt(qte));*/
		   
		   
		/* Number num=new Number (colon, j,Integer.parseInt(qte));
			 sheet0.addCell(num);*/
		   
		    WritableCell cel = sheet0.getWritableCell(colon, j);
		   
			 if ((cel.getType() == CellType.NUMBER) )
			 { 
				      Number num=(Number) cel;
				      
					   num.setValue(Integer.parseInt(qte));
			 }
			 if ((cel.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (colon, j, qte); 
				sheet0.addCell(labelpre);  

			 }	
		cpt=cpt+1;
		rs.next();
			
		 }
		 
	j=j+1;	
	//j=j-1;
	}
	 
	}
 System.out.println("compte_centre "+compte_centre);
 System.out.println("compte_est "+compte_est);
 System.out.println("compte_ouest"+compte_ouest);


 for (int c=0; c<40-compte_centre;c++){
 sheet0.removeRow(6+compte_centre);
System.out.println("c"+c);

 }
 
for (int c=0; c<30-compte_est;c++){
	 sheet0.removeRow(6+compte_centre+2+compte_est);
	System.out.println("c"+c);

	 }
 int index=6+compte_centre+2+compte_est+2+compte_ouest;
	System.out.println("index"+index);
 for (int c=0; c<30-compte_ouest;c++){
	 sheet0.removeRow(6+compte_centre+2+compte_est+2+compte_ouest);
	System.out.println("c"+c);

	 }
 
WritableCell cell_titre = sheet0.getWritableCell(3, 1);
	
 if ((cell_titre.getType() == CellType.LABEL) )
 { 
	      Label num=(Label) cell_titre;
	      
		   num.setString("Rapport des réservations  du :"+debut+" AU "+fin);
 }
 
 
//Label reservation = new Label (3, 1, "Rapport des réservations  journées du :"+debut+" AU "+fin ); 
//sheet0.addCell(reservation); 
 
 if (dest.equals("DIS"))
	{
	 sheet0.removeRow(6+compte_centre+2+compte_est+2+compte_ouest+5);
	 sheet0.removeRow(6+compte_centre+2+compte_est+2+compte_ouest+6);	
	 sheet0.removeRow(6+compte_centre+2+compte_est+2+compte_ouest+7);
	}
 
 else
 {
		System.out.println("select distinct a.act_name,d.whs_id from gss_approbation,gss_actor a,gss_droit_acces d where approv_act=a.act_id and a.act_id=d.act_id and  approv_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and gss_approbation.whs_id='CDS'");
	 rs1=st1.executeQuery("select distinct a.act_name,d.whs_id from gss_approbation,gss_actor a,gss_droit_acces d where approv_act=a.act_id and a.act_id=d.act_id and  approv_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )and gss_approbation.whs_id='CDS'");
	 while (rs1.next())
		{
		 String coordinateur=rs1.getString(1).trim();
		 System.out.println("coordinateur"+coordinateur);
		 
		 System.out.println("rs1.getString(1).trim()="+rs1.getString(2).trim());
		 
		 int colone1,colone=0,ligne=0;
		 int colone2=0;
		 int colone3=0;
		 colone1=3;
		 colone2=3;
		 colone3=3;
		 if ((rs1.getString(2)).trim().equals("CENTRE"))
		 {
			 System.out.println("je suis dans le centre");
			 ligne =6+compte_centre+2+compte_est+2+compte_ouest+5;
			 colone=colone1;
			 colone1=colone1+1;
		 }
		 
		 if ((rs1.getString(2)).trim().equals("EST"))
		 {
			 System.out.println("je suis dans le est");
			 ligne=6+compte_centre+2+compte_est+2+compte_ouest+7;
			 colone=colone2;
			 colone2=colone2+1;
		 }
		 
		 if ((rs1.getString(2)).trim().equals("OUEST"))
		 {
			 System.out.println("je suis dans le ouest");
			 ligne=6+compte_centre+2+compte_est+2+compte_ouest+9;
			 colone=colone3;
			 colone3=colone3+1;
		 }
	
		 System.out.println("colone+ligne="+colone+ligne);
		 
		 WritableCell cell = sheet0.getWritableCell(colone, ligne);
			
		 if ((cell.getType() == CellType.LABEL) )
		 { 
			      Label num=(Label) cell;
			      
				   num.setString(coordinateur);
		 }
		 if ((cell.getType()==CellType.EMPTY) )
		 {
			 Label labelpre = new Label (colone, ligne, coordinateur); 
			sheet0.addCell(labelpre);  

		 }	
		 
		}	 
 }

 //Label reservation = new Label (3, 1, "les réservation de la période :"+debut+"au"+fin ); 
 //sheet0.addCell(reservation); 
 
 WritableCell cell = sheet0.getWritableCell(3, 1);
 
 if ((cell.getType() == CellType.LABEL) )
 { 
	      Label num=(Label) cell;
	      
		   num.setString("les réservations de la période :"+debut+" au "+fin);
 }
 if ((cell.getType()==CellType.EMPTY) )
 {
	 Label labelpre = new Label (compte, 4, "les réservations de la période :"+debut+" au "+fin); 
	sheet0.addCell(labelpre);  

 }	

 
 
 
 
 for (int c=0; c<24-compte;c++){
	 sheet0.removeColumn(compte);
	 }
 
 
 
	 copy.write(); 
	 copy.close();
	 
	
	 response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment; filename=\"Rapport_global_reservation.xls\"");


//FileInputStream is = new FileInputStream(new File(projectRealPath,"bon/ready.xls"));
FileInputStream is = new FileInputStream("Rapport_global_reservation.xls");

byte buffer[] = new byte[1024];
int nbLecture;
//Envoyer le flux dans la réponse
OutputStream os = response.getOutputStream();
while ((nbLecture = is.read(buffer)) != -1) {
os.write(buffer, 0, nbLecture);
}
os.close(); 
con.close();

return null;

/*String sql = "{ call testacteur(?)}";
CallableStatement call = con.prepareCall(sql);
call.execute();*/


}



}


