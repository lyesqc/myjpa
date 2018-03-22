<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

  
  <html:html lang="true">
  <head>
    <html:base />

    <title>Rapport des transactions</title>
    <layout:skin includeScript="true"/>
    
      <script type="text/javascript">
	
	     function setHidden(value){document.reservationForm.hidden.value=value;}  

	     function verifrapport3()
		   {
	if((document.reservationForm.dat_rec_du.value=="")&&(document.reservationForm.dat_rec_au.value=="")&& (document.reservationForm.acteur.value=="")&&(document.reservationForm.destinataire.value==""))

	 {alert('Veuillez remplir au moins un critère de recherche SVP ');}
	 else{
	setHidden('rapportchercher');		  
	document.reservationForm.submit();  
		 }
	  }
	     
		 	
		function verifrapport()
	   {
setHidden('rapportchercher');		  
document.reservationForm.submit();  

  }

		function verifrapport2()
		   {
	setHidden('recherche_groupee');		  
	document.reservationForm.submit();  
	
	  }

		
		function vider()
		{
        document.reservationForm.trans.value=""; 
        document.reservationForm.dat_rec_du.value="";
        document.reservationForm.dat_rec_au.value="";
        document.reservationForm.destinataire.value="";
         document.reservationForm.acteur.value="";
         document.reservationForm.article.value="";
         document.reservationForm.profil.value="";
         document.reservationForm.hiddenTest.value="false";   
document.reservationForm.aprob.checked=false;
		}
		
		
		   function checkboxaprov() 
   {
 if  (document.reservationForm.aprob.checked)
{
 document.reservationForm.hiddenTest.value="true";
}
else
{

 document.reservationForm.hiddenTest.value="false";

} 
   }
		

		

		</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	

  </head>
  
 
   <body>
  
   <jsp:include page="menu.jsp"/>  
<hr>
  
  <layout:form action="/listreserv.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
    <layout:text property="hiddenTest" mode="H,H,H" value="default">   </layout:text>
    
      
      <layout:panel key="Recherche des réservations :" styleClass="FORM" width="820">
      <layout:row>
       <layout:column>
        <layout:text property="trans" key="Code de transaction :"></layout:text>
        <layout:date property="dat_rec_du" key="Date Réservation Du :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date debut" ></layout:date>
        <layout:date property="dat_rec_au" key="Date Réservation Au :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir la date fin" ></layout:date>
         </layout:column>
         
         
   <layout:column>
   
     <layout:select property="acteur" key="responsable:" styleClass="SCROLL" >
  <layout:option value=""></layout:option>
       <layout:options property="nomActeur"></layout:options>
       </layout:select>
          
         <layout:select property="destinataire" key="Distributeur/CDS:">
  <layout:option value=""></layout:option>
       <layout:options property="nomDestinataire"></layout:options>
       </layout:select>
       
           
         <layout:select property="warehouse" key="Région:" >
       <layout:option value=""></layout:option>
       <layout:option value="CENTRE"></layout:option>
       <layout:option value="EST"></layout:option>
       <layout:option value="OUEST"></layout:option>
       </layout:select>
   
        <layout:checkbox property="aprob"  key="Réservation Approuvée/Validée" value="aprob" onclick="checkboxaprov();" ></layout:checkbox>
      
   </layout:column>  

  
    </layout:row>  
    
    
       <layout:row>   
      <layout:column>
               <layout:select property="article" key="Article:">
  <layout:option value=""></layout:option>
       <layout:options property="nomArticle"></layout:options>
       </layout:select>
          </layout:column> 
          
             <layout:column> 
               <layout:select property="profil" key="Profil :">
  <layout:option value=""></layout:option>
       <layout:options property="listprof"></layout:options>
       </layout:select>
      

      </layout:column>  
        </layout:row>  
      
 <layout:row>
 <layout:column> 
  <layout:button onclick="verifrapport();">Recherche détaillée par N° res</layout:button> 
  </layout:column> 
  <layout:column> 
  <layout:button onclick="vider();">Réinitialiser</layout:button> 
  </layout:column> 
    <layout:column> 
  <layout:button onclick="verifrapport2();">Recherche groupée</layout:button> 
  </layout:column> 
  
  </layout:row>         
      </layout:panel>
      
      <layout:cell>
<div style="position:absolute;left:10px;width:820; height:400;overflow-y:scroll;">   
   
        <layout:panel  key="liste des réservations" width="800">
        <center>
  
          <logic:notEmpty property="listeordre" name="reservationForm">
          <layout:collection   name="reservationForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="800" >
         
     <layout:collectionItem  title="Réservation N°:" property="codreserv" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="distributeur" property="distributeur" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Date" property="dat" sortable="true"></layout:collectionItem> 
     <layout:collectionItem title="Responsable:" property="user" sortable="true"></layout:collectionItem> 
     <layout:collectionItem title="approbation/validation" property="aprob" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Annulation" property="annuler" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="BON TRANSACTION" property="bon" action="/listreserv.do?hidden=visualiser" paramId="codreserv" paramProperty="codreserv">
       <center> Visualiser le Bon </center>
       </layout:collectionItem>
     <layout:collectionItem title="Etat distribution"  action="/listreserv.do?hidden=ouvrir2" paramId="codreserv,distributeur" paramProperty="codreserv,distributeur">
       <center>Visualiser l'état distribution </center>
       </layout:collectionItem>
         </layout:collection>
       </logic:notEmpty >
     
  

       
   <logic:present  parameter="hidden" scope="request">
    <logic:equal value="rapportchercher" parameter="hidden" scope="request">  
     <logic:present name="reservationForm" >
      <logic:empty name="reservationForm" property="listeordre">
         <layout:panel key="Resultat de la recherche détaillée" styleClass="FORM">
            <center>
            <layout:message key="aucune réservation n'est en cours "/>
            </center>
         </layout:panel>
       </logic:empty>       
      </logic:present>
    </logic:equal>
 </logic:present> 
   



          <logic:notEmpty property="reserv2" name="reservationForm">
          <layout:collection   name="reservationForm" property="reserv2" styleClass="SCROLL" styleClass="FORM" width="800" >
         
     <layout:collectionItem  title="Article" property="aa" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="profil" property="pp" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Region" property="wh" sortable="true"></layout:collectionItem> 
     <layout:collectionItem title="Qte réservée:" property="qt" sortable="true"></layout:collectionItem> 
     <layout:collectionItem title="Qte livrée" property="qtt" sortable="true"></layout:collectionItem>
 


         </layout:collection>
       </logic:notEmpty >
     
  

       
   <logic:present  parameter="hidden" scope="request">
    <logic:equal value="recherche_groupee" parameter="hidden" scope="request">  
     <logic:present name="reservationForm" >
      <logic:empty name="reservationForm" property="reserv2">
         <layout:panel key="Resultat de la recherche groupée" styleClass="FORM">
            <center>
            <layout:message key="aucune réservation n'est en cours "/>
            </center>
         </layout:panel>
       </logic:empty>       
      </logic:present>
    </logic:equal>
 </logic:present> 


        </center>
        </layout:panel>

  </div>
  </layout:cell>
  
  </layout:form>
   
  </body>
</html:html>