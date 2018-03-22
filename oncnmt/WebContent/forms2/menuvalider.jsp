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
    
    <title>Menu principal</title>
    
    	 <layout:skin includeScript="true"/>
    
    <script>
    function setHidden(value,frm){frm.hidden.value=value;}
   
   
    function valider()   
    {
    var numero ='<%=request.getAttribute("num")%>';    
    document.getElementById ('hiddenTdp').value=numero;     
  
    
    if (confirm("vous avez valider la transaction "+numero+ "\nvoulez vous éditer son rapport? ")) {    
     setHidden('rapport',document.etaStkForm)
 etaStkForm.submit(); 
}
    }
    
    
   
    
    

	</script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>

   
   <body onload="valider();">


<jsp:include page="menu.jsp"/> 
 <hr>
   

 
   
    <layout:form action="/stock.do" method="post">
<layout:text property="hidden"   mode="H,H,H" ></layout:text>    
  
  <layout:text property="hiddenTdp"  key="test" mode="H,H,H" ></layout:text>    
    </layout:form>
  </body>
</html:html>






