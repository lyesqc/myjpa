

package com.yourcompany.struts.action;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.CellFormat;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.biff.NumberFormatRecord;



import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import oracle.sql.NUMBER;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yourcompany.struts.UtilClass.Connexion;
import com.yourcompany.struts.form.EtaStkForm;

import com.yourcompany.struts.form.RechercheForm;
import com.yourcompany.struts.UtilBean.Article;
import com.yourcompany.struts.UtilBean.Rang;
import com.yourcompany.struts.UtilBean.Rapport_reservation;

  
 

public class StockAction extends DispatchAction {
	
	
	
	
	public ActionForward historique(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, RowsExceededException, WriteException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		
		 Statement st = null;
		  ResultSet rs = null;
		  ArrayList list = new ArrayList();
		  st=con.createStatement();
		  
String rng=request.getParameter("dat_au");
System.out.println(rng);
//String rng=etaStkForm.getHiddenTest();
String[] str = rng.split("-");
//String id=rng.substring(0,15);
//String act=rng.substring(16);

		 
		  System.out.println(rng);
		 // System.out.println(act);
		  System.out.println("select tr.t_r_trans_type||'-'||tr.t_r_trans_whs||'-'||tr.t_r_trans_no,to_char(tr.t_r_date, 'DD/MM/YYYY HH24:MI:SS'),a.act_name from gss_transaction_range tr, gss_actor a  where tr.t_r_rng_id='"+str[0]+"' /*and a.act_id='"+str[1]+"'*/ and tr.t_r_rng_act_id=a.act_id order by tr.t_r_date");
	rs=st.executeQuery("select tr.t_r_trans_type||'-'||tr.t_r_trans_whs||'-'||tr.t_r_trans_no,to_char(tr.t_r_date, 'DD/MM/YYYY HH24:MI:SS'),a.act_name from gss_transaction_range tr, gss_actor a  where tr.t_r_rng_id='"+str[0]+"' /*and a.act_id='"+str[1]+"'*/ and tr.t_r_rng_act_id=a.act_id order by tr.t_r_date");
		  
		while (rs.next())
		{
 Article art = new Article();
art.setCode(rs.getString(1).trim()); 
   art.setDate(rs.getString(2).trim());
   art.setCode_art(rs.getString(1).trim());
    art.setResp(rs.getString(3).trim());			
list.add(art);
		}
		
		
		    	con.close();
	       
		etaStkForm.setEtat(list);

		return mapping.findForward("pophistorique");	
	}
	public ActionForward exporter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, RowsExceededException, WriteException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		String test=null;
		List stock= new ArrayList();
		
		System.out.println("je s8 ds exporter");

		
		//stock=etaStkForm.getEtat();
		stock=etaStkForm.getEtat_stock();
		WritableWorkbook classeur = Workbook.createWorkbook (new File ( "stock.xls")); 

		 WritableSheet sheet = classeur.createSheet("first Sheet", 0);
		 WritableSheet sheet1 = classeur.createSheet("seconde Sheet", 1);
		 WritableSheet sheet2 = classeur.createSheet("third  Sheet", 2);
		 WritableSheet sheet3 = classeur.createSheet("firth  Sheet", 3);
		 WritableSheet sheet4 = classeur.createSheet("fifth  Sheet", 4);
		 
		 Label labelart = new Label(1, 0, "ARTICLE"); 
		 sheet.addCell(labelart); 
		 
		 
		 
		 
		 
		 Label deb = new Label(2, 0, "SERIAL START"); 
		 sheet.addCell(deb); 
		 
		 
		 
		
		 
		 Label whs = new Label(3, 0, "WAREHOUSE"); 
		 sheet.addCell(whs); 
		 
		 
		 
		 
		 Label transfert = new Label(4, 0, "TRANSFERT"); 
		 sheet.addCell(transfert); 
		 /*
		 Label des = new Label(5, 0, "DESTINATAIRE"); 
		 sheet.addCell(des); 
		 */
		 
		 Label sorti = new Label(5, 0, "SORTIE"); 
		 sheet.addCell(sorti); 
		 
		 Label reintegr = new Label(6, 0, "REINTEGRATION"); 
		 sheet.addCell(reintegr); 
		 
		int k=0;
		   for (int j=0;j<stock.size();j++){
		    	Article article = (Article) stock.get(j) ;
		    	System.out.println("le j="+j);
		    	if (j<=65000 )
		    	{sheet=sheet;}
		    	if ((j>65000) && (130000>j))
		    	{sheet=sheet1;
		    	k=0;}
		    	if ((j>=130000) && (195000>j))
		    	{sheet=sheet2;
		    	k=0;}
		    	
		    	if ((j>=195000) && (240000>j))
		    	{sheet=sheet3;
		    	k=0;}
		    	if ((j>=240000) && (305000>j))
		    	{sheet=sheet4;
		    	k=0;}
	
		    	Label label = new Label(1, k+1, article.getArt()); 
			      sheet.addCell(label);   
			      
			      Label label3 = new Label(2, k+1,article.getStart()); 
			      sheet.addCell(label3); 
			      
			      Label label10 = new Label(3, k+1, article.getWhs()); 
			      sheet.addCell(label10);
			      
			      Label label13 = new Label(4, k+1,  article.getTra()); 
			      sheet.addCell(label13); 
			      /*
			      Label label2 = new Label(5,k+1,  article.getDest()); 
			      sheet.addCell(label2); 
*/
			  	  
			     
			      Label label12 = new Label(5, k+1, article.getSor()); 
			      sheet.addCell(label12); 
			     
			      Label label14 = new Label(6, k+1, article.getReint()); 
			      sheet.addCell(label14); 
			      
			     
	k=k+1;
		   }

		 

		 classeur.write();  
		 classeur.close(); 
		 
		 
		 response.setContentType("application/octet-stream");
		 response.setHeader("Content-Disposition","attachment; filename=\"stock.xls\"");
		 // Calculer le flux  renvoyer au client
		 FileInputStream is = new FileInputStream("stock.xls");
		 byte buffer[] = new byte[1024];
		 int nbLecture;
		 // Envoyer le flux dans la rponse
		 OutputStream os = response.getOutputStream();
		 while ((nbLecture = is.read(buffer)) != -1) {
		  os.write(buffer, 0, nbLecture);
		 }
		 os.close();
		
		
		return mapping.findForward("EtatDeStock");	
	}
	
	public ActionForward Rechercher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		
		Statement st = null;
		ResultSet rs = null;
		boolean  check,tdp = false;
		ArrayList list = new ArrayList();
		ArrayList list_stock = new ArrayList();
		
		String dat,typ,sdu,sau,art,prof,whs,dist,cds,part,pack,hlr,pq,pos,promo=null;
		String requette=null;
		//Date dat;
		List listWarehouse= new ArrayList() ;
	    List nomProfil= new ArrayList() ;
		List nomArticle= new ArrayList() ;
		List nomDest= new ArrayList() ;
		List nomCds= new ArrayList() ;
		List nomPart= new ArrayList() ;
		
		int qteGlobal =0; 
		int i=0;
		
		
		
		dat = etaStkForm.getDat_du();
		System.out.println(dat);
		typ = etaStkForm.getTyp();
		sdu = etaStkForm.getSdu();
		sau = etaStkForm.getSau();
		art = etaStkForm.getArticle();
		prof = etaStkForm.getProfil();
		whs = etaStkForm.getWarehouse();
		dist = etaStkForm.getDist();
		cds = etaStkForm.getCds();
		part =etaStkForm.getPart();
		pack=etaStkForm.getPackaging();
		hlr =etaStkForm.getHLR();
		pq=etaStkForm.getPQ();
		pos=etaStkForm.getPosition();
		 check = etaStkForm.getSortie();
		 tdp=etaStkForm.getTdp();
		 promo=etaStkForm.getPromotion();
		 System.out.println("  promotion="+promo);
		  
		String hiddensorti=etaStkForm.getHiddenSorti();
		String hiddentdp =etaStkForm.getHiddenTdp();
		System.out.println("check"+check);
		System.out.println("tdp"+tdp);
		System.out.println("hiddensorti"+hiddensorti);
		System.out.println("hiddentdp"+hiddentdp);
		
		String heur1=etaStkForm.getHeur1();
		//avant d'ajouter la jointure avec la vue du last_transaction
		//requette = "select  a.art_art_libelle,nvl(p.profil_libelle,'_')as prof,nvl(r.rng_dist,'_')as dist,r.rng_start,r.rng_end,(r.rng_end-r.rng_start+1)as QTE,case when a.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,nvl(r.rng_pq,'_')as pq,w_stk.whs_adresse as magasin,r.rng_statut,case when a.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,r.rng_id,r.act_id from gss_range r,gss_article_profil p,gss_article a,gss_article_type t,gss_warehouse w_stk,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (p.profil_id (+)= r.profil_id)and (r.art_id = a.art_id)and  (t.art_type_id=a.art_type_id)and (r.rng_whs=w_stk.whs_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+) ";
		
		requette = "select a.art_art_libelle,  'tt' as prof,nvl(r.rng_dist,'_')as dist,r.rng_start,r.rng_end,(r.rng_end-r.rng_start+1)as QTE,0  hlr,  nvl(r.rng_pq,'_')as pq,w_stk.whs_adresse as magasin,r.rng_statut,'gg' PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom, 'F','Retour au fournisseur','N', '_') SORTIE,decode(r.rng_transfert, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_','_') TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,r.rng_id,r.act_id "+
   " from gss_range r,gss_article a,gss_warehouse w_stk,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr " +
   " where (r.art_id = a.art_id)and   (r.rng_whs=w_stk.whs_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+) ";
		
		
		//requette = "select  a.art_art_libelle,nvl(p.profil_libelle,'_')as prof,nvl(r.rng_dist,'_')as dist,r.rng_start,r.rng_end,(r.rng_end-r.rng_start+1)as QTE,case when a.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,nvl(r.rng_pq,'_')as pq,w_stk.whs_adresse as magasin,r.rng_statut,case when a.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,r.rng_id,r.act_id from gss_range r,gss_article_profil p,gss_article a,gss_article_type t,gss_warehouse w_stk,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (p.profil_id (+)= r.profil_id)and (r.art_id = a.art_id)and  (t.art_type_id=a.art_type_id)and (r.rng_whs=w_stk.whs_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+) ";
		
		if ((dat != "") &&(heur1== ""))
		{
			requette = requette +" and (( (trunc(r.rng_actif_date) <= to_date('"+dat+"','DD/MM/YYYY')))   and (Trunc(NVL(r.rng_inactif_date,sysdate+1)) > to_date('"+dat+"','DD/MM/YYYY'))) ";
			
		}
		
	
		
		if ((dat != "") &&(heur1!= ""))
		{
			String date2=dat+" "+heur1;
			requette = requette +" and ((((r.rng_actif_date) <= to_date('"+date2+"', 'DD/MM/YYYY HH24:MI:SS'))) and ((nvl(r.rng_inactif_date,sysdate+1) > to_date('"+date2+"', 'DD/MM/YYYY HH24:MI:SS')))) ";
			
		}
		
	
		
		if ((sdu !="") && (sau==""))
		{
			requette = requette+" and (r.rng_start<= '"+sdu+"') and (r.rng_end>= '"+sdu+"')";
		}
		if ((sau !="") && (sdu==""))
		{
			requette = requette+" and (r.rng_start<= '"+sau+"') and (r.rng_end>= '"+sau+"')";
		}
		
		
		if ((sdu !="") && (sau!=""))
		{
			requette = requette +" and (((r.rng_start<='"+sdu+"') and (r.rng_end>='"+sau+"')) or  ('"+sdu+"' between r.rng_start and r.rng_end) or ('"+sau+"' between r.rng_start and r.rng_end) or ((r.rng_start>='"+sdu+"') and (r.rng_end<='"+sau+"'))) ";
		}
		
		if (art!="")
		{
			requette = requette +"and (a.art_art_libelle = '"+art+"')";
		}
		
		
		
		if (whs != "")
		{
			
		requette = requette + "and (w_stk.whs_adresse = '"+whs+"')";
			
	     }
		
		
		
		if(dist!="" || cds!="")
		{
			requette = requette +"  and ((r.rng_dist in ('"+dist+"','"+cds+"'))) ";
		//	requette = requette +"  and ((r.rng_dist in ('"+dist+"','"+cds+"'))or(tso.dest_nom in ('"+dist+"','"+cds+"'))or(sor.dest_nom in ('"+dist+"','"+cds+"'))) ";
			
		}
		
		
		
		
		
		if (hiddensorti.equals("false"))
		
		 {
			System.out.println("requette+ hiddensorti+ false");
			etaStkForm.setSortie(false);
			
			requette = requette +"  and  (r.rng_sortie <> ('S')) ";	
		//	requette = requette +"  and  ((r.rng_sortie in ('N','O')) or  (r.rng_sortie ='S'  and  (r.rng_reintegration='T'  or r.rng_reintegration='R' ) and nvl(r.trans_type,'_')<>'SOR' ))";
		//	requette = requette +"  and  ((r.rng_sortie in ('N','O')) or  (r.rng_sortie ='S'  and  (r.rng_reintegration='T'  or r.rng_reintegration='R' ) and nvl(r.trans_type,'_') not  in ('SOR','_') ))";
			
		
		//	requette = requette +"union  select  a.art_art_libelle,nvl(p.profil_libelle,'_')as prof,nvl(r.rng_dist,'_')as dist,r.rng_start,r.rng_end,(r.rng_end-r.rng_start+1)as QTE,case when a.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,nvl(r.rng_pq,'_')as pq,w_stk.whs_adresse as magasin,r.rng_statut,case when a.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,r.rng_id,r.act_id from  last_transaction ,  gss_range r,gss_article_profil p,gss_article a,gss_article_type t,gss_warehouse w_stk,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where last_transaction.t_r_rng_id=r.rng_id and last_transaction.t_r_rng_act_id=r.act_id  and (p.profil_id (+)= r.profil_id)and (r.art_id = a.art_id)and  (t.art_type_id=a.art_type_id)and (r.rng_whs=w_stk.whs_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+)";
		 
		 }
		else
				{
			System.out.println("requette+ hiddensorti+ true");
			etaStkForm.setSortie(true);
					requette = requette +" --and (r.rng_sortie ='S')";
				}	
		
		
			 
	/*	 if (check==false) {
			 
			 requette = requette +" and ((r.rng_sortie='O')or (r.rng_sortie='N'))";
		 }
		 
			 if (check==true)
				{
					requette = requette +" and (r.rng_sortie ='S')";
				}*/	 

		 
		if (hiddentdp.equals("false"))
		 {
			etaStkForm.setTdp(false);
		 requette = requette +" and decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') like '_'";
			//requette = requette +"  and (r.rng_sortie in ('N','O'))";
		 }
		else
		{
			etaStkForm.setTdp(true);	
		}
		
		
		//requette = requette + " order by QTE";
		System.out.println(requette);
		
		
		st = con.createStatement();
		rs=st.executeQuery(requette);
		while (rs.next())
		{
			//System.out.println("["+rs.getString(1)+"],["+rs.getString(2)+"],["+rs.getString(3)+"],["+rs.getString(4)+"],["+rs.getString(5)+"]"+"],["+rs.getString(6)+"]"+"],["+rs.getString(7)+"]"+"],["+rs.getString(8)+"]"+"],["+rs.getString(9)+"]"+"],["+rs.getString(10)+"]"+"],["+rs.getString(11)+"]"+"],["+rs.getString(12)+"]"+"],["+rs.getString(13)+"]"+"],["+rs.getString(14)+"]"+"],["+rs.getString(15)+"]"+"],");
			
			 Article article = new Article();
			 
			 //String qtd = rs.getString(6).trim();
			 
			  //  int qt = Integer.parseInt(qtd);
			//	qteGlobal = qteGlobal+qt;
			//	System.out.println("la quantit global"+qteGlobal);
			 
			 article.setArt(rs.getString(1).trim());
			 //article.setProf(rs.getString(2).trim());
			 article.setDest(rs.getString(3).trim());
			 article.setStart(rs.getString(4).trim());
			 article.setEnd(rs.getString(5).trim());
			 //article.setQte(rs.getString(6).trim());
		
			 //article.setHlr(rs.getString(7).trim());
			// article.setPq(rs.getString(8).trim());
			// article.setSwap(rs.getString(16)); 
			 //article.setPos(rs.getString(10).trim());
			 
			 article.setWhs(rs.getString(9).trim());
			 //article.setPack(rs.getString(11).trim());
			 article.setSor(rs.getString(12).trim());
			 article.setTra(rs.getString(13).trim());
			 article.setReint(rs.getString(14).trim());
			 article.setTdp(rs.getString(15).trim());
			 article.setRng_id(rs.getString("rng_id").trim()+"-"+rs.getString("act_id"));
			 
			 i=i+1; 
			 list_stock.add(article);
			 
			 if (i<=10000)
			 {
				 list.add(article);
			 }
			  ///////// le nombre de range
		}
		
		
		etaStkForm.setEtat(list);
		etaStkForm.setEtat_stock(list_stock);
		etaStkForm.setResult(qteGlobal+" articles trouvs dans "+i+" ranges");
		
	//	etaStkForm.setSortie(etaStkForm.getSortie());
		//etaStkForm.setTdp(etaStkForm.getTdp());
		
		
		 
		    	con.close();
	      	
		return mapping.findForward("EtatDeStock"); 
		
	}
	

	
	
	public ActionForward ready(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, RowsExceededException, WriteException, BiffException {
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
		
//		   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//Date maDate = (Date) dateFormat.parse(date);
		
		rs1=st1.executeQuery("select to_char(trunc(sysdate), 'DD/MM/YYYY') from dual");

		while (rs1.next())
		{
			 date=rs1.getString(1).trim();
			
		}
		
		 File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
        file=new File(projectRealPath,"bon/ready.xls");
         System.out.println(file.getAbsolutePath());

Workbook workbook = Workbook.getWorkbook (new File(projectRealPath,"bon/ready.xls"));

WritableWorkbook copy = Workbook.createWorkbook(new File("ReadyDistribution.xls"), workbook);//copie du fichier source 
WritableSheet sheet4 = copy.getSheet(4);//on travail sur la feuile n1 
  

System.out.println("je s8 ds la 5ere feuille des scratch seulement");
System.out.println("select distinct w.whs_region,a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle='SCRATCH')and r.rng_inactif='A'  and r.rng_statut='ACTIVE'  and r.rng_tpd is null   and r.rng_sortie <>'O'  and r.rng_sortie <>'S' and r.rng_reintegration <>'A' group by w.whs_region,a.art_art_libelle");
rs=st.executeQuery("select distinct w.whs_region,a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle='SCRATCH')and r.rng_inactif='A'  and r.rng_statut='ACTIVE'  and r.rng_tpd is null   and r.rng_sortie <>'O' and  r.rng_sortie <> ('S')  group by w.whs_region,a.art_art_libelle order by 1 desc, 2 desc");

//and r.rng_sortie <>'O'
 while (rs.next())
	{
		String whs=rs.getString(1).trim();
		System.out.println(whs);
		if (whs.equals("CENTRE")){i=5;}
       if (whs.equals("EST")){i=4;}
    if (whs.equals("OUEST")){i=3;}
		
		String  art=rs.getString(2).trim();
		System.out.println(art);
		
		if (art.equals("SCRATCH DJEZ 1200 DA")){j=6;}
        if (art.equals("SCRATCH DJEZ   500 DA")){j=7;}
        if (art.equals("SCRATCH ALLO   500 DA")){j=8;}
        if (art.equals("SCRATCH ALLO 1000 DA")){j=9;}
        if (art.equals("SCRATCH DJEZ 2300 DA")){j=10;}
        if (art.equals("SCRATCH ALLO   200 DA")){j=11;}
     //   if (art.equals("SCRATCH DJEZ 3000 DA")){j=12;}
     //   if (art.equals("SCRATCH DJEZ 2000 DA")){j=13;}
        
      
   
        
    
		 String qte=rs.getString(3).trim();
		 System.out.println(qte);	
		 System.out.println(i+"+"+j);
		 
		 Number num=new Number (i, j,Integer.parseInt(qte));
		 sheet4.addCell(num); 
	/*	 WritableCell cell = sheet4.getWritableCell(i, j);
 

 
 if ((cell.getType() == CellType.NUMBER) )
 { 
	      Number num=(Number) cell;
		   num.setValue(Integer.parseInt(qte));
}
 if ((cell.getType()==CellType.EMPTY) )
 {
	 Label label = new Label (i, j, qte); 
   sheet4.addCell(label);  
 
} 	
 */


	}	

Label scratch = new Label (3, 2, "tat prt a la distribution Scratchs rgions Journe du:"+date); 
 sheet4.addCell(scratch); 
 



   rs=null;st=null;
	//	st=con.createStatement();
   st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
		
		
		WritableSheet sheet3 = copy.getSheet(3);//on travail sur la feuile n1 
		  

		System.out.println("je s8 ds la 4ere feuille des prepaid allo");
		rs=st.executeQuery("select distinct w.whs_region,a.art_art_libelle,nvl(r.rng_pq,'_'), decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w  where (a.art_id=r.art_id) and a.art_art_libelle='SIM PREPAID ALLO' and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') and w.whs_region in ('CENTRE','EST','OUEST') group by w.whs_region,a.art_art_libelle,nvl(r.rng_pq,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)),nvl(r.rng_pq,'_'),w.whs_region  ");

int cpt_pre=1;
j=5;
rs.last();
int step_pre = rs.getRow();

rs.first();
System.out.println("la taille des enregistrement="+step_pre);

while ((cpt_pre<=step_pre))
	{
		String hlr=rs.getString(4).trim();
		System.out.println(hlr);
		
		 Label Hlr = new Label (1, j, hlr); 
		 sheet3.addCell(Hlr); 
		
while ((cpt_pre<=step_pre)&& (rs.getString(4).trim().equals(hlr)))
	 
	 {	
	
	 Label Hlr1 = new Label (1, j, hlr); 
	 sheet3.addCell(Hlr1); 
	
	String PQ=rs.getString(3).trim();
	System.out.println(PQ);
	
	 Label pq = new Label (2, j, PQ); 
	 sheet3.addCell(pq); 
		
	 while ((cpt_pre<=step_pre)&& (rs.getString(4).trim().equals(hlr))&&(rs.getString(3).trim().equals(PQ)))
		 
	 {	
	 
        String  whs=rs.getString(1).trim();
		System.out.println(whs);

		if (whs.equals("CENTRE")){i=5;}
	       if (whs.equals("EST")){i=4;}
	    if (whs.equals("OUEST")){i=3;}
	    
	    
	    String  qte=rs.getString(5).trim();
		System.out.println(qte);
		
		  Number num=new Number (i, j,Integer.parseInt(qte));
			 sheet3.addCell(num); 
	
		
	/*	WritableCell cell = sheet3.getWritableCell(i, j);  
		 System.out.println(i+" dist"+"+"+j);
		
		 if ((cell.getType() == CellType.LABEL) )
		 { 
			      Label num=(Label) cell;
			      
				   num.setString(qte);
		}
		 if ((cell.getType()==CellType.EMPTY) )
		 {
			 Label labelpre = new Label (i, j, qte); 
		   sheet3.addCell(labelpre);  

		 }	*/
		 
		 rs.next();
		 cpt_pre=cpt_pre+1;
		 
	 }	
		 
	j=j+1;
	
	 }
		
		
	}	
		
		
		

/*j=5;
		 while (rs.next())
			{
				String whs=rs.getString(1).trim();
				System.out.println(whs);
				
				if (whs.equals("CENTRE")){i=5;}
		       if (whs.equals("EST")){i=4;}
		    if (whs.equals("OUEST")){i=3;}
				
				String  PQ=rs.getString(3).trim();
				System.out.println(PQ);
				
				String  hlr=rs.getString(4).trim();
				System.out.println(hlr);
	 
				String qte=rs.getString(5).trim();
				 System.out.println(qte);	
				 System.out.println(i+"+"+j);
				 
              Number num=new Number (i, j,Integer.parseInt(qte));
				 sheet3.addCell(num); 
				 
		 Label Hlr = new Label (1, j, hlr); 
		 sheet3.addCell(Hlr); 
		   
		 Label pq = new Label (2, j, PQ); 
		 sheet3.addCell(pq); 
		 

		 j=j+1;
			}*/	
		 
		 
		 
		
Label allo = new Label (3, 2, " tat prt a la distribution SIM Allo Card Journe du:"+date); 
sheet3.addCell(allo); 		 

   
rs=null;st=null;
//st=con.createStatement();

st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 


WritableSheet sheet2= copy.getSheet(2);//on travail sur la feuile n1 
  

System.out.println("je s8 ds la 3ere feuille des prapaid djeezy");
rs=st.executeQuery("select distinct w.whs_region,a.art_art_libelle,nvl(r.rng_pq,'_'), decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) as hlr,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w  where (a.art_id=r.art_id) and a.art_art_libelle='SIM PREPAID DJEZZY' and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') and w.whs_region in ('CENTRE','EST','OUEST') group by w.whs_region,a.art_art_libelle,nvl(r.rng_pq,'_'),decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1))order by decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)),nvl(r.rng_pq,'_'),w.whs_region");


int cpt_pre2=1;
j=5;
rs.last();
int step_pre2 = rs.getRow();

rs.first();
System.out.println("la taille des enregistrement="+step_pre);

while ((cpt_pre2<=step_pre2))
	{
		String hlr=rs.getString(4).trim();
		System.out.println(hlr);
		
		 Label Hlr = new Label (1, j, hlr); 
		 sheet2.addCell(Hlr); 
		
while ((cpt_pre2<=step_pre2)&& (rs.getString(4).trim().equals(hlr)))
	 
	 {	
	
	 Label Hlr1 = new Label (1, j, hlr); 
	 sheet2.addCell(Hlr1); 
	
	String PQ=rs.getString(3).trim();
	System.out.println(PQ);
	
	 Label pq = new Label (2, j, PQ); 
	 sheet2.addCell(pq); 
		
	 while ((cpt_pre2<=step_pre2)&& (rs.getString(4).trim().equals(hlr))&&(rs.getString(3).trim().equals(PQ)))
		 
	 {	
	 
        String  whs=rs.getString(1).trim();
		System.out.println(whs);

		if (whs.equals("CENTRE")){i=5;}
	       if (whs.equals("EST")){i=4;}
	    if (whs.equals("OUEST")){i=3;}
	    
	    
	    String  qte=rs.getString(5).trim();
		System.out.println(qte);
		
		
		  Number num=new Number (i, j,Integer.parseInt(qte));
			 sheet2.addCell(num); 
	

		 rs.next();
		 cpt_pre2=cpt_pre2+1;
		 
	 }	
		 
	j=j+1;
	
	 }
		
		
	}	



/*j=5;
 while (rs.next())
	{
		String whs=rs.getString(1).trim();
		System.out.println(whs);
		
		if (whs.equals("CENTRE")){i=5;}
       if (whs.equals("EST")){i=4;}
    if (whs.equals("OUEST")){i=3;}
		
		String  PQ=rs.getString(3).trim();
		System.out.println(PQ);
		
		String  hlr=rs.getString(4).trim();
		System.out.println(hlr);

		String qte=rs.getString(5).trim();
		 System.out.println(qte);	
		 System.out.println(i+"+"+j);
		

 
 
 Number num=new Number (i, j,Integer.parseInt(qte));
 sheet2.addCell(num);  

 Label Hlr = new Label (1, j, hlr); 
 sheet2.addCell(Hlr); 
   
 Label pq = new Label (2, j, PQ); 
 sheet2.addCell(pq); 
 

 
 j=j+1;
	}	
*/
Label djeezy = new Label (3, 2, " tat prt a la distribution SIM Djezzy Card Journe du:"+date); 
sheet2.addCell(djeezy); 
		

rs=null;st=null;
st=con.createStatement();

WritableSheet sheet0= copy.getSheet(0);//on travail sur la feuile n1 
///////numro spciaux  prepaid  djeezy 

System.out.println("je s8 ds la 1ere feuille rcapilatif");
System.out.println("je s8 ds numro spciaux  prepaid  djeezy");
rs=st.executeQuery("select distinct w.whs_region,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w  where (a.art_id=r.art_id) and a.art_art_libelle='SIM PREPAID DJEZZY' and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S')  and r.rng_pq in ('71','72','73') and w.whs_region in ('CENTRE','EST','OUEST') group by w.whs_region order by 1 desc ");

 while (rs.next())
	{
		String whs=rs.getString(1).trim();
		System.out.println(whs);
		
		if (whs.equals("CENTRE")){i=1;}
       if (whs.equals("EST")){i=2;}
    if (whs.equals("OUEST")){i=3;}
  
String qte=rs.getString(2).trim();
		 System.out.println(qte);	
		 System.out.println(i+"+"+j);	
 WritableCell cell = sheet0.getWritableCell(i, 5);
 
 Number num=(Number) cell;
 
	      
		   num.setValue(Integer.parseInt(qte));

	}
/////// prepaid djeezy et allo 
 System.out.println("je s8 ds prepaid djeezy et allo ");
 rs1=null;st1=null;
 st1=con.createStatement();
 System.out.println("select distinct w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w,gss_article_profil p   where (a.art_id=r.art_id) and a.art_art_libelle in ('SIM PREPAID DJEZZY','SIM PREPAID ALLO') and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and r.rng_sortie <>'O'  and r.rng_sortie <>'S'   and  r.rng_reintegration <>'A'  and r.profil_id=p.profil_id(+)group by w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_')");
 // requete avant chang non activ 
 //rs1=st1.executeQuery("select distinct w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w,gss_article_profil p   where (a.art_id=r.art_id) and a.art_art_libelle in ('SIM PREPAID DJEZZY','SIM PREPAID ALLO') and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and  r.rng_sortie <> ('S')  and r.profil_id=p.profil_id(+) and w.whs_region in ('CENTRE','EST','OUEST')group by w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_')");
 rs1=st1.executeQuery("select distinct w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_'),sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w,gss_article_profil p   where (a.art_id=r.art_id) and a.art_art_libelle in ('SIM PREPAID DJEZZY','SIM PREPAID ALLO') and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and ( (nvl(p.profil_pre_non_active,'_')<>'N'  and r.rng_statut='ACTIVE') or  (p.profil_pre_non_active='N')) and r.rng_packaged='P' and r.rng_tpd is null   and   r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') and r.profil_id=p.profil_id(+) and w.whs_region in ('CENTRE','EST','OUEST')group by w.whs_region,a.art_art_libelle,nvl(p.profil_libelle,'_')");
 
 while (rs1.next())
	{
		String whs=rs1.getString(1).trim();
		System.out.println(whs);
		
		if (whs.equals("CENTRE")){i=1;}
    if (whs.equals("EST")){i=2;}
 if (whs.equals("OUEST")){i=3;}

 String art=rs1.getString(2).trim();
	System.out.println(art);
	
	  String profil=rs1.getString(3).trim();
		System.out.println(profil);
		
		if ((art.equals("SIM PREPAID DJEZZY"))&&(profil.equals("_"))){j=6;}
     if ((art.equals("SIM PREPAID DJEZZY"))&&(profil.equals("P_DIRECT"))){j=7;}
  	if ((art.equals("SIM PREPAID DJEZZY"))&&(profil.equals("PSM"))){j=8;}
	if ((art.equals("SIM PREPAID DJEZZY"))&&(profil.equals("P_PRINTEMPS"))){j=9;}
	
	   if (art.equals("SIM PREPAID ALLO")&&(profil.equals("_"))){j=10;}
	    if (art.equals("SIM PREPAID ALLO")&&(profil.equals("PACK_LAHBAB"))){j=11;}
	    
	    
	    if (art.equals("SIM PREPAID ALLO")&&(profil.equals("ALLO  NON ACTIVE"))){j=12;}
	    if (art.equals("SIM PREPAID DJEZZY")&&(profil.equals("DJEZZY NON ACTIVE"))){j=13;}
    
    
  
 
String qte=rs1.getString(4).trim();
		 System.out.println(qte);	
		
WritableCell cell = sheet0.getWritableCell(i, j);
System.out.println("lei"+i+"le je"+j);	

Number num=(Number) cell;
num.setValue(Integer.parseInt(qte));


//Label pre = new Label (i, j, qte); 
//sheet0.addCell(pre);  
				   


	}
// postpaid tous les profil 
 
 System.out.println("je s8 ds postpaid tous les profil  ");
rs2=st2.executeQuery("select distinct w.whs_region,P.PROFIL_LIBELLE,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_profil p,gss_article_type t  where (a.art_id=r.art_id) and r.profil_id(+)=p.profil_id and a.art_type_id=t.art_type_id and t.art_type_libelle='SIMPOST' and (r.rng_whs=w.whs_id) and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') and w.whs_region in ('CENTRE','EST','OUEST') group by w.whs_region,P.PROFIL_LIBELLE order by 1 desc, 2 desc");
 while (rs2.next())
	{
		String whs=rs2.getString(1).trim();
		System.out.println(whs);
		
		if (whs.equals("CENTRE")){i=1;}
    if (whs.equals("EST")){i=2;}
 if (whs.equals("OUEST")){i=3;}

 String prof=rs2.getString(2).trim();
	System.out.println(prof);
	if (prof.equals("DJEZZY CONTROL")){j=14;}
	if (prof.equals("DJEZZY CLASSIC")){j=15;}
	if (prof.equals("CONTROL NON ACTIVE")){j=16;}
	if (prof.equals("CLASSIC NON ACTIVE")){j=17;}
	if (prof.equals("BUSINESS CONTROL")){j=18;}
	if (prof.equals("BUSINESS")){j=19;}
	
	
	
String qte=rs2.getString(3).trim();
		 System.out.println(qte);	
		 System.out.println(i+"+"+j);		
WritableCell cell = sheet0.getWritableCell(i, j);

Number num=(Number) cell;
	      
		   num.setValue(Integer.parseInt(qte));

	}
 
 //les scratch 
 System.out.println("je s8 ds les scratch  ");
 rs=null;st=null;
		st=con.createStatement();
		
		// les scratch Stock Ordinaire Disponible a la consommation
		System.out.println("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle='SCRATCH')and r.rng_inactif='A'  and r.rng_statut='ACTIVE'  and r.rng_tpd is null  and r.rng_sortie <>'O'  and r.rng_sortie <>'S' and r.rng_reintegration <>'A' group by a.art_art_libelle");
 rs=st.executeQuery("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle in ('SCRATCH','E_VOUTCHER')) and r.rng_inactif='A'  and r.rng_statut='ACTIVE'  and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S')  and  a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') group by a.art_art_libelle");
 
 
 while (rs.next())
	{
	
		
		String  art=rs.getString(1).trim();
		System.out.println(art);
		
		if (art.equals("SCRATCH DJEZ 1200 DA")){j=24;}
		if (art.equals("SCRATCH DJEZ 2300 DA")){j=25;}
        if (art.equals("SCRATCH DJEZ   500 DA")){j=26;}
        if (art.equals("SCRATCH ALLO 1000 DA")){j=27;}
        if (art.equals("SCRATCH ALLO   500 DA")){j=28;}
        if (art.equals("SCRATCH ALLO   200 DA")){j=29;}
     //   if (art.equals("SCRATCH DJEZ 3000 DA")){j=27;}
      //  if (art.equals("SCRATCH DJEZ 2000 DA")){j=28;}
        
    	if (art.equals("SCRATCH DJEZ   500 Cadeaux")){j=33;}
		if (art.equals("SCRATCH DJEZ 1200 Cadeaux")){j=34;}
        if (art.equals("SCRATCH ALLO   500 Cadeaux")){j=35;}
        if (art.equals("SCRATCH ALLO   500 Bonus")){j=36;}
        if (art.equals("SCRATCH ALLO 1000 Cadeaux")){j=37;}
        if (art.equals("SCRATCH ALLO 1000 Bonus")){j=38;}
        
        
    	if (art.equals("E_VOUTCHER   ALLO_100 DA")){j=42;}
		if (art.equals("E_VOUTCHER   ALLO_200 DA")){j=43;}
        if (art.equals("E_VOUTCHER   ALLO_500 DA")){j=44;}
        if (art.equals("E_VOUTCHER   ALLO_1000 DA")){j=45;}
        if (art.equals("E_VOUTCHER   DJEZ _100 DA")){j=46;}
        if (art.equals("E_VOUTCHER   DJEZ _200 DA")){j=47;}
        if (art.equals("E_VOUTCHER   DJEZ _500 DA")){j=48;}
        if (art.equals("E_VOUTCHER   DJEZ _1200 DA")){j=49;}
        if (art.equals("E_VOUTCHER   DJEZ _2300 DA")){j=50;}
        
        
        
        
    
		 String qte=rs.getString(2).trim();
		 System.out.println(qte);	
		 
		 System.out.println(i+"+"+j);
		
 WritableCell cell = sheet0.getWritableCell(2, j);
 
 
	      Number num=(Number) cell;
		   num.setValue(Integer.parseInt(qte));

	}
 
//les scratch  Stock Disponible Total
 System.out.println("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle='SCRATCH')and r.rng_inactif='A'   and r.rng_tpd is null  and r.rng_sortie <>'O'  and r.rng_sortie <>'S' and r.rng_reintegration <>'A' group by a.art_art_libelle");
 rs=st.executeQuery("select distinct a.art_art_libelle,sum(r.rng_end-r.rng_start+1) as qte from gss_range r,gss_article a,gss_warehouse w ,gss_article_type t  where a.art_id=r.art_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and (t.art_type_libelle in ('SCRATCH','E_VOUTCHER')) and r.rng_inactif='A'   and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S')  and  a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') group by a.art_art_libelle");

 
 while (rs.next())
	{
	
		
		String  art=rs.getString(1).trim();
		System.out.println(art);
		
		if (art.equals("SCRATCH DJEZ 1200 DA")){j=24;}
		if (art.equals("SCRATCH DJEZ 2300 DA")){j=25;}
     if (art.equals("SCRATCH DJEZ   500 DA")){j=26;}
     if (art.equals("SCRATCH ALLO 1000 DA")){j=27;}
     if (art.equals("SCRATCH ALLO   500 DA")){j=28;}
     if (art.equals("SCRATCH ALLO   200 DA")){j=29;}
  //   if (art.equals("SCRATCH DJEZ 3000 DA")){j=27;}
  //   if (art.equals("SCRATCH DJEZ 2000 DA")){j=28;}
     
     if (art.equals("SCRATCH DJEZ   500 Cadeaux")){j=33;}
		if (art.equals("SCRATCH DJEZ 1200 Cadeaux")){j=34;}
     if (art.equals("SCRATCH ALLO   500 Cadeaux")){j=35;}
     if (art.equals("SCRATCH ALLO   500 Bonus")){j=36;}
     if (art.equals("SCRATCH ALLO 1000 Cadeaux")){j=37;}
     if (art.equals("SCRATCH ALLO 1000 Bonus")){j=38;}
     
     
 	if (art.equals("E_VOUTCHER   ALLO_100 DA")){j=42;}
		if (art.equals("E_VOUTCHER   ALLO_200 DA")){j=43;}
     if (art.equals("E_VOUTCHER   ALLO_500 DA")){j=44;}
     if (art.equals("E_VOUTCHER   ALLO_1000 DA")){j=45;}
     if (art.equals("E_VOUTCHER   DJEZ _100 DA")){j=46;}
     if (art.equals("E_VOUTCHER   DJEZ _200 DA")){j=47;}
     if (art.equals("E_VOUTCHER   DJEZ _500 DA")){j=48;}
     if (art.equals("E_VOUTCHER   DJEZ _1200 DA")){j=49;}
     if (art.equals("E_VOUTCHER   DJEZ _2300 DA")){j=50;}
     
 
		 String qte=rs.getString(2).trim();
		 System.out.println(qte);	
		 
		 System.out.println(i+"+"+j);
		
WritableCell cell = sheet0.getWritableCell(1, j);


	      Number num=(Number) cell;
		   num.setValue(Integer.parseInt(qte));

	}

	System.out.println("select a.art_art_libelle,nvl(a.consomation_j_t,0) from gss_article a ");
	 rs=st.executeQuery("select a.art_art_libelle,nvl(a.consomation_j_t,0) from gss_article a where a.art_type_id in ('S3','S4')  and  a.art_art_libelle not in ('SCRATCH DJEZ 3000 DA','SCRATCH DJEZ 2000 DA') ");
	 
	 
	 while (rs.next())
		{
		
			
			String  art=rs.getString(1).trim();
			System.out.println(art);
			
			if (art.equals("SCRATCH DJEZ 1200 DA")){j=24;}
			if (art.equals("SCRATCH DJEZ 2300 DA")){j=25;}
	     if (art.equals("SCRATCH DJEZ   500 DA")){j=26;}
	     if (art.equals("SCRATCH ALLO 1000 DA")){j=27;}
	     if (art.equals("SCRATCH ALLO   500 DA")){j=28;}
	     if (art.equals("SCRATCH ALLO   200 DA")){j=29;}
	     
	
	     if (art.equals("SCRATCH DJEZ   500 Cadeaux")){j=33;}
			if (art.equals("SCRATCH DJEZ 1200 Cadeaux")){j=34;}
	        if (art.equals("SCRATCH ALLO   500 Cadeaux")){j=35;}
	        if (art.equals("SCRATCH ALLO   500 Bonus")){j=36;}
	        if (art.equals("SCRATCH ALLO 1000 Cadeaux")){j=37;}
	        if (art.equals("SCRATCH ALLO 1000 Bonus")){j=38;}
	        
	        
	    	if (art.equals("E_VOUTCHER   ALLO_100 DA")){j=42;}
			if (art.equals("E_VOUTCHER   ALLO_200 DA")){j=43;}
	        if (art.equals("E_VOUTCHER   ALLO_500 DA")){j=44;}
	        if (art.equals("E_VOUTCHER   ALLO_1000 DA")){j=45;}
	        if (art.equals("E_VOUTCHER   DJEZ _100 DA")){j=46;}
	        if (art.equals("E_VOUTCHER   DJEZ _200 DA")){j=47;}
	        if (art.equals("E_VOUTCHER   DJEZ _500 DA")){j=48;}
	        if (art.equals("E_VOUTCHER   DJEZ _1200 DA")){j=49;}
	        if (art.equals("E_VOUTCHER   DJEZ _2300 DA")){j=50;}
	     
	     
	  //   if (art.equals("SCRATCH DJEZ 3000 DA")){j=27;}
	  //   if (art.equals("SCRATCH DJEZ 2000 DA")){j=28;}
	     
	     
	     
	 
			 Integer qte=rs.getInt(2);
			 System.out.println(qte);	
			 
			 System.out.println(i+"+"+j);
			
	WritableCell cell = sheet0.getWritableCell(3, j);


		      Number num=(Number) cell;
			   num.setValue(qte);
		 
		}
 
		
Label global = new Label (0, 1, " Ready for distribution du:"+date); 
sheet0.addCell(global); 

rs=null;st=null;

st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);



WritableSheet sheet1= copy.getSheet(1
		);//on travail sur la feuile n1 
  

System.out.println("je s8 ds la 2ere feuille des postpaid par distributeur");
rs=st.executeQuery("select distinct w.whs_region,r.rng_dist,p.profil_libelle as prof,sum(r.rng_end-r.rng_start+1) as qte from  gss_destinataire d ,  gss_range r,gss_article a,gss_warehouse w, gss_article_profil p,gss_article_type t where a.art_id=r.art_id and p.profil_id (+) =r.profil_id and (r.rng_whs=w.whs_id) and (a.art_type_id=t.art_type_id) and a.art_art_libelle  like 'SIM POSTPAID DJEZZY%'  and r.rng_inactif='A'  and r.rng_statut='ACTIVE' and r.rng_packaged='P' and p.profil_libelle in ('DJEZZY CONTROL','DJEZZY CLASSIC')and r.rng_tpd is null  and  r.rng_sortie <> ('O') and  r.rng_sortie <> ('S') and r.rng_dist=d.dest_nom and d.dest_type='DISTRIBUTEUR' and w.whs_region in ('CENTRE','EST','OUEST') group by w.whs_region,r.rng_dist,p.profil_libelle order by 1 desc, 2 desc, 3 desc ");
int cpt=1;
//int step=2;
rs.last();
int step = rs.getRow();

rs.first();
System.out.println("la taille des enregistrement="+step);
//while (rs.next()&&(cpt<=step))
while ((cpt<=step))
	{
		String whs=rs.getString(1).trim();
		System.out.println(whs);
		if (whs.equals("CENTRE")){j=4;}
	    if (whs.equals("EST")){j=16;}
	 if (whs.equals("OUEST")){j=28;}
	     
	 while ((cpt<=step)&& (rs.getString(1).trim().equals(whs)))
	 
	 {	
		 
        String  dist=rs.getString(2).trim();
		System.out.println(dist);
		i=0;
	
		WritableCell cell = sheet1.getWritableCell(i, j);  
		 System.out.println(i+" dist"+"+"+j);
		
		 if ((cell.getType() == CellType.LABEL) )
		 { 
			      Label num=(Label) cell;
			      
				   num.setString(dist);
		}
		 if ((cell.getType()==CellType.EMPTY) )
		 {
			 Label labelpre = new Label (i, j, dist); 
		   sheet1.addCell(labelpre);  

		 }	
		 
		
		 
		 while ((cpt<=step)&& (rs.getString(1).trim().equals(whs))&&rs.getString(2).trim().equals(dist)) 
		 {
			 String  prof=rs.getString(3).trim();
			System.out.println(prof);
			
			if (prof.equals("DJEZZY CLASSIC")){i=1;}
		    if (prof.equals("DJEZZY CONTROL")){i=2;}
		    
		    String qte=rs.getString(4).trim();
		    System.out.println(qte);
		    
		  //  WritableCell cel = sheet1.getWritableCell(i, j);
		    System.out.println(i+" profil"+"+"+j);
		/*	 if ((cel.getType() == CellType.NUMBER) )
			 { 
				      Number num=(Number) cel;
				      
					   num.setValue(Integer.parseInt(qte));
			}
			 if ((cel.getType()==CellType.EMPTY) )
			 {
				 Label labelpre = new Label (i, j, qte); 
			   sheet1.addCell(labelpre);  

			 }	*/
		    Number num=new Number (i, j,Integer.parseInt(qte));
			 sheet1.addCell(num); 
			 rs.next();
		cpt=cpt+1;
		
	System.out.println("le cpt="+cpt);
//	 prof=rs.getString(3).trim();
		
			
		 }
		 
		//  dist=rs.getString(2).trim(); 
		
		 j=j+1;
	}
	 
	
		
	//	whs=rs.getString(1).trim();
	}


	

Label postdist = new Label (1, 1, " tat prt a la distribution SIM Djezzy Card Journe du:"+date); 
sheet1.addCell(postdist); 

		
		 copy.write(); 
		 copy.close();
		 
		
		 response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment; filename=\"ReadyDistribution.xls\"");


//FileInputStream is = new FileInputStream(new File(projectRealPath,"bon/ready.xls"));
FileInputStream is = new FileInputStream("ReadyDistribution.xls");

byte buffer[] = new byte[1024];
int nbLecture;
//Envoyer le flux dans la rponse
OutputStream os = response.getOutputStream();
while ((nbLecture = is.read(buffer)) != -1) {
os.write(buffer, 0, nbLecture);
}
os.close(); 
		

	con.close();

		return null;
	}
	
	
	
	public ActionForward preparetatdist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, RowsExceededException, WriteException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		
		etaStkForm.setDat_au("");
	etaStkForm.setDat_du("");
	
		return mapping.findForward("etat");
	}
	
	public ActionForward etatdist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, RowsExceededException, WriteException, BiffException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		
		Statement st,st1,st2 = null;
		ResultSet rs,rs1,rs2 = null;
		st1=con.createStatement();
		int j=0;
		File file;
		
		String debut=etaStkForm.getDat_du();
		System.out.println("date debut="+debut);
		String fin= etaStkForm.getDat_au();
		System.out.println("date fin="+fin);
		
/*	String[] split_date_debut=debut.split("/");
	String jour=split_date_debut[0];
	System.out.println("jour="+jour);
	String mois=split_date_debut[1];
	System.out.println("mois="+mois);
	String annee=split_date_debut[2];
	System.out.println("annee="+annee);
	debut=jour+"_"+mois+"_"+annee;
	
	String[] split_date_fin=fin.split("/");
	String jour1=split_date_fin[0];
	System.out.println("jour="+jour1);
	String mois1=split_date_fin[1];
	System.out.println("mois="+mois1);
	String annee1=split_date_fin[2];
	System.out.println("annee="+annee1);
	fin=jour1+"_"+mois1+"_"+annee1;
	
	System.out.println("date debut apres modif="+debut);
	System.out.println("date fin   apres modif="+fin);*/

	
	
		
	/*	 File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
		 file=new File(projectRealPath,"bon/Etat_Distribution_Template.xls");
         System.out.println(file.getAbsolutePath());  

       
 Workbook workbook = Workbook.getWorkbook (new File(projectRealPath,"bon/Etat_Distribution_Template.xls"));

 WritableWorkbook copy = Workbook.createWorkbook(new File("EtatDistribution.xls"), workbook);//copie du fichier source 
 */
 
 File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
 file=new File(projectRealPath,"bon/Etat_Distribution_Template.xls");
 System.out.println(file.getAbsolutePath());  


Workbook workbook = Workbook.getWorkbook (new File(projectRealPath,"bon/Etat_Distribution_Template.xls"));

WritableWorkbook copy = Workbook.createWorkbook(new File("EtatDistribution.xls"), workbook);//copie du fichier source 


///  tat distribution des cds


st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//System.out.println("select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,  t.art_art_libelle,nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'Z%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') order by 1 desc, 2 desc, 3 desc,4 desc");
//rs=st.executeQuery("select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,  t.art_art_libelle,nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_article_type typ,gss_article art,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'Z%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 ) and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER') group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') order by 1 desc, 2 desc, 3 desc,4 desc");

System.out.println("je s8 ds la 1ere feuille des cds "); 
WritableSheet sheet0 = copy.getSheet(0);//on travail sur la feuile n1 

String requete_art_profil_cds ="select distinct t.art_art_libelle||'\'||nvl(t.profil_libelle,'_'), t.art_art_libelle,nvl(t.profil_libelle,'_')  from gss_article_type typ,gss_article art,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'Z%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 ) and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER') group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') ";
String requete_donnees_cds ="select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,t.art_art_libelle||'\'||nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_article_type typ,gss_article art,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'Z%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 ) and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER') group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle||'\'||nvl(t.profil_libelle,'_') order by t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle||'\'||nvl(t.profil_libelle,'_')";
System.out.println("requete_art_profil_cds"+requete_art_profil_cds); 
System.out.println("requete_donnees_cds"+requete_donnees_cds); 

editExel_parametr(sheet0,request,requete_art_profil_cds,requete_donnees_cds);

		
/*Label distribution_cds = new Label (3, 2, "Distribution Cds journes du :"+debut+"au"+fin ); 
sheet0.addCell(distribution_cds); */


WritableCell cell = sheet0.getWritableCell(3, 2);

if ((cell.getType() == CellType.LABEL) )
{ 
	      Label num=(Label) cell;
	      
		   num.setString("Distribution Cds journes du :"+debut+"au"+fin);
}
if ((cell.getType()==CellType.EMPTY) )
{
	 Label labelpre = new Label (2, 2, "Distribution Cds journes du :"+debut+"au"+fin); 
	sheet0.addCell(labelpre);  

}	








//l'tat des distributeur 

st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//System.out.println("select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,  t.art_art_libelle,nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'D%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') order by 1 desc, 2 desc, 3 desc, 4 desc");
//rs=st.executeQuery("select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,  t.art_art_libelle,nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_article_type typ,gss_article art ,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'D%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 )  and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER')group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') order by 1 desc, 2 desc, 3 desc, 4 desc");

 WritableSheet sheet1 = copy.getSheet(1);//on travail sur la feuile n1 
 
 String requete_art_profil_dist ="select distinct t.art_art_libelle||'\'||nvl(t.profil_libelle,'_'), t.art_art_libelle,nvl(t.profil_libelle,'_')  from gss_article_type typ,gss_article art,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'D%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 ) and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER') group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle,nvl(t.profil_libelle,'_') ";
 String requete_donnees_dist ="select  t.whs_region, t.dest_id || '__' || d.dest_nom as destinataire,  t.art_art_libelle||'\'||nvl(t.profil_libelle,'_') , sum(t.qte) Quantite from gss_article_type typ,gss_article art,gss_rep_transactions t, gss_destinataire d where d.dest_id= t.dest_id and t.dest_id like 'D%' and t.transaction_code like 'SOR%'and t.trans_date between (to_date('"+debut+"', 'dd/mm/yyyy')) and (to_date('"+fin+"', 'dd/mm/yyyy') + 1 ) and t.art_art_libelle=art.art_art_libelle and art.art_type_id=typ.art_type_id  and typ.art_type_libelle not in ('E_VOUTCHER') group by  t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle||'\'||nvl(t.profil_libelle,'_') order by t.whs_region, t.dest_id || '__' || d.dest_nom, t.art_art_libelle||'\'||nvl(t.profil_libelle,'_')";
 editExel_parametr(sheet1,request, requete_art_profil_dist ,requete_donnees_dist);
 
 
Label distribution_distributeur = new Label (2, 2, "Distribution Distributeurs journes du :"+debut+"au"+fin ); 
sheet1.addCell(distribution_distributeur); 
 


////// reliquat distributeur 


//System.out.println("select a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'D%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))> to_date('"+debut+"', 'dd/mm/yyyy') and trunc(nvl(v.date_livraison,sysdate))> to_date('"+fin+"', 'dd/mm/yyyy')and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')   and v.prover='P' and v.quantite_article-v.qte_livree>0 group by a.art_art_libelle,v.profil_id  order by a.art_art_libelle,v.profil_id");
//rs1=st1.executeQuery("select distinct a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d,gss_article_type typ where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'D%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))> to_date('"+debut+"', 'dd/mm/yyyy') and trunc(nvl(v.date_livraison,sysdate))> to_date('"+fin+"', 'dd/mm/yyyy')and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')   and v.prover='P' and v.quantite_article-v.qte_livree>0 and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' group by a.art_art_libelle,v.profil_id  order by a.art_art_libelle,v.profil_id");

 

WritableSheet sheet2 = copy.getSheet(2);//on travail sur la feuile n1 
System.out.println("je s8 ds la 3ere feuille reliquat");

String requete_art_profil_reliquet_dist ="select distinct a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d,gss_article_type typ where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'D%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+debut+"', 'dd/mm/yyyy') and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+fin+"', 'dd/mm/yyyy')and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')   and v.prover='P' and v.quantite_article-v.qte_livree>0 and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' group by a.art_art_libelle,v.profil_id  order by a.art_art_libelle,v.profil_id";
String requete_donnees_reliquet_dist ="select v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id,sum(v.quantite_article-v.qte_livree)from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'D%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+fin+"', 'dd/mm/yyyy') and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')  and v.prover='P'  and (v.quantite_article-v.qte_livree)>0  group by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id order by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id";
editExel_parametr(sheet2,request,requete_art_profil_reliquet_dist,requete_donnees_reliquet_dist);


Label reliquat = new Label (2, 2, "Reliquat  Distributeurs du :"+debut+"au"+fin ); 
sheet2.addCell(reliquat); 

 
 
//////reliquat CDS 




//System.out.println("select d.dest_nom,a.art_art_libelle,v.profil_id,sum(v.quantite_article-v.qte_livree)from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'Z%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))> to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(nvl(v.date_livraison,sysdate))> to_date('"+fin+"', 'dd/mm/yyyy') and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')  and v.prover='P'  group by d.dest_nom,a.art_art_libelle,v.profil_id order by 1 desc, 2 desc, 3 desc");
//rs=st.executeQuery("select d.dest_nom,a.art_art_libelle,v.profil_id,sum(v.quantite_article-v.qte_livree)from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'Z%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))> to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(nvl(v.date_livraison,sysdate))> to_date('"+fin+"', 'dd/mm/yyyy') and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')  and v.prover='P'  group by d.dest_nom,a.art_art_libelle,v.profil_id order by 1 desc, 2 desc, 3 desc");

WritableSheet sheet3 = copy.getSheet(3);//on travail sur la feuile n1 
System.out.println("je s8 ds la 3ere feuille reliquat");

String requete_art_profil_reliquet_cds ="select distinct  a.art_art_libelle||' / '||v.profil_id,a.art_art_libelle,v.profil_id from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d,gss_article_type typ where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'Z%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+debut+"', 'dd/mm/yyyy') and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+fin+"', 'dd/mm/yyyy')and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')   and v.prover='P' and v.quantite_article-v.qte_livree>0 and a.art_type_id=typ.art_type_id and typ.art_type_libelle<>'E_VOUTCHER' group by a.art_art_libelle,v.profil_id  order by a.art_art_libelle,v.profil_id";
String requete_donnees_reliquet_cds ="select v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id,sum(v.quantite_article-v.qte_livree)from gss_reserv_approb v,gss_article a ,gss_transaction t,gss_destinataire d where t.trans_type=v.trans_type and t.whs_id=v.whs_id and v.trans_no=t.trans_no and t.dest_id=d.dest_id and v.art_id=a.art_id and t.dest_id like 'Z%' and t.annuler='N' and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(nvl(v.date_livraison,sysdate))>= to_date('"+fin+"', 'dd/mm/yyyy') and trunc(t.trans_date)>=to_date('"+debut+"', 'dd/mm/yyyy')  and trunc(t.trans_date)<=to_date('"+fin+"', 'dd/mm/yyyy')  and v.prover='P' and (v.quantite_article-v.qte_livree)>0  group by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id order by v.res_app_whs,d.dest_nom,a.art_art_libelle||' / '||v.profil_id";
editExel_parametr(sheet3,request,requete_art_profil_reliquet_cds,requete_donnees_reliquet_cds);


Label reliquatcds = new Label (2, 2, "Reliquat des  CDS du :"+debut+"au"+fin ); 
sheet3.addCell(reliquatcds); 
 
   
    
		copy.write();
		copy.close();
		
		 response.setContentType("application/octet-stream");
		 response.setHeader("Content-Disposition","attachment; filename=\"EtatDistribution.xls\"");


FileInputStream is = new FileInputStream("EtatDistribution.xls");

byte buffer[] = new byte[1024];
int nbLecture;
//Envoyer le flux dans la rponse
OutputStream os = response.getOutputStream();
while ((nbLecture = is.read(buffer)) != -1) {
os.write(buffer, 0, nbLecture);
}
os.close(); 



	con.close();

		
		return null;
		
	}
	 
     
 // editrapport( request,response,"SOR",whh,max);
     
     public ActionForward rapport(ActionMapping mapping, ActionForm form,
 			HttpServletRequest request, HttpServletResponse response) throws SQLException {
 		EtaStkForm etaStkForm = (EtaStkForm) form;
 	String txt,txt1,txt2;
 	
 		//String num=(String)request.getAttribute("num");
 	String num=etaStkForm.getHiddenTdp();
 	     System.out.println("numero"+num);
 	     
 	    txt = num.substring(0,3);
 	   System.out.println("txt="+txt);
 	   txt1 = num.substring(4,7);
 	   System.out.println("txt1="+txt1);
 	   txt2 = num.substring(8);
 	   System.out.println("txt2="+txt2);   
 	   
 	    editrapport( request,response,txt,txt1,txt2);
 		
 		return null;
 	}
     
     
     
     public ActionForward rapportapprob_annul(ActionMapping mapping, ActionForm form,
  			HttpServletRequest request, HttpServletResponse response) throws SQLException {
  		EtaStkForm etaStkForm = (EtaStkForm) form;
  		
  		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
  	String txt,txt1,txt2;
  	File  jasperFile=null;
  	
  		//String num=(String)request.getAttribute("num");
  	String num=etaStkForm.getHiddenTdp();
  	     System.out.println("numero"+num);
  	   String typetrans=(String)request.getSession().getAttribute("typetrans"); 
  	 System.out.println("typetrans"+typetrans);
  	   
  	     
  	    txt = num.substring(0,3);
  	   System.out.println("txt="+txt);
  	   txt1 = num.substring(4,7);
  	   System.out.println("txt1="+txt1);
  	   txt2 = num.substring(8);
  	   System.out.println("txt2="+txt2); 
  	   
  		try{	 
			  File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
			if (typetrans.equals("approuv"))
			{
			  
			    jasperFile=new File(projectRealPath,"bon/approbation.jasper");
			}
			
			if (typetrans.equals("annul"))
			{
			  
			    jasperFile=new File(projectRealPath,"bon/annulation.jasper");
			}
			   System.out.println(jasperFile.getAbsolutePath());
			   
			   
				File	imageFile=new File(projectRealPath,"bon/logo.jpg");		 
				//	  JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
					  // - Paramtres  envoyer au rapport
					  Map parameters = new HashMap();
					  parameters.put("Titre", "Titre"); 
					  parameters.put("param1",new String ("'"+txt+"'"));
					 parameters.put("param2", new String("'"+txt1+"'"));
					  parameters.put("param3", new String("'"+txt2+"'"));
					  parameters.put("image",  new FileInputStream(imageFile));
					  

				//	  JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

					//  File file = new File("/user/repjrxml/rapports");
					     JasperPrint jasperPrint = JasperFillManager.fillReport(
					    new FileInputStream(jasperFile), parameters, con);
					 	  
					  
					  
					  
					  // pour l'affichage
//					  JasperViewer.viewReport(jasperPrint,false);
					  // - Cration du rapport au format PDF
					JasperExportManager.exportReportToPdfFile(jasperPrint, ""+num+".pdf"); 

					response.setContentType("application/octet-stream");
					response.setHeader("Content-Disposition","attachment; filename=\""+num+".pdf\"");
//					 Calculer le flux  renvoyer au client
					FileInputStream is = new FileInputStream(""+num+".pdf");
				//	File.createTempFile(""+trans+".pdf", ""+trans+".pdf");
					
					byte buffer[] = new byte[1024];
					int nbLecture;
//					 Envoyer le flux dans la rponse
					OutputStream os = response.getOutputStream();
					while ((nbLecture = is.read(buffer)) != -1) {
					os.write(buffer, 0, nbLecture);
					}
					os.close();

					   }
					catch (JRException e) {
					     e.printStackTrace();
					    } 
					catch (Exception ex) {
					ex.printStackTrace();
		
					}
					
					 finally
				        {
					    	con.close();
				        }
  	   
  	   // editrapport( request,response,txt,txt1,txt2);
  		
  		return null;
  	}
     
     
	public ActionForward visualiser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		EtaStkForm etaStkForm = (EtaStkForm) form;
		
		String directoryPath="D:\\gss_log";
	
			File[] files = null; 
			File directoryToScan = new File(directoryPath); 
	files = directoryToScan.listFiles(); 

	
	
	for(int i=0; i<files.length; i++) { 
		
		File fichier=files[i];
		String nom_fichier=fichier.getName();
		System.out.println("nom du fichier n="+i+nom_fichier); 
		
		
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				
		
				
				String date_courante = DateFormat.getInstance().format(new Date());
				System.out.println("date_courante="+date_courante);
							
				
				String[] split_log=ligne.split("+");
				
				String username=split_log[0];
				System.out.println("annee="+username);
				
				String date=split_log[1];
				System.out.println("date="+date);
				
				
				String path=split_log[2];
				System.out.println("path"+path);
				
				
				 date="03/02/10 15:30";
				
			      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
				  Date date_log=  sdf.parse(date);
				  
				  
				Calendar calendarDansCinqJours = Calendar.getInstance();
			    calendarDansCinqJours.add(Calendar.MINUTE, -30);
			    Date dateDansCinqJours =  (Date) calendarDansCinqJours.getTime();
			    
				String date_aprs_soustraction = DateFormat.getInstance().format(dateDansCinqJours);
				System.out.println("date_aprs_soustraction="+date_aprs_soustraction);
					  
					  
				
					  if (dateDansCinqJours.before(date_log)) {
						  System.out.println("date sup");
			            }
					  
								
		}	
			br.close(); 	
		}
		catch (Exception e){
			System.out.println(e.toString());
		}

		        
} 

	

		
	
		
		
	
		return null;
	}

	
	
	 public String editrapport( HttpServletRequest request,HttpServletResponse response,String txt,String txt1,String txt2) throws SQLException
		{
			
			
			Connexion connexion=new Connexion();
			Connection con=connexion.createConnection(request);
			File jasperFile=null;
			String trans=null;
			trans=txt+"-"+txt1+"-"+txt2;
			 System.out.println("txt2="+txt2); 
			   try {
			       
				   File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));

			 if((txt.equals("TRA"))||(txt.equals("RTR"))||(txt.equals("OTR")))
			  
			 {
				   System.out.println("je s8 ds transfert");
				 jasperFile=new File(projectRealPath,"bon/ordre.jasper");
				   System.out.println(jasperFile.getAbsolutePath());
			}  
			 else	 { 
		 if((txt.equals("TSO")))
				  
			 {
				   System.out.println("je s8 ds autosortie");
				 jasperFile=new File(projectRealPath,"bon/autosortie.jasper");
				   System.out.println(jasperFile.getAbsolutePath());
			}   
		 else{
			 
			 if((txt.equals("REC"))||(txt.equals("RTF"))||(txt.equals("PAC"))||(txt.equals("RPA"))||(txt.equals("TRE"))||(txt.equals("REI"))||(txt.equals("SOR")))
				   
			 {
			   System.out.println("je s8 ds rec");
			   jasperFile=new File(projectRealPath,"bon/classic4.jasper");
			   System.out.println(jasperFile.getAbsolutePath());
			   
			 }
			 
			 else
			 {if(txt.equals("RES"))
				 {
				 System.out.println("je s8 ds reservation");
				   jasperFile=new File(projectRealPath,"bon/reservation.jasper");
				   System.out.println(jasperFile.getAbsolutePath());
				 
				 }
				 
				  else{
					  if(txt.equals("CPR")) {
						  System.out.println("je s8 ds CONFIRMATION PREPAID");
						   jasperFile=new File(projectRealPath,"bon/confirmationprepaid.jasper");
						   System.out.println(jasperFile.getAbsolutePath());
					  
					  }
					  else{
						  if(txt.equals("ANN")) {
							  System.out.println("je s8 ds ANNULATION");
							   jasperFile=new File(projectRealPath,"bon/annulation.jasper");
							   System.out.println(jasperFile.getAbsolutePath());
						  
						  }
						  else{
							  
					
					  
					  System.out.println("je s8 ds activation");
					   jasperFile=new File(projectRealPath,"bon/activation.jasper");
					   System.out.println(jasperFile.getAbsolutePath());}
					  } }
			 }
		 }
			 }	
			 
			 
			 
		//	 JasperDesign jasperDesign = JRXmlLoader.load(jasperFile); 
			 
		File	imageFile=new File(projectRealPath,"bon/logo.jpg");		 
		//	  JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			  // - Paramtres  envoyer au rapport
			  Map parameters = new HashMap();
			  parameters.put("Titre", "Titre"); 
			  parameters.put("param1",new String ("'"+txt+"'"));
			 parameters.put("param2", new String("'"+txt1+"'"));
			  parameters.put("param3", new String("'"+txt2+"'"));
			  parameters.put("image",  new FileInputStream(imageFile));
			  

			  //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, parameters, con);

		 JasperPrint jasperPrint = JasperFillManager.fillReport( new FileInputStream(jasperFile), parameters, con);
			  
			    
		//	 pour l'affichage
			//  JasperViewer.viewReport(jasperPrint,true);
			  // - Cration du rapport au format PDF
	//	 File report = File.createTempFile("+trans+","pdf");
		//    JasperExportManager.exportReportToPdfFile(jasperPrint, report.getAbsolutePath());	
	
			  
		
			//code  modifer   
			JasperExportManager.exportReportToPdfFile(jasperPrint,""+trans+".pdf"); 
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment; filename=\""+trans+".pdf\"");
//			 Calculer le flux  renvoyer au client
			FileInputStream is = new FileInputStream(""+trans+".pdf");
		
			
			byte buffer[] = new byte[1024];
			int nbLecture;
//			 Envoyer le flux dans la rponse
			OutputStream os = response.getOutputStream();
			while ((nbLecture = is.read(buffer)) != -1) {
			os.write(buffer, 0, nbLecture);
			}
			os.close();

			   }
			catch (JRException e) {
			     e.printStackTrace();
			    } 
			catch (Exception ex) {
			ex.printStackTrace();
			} 
			
			 finally
		        {
			    	con.close();
		        }

	return null;
//		return mapping.findForward("menu");
		}
	 
	 

	 
	
	 
	 public String editExcel( HttpServletResponse response, List collection ,String transaction)
		{
			
			
		
			
		
		//	ArrayList  collection=new ArrayList() ;
			
		
try{
			
		WritableWorkbook classeur = Workbook.createWorkbook (new File ( "'"+transaction+"'.xls"));
			

			 WritableSheet sheet = classeur.createSheet("First Sheet", 0); 
			
			 
			 
			 Label labelart = new Label(1, 0, "ARTICLE"); 
			 sheet.addCell(labelart); 
			 
			 Label labelprof = new Label(2, 0, "PROFIL"); 
			 sheet.addCell(labelprof); 
			 
		Label deb = new Label(3, 0, "SERIAL START"); 
			 sheet.addCell(deb); 
			 
			 Label fin = new Label(4, 0, "SERIAL END"); 
			 sheet.addCell(fin); 
			 
			
			 Label position = new Label(5, 0, "POSITION"); 
			 sheet.addCell(position); 
			 
			
			 Label pack = new Label(6, 0, "PACKAGING"); 
			 sheet.addCell(pack); 
			 
			 Label hlr = new Label(7, 0, "HLR"); 
			 sheet.addCell(hlr); 
			 Label pq = new Label(8, 0, "PQ"); 
			 sheet.addCell(pq); 
			
			 Label qte = new Label(9, 0, "QUANTITE"); 
			 sheet.addCell(qte); 
		
			 
			   for (int j=0;j<collection.size();j++){
			    	Rang article = (Rang) collection.get(j) ;
			    	System.out.println(j);
			    	
		
	       Label label = new Label(1, j+1, article.getArt()); 
		      sheet.addCell(label);   
		      
		      Label label1 = new Label(2, j+1, article.getProf()); 
		      sheet.addCell(label1); 
		      

		      Label label3 = new Label(3, j+1, article.getStart()); 
		      sheet.addCell(label3); 
		      
		      Label label4 = new Label(4, j+1, article.getEnd()); 
		      sheet.addCell(label4);
		     
		     
		      Label label11 = new Label(5, j+1, article.getActive()); 
		      sheet.addCell(label11); 
		      
		      Label label8 = new Label(6, j+1, article.getPackag()); 
		      sheet.addCell(label8); 
		      
		      
		      Label label5 = new Label(7, j+1, article.getHlr()); 
		      sheet.addCell(label5); 
		      
		      Label label6 = new Label(8, j+1, article.getPq()); 
		      sheet.addCell(label6); 
		      
		      Label label9 = new Label(9, j+1, article.getQte()); 
		      sheet.addCell(label9); 
		     
	
			   }

			 classeur.write();  
			 classeur.close(); 
			 
			 
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attachment; filename=\"'"+transaction+"'.xls\"");
//				 Calculer le flux  renvoyer au client
				FileInputStream is = new FileInputStream("'"+transaction+"'.xls");
				byte buffer[] = new byte[1024];
				int nbLecture;
//				 Envoyer le flux dans la rponse
				OutputStream os = response.getOutputStream();
				while ((nbLecture = is.read(buffer)) != -1) {
				os.write(buffer, 0, nbLecture);
				}
				os.close();
			
		}
		
		 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		

	return null;

		}
	 
	 public String editExel_parametr(WritableSheet sheet,HttpServletRequest request,String requete_art_profil ,String requete_donnees) throws SQLException, RowsExceededException, WriteException
		{
		 
		 	Connexion connexion=new Connexion();
			Connection con=connexion.createConnection(request);
			
			Statement st,st1,st2 = null;
			ResultSet rs,rs1,rs2 = null;
			st1=con.createStatement();
			
			
			int colon=0;
			ArrayList listindex = new ArrayList();
			int compte=1;
			
			int compte_centre=0;
			int compte_est=0;
			int compte_ouest=0;
				 
			int cpt2=1;
			int j=0;
		 
		 

		//st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    System.out.println("je s8 dans editExel_parametr  ");
		System.out.println("requete_art_profil="+requete_art_profil);
		st1=con.createStatement();
		rs1=st1.executeQuery(requete_art_profil);


		while (rs1.next())
			{
		  Rapport_reservation index2=new Rapport_reservation();
				
				String article=rs1.getString(1).trim();
				System.out.println("article"+article);
				
				String art=rs1.getString(2).trim();
				System.out.println("art"+art);
				
				String prof=rs1.getString(3).trim();
				System.out.println("prof"+prof);
				
				index2.setArticle(article);
				index2.setIndex(compte);
				listindex.add(index2);
			
				 WritableCell cell = sheet.getWritableCell(compte, 4);
					
				 if ((cell.getType() == CellType.LABEL) )
				 { 
					      Label num=(Label) cell;
					      
						   num.setString(art);
				 }
				 if ((cell.getType()==CellType.EMPTY) )
				 {
					 Label labelpre = new Label (compte, 4, art); 
					sheet.addCell(labelpre);  

				 }	
				
				 WritableCell cell2 = sheet.getWritableCell(compte, 5);
					
				 if ((cell2.getType() == CellType.LABEL) )
				 { 
					      Label num=(Label) cell2;
					      
						   num.setString(prof);
				 }
				 if ((cell2.getType()==CellType.EMPTY) )
				 {
					 Label labelpre = new Label (compte, 5, prof); 
					sheet.addCell(labelpre);  

				 }	
				 
					compte=compte+1;
				
			}


		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		System.out.println("requete_donnees="+requete_donnees);
		rs=st.executeQuery(requete_donnees);
	
		//int step=2;
		rs.last();
		int step2 = rs.getRow();

		rs.first();
			
		while ((cpt2<=step2))
			{
				String whs=rs.getString(1).trim();
				System.out.println(whs);
				if (whs.equals("CENTRE")){j=7;}
			    if (whs.equals("EST")){j=61;}
			    if (whs.equals("OUEST")){j=93;}
			    
			    
			     
			 while ((cpt2<=step2)&& (rs.getString(1).trim().equals(whs)))
			 
			 {	
				 

				 
		  String  dist=rs.getString(2).trim();
				System.out.println(dist);
				if (whs.equals("CENTRE")){compte_centre=compte_centre+1;}
				if (whs.equals("EST")){compte_est=compte_est+1;}
				if (whs.equals("OUEST")){compte_ouest=compte_ouest+1;}
				
				 WritableCell cell = sheet.getWritableCell(0, j);
				
				 if ((cell.getType() == CellType.LABEL) )
				 { 
					      Label num=(Label) cell;
					      
						   num.setString(dist);
				}
				 if ((cell.getType()==CellType.EMPTY) )
				 {
					 Label labelpre = new Label (0, j, dist); 
					sheet.addCell(labelpre);  

				 }	
				 
				 while ((cpt2<=step2)&& (rs.getString(1).trim().equals(whs))&&rs.getString(2).trim().equals(dist)) 
				 {
					 
					 String  art=rs.getString(3).trim();
						System.out.println("art de la requete "+art);
						System.out.println("listindex.size()  "+listindex.size());
					
						 for (int k=0; k<listindex.size();k++){
							 System.out.println("j'ai rentr dans la boucle");
							 Rapport_reservation list2= (Rapport_reservation)listindex.get(k); 
							 System.out.println("art de l'index"+list2.getArticle());
							 System.out.println("list2.getIndex()"+ list2.getIndex());
							
							 if ((list2.getArticle()).equals(art))
							 {
								
								 System.out.println("j'ai trouv l'lment ");
								colon=list2.getIndex();
								System.out.println("colon"+colon);
								 break;
							 }

						 }

				    String qte=rs.getString(4).trim();
				    System.out.println("qte"+qte);
				//   System.out.println(i+"+"+j);
				   
				   
			/*	   WritableCell cellcds = sheet0.getWritableCell(i, j);
				   System.out.println("lei"+i+"le je"+j);	
		Number num=(Number) cellcds;
				   num.setValue(Integer.parseInt(qte));*/
				   
				   
				/* Number num=new Number (colon, j,Integer.parseInt(qte));
					 sheet0.addCell(num);*/
				   
				    WritableCell cel = sheet.getWritableCell(colon, j);
				   
					 if ((cel.getType() == CellType.NUMBER) )
					 { 
						      Number num=(Number) cel;
						      
							   num.setValue(Integer.parseInt(qte));
					 }
					 if ((cel.getType()==CellType.EMPTY) )
					 {
						 Label labelpre = new Label (colon, j, qte); 
						sheet.addCell(labelpre);  

					 }	
				cpt2=cpt2+1;
				rs.next();
					
				 }
				 
			j=j+1;	
			//j=j-1;
			}
			 
			}


		System.out.println("compte_centre "+compte_centre);
		System.out.println("compte_est "+compte_est);
		System.out.println("compte_ouest"+compte_ouest);


		for (int c=0; c<52-compte_centre;c++){
		sheet.removeRow(7+compte_centre);
		System.out.println("c"+c);

		}

		for (int c=0; c<30-compte_est;c++){
			 sheet.removeRow(7+compte_centre+2+compte_est);
			System.out.println("c"+c);

			 }
		//int index=6+compte_centre+2+compte_est+2+compte_ouest;
			//System.out.println("index"+index);
		for (int c=0; c<30-compte_ouest;c++){
			 sheet.removeRow(7+compte_centre+2+compte_est+2+compte_ouest);
			System.out.println("c"+c);

			 }
		
		int k=27;
		for (int c=0; c<27-compte;c++){			
			sheet.removeColumn(k);
			System.out.println("je vais supprimer la colone :"+k);
			k=k-1;
			 }
		
		

		 
		 
		 
		 
	return null;		
		}
	 
	 
	 
	 
	 
	   } 
	
