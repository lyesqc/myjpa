
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
    
    <title>approbation</title>

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
    <layout:img src="../images/entete2.JPG" width="100%"/>
 <jsp:include page="menu.jsp"/> 
 <hr>
 

 
  
     <layout:form action="/listreserv.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
    
    
    
        <layout:row>
        
         <layout:column>
       <layout:text property="trans" key="Réservation n°:" mode="R,R,R">
      </layout:text>
      </layout:column>
        
 <layout:column>
  <layout:text property="destinataire" key="distributeur:" mode="R,R,R"></layout:text>
 </layout:column>
 
 <layout:column>
  <layout:text property="codreserv" key="commande N°:" mode="R,R,R"></layout:text>
 </layout:column>
  
  </layout:row> 
               
      
      <layout:pager maxPageItems="5">
           <layout:collection name="reservationForm" property="reserv2"   styleClass="SCROLL" styleClass="FORM" width="800" height="180">
           <layout:collectionItem title="WAREHOUSE" property="wh"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="pp"></layout:collectionItem>
            <layout:collectionItem title="HLR" property="hlr2" sortable="true"></layout:collectionItem>
            <layout:collectionItem title="PQ" property="pq2" sortable="true"></layout:collectionItem>        
         <layout:collectionItem title="QTE" property="qt"></layout:collectionItem>  
        </layout:collection>
       </layout:pager>
        
      
        

           
      
             
      </layout:form>
     
  </body>
</html:html>
	