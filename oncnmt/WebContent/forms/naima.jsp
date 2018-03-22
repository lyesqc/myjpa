<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>naima.jsp</title>
    
     <layout:skin includeScript="true"/>
    
    <script>
	
	function setHidden(value){document.discoverForm.hidden.value=value;}
	</script>
    
<script src="<%=request.getContextPath()%>/config/swap.js"></script>
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
  <layout:form action="/discovernaima.do"  styleClass="FORM" method="post">
  <layout:message key="discover.step.1" styleClass="LABELLEFT"/>
  <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
	
	<layout:row>
		<layout:swap property="id,id" formProperty="ids1,ids2" selectedStyleClass="FORMSWAP">
		<layout:collection name="list1" styleClass="FORM">
			<layout:collectionItem title="news.title" property="title"/>
			
		</layout:collection>
		<layout:collection name="list2" styleClass="FORM">
			<layout:collectionItem title="news.title" property="title"/>
			
		</layout:collection>
		</layout:swap>
	</layout:row>
     	
<layout:message key="discover.step.2" styleClass="LABELLEFT"/>

	<layout:message key="discover.step.3" styleClass="LABELLEFT"/>	
	<layout:submit onclick="setHidden('send')">send</layout:submit>
</layout:form>
  </body>
</html:html>
