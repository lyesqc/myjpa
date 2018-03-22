
<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
 
   

    
    <title>Authentification</title>
   	 <layout:skin includeScript="true"/>
    
    <script type="text/javascript">
  
  
 function recupererprofil(param1,param2)          
 {
 alert(param1);
  alert(param2);
setHidden('gestionprofil',document.loginForm);      
  loginForm.submit(); 
 }
 
 
 </script>

  
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  <center>
  <div class="index2">
 <layout:img src="../images/entete2.JPG"/>

  </div>
  
    
    <div class="index1">
    
    <layout:form action="/gestionprofil.do" >
    
    <layout:text property="hiddenTest" mode="H,H,H" ></layout:text>
     <layout:text property="warehouse" mode="H,H,H" ></layout:text>
 <layout:text property="profil" mode="H,H,H" ></layout:text>
  
  
    
     <layout:collection id="item"  name="loginForm" property="listprofil" styleClass="SCROLL" styleClass="FORM" width="300" height="500">
           <layout:collectionItem onclick="recupererprofil('${item.profil}','${item.whs}');"    href="javascript:void();"  title="les profils de l'utilisateur" property="prof" sortable="true"></layout:collectionItem>
       </layout:collection>
  
    </layout:form>
    </div>
    </center>
  </body>
</html:html>
