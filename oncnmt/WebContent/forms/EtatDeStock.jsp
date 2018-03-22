<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<layout:html>
  <head>
    
    <html:base/>
    <title>Etat De Stock</title>
    <layout:skin includeScript="true"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">



   <script>
	function setHidden(value){document.rechercheForm.hidden.value=value;}
	
	</script>
  </head>
  
  <body>

  <layout:img src="../images/entete.JPG" width="100%" height="100"/>
 
 
<jsp:include page="menu.jsp"/>  
 <hr>


    <br/><br/>
    <br/><br/>
    
    <layout:form action="/stock.do" method="post">
   <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
   
   
 <layout:collection name="etaStkForm" property="etat" styleClass="FORM" >
     <layout:collectionItem title="ARTICLE" property="art"></layout:collectionItem>
     <layout:collectionItem title="PROFIL" property="prof" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="DESTINATAIRE" property="dest" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="SERIAL_START" property="start" sortable="true"></layout:collectionItem>
     <layout:collectionItem title="SERIAL_END" property="end" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="QTE" property="qte" sortable="true"></layout:collectionItem>
      <layout:collectionItem title="WAREHOUSE" property="whs" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="POSITION" property="pos" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="PACKAGING" property="pack" sortable="true"></layout:collectionItem>
        <layout:collectionItem title="HLR" property="hlr" sortable="true"></layout:collectionItem>
        <layout:collectionItem title="PQ" property="pq" sortable="true"></layout:collectionItem>
          <layout:collectionItem title="TRANSFERT" property="tra" sortable="true"></layout:collectionItem>
       <layout:collectionItem title="SORTIE" property="sor" sortable="true"></layout:collectionItem> 
       <layout:collectionItem title="REINTEGRATION" property="reint" sortable="true"></layout:collectionItem> 
       <layout:collectionItem title="TDP" property="tdp" sortable="true"></layout:collectionItem>
      
   </layout:collection>
     </layout:form>
     
  
  </body>
</layout:html>
