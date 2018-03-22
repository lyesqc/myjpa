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
    
    <title>activation</title>
 <layout:skin includeScript="true"/>
 
   <script>
	function setHidden(value){document.activationpostForm.hidden.value=value;}
	
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
    <layout:form action="/confirmActiv.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
      <layout:space></layout:space>
            
    
      <layout:space></layout:space>
      
       <layout:row width="700">
       <layout:column width="400"></layout:column>
       <layout:column width="300">
       
        <layout:panel  key="LISTE DES DEMANDES D'ACTIVATION POSTPAID" width="500">
       <center>
       <layout:collection name="confirmActivForm" property="demandepost"  styleClass="SCROLL" styleClass="FORM" width="500" height="320">
            <layout:collectionItem title="DEMANDE N°" property="demande"></layout:collectionItem>
           <layout:collectionItem title="DESTINATION" property="destination" sortable="true"></layout:collectionItem>
           <layout:collectionItem title="OUVRIR" property="ouvrir" action="/confirmActiv.do?hidden=ouvrir" paramId="no,dest" paramProperty="no,dest">
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
