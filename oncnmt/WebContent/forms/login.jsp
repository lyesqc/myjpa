
<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>Authentification</title>
    <layout:skin includeScript="true"/>	
    
   <script type="text/javascript" src="config/javascript.js"></script>
    
 

  
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body onload="loginTest();">
  <center>
  <div class="index2">
 <layout:img src="images/gess2.JPG"/>
  </div>
  
    
    <div class="index1">
    
    <layout:form action="/login.do" >
    
    <layout:text property="hiddenTest" mode="H,H,H" ></layout:text>
  
    
    <layout:panel styleClass="FORM" key="Compte utilisateur :" width="100%" height="50%">   <br/>
    <layout:text property="username" key="Nom utilisateur :" isRequired="true" ></layout:text> <br/>
     <layout:password property="password" key="Mot de passe :" isRequired="true" ></layout:password>
    <layout:button onclick="testVideLogin();">Se connecter</layout:button>
    </layout:panel>
    </layout:form>
    </div>
    </center>
  </body>
</html>
<% request.getSession().invalidate(); %>     