
package com.yourcompany.struts.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yourcompany.struts.form.EtaStkForm;
import com.yourcompany.struts.UtilBean.Article;
import com.yourcompany.struts.UtilClass.Connexion;

public class PreparStkAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		EtaStkForm etaStkForm = (EtaStkForm) form;
		Connexion connexion=new Connexion();
		Connection con=connexion.createConnection(request);
		Statement st,st1,st2,st3,st4,st5,st6,st7 = null;
		ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs7 = null;
		String four,mag,type,resp,prof,art,dest,cds,part,dat = null;
		//Date dat;
		
		List listWarehouse= new ArrayList() ;
		List list= new ArrayList() ;
	    List nomProfil= new ArrayList() ;
		List nomArticle= new ArrayList() ;
		List nomDest= new ArrayList() ;
		List nomCds= new ArrayList() ;
		List nomPart= new ArrayList() ;
		
		st1 = con.createStatement();
		st=con.createStatement();
		st2=con.createStatement();
		st3=con.createStatement();
		st4=con.createStatement();
		st6=con.createStatement();
		st5=con.createStatement();
		st7=con.createStatement();
		rs1 = st1.executeQuery("select whs_adresse from gss_warehouse where whs_status='A' and gss_warehouse.whs_id <> 'W00'");
		//rs2=st2.executeQuery("select profil_libelle from gss_article_profil where profil_statut='A'");
		rs3=st3.executeQuery("select art_art_libelle from gss_article where art_status='A'");
		rs4=st4.executeQuery("select dest_nom from gss_destinataire where dest_type='CDS'");
		rs5=st5.executeQuery("select dest_nom from gss_destinataire where dest_type='DISTRIBUTEUR'");
		rs6=st6.executeQuery("select dest_nom from gss_destinataire where dest_type='PARTENAIRE'");
		rs7=st7.executeQuery("select sysdate from dual");
		rs=st.executeQuery("select to_char(trunc(sysdate), 'DD/MM/YYYY') from dual");
		while (rs1.next())
    	{
    		    		    		
     	mag = rs1.getString(1).trim();
    	//System.out.println(four);
     	listWarehouse.add(mag);
    	    			    		
    	}
		etaStkForm.setNomWarehouse(listWarehouse);
		
		
		etaStkForm.setNomProfil(nomProfil);
		
		while (rs3.next())
    	{
    		    		    		
     	art = rs3.getString(1).trim();
    	//System.out.println(four);
     	
     	nomArticle.add(art);  			    		
    	}
		etaStkForm.setNomArticle(nomArticle);
		
		
		while (rs5.next())
    	{
    		    		    		
     	dest = rs5.getString(1).trim();
    	//System.out.println(four);
     	
     	nomDest.add(dest);  			    		
    	}
		etaStkForm.setNomDist(nomDest);
		
		
		while (rs4.next())
    	{
    		    		    		
     	cds = rs4.getString(1).trim();
    	//System.out.println(four);
     	
     	nomCds.add(cds);  			    		
    	}
		etaStkForm.setNomCds(nomCds);
		
		
		while (rs6.next())
    	{
    		    		    		
     	part = rs6.getString(1).trim();
    	//System.out.println(four);
     	
     	nomPart.add(part);  			    		
    	}
		etaStkForm.setNomPart(nomPart);
		
	if (rs.next())
			
		{
			dat = rs.getString(1).trim();
		//	System.out.println(dat);
		}
	     etaStkForm.setDat_du(dat);
		
	     Article article = new Article();
		 
		 article.setArt("");
		 article.setProf("");
		 article.setDest("");
		 article.setStart("");
		 article.setEnd("");
		 article.setHlr("");
		 article.setPq("");
		 article.setPos("");
		 article.setQte("");
		 article.setWhs("");
		 article.setSwap("");
		 article.setPack("");
		 article.setSor("");
		 article.setTra("");
		 article.setReint("");
		 article.setTdp("");
		
		 list.add(article);
		 
		 etaStkForm.setEtat(list);
		 
     ////vider les champs a cause du session
		 etaStkForm.setArticle("");
		 etaStkForm.setCds("");
		 etaStkForm.setDist("");
		 etaStkForm.setHLR("");
		 etaStkForm.setPackaging("");
		 etaStkForm.setPart("");
		 etaStkForm.setPosition("");
		 etaStkForm.setWarehouse("");
		 etaStkForm.setTyp("");
		 etaStkForm.setSdu("");
		 etaStkForm.setSau("");
		 etaStkForm.setPQ("");
		 etaStkForm.setProfil("");
		 etaStkForm.setResult("");
		 etaStkForm.setSortie(false);
		 etaStkForm.setTdp(false);
		
		 etaStkForm.setHiddenSorti("false");
		 etaStkForm.setHiddenTdp("false");
		 
		 etaStkForm.setHeur1("");
		 
		 con.close();
		return mapping.findForward("prepar");
	}
}