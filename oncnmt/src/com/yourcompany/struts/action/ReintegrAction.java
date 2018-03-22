/*
 * Template path: templates/java/JavaClass.vtl
 */
package com.yourcompany.struts.action;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.yourcompany.struts.form.Transfert1Form;

import java.io.IOException;
import java.sql.Connection;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.yourcompany.struts.form.ReintegrForm;
/** 
 * MyEclipse Struts
 * Creation date: 11-01-2008
 * 
 * XDoclet definition:
 * @struts.action path="/reintegr" name="reintegrForm" parameter="hidden" validate="true"
 */
public class ReintegrAction extends DispatchAction {
  
  
  public ActionForward recherche(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
   ReintegrForm reintegrForm = (ReintegrForm) form;// TODO Auto-genera
   
   Connexion connexion=new Connexion();
   Connection con=connexion.createConnection(request);
   
   Statement st,st1 = null;
   ResultSet rs,rs1 = null;
   Integer R,R1;
   String whs=null,whh=null;
   String prio=null;
   String date=null;
   
   ArrayList list = new ArrayList();
   ArrayList priv =  new ArrayList() ;
   
   
   
   
   
    
   
   
   whh=reintegrForm.getMagasin();
   System.out.println(whh);
   
   st1=con.createStatement();
   
   rs1=st1.executeQuery("select whs_id from gss_warehouse where (gss_warehouse.whs_adresse='"+whh+"')");

   if (rs1.next()){
     
      whs=rs1.getString(1).trim();
     System.out.println(whs);
    
     
    }
   request.getSession().setAttribute("warehousenvoi",whs); 
   
   
   st=con.createStatement();
   //rs=st.executeQuery("select distinct tr.t_r_trans_type||'-'||tr.t_r_trans_whs||'-'||tr.t_r_trans_no,tr.t_r_trans_type,tr.t_r_trans_whs,tr.t_r_trans_no, gss_destinataire.dest_nom from gss_transaction_range tr, gss_range r, gss_transaction t, gss_warehouse d ,gss_destinataire where tr.t_r_rng_id=r.rng_id and tr.t_r_rng_act_id=r.act_id and tr.t_r_trans_no=t.trans_no and tr.t_r_trans_type=t.trans_type and tr.t_r_trans_whs=t.whs_id and tr.t_r_trans_type='TRE' and r.rng_inactif='A' and t.dest_id=gss_destinataire.dest_id and r.rng_whs='"+whs+"' and r.rng_reintegration='T'");
   
   rs=st.executeQuery("select * from (select distinct  tr.t_r_trans_type||'-'||tr.t_r_trans_whs||'-'||tr.t_r_trans_no,tr.t_r_trans_type,tr.t_r_trans_whs,tr.t_r_trans_no, gss_destinataire.dest_nom,t.trans_date from gss_transaction_range tr, gss_range r, gss_transaction t, gss_warehouse d ,gss_destinataire where tr.t_r_rng_id=r.rng_id and tr.t_r_rng_act_id=r.act_id and tr.t_r_trans_no=t.trans_no and tr.t_r_trans_type=t.trans_type and tr.t_r_trans_whs=t.whs_id and tr.t_r_trans_type='TRE' and r.rng_inactif='A' and t.dest_id=gss_destinataire.dest_id and r.rng_whs='"+whs+"' and r.rng_reintegration='T'  order by t.trans_date desc ) where rownum<2");
     while (rs.next()){
  Ordre ordre = new Ordre();
  ordre.setOrdre(rs.getString(1).trim());
  ordre.setType(rs.getString(2).trim()); 
  ordre.setCode(rs.getString(4).trim());
  ordre.setWhs(rs.getString(3).trim());
  ordre.setMag(rs.getString(5).trim());
 list.add(ordre);
  
 }
 reintegrForm.setListeordre(list);


 	con.close();

  return mapping.findForward("listreintegr");
 }
  
  
  
  public ActionForward ouvrir(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
   ReintegrForm reintegrForm = (ReintegrForm) form;
   
   Connexion connexion=new Connexion();
   Connection con=connexion.createConnection(request);
  
   ArrayList priv =  new ArrayList() ;
    String max=null;
    String art,prof,maxi;
    Integer R=0,R1=0;
    String prio=null;
    String date=null;
    Statement st,st1,st3,st4 = null;
    ResultSet rs,rs1,rs3,rs4 = null;
    ArrayList listprof = new ArrayList();
    ArrayList listart = new ArrayList();
    
 ArrayList list = new ArrayList();
 ArrayList list2 = new ArrayList();
 st=con.createStatement();
 st1=con.createStatement();
 st3=con.createStatement();
 st4=con.createStatement();
 

 String whs= (String)request.getSession().getAttribute("warehousenvoi");
 System.out.println(whs);
 
 String code = request.getParameter("code");
 System.out.println("code"+code);
 request.getSession().setAttribute( "code",code);
  
 String type= request.getParameter("type");
 System.out.println("type"+type);
 /*String mag = request.getParameter("mag");
 System.out.println("magasin distinataire"+mag);*/
 
 
 rs=st.executeQuery("select distinct gss_article.art_art_libelle,nvl(gss_article_profil.profil_libelle,'_'),gss_range.rng_start,gss_range.rng_end,decode(gss_range.rng_packaged, 'N','non package', 'O', 'sous ordre', 'C', 'EN COUR', 'P', 'package', '_') PACKAGING,gss_range.rng_statut,case when gss_article.art_type_id in ('S1','S2') then decode(substr(gss_range.rng_start, 4, 1),'0', substr(gss_range.rng_start, 4, 2),'1', substr(gss_range.rng_start, 4, 2),'2', substr(gss_range.rng_start, 4, 2), '0' || substr(gss_range.rng_start, 5, 1)) else '_' end hlr,gss_range.rng_end-gss_range.rng_start+1 as qte,nvl(gss_range.rng_pq,'_'),gss_range.rng_id,gss_range.act_id  from gss_range,gss_article, gss_article_profil,gss_warehouse,gss_article_type,gss_transaction t,gss_transaction_range tr where (gss_article.art_id=gss_range.art_id) and (gss_article_profil.profil_id (+) =gss_range.profil_id ) and (gss_range.rng_whs=gss_warehouse.whs_id) and (gss_article.art_type_id=gss_article_type.art_type_id)and(gss_range.rng_reintegration='T')and(gss_range.rng_inactif='A')and tr.t_r_rng_id=gss_range.rng_id and tr.t_r_rng_act_id=gss_range.act_id and tr.t_r_trans_no=t.trans_no and tr.t_r_trans_type=t.trans_type and tr.t_r_trans_whs=t.whs_id and tr.t_r_trans_type='TRE'and tr.t_r_trans_whs ='W00' and tr.t_r_trans_no='"+code+"' and gss_range.rng_tpd is  null ");
    
  rs4=st4.executeQuery("select art_art_libelle from gss_article,gss_article_type where (gss_article.art_type_id=gss_article_type.art_type_id) and (art_status='A')");
 rs3=st3.executeQuery("select profil_libelle from gss_article_profil where profil_statut='A'"); 
 while (rs4.next()){
 art = rs4.getString(1).trim();
 listart.add(art);
 System.out.println(art);
 }
 while (rs3.next())
 {
 prof = rs3.getString(1).trim();
 listprof.add(prof);
 System.out.println(prof);
 }
/* try{
 rs1=st1.executeQuery("select max(trans_no) from gss_transaction  where (trans_type='REI') and (whs_id='"+whs+"')");

 while (rs1.next()){
 max = rs1.getString(1).trim();
 }
 int res =Integer.parseInt(max);
 int res1=res+1;
 maxi = Integer.toString(res1);
 System.out.println("le max :"+maxi);
 }

 catch (Exception e){
        maxi = "10000";
        System.out.println("le max=10000"); 
       }
 
 String code_trans = "REI"+"-"+whs+"-"+maxi;
 System.out.println("le code de reintegration:"+code_trans);
 request.getSession().setAttribute("max", maxi);
*/
 while (rs.next())
  {
   
   System.out.println("["+rs.getString(1)+"],["+rs.getString(2)+"],["+rs.getString(3)+"],["+rs.getString(4)+"],["+rs.getString(5)+"],["+rs.getString(6)+"],["+rs.getString(7)+"],["+rs.getString(8));
  
   
   Rang rang=new Rang();
   
   rang.setArticle(rs.getString(1).trim());
   rang.setProfil(rs.getString(2).trim());
   rang.setStart(rs.getString(3).trim());
   rang.setEnd(rs.getString(4).trim());
   rang.setPackag(rs.getString(5).trim());
   rang.setActive(rs.getString(6).trim());
   rang.setHlr(rs.getString(7).trim());
   rang.setQte(rs.getString(8).trim());
   rang.setPq(rs.getString(9).trim());
   rang.setRng_id(rs.getString(10).trim());
   rang.setAct_id(rs.getString(11).trim());
   
   //les paramId
   
   rang.setArt(rs.getString(1).trim());
   rang.setProf(rs.getString(2).trim());
   rang.setSt(rs.getString(3).trim());
   rang.setNd(rs.getString(4).trim());
   rang.setQt(rs.getString(8).trim());
   
   /* date=(rs.getString(9).trim());
   System.out.println("la date :"+date);
    prio=(rs.getString(10).trim());
   System.out.println("la priorite :"+prio);*/
   
    
   
      
   list.add(rang);
  }
  
      Rang3 rang3 =new Rang3();
      
      rang3.setAa("");
      rang3.setEndd("");
      rang3.setProff("");
      rang3.setQtt("");
      rang3.setStt("");
      
      list2.add(rang3);
      
    
      
    
   

      reintegrForm.setDebut("") ;
      reintegrForm.setFin("");
      reintegrForm.setArticle("");
      reintegrForm.setProfil("");
    
      reintegrForm.setResulrang(list);
      reintegrForm.setListajouter(list2);
      reintegrForm.setNomArticle(listart);
      reintegrForm.setListprof(listprof);
 //     reintegrForm.setTrans(code_trans);
      
      
      
   //   request.getSession().setAttribute( "priorite",prio);
     
      reintegrForm.setHiddenTest(""); 
      
      System.out.println("c'est bon");
      
      
      
     
	    	con.close();
     
   
  return mapping.findForward("reintegr");
 }
  
  
  
  

  public ActionForward ajouter(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
   ReintegrForm reintegrForm = (ReintegrForm) form;
   
   
   List listt;
   
  // ArrayList mm = new ArrayList();
  // ArrayList mm1 = new ArrayList();
   
   
   
   
   String nn=request.getParameter("art");
   String nn1=request.getParameter("prof");
   String nn2=request.getParameter("st");
   String nn3=request.getParameter("nd");
   String nn4=request.getParameter("qt");
   String rng_id=request.getParameter("rng_id");
   String act_id=request.getParameter("act_id");
   System.out.println(rng_id);
   System.out.println(act_id);

 
   //request.getSession().setAttribute( "art",nn);
   //request.getSession().setAttribute( "prof",nn1);
   
   
   System.out.println(nn);
   System.out.println(nn1);
   System.out.println(nn2);
   System.out.println(nn3);
   System.out.println(nn4);
   
   
   reintegrForm.setDebut(nn2);
   reintegrForm.setFin(nn3);
   reintegrForm.setArticle(nn);
   reintegrForm.setProfil(nn1);
   reintegrForm.setAct_id(act_id);
   reintegrForm.setRng_id(rng_id);
  
   
   reintegrForm.setHiddenTest("");
   
   
   
  return mapping.findForward("reintegr");
 }
  
  public ActionForward ajouter1(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
   ReintegrForm reintegrForm = (ReintegrForm) form;

   long R1=0,R2=0,R=0;
   List list=null;
   List listGrand=null;
   ArrayList nouv=new ArrayList();
   Rang3 rang2=new Rang3();
   String  nn1_grand=null;
   Boolean trouver=false, existe= false, existe2=false;
   list=reintegrForm.getListajouter();
   listGrand = reintegrForm.getResulrang();

   String act_id2=null,rng_id2=null;  
   
   String nn=reintegrForm.getArticle();
   String nn1=reintegrForm.getProfil();
   String nn2=reintegrForm.getDebut();
   String nn3=reintegrForm.getFin();
   String rng_id=reintegrForm.getRng_id();
   String act_id=reintegrForm.getAct_id();
 System.out.println(rng_id);
   System.out.println(act_id);
   
   System.out.println(nn);
   System.out.println(nn1);
   System.out.println(nn2);
   System.out.println(nn3);
   
   nn1_grand=nn1;
   if (nn1.equals(""))
   {
     nn1_grand="_";
    System.out.println(nn1_grand);
    System.out.println("profil null"); 
   }

 R1=Long.parseLong(nn2);
 R2=Long.parseLong(nn3);
 long  qte=R2-R1+1;
 
 
  String  qute=Long.toString(qte);
  System.out.println(qute);
  
  if (qte<=0){
      reintegrForm.setHiddenTest("fin inferieur debut"); 
       System.out.println("le fin est< debut");
       
      reintegrForm.setArticle("");
   reintegrForm.setProfil("");
   reintegrForm.setDebut("");
   reintegrForm.setFin("");
      
        return mapping.findForward("reintegr");
      }
  
  int size=list.size();
  System.out.println(size);
 
  if (size==0){
       
       System.out.println("la coll est vide ");
       
       for (int j=0;j<listGrand.size();j++){
       Rang list3 =(Rang) listGrand.get(j);
        
       
        if(
            (R1 >= Long.parseLong(list3.getStart()) &&  R2<= Long.parseLong(list3.getEnd())&& nn.equals(list3.getArticle())&& nn1_grand.equals(list3.getProfil())) 
            )
        {
         System.out.println("j de la grande="+j);
         System.out.println("j'ai trouvé un element ds la grand ");
         
         ///   ndl <= parseLong(list3.getStart()) <= nfl
         trouver=true;
         existe=true;
         act_id2=list3.getAct_id();
 		 rng_id2=list3.getRng_id();
 		 System.out.println("act_id2"+act_id2);
 		 System.out.println("rng_id2"+rng_id2);

         
         break;
        
          
        }/// end if teste coll grande
        
       
            
         }//// end for coll grande
       
       if (existe.equals(false)){
       reintegrForm.setHiddenTest("range n'est pas dans la coll grande"); 
        System.out.println("range n'existe pas dans la collection grande");
        
       reintegrForm.setArticle("");
    reintegrForm.setProfil("");
    reintegrForm.setDebut("");
    reintegrForm.setFin("");
       
         return mapping.findForward("reintegr");
       }
       
       else{
        
       
       
            //   calculer la quantité
     
     
      
      // remplir la collection
     rang2.setAa(nn);
    rang2.setProff(nn1);
    rang2.setStt(nn2);
    rang2.setEndd(nn3);
    rang2.setQtt(qute);
    
    rang2.setAaa(nn);
    rang2.setPpp(nn1);
    rang2.setSt(nn2);
    rang2.setSee(nn3);
    rang2.setQt(qute);
   /* rang2.setAct_id(act_id);
    rang2.setRng_id(rng_id);*/
    rang2.setAct_id(act_id2);
    rang2.setRng_id(rng_id2);
      list.add(rang2);
      
     
       for (int j=0; j<list.size();j++){
       System.out.println("dans le for");
       System.out.println("j ="+j);
       
       Rang3 list3 = (Rang3)list.get(j);
        
         if ((list3.getAa().equals("")))  
        {
         System.out.println("dans le if");
        }
            else{
         nouv.add(list3);
         System.out.println("dans le else");
        
        }
        
      }
     
     trouver=true;
     reintegrForm.setListajouter(nouv);
     reintegrForm.setHiddenTest("");
       //break;
     
      }// end if ""
 }// ende else existe
  
  
        
  else{
   for (int i=0; i<list.size();i++){
     Rang3 list2 = (Rang3)list.get(i);
     
    if (list2.getAa().equals("")){
           
           System.out.println("la 1ere ligne vide");
           
           for (int j=0;j<listGrand.size();j++){
           Rang list3 =(Rang) listGrand.get(j);
            
           
            if(
                (R1 >= Long.parseLong(list3.getStart()) &&  R2<= Long.parseLong(list3.getEnd())&& nn.equals(list3.getArticle())&& nn1_grand.equals(list3.getProfil())) 
                )
            {
            System.out.println("j de la grand="+j);
             
             ///   ndl <= parseLong(list3.getStart()) <= nfl
             trouver=true;
             existe=true;
             act_id2=list3.getAct_id();
	    		 rng_id2=list3.getRng_id();
	    		 System.out.println("act_id2"+act_id2);
	    		 System.out.println("rng_id2"+rng_id2);

             
             break;
            
              
            }/// end if teste coll grande
            
           
                
             }//// end for coll grande
           
           if (existe.equals(false)){
           reintegrForm.setHiddenTest("range n'est pas dans la coll grande"); 
            System.out.println("range n'existe pas dans la collection grande");
            
           reintegrForm.setArticle("");
        reintegrForm.setProfil("");
        reintegrForm.setDebut("");
        reintegrForm.setFin("");
           
             return mapping.findForward("reintegr");
           }
           
           else{
            
           
           
                     //   calculer la quantité
        
        
         
         // remplir la collection
        rang2.setAa(nn);
       rang2.setProff(nn1);
       rang2.setStt(nn2);
       rang2.setEndd(nn3);
       rang2.setQtt(qute);
       
       rang2.setAaa(nn);
       rang2.setPpp(nn1);
       rang2.setSt(nn2);
       rang2.setSee(nn3);
       rang2.setQt(qute);
     /*  rang2.setAct_id(act_id);
       rang2.setRng_id(rng_id);*/
       rang2.setAct_id(act_id2);
       rang2.setRng_id(rng_id2);
         list.add(rang2);
         
        
          for (int j=0; j<list.size();j++){
          System.out.println("dans le for");
          System.out.println("j ="+j);
          
          Rang3 list3 = (Rang3)list.get(j);
           
            if ((list3.getAa().equals("")))  
           {
            System.out.println("dans le if");
           }
               else{
            nouv.add(list3);
            System.out.println("dans le else");
           
           }
           
         }
        
        trouver=true;
        reintegrForm.setListajouter(nouv);
        reintegrForm.setHiddenTest("");
           break;
         
          }// end if ""
    }// ende else existe
     
        ///// si la collection est non vide
          
       else{
           
           System.out.println("la 1ere ligne non vide");
           
           reintegrForm.setHiddenTest("");
               
           if(
             (Long.parseLong(nn2)>= Long.parseLong(list2.getSt()) )&& (Long.parseLong(nn3)<= (Long.parseLong(list2.getSee()) )&& nn.equals(list2.getAa())&& nn1.equals(list2.getProff()))
             ||
             (Long.parseLong(list2.getSt())>=Long.parseLong(nn2) && Long.parseLong(list2.getSt())<=Long.parseLong(nn3) && nn.equals(list2.getAa())&& nn1.equals(list2.getProff()))
             ||
             (Long.parseLong(list2.getSee())>=Long.parseLong(nn2) && Long.parseLong(list2.getSee())<=Long.parseLong(nn3)&& nn.equals(list2.getAa())&& nn1.equals(list2.getProff()))
           
              )
           {
            reintegrForm.setHiddenTest("range dans la coll"); 
             System.out.println("range existe dans la collection");
             trouver=true;
             existe2= true;
             existe=true;
             
             break;
           }//// end if collection
           
       }//// end for
           
            
           if(existe2.equals(false))
            {
            //// n'existe pas dans la petite coll
            
             for (int j=0;j<listGrand.size();j++){
             Rang list3 =(Rang) listGrand.get(j);
             
             
             
              if(
               (R1 >= Long.parseLong(list3.getStart()) &&  R2<= Long.parseLong(list3.getEnd())&& nn.equals(list3.getArticle())&& nn1_grand.equals(list3.getProfil())) 
                  
                )
             
              {
              // trouver=true;
               existe=true;
               act_id2=list3.getAct_id();
	    		 rng_id2=list3.getRng_id();
	    		 System.out.println("act_id2"+act_id2);
	    		 System.out.println("rng_id2"+rng_id2);

               
               break;
              
                
              }/// end if teste coll grande
              
             
              }//// end for coll grande
          }// end if existe2
          
          }/// end else " "
  }   
     if (existe.equals(false)){
      reintegrForm.setHiddenTest("range n'est pas dans la coll grande"); 
        System.out.println("range n'existe pas dans la collection grande");
        
        reintegrForm.setArticle("");
     reintegrForm.setProfil("");
     reintegrForm.setDebut("");
     reintegrForm.setFin("");
       
         return mapping.findForward("reintegr");
       }
         
   
    
    
     if (trouver.equals(false))
     {
      reintegrForm.setHiddenTest("");
        
        System.out.println("rang n'existe pas dans la collection ");
        
        // calculer la quantité
       
        
        // remplir la collection
       rang2.setAa(nn);
     rang2.setProff(nn1);
     rang2.setStt(nn2);
     rang2.setEndd(nn3);
     rang2.setQtt(qute);
     
     rang2.setAaa(nn);
     rang2.setPpp(nn1);
     rang2.setSt(nn2);
     rang2.setSee(nn3);
     rang2.setQt(qute);
   /*  rang2.setAct_id(act_id);
     rang2.setRng_id(rng_id);*/
     rang2.setAct_id(act_id2);
     rang2.setRng_id(rng_id2);
        list.add(rang2);
       
       reintegrForm.setListajouter(list); 
     }
      

    reintegrForm.setArticle("");
    reintegrForm.setProfil("");
    reintegrForm.setDebut("");
    reintegrForm.setFin("");
 
  
  
 return mapping.findForward("reintegr");
}
  
 
 public ActionForward Retirer(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException {
  ReintegrForm reintegrForm = (ReintegrForm) form;
   List list=null;
   ArrayList nouv= new ArrayList();
   
   list = reintegrForm.getListajouter();
   String art = request.getParameter("aaa");
   System.out.println("arti"+art);
   String prof = request.getParameter("ppp");
   System.out.println("prof"+prof);
   String ser_str = request.getParameter("st");
   System.out.println("serial_str"+ser_str);
   String ser_end = request.getParameter("see");
   System.out.println("serial_end"+ser_end);
   String quante = request.getParameter("qt");
   System.out.println("qte"+quante);
   
   System.out.println("colle"+list.size());
   for (int i=0; i<list.size();i++){
   
   Rang3 list2= (Rang3)list.get(i); 
   System.out.println("dans le for");
   
   Rang3 pre = new Rang3();
  
   System.out.println(i);
   System.out.println("soum"+list2.getAa());
   
   if ((list2.getAa().equals(art))&&(list2.getProff().equals(prof))&&(list2.getEndd().equals(ser_end))&&(list2.getStt().equals(ser_str))) 
   {
    System.out.println("dans le if");
   }
   else{
    nouv.add(list2);
    System.out.println("dans le else");
   }
   
   }
   
   reintegrForm.setListajouter(nouv);
   reintegrForm.setHiddenTest("");
   return mapping.findForward("reintegr"); 
   }
 
 
 
 
 
  
 
  
  public String getResult(String Str)
  {
   return ((Str != null) ? Str=Str.trim():Str); 
  }
  
  
  public String setResult(String Str)
  {
   return ((Str != null) ? Str : null); 
  }
  
  
  
  
  public ActionForward valider(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
   ReintegrForm reintegrForm = (ReintegrForm) form;
   
   
   Connexion connexion=new Connexion();
   Connection con=connexion.createConnection(request);
   
   
   String idpart = null,idact=null,idart,idprof,maxrng=null,res1=null,res2,start,end,tra,wh,
   no,whp,pfp,arp,rp,acp,pq,statu,swap,promo,prior,p,t,s,r,sta2=null,end2,res3=null;
   Statement st,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12 = null;
   ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,rs8 = null;
   int h,h1,h2,h3,h4,h5,h6,h7,h8;
   Integer I2;
   Number P=0;
   long R2,R3,I=0,Res2=0,I1=0;
   List listt;
   String whh=null,max=null;
   ArrayList priv =  new ArrayList() ;
   
   
   
   
   st=con.createStatement();
   st1=con.createStatement();
   st2=con.createStatement();
   st3=con.createStatement();
   st4=con.createStatement();
   st5=con.createStatement();
   st6=con.createStatement();
   st7=con.createStatement();
   st8=con.createStatement();
   st9=con.createStatement();
   st10=con.createStatement();
   st11=con.createStatement();
   st12=con.createStatement();
   
 /*  max = (String)request.getSession().getAttribute("max");
   System.out.println(max);*/
   
   whh= (String)request.getSession().getAttribute("warehousenvoi");
   System.out.println(whh);
   
   try{
		  rs6=st6.executeQuery("select max(trans_no) from gss_transaction  where (trans_type='REI') and (whs_id='"+whh+"')");
		  while (rs6.next()){
		  max = rs6.getString(1).trim();
		  }
		  int res =Integer.parseInt(max);
		   res=res+1;
		  max = Integer.toString(res);
		  System.out.println("le max :"+max);
		  }

		  catch (Exception e){
		         max = "10000";
		         //System.out.println("rs est null"); 
		        }
	  
		 rs6=null;st6=null;
		 st6=con.createStatement();
   String mm= (String)request.getSession().getAttribute("username");
   System.out.println(mm);

   
   String code= (String)request.getSession().getAttribute("code");
   System.out.println(code);
   
   

   
   String note=reintegrForm .getNote();
   System.out.println(note);
   
   String doc=reintegrForm .getDoc();
   System.out.println(doc);
   
   
   
   con.setAutoCommit(false);
   
   
   rs3=st3.executeQuery("select ACT_ID from gss_actor where act_name='"+mm+"'");
   
   
   
  

   
   while (rs3.next())
      {
                   
       idact = rs3.getString(1).trim();
      System.out.println(idact);
       }
   
/*
   try{
     rs4=st4.executeQuery("select max(rng_id) from gss_range where ACT_ID='"+idact+"'");
     
     if (rs4.next()){
         maxrng=rs4.getString(1).trim();
        System.out.println(maxrng);
        
        R2=Long.parseLong(maxrng);
        R2=R2+1;
     res1=Long.toString(R2);
     System.out.println(res1);
        
        }
     
     
    }
     
      
       catch (Exception e) {
       
       res1 = "1000000000";
       
      }
     */
   
   listt=reintegrForm .getListajouter();
   
   
   
    
    
    /*   if (prof!="_"){
       rs6=st6.executeQuery("select profil_id from gss_article_profil where profil_libelle='"+prof+"'");
       
       if (rs6.next()){
          idprof=rs6.getString(1).trim();
         System.out.println(idprof);
         }
       }*/
  /* System.out.println("insert into gss_transaction values ('"+max+"','REI','"+whh+"',SYSDATE,'"+idact+"',(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),'"+doc+"','"+note+"','','','')");
    h = st.executeUpdate("insert into gss_transaction values ('"+max+"','REI','"+whh+"',SYSDATE,'"+idact+"',(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),'"+doc+"','"+note+"','','','')");
   */
    
    
    int size=listt.size();
   System.out.println(size);
   
   
       
       if (size==0){
       System.out.println("la collection est vide"); 
       
      reintegrForm.setHiddenTest("collection null");
       
         return mapping.findForward("reintegr");
        
       }
       else
        
       {
        try{
        System.out.println("insert into gss_transaction values ('"+max+"','REI','"+whh+"',SYSDATE,'"+idact+"',(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),'"+doc+"','"+note+"','','','','','N')");
      
      h = st.executeUpdate("insert into gss_transaction values ('"+max+"','REI','"+whh+"',SYSDATE,'"+idact+"',(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),'"+doc+"','"+note+"','','','','','N')");
     
    
    for (int i=0;i<listt.size();i++)
    {
     System.out.println(i);
     Rang3 rn = (Rang3)listt.get(i); 
     System.out.println("aa="+rn.getAa());
              System.out.println("pp="+rn.getProff());
     System.out.println("st="+rn.getStt());
     System.out.println("se="+rn.getEndd());
     System.out.println("qt="+rn.getQtt());
     
     
     
     String art=rn.getAa();
     System.out.println(art);
     
     if (art.equals("")){
      System.out.println("la collection est vide"); 
         
        reintegrForm.setHiddenTest("collection null");
         
           return mapping.findForward("reintegr");
          
         
     }
     
      try{
       rs4=st4.executeQuery("select max(rng_id) from gss_range where ACT_ID='"+idact+"'");
       
       if (rs4.next()){
           maxrng=rs4.getString(1).trim();
          System.out.println(maxrng);
          
          R2=Long.parseLong(maxrng);
          R2=R2+1;
       res1=Long.toString(R2);
       System.out.println(res1);
          
          }
       
       
      }
       
        
         catch (Exception e) {
         
         res1 = "1000000000";
         
        }
     
     String prof=rn.getProff();
     System.out.println(prof);
     String sta=rn.getStt();
     System.out.println(sta);
     String ind=rn.getEndd();
     System.out.println(ind);
     String rng_id=rn.getRng_id();
     String act_id=rn.getAct_id();
     System.out.println(rng_id);
     System.out.println(act_id);
    
     System.out.println("tous va bien");
     
    
  //  rs2=st2.executeQuery("select rng_start,rng_end,rng_id,act_id,profil_id,art_id,rng_pq,rng_statut,rng_swap,trans_type,whs_id,trans_no,rng_promotion,rng_priorite,rng_packaged,rng_transfert,rng_sortie,rng_reintegration,rng_whs,rng_dist,rng_packaging_whs,rng_sortie_whs,rng_reintegration_whs,rng_transfert_whs from gss_range r where (rng_inactif ='A') and  r.rng_reintegration='T' ");   
    rs2=st2.executeQuery("select rng_start,rng_end,rng_id,act_id,profil_id,art_id,rng_pq,rng_statut,rng_tpd,trans_type,whs_id,trans_no,rng_promotion,rng_priorite,rng_packaged,rng_transfert,rng_sortie,rng_reintegration,rng_whs,rng_dist,rng_packaging_whs,rng_sortie_whs,rng_reintegration_whs,rng_transfert_whs,rng_trans_hist,rng_tpd from gss_range r where r.rng_id='"+rng_id+"' and r.act_id='"+act_id+"'  ");    
     
      
      
    
      while (rs2.next()){
       System.out.println("dans le while");
       
        
       
       start = rs2.getString(1).trim();
       System.out.println("1"+start);
       
       end = rs2.getString(2).trim();
       System.out.println("2"+end);
       
       rp=rs2.getString(3).trim();
       System.out.println("3"+rp);
       
       acp=rs2.getString(4).trim();
       System.out.println("4"+acp);
       
       pfp=getResult(rs2.getString(5));
         System.out.println("5"+pfp);
       
       
       arp=rs2.getString(6).trim();
       System.out.println("6"+arp);
       
       
      pq=getResult(rs2.getString(7));
         System.out.println("7"+pq);
       
       statu=rs2.getString(8).trim();
        System.out.println("8"+statu);
       
       swap=getResult(rs2.getString(9));
         System.out.println("9"+swap);
       
         
     /*  tra = rs2.getString(10).trim();
       
       wh=rs2.getString(11).trim();
       no=rs2.getString(12).trim();*/
       
       
       promo=getResult(rs2.getString(13));
         System.out.println(promo);
         
      
       
       prior=getResult(rs2.getString(14));
         System.out.println(prior);
       
       p=rs2.getString(15).trim();
       t=rs2.getString(16).trim();
       s=rs2.getString(17).trim();
       r=rs2.getString(18).trim();
       
       whp=rs2.getString(19).trim();
       
          String dist=getResult(rs2.getString(20));
          System.out.println("20"+dist);
      
          
          String whspack=getResult(rs2.getString(21));
        System.out.println("21"+whspack);
       
        String whssor=getResult(rs2.getString(22));
        System.out.println("22"+whssor);
        
        String whsrentegr=getResult(rs2.getString(23));
        System.out.println("23"+whsrentegr);
      
        String whstransfert=getResult(rs2.getString(24));
        System.out.println("24"+whstransfert);
      
      
        String trans_hist=getResult(rs2.getString(25));
        System.out.println("25"+trans_hist);
        
        String TPD=getResult(rs2.getString(26));
        System.out.println("26"+TPD);
      
     
     
     
     /*************** rang entier*******************************/
     
     if((sta.equals(start))&&(ind.equals(end)))
     { 
      System.out.println("dans le 1er if");
      
      
      if(trans_hist!=null && trans_hist.equals("dispatché")) 
      h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','V',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      else 
      h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))"); 
      h3 = st9.executeUpdate("insert into gss_transaction_range values ('REI','"+whh+"','"+max+"','"+res1+"','"+idact+"',SYSDATE)");
      
    
      
      
      h3 = st9.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res1+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
      
     
     // h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"')");

      h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"') and rng_inactif='A' ");
         
         if (h8==0)
         {
        	 System.out.println("le rang est inactif");
        	 reintegrForm.setHiddenTest("rang deja touche");
        	 con.rollback();
             return mapping.findForward("reintegr");
        	 
         }
      
     
     break;
     }
     
     else{
      System.out.println("dans le else1");
     }
     
     
     
     
                 /**********  le 1er rang********************/
     
     
     /*Res1=Long.parseLong(sta);
     Res2=Long.parseLong(ind);*/
     
     
     
        
      if((sta.equals(start))&&(Long.parseLong(ind)< Long.parseLong(end)) )
     {
      System.out.println("dans le 2eme if");
      
      I=Long.parseLong(ind);
      I=I+1;
      sta2=Long.toString(I);
      //sta : rng_start de la collection, start : rng_start du range pere
      
      
            
      if(trans_hist!=null && trans_hist.equals("dispatché")) 
    	  h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','V',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      else
    	  h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      
      h3 = st9.executeUpdate("insert into gss_transaction_range values ('REI','"+whh+"','"+max+"','"+res1+"','"+idact+"',SYSDATE)");
      
      R3=Long.parseLong(res1);
      R3=R3+1;
      res2=Long.toString(R3);
        System.out.println(res2);
      
      h4 = st10.executeUpdate("insert into gss_range values ('"+res2+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta2+"','"+end+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','','','',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','"+s+"','"+r+"','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),decode('"+whsrentegr+"','null',null,'"+whsrentegr+"'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      
     
      
      
      h3 = st9.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res1+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
      
     
     h1 = st11.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res2+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
      
     
     //h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"')");

     h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"') and rng_inactif='A' ");
        
        if (h8==0)
        {
       	 System.out.println("le rang est inactif");
       	 reintegrForm.setHiddenTest("rang deja touche");
       	 con.rollback();
            return mapping.findForward("reintegr");
       	 
        }
     break; 
     }
     else 
     {
      System.out.println("dans le else2");
     }
     
     
     
     
     
     
     
      /*****************2er partie***************/
     
   if((Long.parseLong(sta)> Long.parseLong(start))&&(ind.equals(end)) )
     
     
     {
      System.out.println("dans le 3eme if");
      
      
      if(trans_hist!=null && trans_hist.equals("dispatché"))
          h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','V',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      else
    	  h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      
      
      h3 = st9.executeUpdate("insert into gss_transaction_range values ('REI','"+whh+"','"+max+"','"+res1+"','"+idact+"',SYSDATE)");
      
      
      I=Long.parseLong(sta);
      I=I-1;
      end2=Long.toString(I);
      
      R3=Long.parseLong(res1);
      R3=R3+1;
      res2=Long.toString(R3);
        System.out.println(res2);
      
      h4 = st10.executeUpdate("insert into gss_range values ('"+res2+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+start+"','"+end2+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','','','',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','"+s+"','"+r+"','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),decode('"+whsrentegr+"','null',null,'"+whsrentegr+"'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
     
      
      h3 = st9.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res1+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'"); 
     
      h1 = st11.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res2+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
     
     // h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"')");

      h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"') and rng_inactif='A' ");
         
         if (h8==0)
         {
        	 System.out.println("le rang est inactif");
        	 reintegrForm.setHiddenTest("rang deja touche");
        	 con.rollback();
             return mapping.findForward("reintegr");
        	 
         }
      
     break; 
     }
     else 
     {
      System.out.println("dans le else3");
     }
     
    
     
     
     /* 3 parties*/
      if((Long.parseLong(sta)> Long.parseLong(start))&&(Long.parseLong(ind)< Long.parseLong(end)))
        
     
     {
      System.out.println("dans le 4eme if");
      
      if(trans_hist!=null && trans_hist.equals("dispatché"))       
          h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','V',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      else
    	  h2 = st7.executeUpdate("insert into gss_range values ('"+res1+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta+"','"+ind+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','REI','"+whh+"','"+max+"',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','R','R','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),(select dest_id from gss_transaction where trans_no='"+code+"' and trans_type='TRE'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      
      
      h3 = st9.executeUpdate("insert into gss_transaction_range values ('REI','"+whh+"','"+max+"','"+res1+"','"+idact+"',SYSDATE)");
      
      
      I=Long.parseLong(sta);
      I=I-1;
      end2=Long.toString(I);
      
      I1=Long.parseLong(ind);
      I1=I1+1;
      sta2=Long.toString(I1);
      
      
      R3=Long.parseLong(res1);
      R3=R3+1;
      res2=Long.toString(R3);
        System.out.println(res2);
      
      h4 = st10.executeUpdate("insert into gss_range values ('"+res2+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+start+"','"+end2+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','','','',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','"+s+"','"+r+"','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),decode('"+whsrentegr+"','null',null,'"+whsrentegr+"'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
      
      R3=R3+1;
      res3=Long.toString(R3);
        System.out.println(res3);
      
       h5 = st7.executeUpdate("insert into gss_range values ('"+res3+"','"+idact+"',decode('"+pfp+"','null',null,'"+pfp+"'),'"+arp+"','"+sta2+"','"+end+"','"+rp+"','"+acp+"','A',SYSDATE,'',decode('"+pq+"','null',null,'"+pq+"'),'"+statu+"','','','',decode('"+trans_hist+"','null',null,'"+trans_hist+"'),decode('"+TPD+"','null',null,'"+TPD+"'),decode('"+promo+"','null',null,'"+promo+"'),decode('"+prior+"','null',null,'"+prior+"'),'"+p+"','"+t+"','"+s+"','"+r+"','"+whp+"',decode('"+dist+"','null',null,'"+dist+"'),decode('"+whspack+"','null',null,'"+whspack+"'),decode('"+whssor+"','null',null,'"+whssor+"'),decode('"+whsrentegr+"','null',null,'"+whsrentegr+"'),decode('"+whstransfert+"','null',null,'"+whstransfert+"'))");
       
      
       
       
       h3 = st9.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res1+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'"); 
      
       h1 = st11.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res2+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
       
       h7 = st6.executeUpdate("insert into gss_transaction_range select t_r_trans_type, t_r_trans_whs,t_r_trans_no,"+res3+" ,'"+idact+"'code ,t_r_date from gss_transaction_range where t_r_rng_id='"+rp+"' and t_r_rng_act_id ='"+acp+"'");
       
     //  h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"')");

       h8 = st12.executeUpdate("UPDATE gss_range SET rng_inactif = 'I',rng_inactif_date=sysdate WHERE (rng_id='"+rp+"')and (act_id='"+acp+"') and rng_inactif='A' ");
          
          if (h8==0)
          {
         	 System.out.println("le rang est inactif");
         	 reintegrForm.setHiddenTest("rang deja touche");
         	 con.rollback();
              return mapping.findForward("reintegr");
         	 
          }
      break;
      
      
     }
     else 
     {
      System.out.println("dans le 4 else");
     }
     
      }
    
    
      }
    
    con.commit();
 con.close();
        }
        catch(SQLException ex){
	    	   ex.printStackTrace();
  		
	    	   con.rollback();
	           con.close(); 
	    	   throw ex;
			} 
        
        finally
        {
	    	con.close();
        }
   }
   
    
  
  
  
    
    String num="REI"+"-"+whh+"-"+max;
    request.setAttribute("num", num);
    System.out.println("le num de transaction"+num);
   return mapping.findForward("menu");
/*	editrapport( request,response,"REI",whh,max);
   
  ActionForward  forward = new RedirectingActionForward();
        forward.setPath("/afficher2.do");
        return forward; */
    
    //return null;
    
   // return mapping.findForward("envoipac");

    }
  
  
  public ActionForward editExcel(ActionMapping mapping, ActionForm form,
		   HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException  {
	  ReintegrForm reintegrForm = (ReintegrForm) form;
		
		List list =reintegrForm.getResulrang();
		String trans="Réintégration";
		
		StockAction stock=new StockAction();
		stock.editExcel(response, list, trans);
		  
		  return null;

} 
  
/*public String editrapport( HttpServletRequest request,HttpServletResponse response,String txt,String txt1,String txt2)
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
		  // - Paramètres à envoyer au rapport
		  Map parameters = new HashMap();
		  parameters.put("Titre", "Titre"); 
		  parameters.put("param1",new String ("'"+txt+"'"));
		 parameters.put("param2", new String("'"+txt1+"'"));
		  parameters.put("param3", new String("'"+txt2+"'"));
		  

		  JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
		  // pour l'affichage
//		  JasperViewer.viewReport(jasperPrint,false);
		  // - Création du rapport au format PDF
		JasperExportManager.exportReportToPdfFile(jasperPrint, "rapport4.pdf");

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment; filename=\"rapport4.pdf\"");
//		 Calculer le flux à renvoyer au client
		FileInputStream is = new FileInputStream("rapport4.pdf");
		byte buffer[] = new byte[1024];
		int nbLecture;
//		 Envoyer le flux dans la réponse
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
	}
   */
 } 
