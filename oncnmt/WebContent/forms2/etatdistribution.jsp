
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
    
    <title>état distribution</title>

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

  <jsp:include page="menu.jsp"/>  
 <hr>

 
  
     <layout:form action="/listreserv.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
    <layout:space></layout:space>
        <layout:row>
          <layout:column width="200">
      </layout:column>
      <layout:column>  
      <h3 >
   ETAT DISTRIBUTION
      </h3>
  </layout:column>
        </layout:row>
    
        <layout:row>
        
         <layout:column>
       <layout:text property="trans" key="Réservation n°:" mode="R,R,R">
      </layout:text>
      </layout:column>
        
 <layout:column>
  <layout:text property="destinataire" key="destinataire:" mode="R,R,R"></layout:text>
 </layout:column>
 
 <layout:column>
  <layout:text property="codreserv" key="commande N°:" mode="R,R,R"></layout:text>
 </layout:column>
  
  </layout:row> 
           <layout:space></layout:space>    
      <layout:cell>
<div style="position:absolute;left:10px;width:820; height:400;overflow-y:scroll;">    
      
           <layout:collection name="reservationForm" property="reserv2"   styleClass="SCROLL" styleClass="FORM" width="800" >
           <layout:collectionItem title="WAREHOUSE" property="wh"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="aa"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="pp"></layout:collectionItem>

            
         <layout:collectionItem title="Qte réservée" property="qt"></layout:collectionItem>  
         <layout:collectionItem title="QTE livrée" property="qtt"></layout:collectionItem> 
        <layout:collectionItem title="Reliquat" property="ppp"></layout:collectionItem> 
        
        </layout:collection>
    
</div>
</layout:cell>        
      
        

           
      
             
      </layout:form>
     
  </body>
</html:html>
	