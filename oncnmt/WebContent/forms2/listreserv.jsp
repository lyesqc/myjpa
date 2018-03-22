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
<hr>
  
  <layout:form action="/approbation.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
  
  
   
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       <layout:write property="writ1"  >  </layout:write>
       </layout:column>
       </layout:row>
       <layout:space></layout:space>

  <logic:present  parameter="hidden" scope="session">
    <logic:equal value="inialiservalid" parameter="hidden" scope="session">
       <logic:present name="approbationForm" >
        <layout:row >
          <layout:column width="280"></layout:column>
         <layout:column >
          <layout:select property="region" key="Sélectionnez une région SVP:" >
       <layout:option value=""></layout:option>
       <layout:option value="CENTRE"></layout:option>
        <layout:option value="EST"></layout:option>
        <layout:option value="OUEST"></layout:option>
       </layout:select>
       </layout:column>
      
           <layout:column> <layout:submit onclick="setHidden('recherche',document.approbationForm);">afficher les réservations</layout:submit> </layout:column>
      
       </layout:row>
       
    </logic:present>
    </logic:equal>
    </logic:present>   

    
   <layout:cell>
<div style="position:absolute;left:250px;width:550; height:350;overflow-y:scroll;">   
       
        
          <logic:notEmpty property="listeordre" name="approbationForm">
         <layout:collection name="approbationForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="530" >
         
     <layout:collectionItem title="Réservation N°" property="codreserv" sortable="true"></layout:collectionItem>
    
        <layout:collectionItem title="date réservation" property="date" sortable="true"></layout:collectionItem>
        
            <layout:collectionItem title="Destinataire" property="distributeur" sortable="true"></layout:collectionItem>
            
           <layout:collectionItem title="OUVRIR" property="ouvrir" action="/approbation.do?hidden=ouvrir" paramId="type,whs,code,dist" paramProperty="type,whs,code,dist">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
     
  
     <logic:present  parameter="hidden" scope="request">
    <logic:equal value="recherche" parameter="hidden" scope="request">
       <logic:present name="approbationForm" >
         <logic:empty name="approbationForm" property="listeordre">
         
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <center>
            <layout:message key="aucune réservation n'est en cours "/>
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