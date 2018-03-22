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
    
    <title>list réservations</title>
    
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
  
  <layout:form action="/listreserv.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
      <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      
   
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       
        <layout:panel  key="liste des réservations " width="650">
       <center>
  
          <logic:notEmpty property="listeordre" name="reservationForm">
         <layout:collection name="reservationForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="650" height="200">
      
     <layout:collectionItem title="Réservation N°" property="codreserv" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Bon de commande N°" property="cmd" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="distinataire" property="distributeur" sortable="true"></layout:collectionItem>
    <layout:collectionItem title="date" property="date" sortable="true"></layout:collectionItem>
        
    <layout:collectionItem title="OUVRIR" property="ouvrir" action="/listreserv.do?hidden=ouvrir2" paramId="type,whs,code,dist,cmd" paramProperty="type,whs,code,dist,cmd">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
     
  
     <logic:present  parameter="hidden" scope="request">
    <logic:equal value="listreserv2" parameter="hidden" scope="request">
       <logic:present name="reservationForm" >
         <logic:empty name="reservationForm" property="listeordre">
         
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
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
</layout:column>      
</layout:row>
  
  
  </layout:form>
   
  </body>
</html:html>