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
   
   
     <logic:present  parameter="hidden" scope="session">
    <logic:equal value="inialisermodif" parameter="hidden" scope="session">
       <logic:present name="reservationForm" >
        <layout:row >
          <layout:column width="280"></layout:column>
         <layout:column >
          <layout:select property="warehouse" key="Sélectionnez une région SVP:" >
       <layout:option value=""></layout:option>
       <layout:option value="CENTRE"></layout:option>
        <layout:option value="EST"></layout:option>
        <layout:option value="OUEST"></layout:option>
       </layout:select>
       </layout:column>
      
           <layout:column> <layout:submit onclick="setHidden('listreserv',document.reservationForm);">afficher les réservations</layout:submit> </layout:column>
      
       </layout:row>
       
    </logic:present>
    </logic:equal>
    </logic:present>   
   
     <layout:cell>
<div style="position:absolute;left:10px;width:820; height:400;overflow-y:scroll;">  

        <layout:panel  key="liste des réservations des distributeurs/CDS" width="650">
       <center>
  
          <logic:notEmpty property="listeordre" name="reservationForm">
         <layout:collection name="reservationForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="800" >
         
     <layout:collectionItem title="Réservation N°" property="codreserv" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Bon de commande N°" property="cmd" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="Date réservation" property="date" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="Distributeur/CDS" property="distributeur" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="APPROBATION/VALIDATION" property="aprob" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="OUVRIR" property="ouvrir" action="/listreserv.do?hidden=ouvrir" paramId="type,whs,code,dist,aprobb,cmd" paramProperty="type,whs,code,dist,aprobb,cmd">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
     
  
     <logic:present  parameter="hidden" scope="request">
    <logic:equal value="listreserv" parameter="hidden" scope="request">
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

  </div>
  </layout:cell>
  
  </layout:form>
   
  </body>
</html:html>