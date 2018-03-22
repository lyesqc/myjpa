
  
   <%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<%@ page import="com.yourcompany.struts.form.RecepForm"%>



   <layout:dynMenu config="MainMenu" includeScript="true" left="100" top="65"  >
   
  <layout:menuItem  key="Mouvements">

<%

ArrayList priv = new ArrayList();
priv= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv.size();i++){
Profil profi =(Profil)priv.get(i);

if (profi.getProf().equals("AJOUTER RECEPTION")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>
   
 
     <layout:menuItem key="Réception"  >
     
                       <layout:menuItem key="Ajouter réception" page="/afficherecep.do"></layout:menuItem>
                   
     </layout:menuItem>
    
<%break;}} %>
 
     <layout:menuItem key="Packaging">

<%

ArrayList priv1p = new ArrayList();
priv1p= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv1p.size();i++){
Profil profi =(Profil)priv1p.get(i);

if (profi.getProf().equals("AJOUTER ORDRE PACKAGING")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>

       
           <layout:menuItem key="Ordre de packaging" page="/package.do"></layout:menuItem>  
           
<%break;}} %>


<%

ArrayList priv2p = new ArrayList();
priv2p= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv2p.size();i++){
Profil profi =(Profil)priv2p.get(i);

if (profi.getProf().equals("AJOUTER ENVOI PACKAGING")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>
          
           <layout:menuItem key="Envoie packaging" page="/afficher3.do"></layout:menuItem> 
           
<%break;}} %>


<%

ArrayList priv3p = new ArrayList();
priv3p= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv3p.size();i++){
Profil profi =(Profil)priv3p.get(i);

if (profi.getProf().equals("AJOUTER RECEP PACKAGING")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>

           <layout:menuItem key="Reception packaging" page="/afficher4.do"></layout:menuItem>   

<%break;}} %>  

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
       
          <layout:menuItem key="Ordre de transfert" page="/ordretrans1.do?hidden=afficher"></layout:menuItem>  

<%break;}} %>  



          <%

ArrayList priv2t = new ArrayList();
priv2t= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv2t.size();i++){
Profil profi =(Profil)priv2t.get(i);

if (profi.getProf().equals("AJOUTER ENVOI TRANSFERT")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>        






 <layout:menuItem key="Envoie transfert" page="/afficher.do"></layout:menuItem> 


<%break;}} %> 



          <%

ArrayList priv3t = new ArrayList();
priv3t= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv3t.size();i++){
Profil profi =(Profil)priv3t.get(i);

if (profi.getProf().equals("AJOUTER RECEP TRANSFERT")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  


 <layout:menuItem key="Reception transfert" page="/afficher1.do" ></layout:menuItem>             
     
<%break;}} %>


</layout:menuItem>
        
     <layout:menuItem key="Sortie">
     
  <%

ArrayList privs = new ArrayList();
privs= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<privs.size();i++){
Profil profi =(Profil)privs.get(i);
String profil=profi.getProf();
request.getSession().setAttribute("PROFILAUTOSORTIE",profil);



if ((profi.getProf().equals("AUTO SORTIE"))||(profi.getProf().equals("AUTO SORTIE VOUTCHER"))){

%>  
       
         <layout:menuItem key="Autorisation de sortie sans réservation" page="/autosorti.do?hidden=afficher"></layout:menuItem> 
         
         
        <layout:menuItem key="Autorisation de sortie avec réservation" page="/autosorti.do?hidden=afficherreserv"></layout:menuItem> 
       
         
             <%break;}} %>
             
 <%

ArrayList privs1 = new ArrayList();
privs1= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<privs1.size();i++){
Profil profi =(Profil)privs1.get(i);

if (profi.getProf().equals("SORTIE")){

String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  
 
 
              
         <layout:menuItem key="Exécution sortie" page="/afficher5.do"></layout:menuItem> 
         
  <%break;}} %>    
                
     </layout:menuItem>
     
       <layout:menuItem key="Reintégration">
      
      
         <%



ArrayList priv1r = new ArrayList();
priv1r= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv1r.size();i++){
Profil profi =(Profil)priv1r.get(i);

if (profi.getProf().equals("AJOUTER AUTO REINTEGRATION")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  
       
         <layout:menuItem key="Autorisation de reintégration" page="/autoreintegr.do"></layout:menuItem> 
         
    <%break;}} %>
    
    
    
    
    <%

ArrayList priv2r = new ArrayList();
priv2r= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<priv2r.size();i++){
Profil profi =(Profil)priv2r.get(i);

if (profi.getProf().equals("AJOUTER REINTEGRATION")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>  
          
         <layout:menuItem key="Exécution reintégration"page="/afficher2.do"></layout:menuItem> 
            
      <%break;}} %>
                   
      </layout:menuItem>
             
  </layout:menuItem>
  
  <layout:menuItem key="Action">
 
 <layout:menuItem key="Activation Postpaid">
      
      <%

ArrayList PRIVI = new ArrayList();
PRIVI= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIVI.size();i++){
Profil profi =(Profil)PRIVI.get(i);

if (profi.getProf().equals("DEMANDE POSTPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>
                              <layout:menuItem key="Demande d'activation">
                                <layout:menuItem key="Pré/Activé" page="/preactivpost.do"></layout:menuItem>
                               <layout:menuItem key="Non/Activé" page="/nonactivpost.do?param=demandactiv"></layout:menuItem>
                              </layout:menuItem>
    
<%break;}}%>
 
 <%

ArrayList POST = new ArrayList();
POST= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<POST.size();i++){
Profil profi =(Profil)POST.get(i);

if (profi.getProf().equals("CONFIRMATION POSTPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>


                         
                              <layout:menuItem key="Confirmation d'activation" page="/preparConfirm.do">
                              </layout:menuItem>
                              
<%break;}}%>                              
                                
           
  </layout:menuItem>
  
  <layout:menuItem key="Activation Prepaid">
       
<%

ArrayList PRIV2 = new ArrayList();
PRIV2= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRIV2.size();i++){
Profil profi =(Profil)PRIV2.get(i);

if (profi.getProf().equals("DEMANDE PREPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("demandpre",whs);

%>
      
     
                              <layout:menuItem key="Demande d'activation" page="/preparPre.do"> </layout:menuItem>
<%break;}}%>  

<%

ArrayList PRE = new ArrayList();
PRE= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRE.size();i++){
Profil profi =(Profil)PRE.get(i);

if (profi.getProf().equals("CONFIRMATION PREPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("confirmpre",whs);

%>                            
                                                   
                             <layout:menuItem key="Confirmation d'activation" page="/confirmPrepaid.do?hidden=ouvrir"></layout:menuItem>
                             
<%break;}}%>                                     
                  
      </layout:menuItem>
      
            <layout:menuItem key="Chargement Scratch"> 
      
 <%

ArrayList SCR = new ArrayList();
SCR= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<SCR.size();i++){
Profil profi =(Profil)SCR.get(i);

if (profi.getProf().equals("DEMANDE CHARGEMENT SCRATCH")){
String whs=profi.getWhs();
request.getSession().setAttribute("demandesrc",whs);

%> 
        <layout:menuItem key="Demande de chargement" page="/preparScr.do"> </layout:menuItem>
        
<%break;}}%> 

 <%

ArrayList SCR2 = new ArrayList();
SCR2= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<SCR2.size();i++){
Profil profi =(Profil)SCR2.get(i);

if (profi.getProf().equals("CONFIRMATION CHARGEMENT SCRATCH")){
String whs=profi.getWhs();
request.getSession().setAttribute("confirscr",whs);

%> 
         <layout:menuItem key="Confirmation de chargement" page="/confirmChargement.do?hidden=ouvrir"> </layout:menuItem>
         
<%break;}}%>         
      
       </layout:menuItem> 
       
      <layout:menuItem key="Affectation statut">
                   <layout:menuItem key="Affectation Swap">  
                   
<%

ArrayList PRI = new ArrayList();
PRI= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRI.size();i++){
Profil profi =(Profil)PRI.get(i);

if (profi.getProf().equals("DEMANDE SWAP POSTPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>         
                    
                     <layout:menuItem key="Demande Swap/Postpaid" page="/preparSwpo.do"> </layout:menuItem>
                    
                     
<%break;}}%> 

<%

ArrayList WPO = new ArrayList();
WPO= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<WPO.size();i++){
Profil profi =(Profil)WPO.get(i);

if (profi.getProf().equals("CONFIRMATION SWAP POSTPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%> 

                  <layout:menuItem key="Confirmation Swap/Postpaid" page="/confirmSwpo.do?param=confirmpostswap"> </layout:menuItem>   
                  
<%break;}}%> 

<%

ArrayList WPR = new ArrayList();
WPR= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<WPR.size();i++){
Profil profi =(Profil)WPR.get(i);

if (profi.getProf().equals("DEMANDE SWAP PREPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>                   
                     
                     <layout:menuItem key="Demande Swap/Prepaid" page="/preparSwpr.do"> </layout:menuItem>
                     
<%break;}}%> 

<%

ArrayList WPR2 = new ArrayList();
WPR2= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<WPR2.size();i++){
Profil profi =(Profil)WPR2.get(i);

if (profi.getProf().equals("DEMANDE SWAP PREPAID")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%> 

                     
                     <layout:menuItem key="Confirmation Swap/Prepaid" page="/confirmSwpr.do"> </layout:menuItem>
                     
<%break;}}%>                     
                 
                   </layout:menuItem>
                   
                 <layout:menuItem key="affectation profil prepaid" >  
                   <%

ArrayList PROM1 = new ArrayList();
PROM1= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PROM1.size();i++){
Profil profi =(Profil)PROM1.get(i);

if (profi.getProf().equals("AFFECTATION PROMOTION")){
String whs=profi.getWhs();
request.getSession().setAttribute("affprofpre",whs);

%>                   
                     
                     <layout:menuItem key="Demande d'affectation" page="/nonactivpost.do?param=demandempromo"> </layout:menuItem>
                     
<%break;}}%> 

<%

ArrayList PROM2 = new ArrayList();
PROM2= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PROM2.size();i++){
Profil profi =(Profil)PROM2.get(i);

if ((profi.getProf().equals("CONFIRMATION PROMOTION"))||(profi.getProf().equals("CONFIRMATION SWAP POSTPAID"))){
String whs=profi.getWhs();
request.getSession().setAttribute("confprofpre",whs);

%> 

                     
                    <layout:menuItem key="Confirmation d'affectation" page="/confirmSwpo.do?param=confirmpromo">   </layout:menuItem>
                     
<%break;}}%>  
                   
                   
      </layout:menuItem>             
       
      <%

ArrayList PROM3 = new ArrayList();
PROM3= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PROM3.size();i++){
Profil profi =(Profil)PROM3.get(i);

if (profi.getProf().equals("AFFECT PROMO SCRATCH")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>         
                    
                     <layout:menuItem key="affectation promotion/sécurité scratch" page="/nonactivpost.do?param=affpromoscratch"> </layout:menuItem>
                    
                     
<%break;}}%>                   
                   
<%

ArrayList PRV = new ArrayList();
PRV= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<PRV.size();i++){
Profil profi =(Profil)PRV.get(i);

if (profi.getProf().equals("AFFECTATION STATUT")){


%>
                   <layout:menuItem key="Affectation Test" page="/preparTest.do">   </layout:menuItem>
                   <layout:menuItem key="Affectation Perdu" page="/preparPerdu.do">   </layout:menuItem>
                   <layout:menuItem key="Affectation Défecteux" page="/preparDefect.do">   </layout:menuItem>
                             
<%break;}}%>                    
</layout:menuItem>

   
 <layout:menuItem key="Désactivation SIMS et SCRATCHS"> 
      
      <%     

ArrayList DDE = new ArrayList();
DDE= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<DDE.size();i++){
Profil profi =(Profil)DDE.get(i);

if (profi.getProf().equals("DEMANDE DESACTIVATION")){

	

%>
    <layout:menuItem key="demande de désactivation"  page="/nonactivpost.do?param=demanddesactiv"> </layout:menuItem>             
                             
<%break;}}%> 

      <%     

ArrayList CDE = new ArrayList();
CDE= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<CDE.size();i++){
Profil profi =(Profil)CDE.get(i);

if (profi.getProf().equals("CONFIRMATION DESACTIVATION")){

	

%>
    <layout:menuItem key="confirmation de désactivation"  page="/nonactivpost.do?param=confirmdesactiv"> </layout:menuItem>             
                             
<%break;}}%> 
      
</layout:menuItem>  
   
     
<layout:menuItem key="Annulation transaction">

<%

ArrayList ANN = new ArrayList();
ANN= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<ANN.size();i++){
Profil profi =(Profil)ANN.get(i);

if (profi.getProf().equals("ANNULER TRANS")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>


               <layout:menuItem key="annuler une transaction" page="/annuler.do?hidden=afficher"></layout:menuItem> 
    
 <%break;}}%>  
 
   </layout:menuItem>  
      
       <layout:menuItem key="Réservation" >
    <%

ArrayList RES1 = new ArrayList();
RES1= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<RES1.size();i++){
Profil profi =(Profil)RES1.get(i);

if (profi.getProf().equals("AJOUTER RESERVATION")){
String whs=profi.getWhs();
String profil=profi.getProfil();
request.getSession().setAttribute("whs_dist_ajout",whs);
request.getSession().setAttribute("profil_ajouter",profil);

%>      
             <layout:menuItem key="ajouter une réservation" page="/preparReserv.do"> </layout:menuItem>
            
<%break;}}%> 

 <%

ArrayList RES2 = new ArrayList();
RES2= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<RES2.size();i++){
Profil profi =(Profil)RES2.get(i);

if (profi.getProf().equals("MODIFIER RESERVATION")){
String whs=profi.getWhs();
String profil=profi.getProfil();

request.getSession().setAttribute("region_modif",whs);
request.getSession().setAttribute("profil_modifier",profil);

if (profil.equals("RESPONSABLE CDS")||profil.equals("CHARGE DE COMPTE")||profil.equals("SUPERVISEUR DE COMPTE"))
{
%>      
             <layout:menuItem key="Modifier une réservation" page="/listreserv.do?hidden=listreserv"> </layout:menuItem>

<%break;}}}%>

    <%

ArrayList RES_modif = new ArrayList();
RES_modif= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<RES_modif.size();i++){
Profil profi =(Profil)RES_modif.get(i);

if (profi.getProf().equals("MODIFIER RESERVATION")){
String whs=profi.getWhs();
String profil=profi.getProfil();

request.getSession().setAttribute("region_modif",whs);
request.getSession().setAttribute("profil_modifier",profil);


if (profil.equals("COORDINATEUR REGION"))
{
%>      
             <layout:menuItem key="Modifier une réservation" page="/listreserv.do?hidden=inialisermodif"> </layout:menuItem>

 
<%break;}}}%>


  <%

ArrayList RES3 = new ArrayList();
RES3= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<RES3.size();i++){
Profil profi =(Profil)RES3.get(i);

if (profi.getProf().equals("VISAULISER RESERVATION")){
String whs=profi.getWhs();
String profil=profi.getProfil();

request.getSession().setAttribute("region_visualisation",whs);
request.getSession().setAttribute("profil_visualiser",profil);

%>
           <layout:menuItem key="rapport des réservations" page="/listreserv.do?hidden=rapportreserv"> </layout:menuItem>
<%break;}}%> 
          
</layout:menuItem> 


<%

ArrayList aprob = new ArrayList();
aprob= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<aprob.size();i++){
Profil profi =(Profil)aprob.get(i);

if ((profi.getProf().equals("APPROBATION"))){
String whs=profi.getWhs();
String prof=profi.getProf();
request.getSession().setAttribute("region_validation",whs);
request.getSession().setAttribute("profilvalidation",prof);

%>     
 
     <layout:menuItem key="Approbation/Validation" page="/approbation.do?hidden=recherche">   </layout:menuItem> 
     
     <%break;}}%> 

<%

ArrayList valid = new ArrayList();
valid= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<valid.size();i++){
Profil profi =(Profil)aprob.get(i);

if ((profi.getProf().equals("VALIDATION"))){
String whs=profi.getWhs();
String prof=profi.getProf();
request.getSession().setAttribute("region_validation",whs);
request.getSession().setAttribute("profilvalidation",prof);

%>     
 
     <layout:menuItem key="Approbation/Validation" page="/approbation.do?hidden=inialiservalid">   </layout:menuItem> 
     
     <%break;}}%>



 <%

ArrayList POST = new ArrayList();
POST= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<POST.size();i++){
Profil profi =(Profil)POST.get(i);

if (profi.getProf().equals("VALIDATION TRANSACTION")){
String whs=profi.getWhs();
request.getSession().setAttribute("werhs",whs);

%>


                         
                              <layout:menuItem key="Validation des transactions" page="/approbation.do?hidden=initiallisttransaction">
                              </layout:menuItem>
                              
<%break;}}%>   
     
   

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
   
      <%

ArrayList DIST = new ArrayList();
DIST= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<DIST.size();i++){
Profil profi =(Profil)DIST.get(i);

if (profi.getProf().equals("VISAULISER ETAT DIST")){

%>                   
                   
              <layout:menuItem key="Ready for distribution" page="/stock.do?hidden=ready"></layout:menuItem>
                      <layout:menuItem key="Etat distribution" link="javascript:window.open('stock.do?hidden=preparetatdist','','location=250,status=0,scrollbars=0,width=350,height=350');void('');" ></layout:menuItem>
     <%break;}}%> 
     
               <%

ArrayList rapport = new ArrayList();
rapport= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<rapport.size();i++){
Profil profi =(Profil)rapport.get(i);

if (profi.getProf().equals("VISAULISER RAPPORT GLOBAL")){

%>                   
<layout:menuItem key="Rapport global" link="javascript:window.open('rapport_global.do?hidden=initial_rapport','','location=250,status=0,scrollbars=0,width=350,height=350');void('');" ></layout:menuItem>
  
  
     <%break;}}%> 
     
                     <%

ArrayList rapportr = new ArrayList();
rapportr= (ArrayList)request.getSession().getAttribute("privilege");
for ( int i=0;i<rapportr.size();i++){
Profil profi =(Profil)rapportr.get(i);
request.getSession().setAttribute("profil_visualiser_rapport",profi.getProfil());

if (profi.getProf().equals("VISAULISER RAPPORT RESERVATION")){

%>                   
<layout:menuItem key="Rapport réservation  global" page="/rapport_global.do?hidden=initial_rapport_reservation" ></layout:menuItem>
  
  
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
                                <layout:menuItem key="Paramètrage distributeur"    page="/afficherparametre.do?param=DISTRIBUTEUR" ></layout:menuItem> 
                                <layout:menuItem key="Paramètrage fournisseur"     page="/afficherparametre.do?param=FOURNISSEUR" ></layout:menuItem> 
                                <layout:menuItem key="Paramètrage partenaire"      page="/afficherparametre.do?param=PARTENAIRE" ></layout:menuItem> 
                                <layout:menuItem key="Paramètrage CDS"             page="/afficherparametre.do?param=CDS" ></layout:menuItem> 
                                <layout:menuItem key="Paramètrage SORTIE DIVERSE"  page="/afficherparametre.do?param=SORTIE DIVERSE" ></layout:menuItem> 
                                <layout:menuItem key="Paramètrage article"         page="/parametre1.do?hidden=afficheraricle " ></layout:menuItem>   
                                <layout:menuItem key="Paramètrage warehouse"       page="/parametre1.do?hidden=afficherwarehouse" ></layout:menuItem>   
                                 
    <%break;}}%>
                                 
                               
                    
                      
                      
   </layout:menuItem>
  
      <layout:menuItem  key="Déconnexion "  link="forms/login.jsp"> 
      
      </layout:menuItem>
  
 </layout:dynMenu>