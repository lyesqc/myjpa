<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yourcompany.struts.UtilBean.Profil" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<layout:html>

  <head>

   
    
    <title>Edition du bon</title>
    <layout:skin includeScript="true"/>
    
     <script type="text/javascript">
		function effacer(form)
		{
		document.recheditForm.nrec.value="";
	}
		
		
		
	 function valid6(){
	 
	   if ( recheditForm.hiddenTest.value =="aucun bon")
	   {
		    alert(" aucune transaction ne correspond à ce code")
		      recheditForm.hiddenTest.value="";
		   
		         }
		          else 
		                {
		                  setHidden('Editer')
		                   recheditForm.submit(); 
		                }
		              
		     }	
		
		</script>
    

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script>
	function setHidden(value){document.recheditForm.hidden.value=value;}
	
	</script>

  </head>
  
  
  <body>
 
 


   
    <layout:form action="/rechedit1.do" method="post">
    <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
   <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
    <center>
      <h3>
      Edition du bon de transaction :
      </h3>
         </center>   
      
         <layout:panel  align="center" key="Veuillez introduire le code de la transaction :" styleClass="FORM">
<layout:text property="nrec" key="Code de transaction :"></layout:text>

<layout:button onclick="valid6();">Editer</layout:button>
<layout:button onclick="effacer(this.form)">Réinitialiser</layout:button>
   
       </layout:panel> 

    </layout:form>
  
    
  </body>
</layout:html>
