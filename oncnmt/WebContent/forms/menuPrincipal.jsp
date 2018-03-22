
<%@ page language="java" pageEncoding="ISO-8859-1"%>
<jsp:directive.page import="com.yourcompany.struts.UtilBean.Profil"/>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<layout:html>
 <head>
 <title>Menu Principal</title>
 <layout:skin includeScript="true"/>
  <script type="text/javascript">
</script >
 

 
 <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
 </head>
  
  
  <body>
  <div class="index2">
 <layout:img src="../images/gess2.JPG"/>
  </div>
   <layout:dynMenu config="MainMenu" includeScript="true" left="100" top="68">
   
 <layout:menuItem  key="Mouvements">
<layout:menuItem key="Réception"  >
<%
String act= (String)request.getSession().getAttribute("username");

ArrayList priv = new ArrayList();
priv= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv.size();i++){
Profil profi =(Profil)priv.get(i);
String whs = "";
if (profi.getProf().equals("AJOUTER RECEPTION")){
 whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>
   
 
     
     
                      <layout:menuItem key="Ajouter réception" page="/recepxls.do?hidden=initial"></layout:menuItem> 
                   <
				   <%break;}}%>

 </layout:menuItem>
   
     
      <layout:menuItem key="Transfert">


<%

ArrayList priv1t = new ArrayList();
priv1t= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv1t.size();i++){
Profil profi =(Profil)priv1t.get(i);

if (profi.getProf().equals("AJOUTER ORDRE TRANSFERT")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>
       
          <layout:menuItem key="Transfert" page="/transfert.do?hidden=load"></layout:menuItem>  

<%break;}} %>  



      


</layout:menuItem>
        
     <layout:menuItem key="Sortie">
     
  
             
 <%

ArrayList privs1 = new ArrayList();
privs1= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<privs1.size();i++){
Profil profi =(Profil)privs1.get(i);

if (profi.getProf().equals("SORTIE")){

String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  
 
 
              
         <layout:menuItem key="Exécution sortie" page="/sortie.do?hidden=load"></layout:menuItem> 
         
  <%break;}} %>    
                
     </layout:menuItem>
     
       <layout:menuItem key="Reintégration">
      
      

    
    
    
    
    <%

ArrayList priv2r = new ArrayList();
priv2r= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv2r.size();i++){
Profil profi =(Profil)priv2r.get(i);

if (profi.getProf().equals("AJOUTER REINTEGRATION")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  
          
         <layout:menuItem key="Exécution reintégration"page="/reint.do?hidden=afficher"></layout:menuItem> 
            
      <%break;}} %>
                   
      </layout:menuItem>
	  
	  
	  
	  <layout:menuItem key="Retour Fournisseur">
	  <%

ArrayList PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("RETOUR FOURNISSEUR")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>                                 
                             
                                <layout:menuItem key="Retour Fournisseur"       page="/return.do?hidden=afficher" >
                                </layout:menuItem>   
                           <%break;}} %> 
             
  </layout:menuItem>
             
  </layout:menuItem>
  
  
  <layout:menuItem key="Edition">
 
  <%

ArrayList TRANS = new ArrayList();
TRANS= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<TRANS.size();i++){
Profil profi =(Profil)TRANS.get(i);

if (profi.getProf().equals("VISAULISER TRANS")){

%>
<layout:menuItem key="Rapport des transactions" page="/recherche.do"></layout:menuItem>
 <layout:menuItem key="Bon des transaction" link="javascript:window.open('rechedit.do','','location=250,status=0,scrollbars=0,width=350,height=250');void('');" ></layout:menuItem>
    <%break;}}%>  
    
  <%

ArrayList stok = new ArrayList();
stok= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<stok.size();i++){
Profil profi =(Profil)stok.get(i);

if (profi.getProf().equals("VISAULISER ETAT STOCK")){

%>     
   
<layout:menuItem key="Etat de Stock" page="/preparStk.do"></layout:menuItem>
 <%break;}}%> 
   
     
     
              
     
                     
</layout:menuItem>
     
   <layout:menuItem key="Administration">
   
                     
                      
                      
                       <%

ArrayList PRIVA = new ArrayList();
PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("AJOUTER UTILISATEUR")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%> 
                      
    
                                 <layout:menuItem key="Paramètrage utilisateur"     page="/preparparametre.do"   ></layout:menuItem>   
                                
    <%break;}}%>
                                 
 
  
  <%


PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("AJOUTER FOURNISSEUR")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%> 
  <layout:menuItem key="Paramètrage fournisseur"     page="/afficherparametre.do?param=FOURNISSEUR" ></layout:menuItem> 
                               
         <%break;}} %>                      
                               
                               
                         
                                
<%

PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("AJOUTER CDS")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>                 
                                
                                <layout:menuItem key="Paramètrage CDS"             page="/afficherparametre.do?param=CDS" ></layout:menuItem> 
                                
                                <%break;}} %>
             
            
                               
                 <%

PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("AJOUTER ARTICLE")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>                        
                                <layout:menuItem key="Paramètrage article"         page="/parametre1.do?hidden=afficheraricle " ></layout:menuItem>   
                                
                                <%break;}} %>
<%

PRIVA= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVA.size();i++){
Profil profi =(Profil)PRIVA.get(i);

if (profi.getProf().equals("AJOUTER WAREHOUSE")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>                                 
                             
                                <layout:menuItem key="Paramètrage warehouse"       page="/parametre1.do?hidden=afficherwarehouse" >
                                </layout:menuItem>   
                           <%break;}} %>    
                          
                  </layout:menuItem>               
      <layout:menuItem  key="Déconnexion "  link="forms/login.jsp"> 
      
      </layout:menuItem>
 </layout:dynMenu>
 <hr>
  </body>
</layout:html>
