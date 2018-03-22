
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
    
    <title>réservation.jsp</title>

	 <layout:skin includeScript="true"/>
 <script type="text/javascript" src="config/javascript.js">
   
   </script>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body >
   
 
  
     <layout:form action="/autosorti.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>

     
        <layout:row>
  <layout:column>
  <layout:text property="codreserv" key="Réservation N°:" mode="R,R,R"></layout:text>
 </layout:column>
 <layout:column>
  <layout:text property="codaprob" key="N°commande:" mode="R,R,R"></layout:text>
 </layout:column>
 <layout:column>
  <layout:text property="dis" key="destinataire:" mode="R,R,R"></layout:text>
 </layout:column>
  </layout:row> 
               
      
      <layout:pager maxPageItems="7">
           <layout:collection name="sortiForm" property="listaprob"   styleClass="SCROLL" styleClass="FORM" width="600" height="250">
           <layout:collectionItem title="WAREHOUSE" property="magasin"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
                   
           <layout:collectionItem title="QTE " property="qte"></layout:collectionItem>         
       
 
        </layout:collection>
       </layout:pager>
    <layout:row> 
   <layout:column width="150"></layout:column>
   <layout:column>
     <layout:button onclick="window.opener.chercher();">Afficher les rangs</layout:button>   
  </layout:column>         
           
        
    </layout:row>     
 
      </layout:form>
     
  </body>
</html:html>
	