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
    
    <title>Liste des ordres packaging</title>
    <layout:skin includeScript="true"/>
    
    <script>
	
	function setHidden(value){document.envoiForm.hidden.value=value;}
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
  
  
  <layout:form action="/envoi.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
   
      <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
      
     
      <layout:panel  key="liste des ordres de packaging" width="500" styleClass="FORM" height="500">
       <center>
         <logic:notEmpty property="listeordre" name="envoiForm">
         <layout:collection name="envoiForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="500" height="320">
           <layout:collectionItem title="ORDRE" property="ordre" sortable="true"></layout:collectionItem>
           
            <layout:collectionItem title="Date limite" property="date" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="Priorite" property="prio" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="Partenaire" property="part" ></layout:collectionItem>
            
           <layout:collectionItem title="OUVRIR" property="ouvrir" action="/envoi.do?hidden=ouvrir" paramId="type,whs,code,partt,dat" paramProperty="type,whs,code,partt,dat">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
  </logic:notEmpty>
  
  
   <logic:present parameter="hidden" scope="request">
    <logic:equal value="listordre" parameter="hidden" scope="request">
       <logic:present name="envoiForm" >
         <logic:empty name="envoiForm" property="listeordre">
             <layout:row>
         <layout:column width="150"></layout:column>
         <layout:column>
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
        
            <layout:message key="aucun ordre "/>
            
         </layout:panel>
       </layout:column>
       </layout:row>
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
