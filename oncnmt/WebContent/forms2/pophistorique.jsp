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

   
    
    <title>Rapport des transactions</title>
    <layout:skin includeScript="true"/>
    
      <script type="text/javascript">
	
	     function setHidden(value){document.rechercheForm.hidden.value=value;}

		</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	

  </head>
  
  
  <body>
<hr>

    <layout:form action="/recherche1.do" method="post">
    <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>

 <logic:notEmpty property="etat" name="etaStkForm">

     <layout:collection name="etaStkForm" property="etat" styleClass="SCROLL"  styleClass="FORM" width="430" height="300">
     <layout:collectionItem title="CODE TRANSACTION" property="code"></layout:collectionItem>
    <layout:collectionItem title="___DATE___" property="date" sortable="true"></layout:collectionItem>
   
   <layout:collectionItem title="BON TRANSACTION" property="bon" action="/recherche1.do?hidden=visualiser" paramId="code_art" paramProperty="code_art">
       <center> Visualiser Bon </center>
       </layout:collectionItem>
     </layout:collection>

 </logic:notEmpty > 
 <logic:present parameter="hidden" scope="request">
    <logic:equal value="historique" parameter="hidden" scope="request">
       <logic:present name="etaStkForm" >
         <logic:empty name="etaStkForm" property="etat">
        
         <layout:panel key="Resultat de Recherche" styleClass="FORM">
            <layout:message key="aucun resultat corespondante"/>
         </layout:panel>
       
         </logic:empty>
       </logic:present>
    </logic:equal>
 </logic:present>  
    
    </layout:form>
   
   
  
  
   
    
  </body>
</layout:html>
