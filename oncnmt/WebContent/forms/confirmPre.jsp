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
    
    <title>Liste des demandes Prepaid</title>
 <layout:skin includeScript="true"/>
 
   <script>
	function setHidden(value){document.activationPreForm.hidden.value=value;}
	
	</script>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body>
    
 <layout:img src="../images/entete2.JPG" width="100%"/>

  
<jsp:include page="menu.jsp"/>  
 <hr>
    
  
    <layout:form action="/confirmPrepaid.do" method="post" onsubmit="return false;">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
     
      
       <layout:row width="700">
       <layout:column width="500"></layout:column>
       <layout:column width="300">
       
       <layout:panel  key="LISTE DES DEMANDES D'ACTIVATION PREPAID" width="350" align="center">
       <center>
       <layout:collection name="activationPreForm" property="demandepre"  styleClass="SCROLL" styleClass="FORM" width="350" height="400">
            <layout:collectionItem title="DEMANDE N°" property="demande"></layout:collectionItem>
            <layout:collectionItem title="OUVRIR" property="ouvrir" action="/confirmPrepaid.do?hidden=ouvrir" paramId="no" paramProperty="no">
             <center> <layout:img srcName="ok.GIF" border="0"></layout:img> </center>
           </layout:collectionItem>
        </layout:collection>
        </center>
        </layout:panel>
</layout:column>      
</layout:row>
        
      </layout:form>
  </body>
</html:html>
