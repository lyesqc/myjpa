
<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>list réservation</title>
    
     <layout:skin includeScript="true"/>
 <script type="text/javascript" src="config/javascript.js"></script>
     
         

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
<jsp:include page="menu.jsp"/> 


    <layout:form action="/approbation.do">


   <layout:row>
        <layout:column width="300">
      </layout:column>
      <layout:column>  
      <h2 >
          Approbation  Des  Transactions 
      </h2>
  </layout:column>
        </layout:row>
   

   <layout:row >
  <layout:column width="120"></layout:column>
<layout:column >

     <layout:select property="transaction" key="Sélectionnez une transaction SVP:" >
       <layout:option value=""></layout:option>
       <layout:options property="listtransaction"></layout:options>
</layout:select>
    
<layout:space></layout:space>
 <layout:submit onclick="setHidden('afficher_list_transaction',document.approbationForm);">afficher les transactions</layout:submit>

</layout:column>
</layout:row>

 

      <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
    
<layout:space></layout:space>

     <layout:row >
  <layout:column width="300"></layout:column>
<layout:column >
  <h3 >
  la liste des transactions à Approuver 
  </h3 >
</layout:column >
 
  </layout:row>
     

    
    
   <layout:cell>
<div style="position:absolute;left:200px;width:600; height:350;overflow-y:scroll; border:solid 1px red;">   
       
        
          <logic:notEmpty property="listeordre" name="approbationForm">
         <layout:collection name="approbationForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="580" >
         
     <layout:collectionItem title="Transaction N°" property="code" sortable="true"></layout:collectionItem>
    
        <layout:collectionItem title="date transaction" property="date" sortable="true"></layout:collectionItem>
        
            <layout:collectionItem title="Destinataire" property="dist" sortable="true"></layout:collectionItem>
            
            
               <layout:collectionItem title="date limite d'envoi " property="dat" sortable="true"></layout:collectionItem>
        
          <layout:collectionItem title="Responsable" property="user" sortable="true"></layout:collectionItem>

           <layout:collectionItem title="Afficher le détail" property="ouvrir" action="/approbation.do?hidden=afficher_detail_transaction" paramId="code,dist,mag,whs" paramProperty="code,dist,mag,whs">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
     
  
     <logic:present  parameter="hidden" scope="request">
    <logic:equal value="afficher_list_transaction" parameter="hidden" scope="request">
       <logic:present name="approbationForm" >
         <logic:empty name="approbationForm" property="listeordre">
         
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <center>
            <layout:message key="aucune transaction n'est en cour "/>
       </center>
         </layout:panel>
        
         </logic:empty>
       </logic:present>
    </logic:equal>
 </logic:present> 
  
 
  </div>
  </layout:cell>

 
  </layout:form>
   
  </body>
</html:html>