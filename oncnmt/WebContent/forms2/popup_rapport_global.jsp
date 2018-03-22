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
  
  
    
    <title>Rapport global</title>
    <layout:skin includeScript="true"/>
    
     

    
  <script type="text/javascript">
	 function  chercher()
 {  if  (document.getElementById('dat_du').value=="" )
    {
     alert("vous devez choisir une date debut"); 
     document.getElementById('dat_du').focus();
   }
   else
   {
   if  (document.getElementById('dat_au').value=="" )
    {
      alert("vous devez choisir une date fin");
      document.getElementById('dat_au').focus();
   }
   else
   {
   setHidden('edit_rapport');
    document.etaStkForm.submit();
   
   }
   
   }
   }
  </script>
   <script type="text/javascript">
     function setHidden(value){document.etaStkForm.hidden.value=value;}
   </script>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
<body >
<jsp:include page="menu.jsp"/>  

  <layout:form action="/rapport_global.do" method="post">
  <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
  
    <layout:panel key="Rapport Global :" styleClass="FORM">   
      <layout:row> 
      <layout:column>  
      <h3 >
   Choisissez une période SVP 
      </h3>
  </layout:column>
        </layout:row>
    <layout:row> 
          
 <layout:date property="dat_du" key="depuis la date Du :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir une date" ></layout:date>

     </layout:row>
<layout:row> 
          
 <layout:date property="dat_au" key="Jusqu'à la date Du :" endYear="2020" startYear="1999" patternKey="dd/MM/y" calendarTooltip="Choisir une date" ></layout:date>

     </layout:row>
    <layout:row>   
   <layout:button onclick="chercher();">Editer</layout:button>
    </layout:row>
    
    </layout:panel>
  </layout:form>
   

  </body>
</layout:html>
