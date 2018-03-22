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
    
    <title>listreserv.jsp</title>
    
     <layout:skin includeScript="true"/>

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
 
  
  <layout:form action="/autosorti.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
      <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      <layout:row >

     

</layout:row >  
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       
        <layout:panel  key="liste des  réservations " width="550">
      <center>
  
          <logic:notEmpty property="listeordre" name="sortiForm">
         <layout:collection name="sortiForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="550" height="250">
          
            <layout:collectionItem title="Bon de commande N°" property="ordre" sortable="true"></layout:collectionItem>
           
            <layout:collectionItem title="Réservation/ N°" property="codreserv" sortable="true"></layout:collectionItem>
           
          
          
            <layout:collectionItem title="Date réservation" property="date" sortable="true"></layout:collectionItem>
           
            <layout:collectionItem title="distributeur" property="distributeur" sortable="true"></layout:collectionItem>
            
           <layout:collectionItem title="OUVRIR" property="ouvrir" action="/autosorti.do?hidden=ouvriraprob" paramId="type,whs,code,dist,cmd,codreserv" paramProperty="type,whs,code,dist,cmd,codreserv">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
  
  
     <logic:present parameter="hidden" scope="request">
    <logic:equal value="listaprob" parameter="hidden" scope="request">
       <logic:present name="sortiForm" >
         <logic:empty name="sortiForm" property="listeordre">
        
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <layout:message key="aucune réservation n'est en cours "/>
         </layout:panel>
       
         </logic:empty>
       </logic:present>
    </logic:equal>
 </logic:present> 
  
     </center>
        </layout:panel>
</layout:column>      
</layout:row>
  
  
  </layout:form>
   
  </body>
</html:html>