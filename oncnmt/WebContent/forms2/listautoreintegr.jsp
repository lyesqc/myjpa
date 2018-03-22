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
    
    <title>listautoreintegr.jsp</title>

	 <layout:skin includeScript="true"/>
    
    <script>
	
	function setHidden(value){document.reintegrForm.hidden.value=value;}
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
  
  <layout:form action="/reintegr.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
      <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       
        <layout:panel  key="liste des autorisations de réintègration" width="500" styleClass="FORM" height="500">
       <center>
  
          <logic:notEmpty property="listeordre" name="reintegrForm">
         <layout:collection name="reintegrForm" property="listeordre" styleClass="SCROLL" styleClass="FORM" width="500" height="320">
           <layout:collectionItem title="ORDRE" property="ordre" sortable="true"></layout:collectionItem>
           
            <layout:collectionItem title="source" property="mag" sortable="true"></layout:collectionItem>
            
           <layout:collectionItem title="OUVRIR" property="ouvrir" action="/reintegr.do?hidden=ouvrir" paramId="type,whs,code" paramProperty="type,whs,code">
           <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
         </layout:collection>
  
   </logic:notEmpty >
  
  
     <logic:present parameter="hidden" scope="request">
    <logic:equal value="recherche" parameter="hidden" scope="request">
       <logic:present name="reintegrForm" >
         <logic:empty name="reintegrForm" property="listeordre">
        
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
	