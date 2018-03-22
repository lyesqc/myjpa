
package com.yourcompany.struts.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.yourcompany.struts.form.RechercheForm;
import com.yourcompany.struts.UtilBean.Article;
import com.yourcompany.struts.UtilClass.Connexion;

public class RechercheAction extends DispatchAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RechercheForm rechercheForm = (RechercheForm) form;// TODO Auto-generated method stub
		
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		Statement st,st1,st2,st3,st4,st5,st6 = null;
		ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6 = null;
		String four,mag,type,resp,prof,art;
		//List listFournisseur= new ArrayList() ;
		List listWarehouse= new ArrayList() ;
		List typeTrans= new ArrayList() ;
		List nomResp= new ArrayList() ;
		List nomProfil= new ArrayList() ;
		List nomArticle= new ArrayList() ;
		List listDestination= new ArrayList() ;
		
		
		st = con.createStatement();
		st1 = con.createStatement();
		st2=con.createStatement();
		st3=con.createStatement();
		st4=con.createStatement();
		st5=con.createStatement();
		st6=con.createStatement();
		
		//rs = st.executeQuery("select DEST_NOM from GSS_DESTINATAIRE where DEST_TYPE ='fournisseur'");
		rs1 = st1.executeQuery("select whs_adresse from gss_warehouse where whs_status='A' and gss_warehouse.whs_id <> 'W00'");
		rs2=st2.executeQuery("select trans_type_libelle from gss_transaction_type order by trans_type_libelle");
		rs3=st3.executeQuery("select act_name from gss_actor where act_status='A'");
		//rs4=st4.executeQuery("select profil_libelle from gss_article_profil where profil_statut='A'");
		rs5=st5.executeQuery("select art_art_libelle from gss_article where art_status='A'");
		rs6=st6.executeQuery("select dest_nom from gss_destinataire where dest_type  in ('SORTIE DIVERSE','CDS','DISTRIBUTEUR') and gss_destinataire.dest_status='A' ");
		
/*		rs=st.executeQuery("select to_char(trunc(sysdate), 'DD/MM/YYYY') from dual");
		String	dat=null;		
if (rs.next())
			
		{
		dat = rs.getString(1).trim();
			System.out.println(dat);
		}
     	

rechercheForm.setDat_rec_au(dat);
rechercheForm.setDat_rec_du(dat);
*/

     	while (rs1.next())
    	{
    		    		    		
     	mag = rs1.getString(1).trim();
    	
     	listWarehouse.add(mag);
    	    			    		
    	}
		
		
		while (rs2.next())
    	{
    		    		    		
		type = rs2.getString(1).trim();
    	
		typeTrans.add(type);
     	    	    			    		
    	}
		
		
		
		while (rs3.next())
    	{
    		    		    		
		resp = rs3.getString(1).trim();
    	
		nomResp.add(resp);
     	    	    			    		
    	}
		
		
		
		
     	
		while (rs5.next())
    	{
    		    		    		
     	art = rs5.getString(1).trim();
    	
     	
     	nomArticle.add(art);  			    		
    	}
		
		while (rs6.next())
    	{
    		    		    		
     	String dest = rs6.getString(1).trim();
    	
     	listDestination.add(dest);
    	    			    		
    	}
		
		rechercheForm.setNomWarehouse(listWarehouse);
		rechercheForm.setTypeTrans(typeTrans);
		rechercheForm.setNomResp(nomResp);
		rechercheForm.setNomProfil(nomProfil);
		rechercheForm.setNomArticle(nomArticle);
		rechercheForm.setListdestination(listDestination);
		
		
		/// initialiser la collection
		
		 Article article = new Article();
		 ArrayList list = new ArrayList();
   	  
		    article.setCode(""); 
		    article.setDate("");
		    article.setDest("");
			article.setResp("");
			article.setWhs("");
			article.setArt("");
			article.setStart("");
			article.setEnd("");
			article.setSwap("");
			article.setQte("");
			article.setProf("");
			article.setHlr("");
			article.setPos("");
			article.setPq("");
			article.setPack("");
			article.setSor("");
			article.setTra("");
			article.setReint("");
			article.setTdp("");
			article.setAnnuler("");
			article.setCode_art("");
			article.setDispatch_tabs("");
			
			list.add(article);
			
			rechercheForm.setResultat(list);
		
		//// vider les champs a cause du session
		
		rechercheForm.setArticle("");
		/*rechercheForm.setDat_rec_au("");
		rechercheForm.setDat_rec_du("");*/
		rechercheForm.setHLR("");
		rechercheForm.setNrec("");
		rechercheForm.setTransaction("");
		rechercheForm.setResponsable("");
		rechercheForm.setPackaging("");
		rechercheForm.setPosition("");
		rechercheForm.setPQ("");
		rechercheForm.setProfil("");
		rechercheForm.setWarehouse("");
		rechercheForm.setType("");
		rechercheForm.setSau("");
		rechercheForm.setSdu("");
		rechercheForm.setHeur1("");
		rechercheForm.setHeur2("");
		rechercheForm.setResult("");
		rechercheForm.setDat_rec_au("");
		rechercheForm.setDat_rec_du("");
		rechercheForm.setDestination("");
		
		 
		    	con.close();
	       
		return mapping.findForward("recherche"); 
	}
	
	
	
	
	
	}



