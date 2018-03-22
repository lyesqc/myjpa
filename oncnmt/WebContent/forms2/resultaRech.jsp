<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%
// reception : ArrayList dans la requête
// reception(i) : tableau (String[5]) de 5 éléments
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<layout:html>
  <head>
    <html:base />
    
    <title>Resultat</title>

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
  <table border="1">
<tr>
<td>CODE TRANSACTION</td>
<td>DESTINATAIRE</td>
<td>WAREHOUSE</td>
<td>DATE</td>
<td>RESPONSABLE</td>
<td>BON TRANSACTION</td>
</tr>
<logic:iterate id="ligne" name="reception">
<tr>
<logic:iterate id="colonne" name="ligne">
<td><bean:write name="colonne"/></td>
</logic:iterate>
<td><layout:link page="/recherche1.do">Visualiser le Bon</layout:link> </td>
</tr>
</logic:iterate>
</table>
</body>


</layout:html>
