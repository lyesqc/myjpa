
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
    
    <title>approbation</title>

	 <layout:skin includeScript="true"/>
	  <script>  
 function desactiverapprob()  
 {
var privileg='<%=(String)request.getSession().getAttribute("profilvalidation")%>';   
if  (privileg=="VALIDATION")
 {
document.approbationForm.montantcheque.disabled=true;   
document.approbationForm.cheque.disabled=true; 
document.approbationForm.codreserv.disabled=true;            
 }
			
 }
 
 
 function valid8(){
 
 var privileg='<%=(String)request.getSession().getAttribute("profilvalidation")%>';   
if  (privileg=="VALIDATION")
 {
      setHidden('valider',document.approbationForm)
		                   approbationForm.submit();         
 }
 else{
		   if (document.approbationForm.cheque.value=="")
		         {alert(" vous devez indiquez un num de chèque SVP")
		          document.approbationForm.cheque.focus();
		         }
		          
		               
		                else 
		                {
		                
		                if (document.approbationForm.montantcheque.value=="")
		         {alert(" vous devez indiquez le montant global du chèque SVP")
		          document.approbationForm.montantcheque.focus();
		         }
		                
		                else{
		                
		                   setHidden('valider',document.approbationForm)
		                   approbationForm.submit(); 
		                }
		              }
		     }}
   </script>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
          
  <body onload="desactiverapprob();">
   
<jsp:include page="menu.jsp"/>  
 <hr>
 
  
 
  
     <layout:form action="/approbation.do" method="post">
      <layout:text property="hidden" value="default" mode="H,H,H"></layout:text>
       <layout:text property="hiddenTest" mode="H,H,H"></layout:text>
     <layout:row>
 <layout:column width="100">
               </layout:column>    
              <layout:column>
               <layout:button onclick="valid8();">Valider</layout:button>
              </layout:column>
     <layout:column width="100">
               </layout:column>         
            
     
      <layout:column>
      <center>
      <h3>
     APPROBATION/VALIDATION DE RESERVATION
      </h3>
       </center>
      </layout:column>
     
      </layout:row>
    <layout:panel key="Informations approbation:" styleClass="FORM" width="250">   
        <layout:row>
 <layout:column>
  <layout:text property="dis" key="Destinataire:" mode="R,R,R"></layout:text>
 </layout:column>
 
  <layout:column>
       <layout:text property="trans" key=" Réservation n°:" mode="R,R,R">
      </layout:text>
      </layout:column>
 
 <layout:column>
  <layout:text property="codreserv" key="commande N°:" ></layout:text>
 </layout:column>
  
  </layout:row> 
  
   <layout:row>
    
       <layout:column>

           <layout:text property="cheque" key="N° du chèque:" ></layout:text>
       </layout:column>
        <layout:column>
           <layout:text property="montantcheque" key="montant du chèque:" ></layout:text>        
 </layout:column>
  <layout:column>
           <layout:textarea property="note" key="Note:"></layout:textarea>
        
          </layout:column>
     </layout:row>
               
       </layout:panel > 
       <layout:space></layout:space>
         <layout:space></layout:space>
        <layout:write   name="approbationForm"  property="writ1"  ></layout:write>
  <layout:cell>
<div style="position:absolute;left:10px;width:820; height:250;overflow-y:scroll;">   
      
           <layout:collection name="approbationForm" property="resulrang"  indexId="index" styleClass="SCROLL" styleClass="FORM" width="800">
           <layout:collectionItem title="WAREHOUSE" property="magasin"></layout:collectionItem> 
            <layout:collectionItem title="ARTICLE" property="article"></layout:collectionItem>
           <layout:collectionItem title="PROFIL" property="profil"></layout:collectionItem>
           <layout:collectionItem title="QTE" property="qte"></layout:collectionItem>  
        </layout:collection>
  </div>
  </layout:cell>   
        
        <layout:space></layout:space>
         <layout:space></layout:space>
          <layout:space></layout:space>
           <layout:space></layout:space>
        
    
  
     
             
      </layout:form>
     
  </body>
</html:html>
	