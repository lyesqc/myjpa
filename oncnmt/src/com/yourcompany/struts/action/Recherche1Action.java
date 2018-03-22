
package com.yourcompany.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yourcompany.struts.form.EtaStkForm;
import com.yourcompany.struts.form.RechercheForm;
import com.yourcompany.struts.UtilBean.Article;
import  com.yourcompany.struts.UtilClass.Connexion;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;




public class Recherche1Action extends DispatchAction {

	
	public ActionForward exporter(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException, SQLException, RowsExceededException, WriteException {
		RechercheForm rechercheForm = (RechercheForm) form;
		
List stock= new ArrayList();
		
		System.out.println("je s8 ds exporter");

		
		stock=rechercheForm.getResultat();
		
		WritableWorkbook classeur = Workbook.createWorkbook (new File ( "stock.xls")); 

		 WritableSheet sheet = classeur.createSheet("First Sheet", 0); 
		 
		 
		 
		 Label labelcode= new Label(1, 0, "TRANSACTION_CODE"); 
		 sheet.addCell(labelcode);
		 
		
		 
		 Label labeldate= new Label(2, 0, "DATE"); 
		 sheet.addCell(labeldate);
		 
		 Label RESPONSABLE= new Label(3, 0, "RESPONSABLE"); 
		 sheet.addCell(RESPONSABLE);
		 
		 Label sorti = new Label(4, 0, "SORTIE"); 
		 sheet.addCell(sorti); 
		 /*
		 Label des = new Label(6, 0, "DESTINATAIRE"); 
		 sheet.addCell(des); 
		 */
		 
		 Label labelart = new Label(5, 0, "ARTICLE"); 
		 sheet.addCell(labelart); 
		 
		 
		 
		 
		 Label deb = new Label(6, 0, "SERIAL START"); 
		 sheet.addCell(deb); 
		 
		
		 
		 Label whs = new Label(7, 0, "WAREHOUSE"); 
		 sheet.addCell(whs); 
		 
		 
		 
		 Label transfert = new Label(8, 0, "TRANSFERT"); 
		 sheet.addCell(transfert); 
		 
		 Label reintegr = new Label(9, 0, "REINTEGRATION"); 
		 sheet.addCell(reintegr); 
		
		
		   for (int j=0;j<stock.size();j++){
		    	Article article = (Article) stock.get(j) ;
		    	System.out.println(j);
		    	
		    	
		 
		    	
		    	 Label label16 = new Label(1, j+1, article.getCode() ); 
			      sheet.addCell(label16); 
			      
			      
			      
			      Label label17 = new Label(2, j+1, article.getDate()); 
			      sheet.addCell(label17); 
			      Label label18 = new Label(3, j+1, article.getResp()); 
			      sheet.addCell(label18); 	
			      
			      Label label12 = new Label(4, j+1, article.getSor()); 
			      sheet.addCell(label12); 
			      /*
			      Label label2 = new Label(6,j+1,  article.getDest()); 
			      sheet.addCell(label2); 
			      */
                  Label label = new Label(5, j+1, article.getArt()); 
	              sheet.addCell(label);   
	      
	      

	  
          
	      
          Label label3 = new Label(6, j+1,article.getStart()); 
	      sheet.addCell(label3); 
	      
	   
	      
	      
	      
	      
	      
	      
	      
	
	  /*    Number label4 = new Number(8, j+1,Long.parseLong(article.getEnd())); 
	      sheet.addCell(label4);
	      
	      
	      Number label9 = new Number(9, j+1,Integer.parseInt(article.getQte())); 
	      sheet.addCell(label9); */
	      
	     
	      
	   /*   Label label3 = new Label(7, j+1,article.getStart()); 
	      sheet.addCell(label3); 
	      
	   
	      
	      Label label4 = new Label(8, j+1,article.getEnd()); 
	      sheet.addCell(label4);
	      
	      
	      Label label9 = new Label(9, j+1,article.getQte()); 
	      sheet.addCell(label9); */
	      
	      
	      
	      
	      
	      Label label10 = new Label(7, j+1, article.getWhs()); 
	      sheet.addCell(label10);
	      
	      
	    
	   
	      Label label13 = new Label(8, j+1,  article.getTra()); 
	      sheet.addCell(label13); 
	    
	    
	      
	  
	      Label label14 = new Label(9, j+1, article.getReint()); 
	      sheet.addCell(label14); 
	      
	
	     
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
		
		// response.sendRedirect(response.encodeRedirectURL("/forms/recherche.jsp")); 
		 return null;
	//	return mapping.findForward("visualiser");
	}
	
	public ActionForward Rechercher(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException, SQLException {
		RechercheForm rechercheForm = (RechercheForm) form;
		
		String set,dateDu,dateAu,four,mag,txt,txt1,txt2,requette,resp,trans,artc,prof,hlr,pq,pack,pos,typ,nd,nf = null; 
		String no,type,wh,code;
		int qteGlobal =0;  
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
	
		
		Statement st,st1,st2,st3,st4,st5 = null;
		ResultSet rs,rs1,rs2,rs3,rs4,rs5 = null;
		
		int i=0;
		
		
		ArrayList list = new ArrayList();
		
		List listWarehouse= new ArrayList() ;
		List typeTrans= new ArrayList() ;
		List nomResp= new ArrayList() ;
		List nomProfil= new ArrayList() ;
		List nomArticle= new ArrayList() ;
		
		
		
		set = rechercheForm.getNrec();
		System.out.println(set);
		mag = rechercheForm.getWarehouse();
		System.out.println(mag);
		dateDu = rechercheForm.getDat_rec_du();
		System.out.println(dateDu);
		dateAu = rechercheForm.getDat_rec_au();
		System.out.println(dateAu);		
		resp = rechercheForm.getResponsable();
		System.out.println(resp);	
		trans = rechercheForm.getTransaction();
		System.out.println(trans);
		artc = rechercheForm.getArticle();
		System.out.println(artc);
		prof= rechercheForm.getProfil();
		System.out.println(prof);
		hlr = rechercheForm.getHLR();
		System.out.println(hlr);
		pq = rechercheForm.getPQ();
		pack = rechercheForm.getPackaging();
		System.out.println(pack);
		pos = rechercheForm.getPosition();
		typ=rechercheForm.getType();
		nd=rechercheForm.getSdu();
		nf=rechercheForm.getSau();
		String heur1=rechercheForm.getHeur1();
		String heur2=rechercheForm.getHeur2();
		
		String destination=rechercheForm.getDestination();
		System.out.println("destination"+destination);
		
		String dispatch=rechercheForm.getDispatch_tabs();
		System.out.println("dispatch"+dispatch);
		
		              //requette = "select trr.t_r_trans_type|| '-' ||trr.t_r_trans_whs|| '-' || trr.t_r_trans_no as code,nvl(d.dest_nom,'_'),w_stk.whs_adresse,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS'),act_name,art_art_libelle,rng_start,rng_end,nvl(profil_libelle,'_'),case when ar.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,rng_statut,nvl(rng_pq,'_'),case when ar.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D', 'Defect', '_') Test_Perte_Defect,nvl(r.rng_swap,'_') from gss_transaction tr,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_transaction_type trt,gss_article ar,gss_article_type art,gss_range r,gss_article_profil arp,gss_transaction_range trr,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (r.rng_whs= w_stk.whs_id)and (trr.t_r_rng_id = r.rng_id)and (trr.t_r_rng_act_id=r.act_id)and (r.act_id=a.act_id)and (tr.act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)  and tr.trans_type=trt.trans_type and (tr.trans_no=trr.t_r_trans_no)and (tr.trans_type=trr.t_r_trans_type)and (tr.whs_id=trr.t_r_trans_whs)and (trr.t_r_trans_no = r.trans_no)and (trr.t_r_trans_whs= r.whs_id)and (trr.t_r_trans_type= r.trans_type)and (arp.profil_id (+)= r.profil_id)and (r.art_id = ar.art_id)and (ar.art_type_id=art.art_type_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+)";
		
		
		///////     requete avant l'optimisation
		//requette = "select tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_'),w_stk.whs_adresse,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS'),act_name,art_art_libelle,rng_start,rng_end,nvl(profil_libelle,'_'),case when ar.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,rng_statut,nvl(rng_pq,'_'),case when ar.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,tr.annuler,nvl(r.rng_trans_hist,'_')  from gss_transaction tr,gss_transaction_type trt,gss_warehouse w_stk,gss_actor2 a,gss_destinataire d,gss_article ar,gss_article_type art,gss_range r,gss_article_profil arp,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (r.rng_whs= w_stk.whs_id) and (tr.act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)  and (tr.trans_no= r.trans_no)and (tr.whs_id= r.whs_id)and (tr.trans_type= r.trans_type)and(arp.profil_id (+)= r.profil_id)and (r.art_id = ar.art_id)and (ar.art_type_id=art.art_type_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+)and  tr.trans_type=trt.trans_type";
		
		///requete aprs l'optimisation
	//requette = "select   tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_'),  w_stk.whs_adresse,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS'),  act_name,art_art_libelle,  rng_start,  rng_end,nvl(profil_libelle,'_'),  case when ar.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),  '0',   substr(r.rng_start, 4, 2),  '1',  substr(r.rng_start, 4, 2),  '2',   substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,  rng_statut,nvl(rng_pq,'_'),  case when ar.art_type_id in ('S1','S2') then   decode(r.rng_packaged, 'O', 'Sous ordre vers '|| pac.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||pac.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,  decode(r.rng_sortie, 'O', 'Autorise vers '|| sor.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,  decode(r.rng_transfert, 'O', 'Sous ordre vers '|| tra.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| tra.whs_adresse,'N', '_')TRANSFERT,  decode(r.rng_reintegration, 'T', 'Autoris depuis '||rei.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,  decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D', 'Defect', '_') Test_Perte_Defect,tr.annuler,nvl(r.rng_trans_hist,'_'),nvl(tr.approver,'_')  from gss_transaction tr,gss_transaction_type trt,gss_warehouse  w_stk,gss_actor2 a,gss_article ar,gss_article_type art,gss_range r,gss_article_profil arp,gss_destinataire d,gss_destinataire  pac ,gss_destinataire  sor,gss_destinataire  rei,gss_warehouse tra  where r.rng_whs= w_stk.whs_id   and r.rng_packaging_whs=pac.dest_id(+)   and r.rng_sortie_whs=sor.dest_id(+)   and r.rng_reintegration_whs=rei.dest_id(+)   and r.rng_transfert_whs=tra.whs_id (+)  and r.art_id = ar.art_id  and arp.profil_id (+)= r.profil_id  and tr.trans_type=trt.trans_type  and tr.act_id = a.act_id  and tr.trans_no= r.trans_no  and tr.whs_id= r.whs_id  and tr.trans_type= r.trans_type  and d.dest_id (+)=tr.dest_id    and ar.art_type_id=art.art_type_id";
		
		requette = "select tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_') as destnom,w_stk.whs_adresse as adr,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS') as transdate ,act_name,art_art_libelle as libelle,rng_start as start1,'rng_end','profil_libelle' as profille,rng_statut as rngstatu,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom,'F' ,'Retour Fournisseur','N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode('R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,tr.annuler,nvl(r.rng_trans_hist,'_') hist,nvl(tr.approver,'_')  as approuver "+
				"from  gss_transaction_type trt, gss_transaction tr, gss_transaction_range tgt ,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_article ar,gss_range r,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr  "+
				"where (r.rng_whs= w_stk.whs_id)and (tgt.t_r_rng_act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)   and "+
				"tr.trans_no = tgt.t_r_trans_no and tr.trans_type = tgt.t_r_trans_type and tr.whs_id = tgt.t_r_trans_whs and "+
				"tgt.t_r_rng_id = r.rng_id and (r.art_id = ar.art_id)and  r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) "+
				"and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) "+
				"and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+) "+
				"and  tr.trans_type=trt.trans_type and r.rng_transfert_whs=rtr.whs_id(+) ";
				
		st=con.createStatement();
		st1 = con.createStatement();
	
			   
		if (set != "")
		{ //fsdfsdf
			txt = set.substring(0,3);
			System.out.println("txt="+txt);
			txt1 = set.substring(4,7);
			System.out.println("txt1="+txt1);
			txt2 = set.substring(8);
			System.out.println("txt2="+txt2);
			
  // rs = st.executeQuery("select trr.t_r_trans_type|| '-' ||trr.t_r_trans_whs|| '-' || trr.t_r_trans_no as code,nvl(d.dest_nom,'_'),w_stk.whs_adresse,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS'),act_name,art_art_libelle,rng_start,rng_end,nvl(profil_libelle,'_'),case when ar.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,rng_statut,nvl(rng_pq,'_'),case when ar.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D', 'Defect', '_') Test_Perte_Defect,nvl(r.rng_swap,'_') from gss_transaction tr,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_transaction_type trt,gss_article ar,gss_article_type art,gss_range r,gss_article_profil arp,gss_transaction_range trr,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (r.rng_whs= w_stk.whs_id)and (trr.t_r_rng_id = r.rng_id)and (trr.t_r_rng_act_id=r.act_id)and (r.act_id=a.act_id)and (tr.act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)  and tr.trans_type=trt.trans_type and (tr.trans_no=trr.t_r_trans_no)and (tr.trans_type=trr.t_r_trans_type)and (tr.whs_id=trr.t_r_trans_whs)and (trr.t_r_trans_no = r.trans_no)and (trr.t_r_trans_whs= r.whs_id)and (trr.t_r_trans_type= r.trans_type)and (arp.profil_id (+)= r.profil_id)and (r.art_id = ar.art_id)and (ar.art_type_id=art.art_type_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and r.rng_transfert_whs=rtr.whs_id(+) and (tr.trans_type='"+txt+"') and(tr.whs_id='"+txt1+"') and(tr.trans_no='"+txt2+"')");
			//System.out.println("select tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_'),w_stk.whs_adresse,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS'),act_name,art_art_libelle,rng_start,rng_end,nvl(profil_libelle,'_'),case when ar.art_type_id in ('S1','S2') then decode(substr(r.rng_start, 4, 1),'0', substr(r.rng_start, 4, 2),'1', substr(r.rng_start, 4, 2),'2',  substr(r.rng_start, 4, 2), '0' || substr(r.rng_start, 5, 1)) else  '_' end hlr,rng_statut,nvl(rng_pq,'_'),case when ar.art_type_id in ('S1','S2') then decode(r.rng_packaged, 'O', 'Sous ordre vers '|| opa.dest_nom, 'C', 'En Cours chez '|| pac.dest_nom, 'P', 'Package par ' ||rpa.dest_nom, 'N', 'Non Package') else  '_' end PACKAGING,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom, 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode(r.rng_reintegration, 'T', 'Autoris depuis '||tre.dest_nom, 'R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,nvl(r.rng_swap,'_') from gss_transaction tr,gss_transaction_type trt,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_article ar,gss_article_type art,gss_range r,gss_article_profil arp,gss_destinataire opa,gss_destinataire pac,gss_destinataire rpa,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr where (r.rng_whs= w_stk.whs_id)and (r.act_id=a.act_id)and (tr.act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)  and (tr.trans_no= r.trans_no)and (tr.whs_id= r.whs_id)and (tr.trans_type= r.trans_type)and(arp.profil_id (+)= r.profil_id)and (r.art_id = ar.art_id)and (ar.art_type_id=art.art_type_id)and r.rng_packaging_whs=opa.dest_id(+) and r.rng_packaging_whs=pac.dest_id(+) and r.rng_packaging_whs=rpa.dest_id(+) and r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+)and  tr.trans_type=trt.trans_type and r.rng_transfert_whs=rtr.whs_id(+) and (tr.trans_type='"+txt+"') and(tr.whs_id='"+txt1+"') and(tr.trans_no='"+txt2+"')");
			
			
			
			
			
			System.out.println("select tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_') as destnom,w_stk.whs_adresse as adr,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS') as transdate ,act_name,art_art_libelle as libelle,rng_start as start1,'rng_end','profil_libelle' as profille,rng_statut as rngstatu,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom,'F','Retour Fournisseur', 'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode('R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,tr.annuler,nvl(r.rng_trans_hist,'_') hist,nvl(tr.approver,'_')  "+
					"from  gss_transaction_type trt, gss_transaction tr, gss_transaction_range tgt ,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_article ar,gss_range r,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr  "+
					"where (r.rng_whs= w_stk.whs_id)and (tgt.t_r_rng_act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)   and "+
					"tr.trans_no = tgt.t_r_trans_no and tr.trans_type = tgt.t_r_trans_type and tr.whs_id = tgt.t_r_trans_whs and "+
					"tgt.t_r_rng_id = r.rng_id and (r.art_id = ar.art_id)and  r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) "+
					"and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) "+
					"and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+) "+
					"and  tr.trans_type=trt.trans_type and r.rng_transfert_whs=rtr.whs_id(+) ");
					rs = st.executeQuery("select tr.trans_type|| '-' ||tr.whs_id|| '-' || tr.trans_no as code,nvl(d.dest_nom,'_') as destnom,w_stk.whs_adresse as adr,to_char(trans_date, 'DD/MM/YYYY HH24:MI:SS') as transdate ,act_name,art_art_libelle as libelle,rng_start as start1,'rng_end','profil_libelle' as profille,rng_statut as rngstatu,decode(r.rng_sortie, 'O', 'Autorise vers '|| tso.dest_nom, 'S', 'Sorti vers '||sor.dest_nom,'R', 'Sorti vers '||sor.dest_nom,'F','Retour Fournisseur' ,'N', '_') SORTIE,decode(r.rng_transfert, 'O', 'Sous ordre vers '|| otr.whs_adresse, 'C', 'En cours vers'|| tra.whs_adresse, 'T','Transfr depuis '|| rtr.whs_adresse,'N', '_')TRANSFERT,decode('R', 'Reintgr depuis '||rei.dest_nom, 'N','_') REINTEGRATION,decode(r.rng_tpd, 'T', 'Test', 'P', 'Perte', 'D','Defect','V', 'Vole', '_') Test_Perte_Defect,tr.annuler,nvl(r.rng_trans_hist,'_') hist,nvl(tr.approver,'_')  as approuver "+
							"from  gss_transaction_type trt, gss_transaction tr, gss_transaction_range tgt ,gss_warehouse w_stk,gss_actor a,gss_destinataire d,gss_article ar,gss_range r,gss_destinataire tso,gss_destinataire sor,gss_destinataire tre,gss_destinataire rei,gss_warehouse otr,gss_warehouse tra,gss_warehouse rtr  "+
							"where (r.rng_whs= w_stk.whs_id)and (tgt.t_r_rng_act_id = a.act_id)and (d.dest_id (+)=tr.dest_id)   and "+
							"tr.trans_no = tgt.t_r_trans_no and tr.trans_type = tgt.t_r_trans_type and tr.whs_id = tgt.t_r_trans_whs and "+
							"tgt.t_r_rng_id = r.rng_id and (r.art_id = ar.art_id)and  r.rng_sortie_whs=tso.dest_id(+) and r.rng_sortie_whs=sor.dest_id(+) "+
							"and r.rng_reintegration_whs=tre.dest_id(+) and r.rng_reintegration_whs=rei.dest_id(+) "+
							"and r.rng_transfert_whs=otr.whs_id(+) and r.rng_transfert_whs=tra.whs_id (+) "+
							"and  tr.trans_type=trt.trans_type and r.rng_transfert_whs=rtr.whs_id(+) "+
							"and tgt.t_r_trans_type='"+txt+"' and tgt.t_r_trans_whs='"+txt1+"' and tgt.t_r_trans_no='"+txt2+"'");        
							while (rs.next())
                  {
            	  
            	  String start = rs.getString("start1");
            	  System.out.println(start);
            	  
 				 //String end = rs.getString(8);
 				  //System.out.println(end);
 				// int str = Integer.parseInt(start);
 				Long str = Long.parseLong(start);
 				//System.out.println("str="+str);
 				//Long en = Long.parseLong(end);
 				//System.out.println("en="+en);
 			
 				 
 				//Long Qt = (en-str)+1;
 				//System.out.println(Qt);
 				 //String quantit = String.valueOf(Qt);
 				//System.out.println(quantit);
 	
 				//int qt = Integer.parseInt(quantit);
 				//qteGlobal = qteGlobal+qt;
 				//System.out.println("la quantit global"+qteGlobal);
 				
            	  Article art = new Article();
            	  
            	art.setCode(rs.getString("code").trim()); 
      			art.setDate(rs.getString("transdate").trim());
      			art.setDest(rs.getString("destnom").trim());
      			art.setResp(rs.getString("act_name").trim());
      			art.setWhs(rs.getString("adr").trim());
      			art.setArt(rs.getString(6).trim());
      			art.setStart(rs.getString("start1").trim());
      			//art.setEnd(rs.getString(8).trim());
      		//	art.setSwap(rs.getString(18).trim());
      			//art.setQte(quantit);
      			
      			art.setPos(rs.getString("rngstatu").trim());
      			
      			art.setSor(rs.getString("SORTIE").trim());
      			art.setTra(rs.getString("TRANSFERT").trim());
      			art.setReint(rs.getString("REINTEGRATION").trim());
      			//art.setTdp(rs.getString(17).trim());
      			
      			
      			if (rs.getString("ANNULER").trim().equals("A"))
      			{
      				art.setAnnuler("Annule");	
      			}
      			if (rs.getString("ANNULER").trim().equals("N"))
      			{
      				art.setAnnuler("Non");	
      			}
      			
      			
      			if (rs.getString("approuver").trim().equals("P"))
      			{
      				art.setApprover("Approuve");	
      			}
      			if (rs.getString("approuver").trim().equals("_"))
      			{
      				art.setApprover("N_Approuve");	
      			}
      			
      			
      			if (rs.getString("approuver").trim().equals("R"))
      			{
      				art.setApprover("Rejete");	
      			}
      			
      			art.setCode_art(rs.getString(1).trim());
      			
      			list.add(art);
      			
      			i=i+1;
      			
            	
	          // System.out.println("["+rs.getString(1)+"],["+rs.getString(2)+"],["+rs.getString(3)+"],["+rs.getString(4)+"],["+rs.getString(5)+"]"+"],["+rs.getString(6)+"]"+"],["+rs.getString(7)+"]"+"],["+rs.getString(8)+"]"+"],["+rs.getString(9)+"]"+"],["+rs.getString(10)+"]"+"],["+rs.getString(11)+"]"+"],["+rs.getString(12)+"]"+"],["+rs.getString(13)+"]"+"],["+rs.getString(14)+"]"+"],["+rs.getString(15)+"]"+"],["+rs.getString(16)+"]"+"],["+rs.getString(17)+"]"+"],["+rs.getString(18)+"]");
                  }
        
      	
	}
		
else 
 {
			
	
		
			if (mag != "")
			{
				
			requette = requette + " and (w_stk.whs_adresse = '"+mag+"')";
		
			
		     }// end if magasin
			
		/*	if ((dateDu != "") && (dateAu != ""))
			{
				requette = requette + " and (trunc(trans_date) BETWEEN '"+dateDu+"' AND '"+dateAu+"')";
				

			}// end if date
			else
			{
				  if ((dateDu != "") && (dateAu == ""))
				   {
					  requette = requette + "and (trunc(trans_date) BETWEEN '"+dateDu+"' AND trunc (SYSDATE))"; 
					
				   } /// end if date dbut
				  if ((dateDu == "") && (dateAu != ""))
				    {
					  requette = requette +" and (trunc(trans_date) <= '"+dateAu+"')";
					
				    }/// end if date fin
			}
			
			*/
		
			if ((dateDu != "") && (dateAu != "") &&(heur1!= "") &&(heur2!= "") )
			{
				String date1=dateDu+" "+heur1;
				String date2=dateAu+" "+heur2;
				 System.out.println(date1);
				 System.out.println(date2);
	    requette = requette + " and ((trans_date) BETWEEN to_date('"+date1+"', 'DD/MM/YYYY HH24:MI:SS')  AND to_date('"+date2+"', 'DD/MM/YYYY HH24:MI:SS'))";
           }
			
			if ((dateDu != "") && (dateAu != "")&&(heur1== "") &&(heur2== ""))
			{
				requette = requette + " and (trunc(trans_date) BETWEEN '"+dateDu+"' AND '"+dateAu+"')";
				

			}
			
          if ((dateDu != "") && (dateAu == "") &&(heur1!= "") &&(heur2== ""))
				   {
        	  String date1=dateDu+" "+heur1;
					  requette = requette + " and ((trans_date) BETWEEN to_date('"+date1+"', 'DD/MM/YYYY HH24:MI:SS') AND  (SYSDATE))"; 
					
				   } /// end if date dbut
          
          
          
          if ((dateDu != "") && (dateAu == "")&&(heur1== "") &&(heur2== ""))
		   {
			  requette = requette + " and (trunc(trans_date) BETWEEN '"+dateDu+"' AND trunc (SYSDATE))"; 
			
		   } 
          
          
          
				  if ((dateDu == "") && (dateAu != "")&&(heur1== "") &&(heur2!= ""))
				    {
						String date2=dateAu+" "+heur2;
					  requette = requette +" and ((trans_date) <= to_date('"+date2+"', 'DD/MM/YYYY HH24:MI:SS'))";
					
				    }/// end if date fin
				  
		
				  if ((dateDu == "") && (dateAu != "")&&(heur1== "") &&(heur2== ""))
				    {
					  requette = requette +" and (trunc(trans_date) <= '"+dateAu+"')";
					
				    }/// 
			
			
			
				  if (destination !=""){
						
						requette = requette+" and (nvl(d.dest_nom,'_')='"+destination+"')";
					}	/// end if destination
				  
				 
			
			
			
		if (resp !=""){
			
			requette = requette+" and (a.act_name='"+resp+"')";
		}	/// end if responsable
		
		if (trans!="")
		{
			requette=requette+" and (trt.trans_type_libelle='"+trans+"')";
		} /// end if type trans
		
		if (artc!="")
		{
			requette = requette +" and (ar.art_art_libelle = '"+artc+"')";
		}// end if article
		
		
		
		
		
		
		if(pos!="")
		{
			requette = requette + " and (r.rng_statut = '"+pos+"')";
		}// end if position
		
		
		
		if ((nd !="") && (nf==""))
		{
			requette = requette+" and (r.rng_start<= '"+nd+"') and (r.rng_end>= '"+nd+"')";
		} /// end if serial start
		
		if ((nf !="") && (nd==""))
		{
			requette = requette+" and (r.rng_start<= '"+nf+"') and (r.rng_end>= '"+nf+"')";
		}/// end if serial end
		
	/*	if ((nd !="") && (nf!=""))
		{
			requette = requette +" and (r.rng_start<='"+nd+"') and (r.rng_end>='"+nf+"')";
		} //// end if range
		*/
		
		
		if ((nd !="") && (nf!=""))
		{
			requette = requette +" and (('"+nd+"' between r.rng_start and r.rng_end) or ('"+nf+"' between r.rng_start and r.rng_end))";
		}
		
		
		
		
		
			
		
		requette = requette + " order by code";
			System.out.println(requette);
			
			st = con.createStatement();
			rs = st.executeQuery(requette);
			
			 while (rs.next())
			   {
					/*
					System.out.println("rs.getString(18)="+rs.getString(18));
					
				 
				 String start = rs.getString(7);
           	
           	  
				 String end = rs.getString(8);
				
				long str = Long.parseLong(start);
				
				long en = Long.parseLong(end);
				
			
				 
				 long Qt = (en-str)+1;
				 
				 System.out.println("la quantit"+Qt);
				
				 String quantit = String.valueOf(Qt);
				
				    int qt = Integer.parseInt(quantit);
	 				qteGlobal = qteGlobal+qt;
	 				System.out.println("la quantit global"+qteGlobal);
				 */
				
				
				 Article art = new Article();
				
				 
				 art.setCode(rs.getString("code").trim()); 
	      			art.setDate(rs.getString("transdate").trim());
	      			art.setDest(rs.getString("destnom").trim());
	      			art.setResp(rs.getString("act_name").trim());
	      			art.setWhs(rs.getString("adr").trim());
	      			art.setArt(rs.getString(6).trim());
	      			art.setStart(rs.getString("start1").trim());
	      			//art.setEnd(rs.getString(8).trim());
	      		//	art.setSwap(rs.getString(18).trim());
	      			//art.setQte(quantit);
	      			
	      			art.setPos(rs.getString("rngstatu").trim());
	      			
	      			art.setSor(rs.getString("SORTIE").trim());
	      			art.setTra(rs.getString("TRANSFERT").trim());
	      			art.setReint(rs.getString("REINTEGRATION").trim());
	      			//art.setTdp(rs.getString(17).trim());
	      			
	      			
	      			if (rs.getString("ANNULER").trim().equals("A"))
	      			{
	      				art.setAnnuler("Annule");	
	      			}
	      			if (rs.getString("ANNULER").trim().equals("N"))
	      			{
	      				art.setAnnuler("Non");	
	      			}
	      			
	      			
	      			if (rs.getString("approuver").trim().equals("P"))
	      			{
	      				art.setApprover("Approuve");	
	      			}
	      			if (rs.getString("approuver").trim().equals("_"))
	      			{
	      				art.setApprover("N_Approuve");	
	      			}
	      			
	      			
	      			if (rs.getString("approuver").trim().equals("R"))
	      			{
	      				art.setApprover("Rejete");	
	      			}
				 
				 
				 
           	  /*
           	  art.setCode(rs.getString(1).trim()); 
     			art.setDate(rs.getString(4).trim());
     			art.setDest(rs.getString(2).trim());
     			art.setResp(rs.getString(5).trim());
     			art.setWhs(rs.getString(3).trim());
     			art.setArt(rs.getString(6).trim());
      			art.setStart(rs.getString(7).trim());
      			art.setEnd(rs.getString(8).trim());
      	//		art.setSwap(rs.getString(18).trim());
      			art.setQte(quantit);
      			art.setProf(rs.getString(9).trim());
      			art.setHlr(rs.getString(10).trim());
      			art.setPos(rs.getString(11).trim());
      			art.setPq(rs.getString(12).trim());
      			art.setPack(rs.getString(13).trim());
      			art.setSor(rs.getString(14).trim());
      			art.setTra(rs.getString(15).trim());
      			art.setReint(rs.getString(16).trim());
      			art.setTdp(rs.getString(17).trim());
      			art.setDispatch_tabs(rs.getString(19).trim());
      			
      			//art.setAnnler(rs.getString(18).trim());
      			
      			if (rs.getString(18).trim().equals("A"))
      			{
      				art.setAnnuler("Annule");	
      			}
      			if (rs.getString(18).trim().equals("N"))
      			{
      				art.setAnnuler("Non");	
      			}
      			
      			if (rs.getString(20).trim().equals("P"))
      			{
      				art.setApprover("Approuve");	
      			}
      			if (rs.getString(20).trim().equals("_"))
      			{
      				art.setApprover("N_Approuve");	
      			}
      			if (rs.getString(20).trim().equals("R"))
      			{
      				art.setApprover("Rejete");	
      			}
      			
      			art.setCode_art(rs.getString(1).trim());
     			*/
	      			art.setCode_art(rs.getString(1).trim());
     			list.add(art);
     			//System.out.println("["+rs.getString(1)+"],["+rs.getString(2)+"],["+rs.getString(3)+"],["+rs.getString(4)+"],["+rs.getString(5)+"]"+"],["+rs.getString(6)+"]"+"],["+rs.getString(7)+"]"+"],["+rs.getString(8)+"]"+"],["+rs.getString(9)+"]"+"],["+rs.getString(10)+"]"+"],["+rs.getString(11)+"]"+"],["+rs.getString(12)+"]"+"],["+rs.getString(13)+"]"+"],["+rs.getString(14)+"]"+"],["+rs.getString(15)+"]"+"],["+rs.getString(16)+"]"+"],["+rs.getString(17)+"]"+"],");
				 
     			i=i+1;
			   	   
			   
			   }
			// rechercheForm.setResultat(list);
 			 
	}
		
		rechercheForm.setResultat(list);
		 
		 
		 System.out.println("la fin");
		 rechercheForm.setResult(qteGlobal+" articles trouvs dans "+i+" ranges");
		 System.out.println(qteGlobal+" articles trouvs dans "+i+" ranges");
	
		
		con.close();
	        
		return mapping.findForward("visualiser");
	}
	
	
	
	
	public ActionForward visualiser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException, SQLException {
		RechercheForm rechercheForm = (RechercheForm) form;
		

			
		//	Connexion connexion=new Connexion();
		//	Connection con=connexion.createConnection(request);
			
			System.out.println("dans visualiser");
			String code = request.getParameter("code_art");
			System.out.println(code);
			System.out.println(code.length()+1);
			
			String txt = code.substring(0,3);
			System.out.println(txt);
			String txt1 = code.substring(4,7);
			System.out.println(txt1);
		//	String txt2 = code.substring(8,13);
			
			String txt2 = code.substring(8,code.length());
			System.out.println(txt2);
			
			//String txt3=code.substring(8,code.length()+1);
			
			StockAction stock=new StockAction();
			stock.editrapport( request,response,txt,txt1,txt2);       
		
			return mapping.findForward("visualiser");
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
	
	
/*	public String editrapport( HttpServletRequest request,HttpServletResponse response,String txt,String txt1,String txt2)
	{
		
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		File jasperFile;
		
		   try {
		       
			   File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));

		 if((txt.equals("TRA"))||(txt.equals("RTR"))||(txt.equals("OTR")))
		  
		 {
			   System.out.println("je s8 ds transfert");
			 jasperFile=new File(projectRealPath,"bon/ordre transfert.jrxml");
			   System.out.println(jasperFile.getAbsolutePath());
		}   
		 
		 
		 if((txt.equals("REC"))||(txt.equals("OPA"))||(txt.equals("PAC"))||(txt.equals("RPA"))||(txt.equals("TRE"))||(txt.equals("REI"))||(txt.equals("SOR"))||(txt.equals("ASO")))
			   
		 {
		   System.out.println("je s8 ds rec");
		   jasperFile=new File(projectRealPath,"bon/classic4.jrxml");
		   System.out.println(jasperFile.getAbsolutePath());
		   
		 }
		 
		 
			 
			  else{
				  System.out.println("je s8 ds activation");
				   jasperFile=new File(projectRealPath,"bon/activation.jrxml");
				   System.out.println(jasperFile.getAbsolutePath());
		 }
		 
		 
		 JasperDesign jasperDesign = JRXmlLoader.load(jasperFile); 
		 
		 //JasperDesign jasperDesign1 = JRXmlLoader.load("\\bon\\classic4.jrxml"); 
		  JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		  // - Paramtres  envoyer au rapport
		  Map parameters = new HashMap();
		  parameters.put("Titre", "Titre"); 
		  parameters.put("param1",new String ("'"+txt+"'"));
		 parameters.put("param2", new String("'"+txt1+"'"));
		  parameters.put("param3", new String("'"+txt2+"'"));
		  

		  JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
		  // pour l'affichage
//		  JasperViewer.viewReport(jasperPrint,false);
		  // - Cration du rapport au format PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint, "rapport4.pdf");

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment; filename=\"rapport4.pdf\"");
//		 Calculer le flux  renvoyer au client
		FileInputStream is = new FileInputStream("rapport4.pdf");
		byte buffer[] = new byte[1024];
		int nbLecture;
//		 Envoyer le flux dans la rponse
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

return null;
//	return mapping.findForward("menu");
	}	*/
}