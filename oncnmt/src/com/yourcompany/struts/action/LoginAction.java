

package com.yourcompany.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yourcompany.struts.UtilClass.Connexion;
import com.yourcompany.struts.form.LoginForm;
import com.yourcompany.struts.UtilBean.Profil;

import java.io.*; 

import oracle.jdbc.*; // Pour les pilotes Oracle
import oracle.sql.*; // Pour les spécificités SQL d'Oracle
//import java.util.jar.*;
//import java.util.zip.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import java.net.UnknownHostException;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.PartialResultException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.*;
import com.yourcompany.struts.UtilClass.Connexion;


public class LoginAction extends Action {

	
	
	public String mm;
//	public String username;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response ) throws SQLException { 
		
		
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		Connexion connexion=new Connexion();
		Connection con= connexion.createConnection(request);
		
      
		Statement st = null;
		ResultSet rs = null;
		Statement st1 = null;
		ResultSet rs1 = null;
		String trouve="false";
		
		//st1=con.createStatement();
		
		  
		String nom=null;
		Boolean verif = false; 
		Boolean verif1 = false; 
		String status=null;
		Hashtable env = new Hashtable();
		String msg = null;
		String domaine = "otalgerie.com";
	    String username = loginForm.getUsername();
          username=  username.toLowerCase();
	
		String password = loginForm.getPassword();
		request.getSession().setAttribute( "username",username);
		
		
/*		Context ctxt;
		try {
			ctxt = new InitialContext();
			HashMap map = (HashMap) ctxt.lookup("ListeUtilisateur");
			map.put("userID",username);
			ctxt.rebind("ListeUtilisateur",map); 
			
			
		} catch (NamingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	*/
		

		
		System.out.println("le username ==="+username);

		
	/*	String date = DateFormat.getInstance().format(new Date());
		
		System.out.println("date="+date);
		
		String[] split_date=date.split("/");
		
		String jour=split_date[0];
		System.out.println("jour="+jour);
		String mois=split_date[1];
		System.out.println("mois="+mois);
		String annee_heure=split_date[2];
		System.out.println("annee_heure="+annee_heure);
		
		String[] split_annee=annee_heure.split(" ");
		
		String annee=split_annee[0];
		System.out.println("annee="+annee);
		
		String heure=split_annee[1];
		System.out.println("heure="+heure);
		
	String	date_string=jour+"_"+mois+"_"+annee;
		System.out.println("date_string aprés conversion="+date);
		
		
		String directoryPath="D:\\gss_log";
		
		File[] files = null; 
		File directoryToScan = new File(directoryPath); 
files = directoryToScan.listFiles(); 

for(int i=0; i<files.length; i++) { 
	
	File fichier=files[i];
	String nom_fichier=fichier.getName();
	System.out.println("nom du fichier n°="+i+nom_fichier); 
	//String[] split_nom_fichier=nom_fichier.split(".");
	//nom_fichier=split_nom_fichier[0];
	
	

	
	if (nom_fichier.equals(date_string+".txt"))
	{
		
		System.out.println("texte à insérer à la fin du fichier");
		
		System.out.println("j'ai trouvé  le fichier"); 
		trouve="true";
		
		
		FileWriter writer = null;
		String texte = "texte à insérer à la fin du fichier";
		try{
		     writer = new FileWriter("D:\\gss_log\\"+nom_fichier+"", true);
		     
		     BufferedWriter output = new BufferedWriter(writer); 
		   //  writer.write(texte+"\r\n ",0,texte.length());
		     
		     output.newLine();
		     
		     output.write(texte);
			//output.write(texte+"\r\n ");
				
				
				output.flush(); 
				output.close(); 
		     
		    // output.write(texte+"\r\n "); 
		     
		}catch(IOException ex){
		    ex.printStackTrace();
		}
		
	
				
		finally{
		  if(writer != null){
		     try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		}
		
		
			break;
						
	}

    
} 

System.out.println("trouve="+trouve); 
		
	if (trouve.equals("false"))
		
	{
		System.out.println("je vais créer le fichier"); 
		File fichier = new File("D:\\gss_log\\"+date_string+".txt") ;
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(fichier));
			out.write(date_string) ; //écris bonjour dans le fichier
			out.println() ; //fais un retour à la ligne dans le fichier
			//out.write("Comment allez vous") ; //écris dans le fichier
		
			out.close() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	else{System.out.println(" le fichier existe déja"); }
		

*/
		
		

				
		
		   File projectRealPath=new File(request.getSession().getServletContext().getRealPath("."));
			
			  
			File jasperFile=new File(projectRealPath,"config/param.conf");
			System.out.println(jasperFile.getAbsolutePath());

			
			Properties prop = new Properties();
		
			FileInputStream in = null;
			try {
				in = new FileInputStream(jasperFile);
			} catch (FileNotFoundException e1) {

	    	e1.printStackTrace();
			}
			try {
				prop.load(in);
				in.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			
			// Extraction des propriétés
			 String url_ldap = prop.getProperty("url_ldap");
			 
       try {
        	
   		
            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL,url_ldap); 
            env.put(Context.SECURITY_PRINCIPAL, username + "@" + domaine);
            env.put(Context.SECURITY_CREDENTIALS, password);
            InitialDirContext ctx = new InitialDirContext(env);
            
 } 
        
	 catch (AuthenticationException ex) {
       msg = ex.getExplanation();
        if (msg.indexOf("LDAP: error code 49") != -1){
            msg = "Erreur lors de l'authentification. Vérifiez votre Username/Password.";
            System.out.println(msg);
           
            verif = true;
        
            
          //  return mapping.findForward("menu");    
       
        
        }
            
        
        
  } 
	catch (NamingException en) {
    
        msg = en.getExplanation();
        en.printStackTrace();
        System.out.println("rien");
    } 
	
    catch (Exception ec) {
        System.out.println("doLDAPLogibn : Erreur " + ec.toString());
    }
 
 

	 if (verif.equals(true)){
		  loginForm.setHiddenTest("Erreur user/pass");
		  System.out.println("Erreur user/pass");
		  
		  return mapping.findForward("login");
	  }
	 
 if (msg==null )    
 {
	// st= con.createStatement();
	
 	 
 	 try{
 		 st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
 	 	 rs = st.executeQuery("select ACT_STATUS from GSS_ACTOR where gss_actor.act_name='"+username+"'");
 	 	 
 	
 	
 	
 	 rs.last();
	 int cpt = rs.getRow();
	 System.out.println("cpt"+cpt);
	 
	 if (cpt==0)
	 {
			loginForm.setHiddenTest("refusé");
	 		return mapping.findForward("login"); 
		 
	 }
 	  rs.beforeFirst();
 	  
 	  boolean trouv=false;
	while (rs.next()) {
		

	String	  stat = rs.getString(1).trim();
	 System.out.println("le satus du user"+stat);
	
		  if(stat.equals("A"))
		  {
			 trouv=true;
		  }

	}
			if (trouv==true )
			 
			   { 
			        System.out.println(username);
			        st1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        
			        rs1=st1.executeQuery("select priv_libelle,whs_id,pr.profil_act_libelle from gss_privilege p,gss_actor a,gss_profil_actor pr, gss_droit_acces d,gss_profil_privillege pf where (d.act_id=a.act_id)and (d.profil_act_id=pr.profil_act_id)and (pf.priv_id=p.priv_id)and(pf.profil_act_id=pr.profil_act_id)and (a.act_name='"+username+"')and d.profil_act_id=pr.profil_act_id and a.act_status='A'");
			        rs1.last();
			   	 int cpt2 = rs1.getRow();
			   	 System.out.println("cpt2"+cpt2);
			   	 
			   	 if (cpt2==0)
			   	 {
			   			loginForm.setHiddenTest("refusé");
			   	 		return mapping.findForward("login"); 
			   		 
			   	 }
			    	  rs1.beforeFirst();        
			       ArrayList pri =new ArrayList();
			      
			       while (rs1.next())
			            	{
			            		Profil profil =new Profil();
			            		
			            		profil.setProf(rs1.getString(1).trim());
			            		profil.setWhs(rs1.getString(2).trim());
			            		profil.setProfil(rs1.getString(3).trim());
			            		System.out.println("["+rs1.getString(1)+"]"+"["+rs1.getString(2)+"]");
			            		
			            		  	   		
			            		pri.add(profil);
			            	
			            	}
			          
			            	
			            	
			          request.getSession().setAttribute("privilege", pri);
			          return mapping.findForward("menu");	 
		        }
		       else   {
		    	   
		    	   System.out.println("votre status est désactivé");
		    	   loginForm.setHiddenTest("status désactivé");
		       
		    	   return mapping.findForward("login");	 
		              }	
			   
	
	
 	 }
 	 catch (SQLException e){
 		 
 		 
 		 verif1 = true;
 		 
 	 }
 	 
 	 if (verif1.equals(true)){
 		loginForm.setHiddenTest("refusé");
 		return mapping.findForward("login");
 	 }
 }
 
  	
   
    	
	
	    con.close();
	    		
 
       
	    	return null;	  
	}
}