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
    
    <title>reception packaging</title>

	 <layout:skin includeScript="true"/>
    
    <script>
	
	function setHidden(value){document.envoipackagForm.hidden.value=value;}
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
  
  
  <layout:form action="/recepackag.do">
  
   <layout:text property="hidden" mode="H,H,H" value="default">   </layout:text>
      
         
           <layout:row>
    <layout:column width="400"></layout:column>
   <layout:column> 
      <center>
      <h3>
          RECEPTION PACKAGING
      </h3>
       </center>
      </layout:column>
   </layout:row>
          <layout:row width="700">
       <layout:column width="400"> </layout:column>
       <layout:column width="300">
           <layout:panel  key="choisir un magasin" styleClass="FORM">
            
          <center>
         
           <layout:select property="magasin" key="choisir un magasin:" onchange="setHidden('listenvoip');document.envoipackagForm.submit();">
       <layout:option value=""></layout:option>
       <layout:options property="listmagasin"></layout:options>
       </layout:select> 
          
            </center>
        </layout:panel>
</layout:column>      
</layout:row>
       
    </layout:form>
  </body>
</html:html>
